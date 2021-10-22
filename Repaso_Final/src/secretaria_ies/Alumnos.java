/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secretaria_ies;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Alumnos extends Thread {

    //CONSTANTES
    private static final int N_EXP_MIN = 1;
    private static final int N_EXP_MAX = 10000;
    private static final int N_ASIG_MIN = 1;
    private static final int N_ASIG_MAX = 15;
    private static final double TASA_MIN = 20;
    private static final double TASA_MAX = 40;

    //INSTANCIAMOS RC
    RC_Despacho despacho;

    //CAMPOS DE SOLICITUDES
    private int nExp;
    private int nAsig;
    private double tasa[];
    private String[] nombreAlumno = {"Juan Luis", "Pardo", "Dani", "Puche", "Pablo", "Raúl", "Galán",
        "Alexis", "Alejandro", "Juanvi", "Camilo", "Jose", "Esteban", "Victor", "Manu"};
    private double importeTotal;
    private int aleNombre;

    //CONSTRUCTOR
    public Alumnos(RC_Despacho despacho) {
        this.despacho = despacho;
        //INICIALIZAMOS ALEATORIOS
        this.nExp = new Random().nextInt((N_EXP_MAX - N_EXP_MIN) + 1) + N_EXP_MIN;
        this.nAsig = new Random().nextInt((N_ASIG_MAX - N_ASIG_MIN) + 1) + N_ASIG_MIN;
        this.importeTotal=0;
        this.aleNombre=0;

    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        try {
            this.sleep(300);
            tasa = new double[nAsig];
            //SUMAMOS EL IMPORTE DE LA TASA POR CADA ASIGNATURA
            for (int i = 0; i < nAsig; i++) {
                tasa[i] = Math.random() * ((TASA_MAX-TASA_MIN)+1) + TASA_MIN;
                importeTotal += tasa[i];
            }
            aleNombre=new Random().nextInt(nombreAlumno.length);
            //CREAMOS SOLICITUD
            this.setName(nombreAlumno[aleNombre]+" ("+nExp+")");
            Solicitudes solicitud=new Solicitudes(nombreAlumno[aleNombre]
                    , nExp, nAsig, importeTotal);
            //METEMOS SOLICITUD EN RC
            despacho.addSolicitud(solicitud);
            importeTotal=0;
        } catch (InterruptedException ex) {
            Logger.getLogger(Alumnos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
