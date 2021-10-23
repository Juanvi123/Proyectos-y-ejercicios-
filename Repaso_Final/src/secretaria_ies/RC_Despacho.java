/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secretaria_ies;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

/**
 *
 * @author juanv
 */
public class RC_Despacho {

    //CONSTANTES
    private static final int CAPACIDAD_BANDEJA = 5;
    //CONTENEDOR
    private List<Solicitudes> lstSolicitudes;
    //SEMAFORO
    private boolean bandejaLlena;
    //IMPORTE TOTAL
    private double importeTotal;
    //CONTADOR DE SOLICITUDES
    private int cont;

    //CONSTRUCTOR
    public RC_Despacho() {
        this.lstSolicitudes = new ArrayList<>();
        this.bandejaLlena = false;
        this.importeTotal = 0.0;
        this.cont=0;
    }

    //MÉTODOS
    public synchronized void addSolicitud(Solicitudes solicitud) throws InterruptedException {
        while (bandejaLlena) {
            wait();
        }
        //AÑADIMOS SOLICITUD A BANDEJA
        lstSolicitudes.add(solicitud);
        //ECOS
        System.out.println(Thread.currentThread().getName() + " mete solicitud, se ha matriculado en "
                + solicitud.getnAsignaturas() + " asignaturas y le ha costado "
                + String.format("%.2f", solicitud.getImporteTotal()) + "€");
        System.err.println("La bandeja tiene " + getCount() + " solicitudes");
        //NOTIFICAMOS A TODOS
        notifyAll();
        //ECO BANDEJA LLENA
        if (getCount() == CAPACIDAD_BANDEJA) {
            System.err.println("La bandeja se ha llenado");
            bandejaLlena = true;
            notifyAll();
        }
    }

    public int getCount() {
        return lstSolicitudes.size();
    }

    public synchronized void comprobarBandeja() throws InterruptedException {
        while (getCount() == 0) {
            wait();
        }
        try {
            if (bandejaLlena) {
                for (Solicitudes solicitud : lstSolicitudes) {
                    //ECO
                    System.out.println(Thread.currentThread().getName() + " vacía solicitud de "
                            + solicitud.getNombreAlumno() + "(" + solicitud.getnExp() + ")");
                    //AÑADIMOS IMPORTE DE ESTA SOLICITUD AL TOTAL
                    importeTotal += solicitud.getImporteTotal();
                    //INCREMENTAMOS EL CONTADOR
                    cont++;
                    //ELIMINAMOS SOLICITUD
                    lstSolicitudes.remove(solicitud);
                    System.err.println("La bandeja tiene "+getCount()+" solicitudes");
                    //NOTIFICAMOS A TODOS
                    notifyAll();
                }
                bandejaLlena = false;
            } else {
                System.out.println("La bandeja no se ha vaciado");
            }
        } catch (ConcurrentModificationException e) {

        }
    }

    public String getRecaudado() {
        return "Se han echado "+cont+" solicitudes, se ha recaudado un total de " + String.format("%.2f", importeTotal) + "€";
    }
    public synchronized boolean marcarBandejaLlena(){
        return bandejaLlena=true;
    }
}
