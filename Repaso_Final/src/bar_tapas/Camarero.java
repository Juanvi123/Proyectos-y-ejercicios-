/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bar_tapas;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Camarero extends Thread {

    //CONSTANTES
    private static final int TIEMPO_MIN = 50;
    private static final int TIEMPO_MAX = 250;

    //INSTANCIAMOS RC
    RC_Barra barra;

    //CAMPOS BEBIDA
    private String[] nombreBebidas = {"Vino Tinto", "Vino Blanco", "Cerveza", "Refrescos", "Licores"};
    private double[] precios = {3.00, 2.50, 2.00, 3.00, 5.00};
    private int aleBebidas;

    //CONSTRUCTOR
    public Camarero(RC_Barra barra) {
        this.barra = barra;
        this.aleBebidas = 0;
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        //CREAMOS UN UCLE INFINITO X Q EL CAMARERO SERÁ DEMONIO
        try {
            while (true) {
                //TIEMPO ENTRE BEBIDA Y BEBIDA QUE SE COGE
                 this.sleep(new Random().nextInt((TIEMPO_MAX-TIEMPO_MIN)+1)+TIEMPO_MIN);
                //CREAMOS BEBIDA
                aleBebidas=new Random().nextInt(nombreBebidas.length);
                Bebidas bebida = new Bebidas(nombreBebidas[aleBebidas], precios[aleBebidas]);
                //METEMOS BEBIDA EN RC
                barra.addbebida(bebida);

            }
        } catch (InterruptedException ex) {
            System.out.println(getName()+" FIN");
        }
    }

}
