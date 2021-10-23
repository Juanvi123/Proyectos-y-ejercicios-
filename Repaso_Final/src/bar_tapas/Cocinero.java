/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bar_tapas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Cocinero extends Thread {

    //CONSTANTES
    private static final int CAPACIDAD_BANDEJA = 12;
    private static final int TIEMPO_MIN = 50;
    private static final int TIEMPO_MAX = 250;

    //BANDEJA
    List<Tapas> bandeja;

    //INSTANCIAMOS RC
    RC_Barra barra;

    //LISTA CLIENTES
    List lstClientes;

    //CONTADOR TAPA
    private int contTapas;

    //CAMPOS TAPA
    private String[] nombreTapas = {"Pincho de Calamar", "Pincho de Jamón", "Ración de patatas"};
    private double[] precios = {1.30, 3.00, 4.00};
    private int aleTapas;

    //CONSTRUCTOR
    public Cocinero(RC_Barra barra, List lstClientes) {
        this.barra = barra;
        this.lstClientes = lstClientes;
        this.contTapas = 0;
        this.aleTapas = 0;
        this.bandeja=new ArrayList<>();
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        try {
            //MIENTRAS TODOS LOS CLIENTE NO TENGAN TAPA, EL COCINERO SIGUE COCINANDO
            while (lstClientes.size() > contTapas) {
                //MIENTRAS LA BANDEJA NO ESTÉ LLENA, CREAMOS TAPA
                while (bandeja.size() < CAPACIDAD_BANDEJA) {
                    //TIEMPO ENTRE LA ELABORACIÓN DE CADA TAPA
                    this.sleep(new Random().nextInt((TIEMPO_MAX-TIEMPO_MIN)+1)+TIEMPO_MIN);
                    //CREAMOS TAPA
                    aleTapas = new Random().nextInt(nombreTapas.length);
                    Tapas tapa = new Tapas(nombreTapas[aleTapas], precios[aleTapas]);
                    //METEMOS LA TAPA EN BANDEJA
                    bandeja.add(tapa);
                    contTapas++;
                }
                //METEMOS BANDEJA EN RC
                barra.addBandeja(bandeja);
                //VOLVEMOS A INICIALIZAR LA BANDEJA
                bandeja.removeAll(bandeja);
            }
            //ECO FINAL
            System.out.println(getName()+" FIN");
        } catch (InterruptedException ex) {
            System.out.println(getName()+" FIN");
        }
    }

}
