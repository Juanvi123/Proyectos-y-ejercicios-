/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zampabombones_v1_interrupcion;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Chefs extends Thread {

    //CONSTANTES
    private static final int N_BOMBONES_MIN = 0;
    private static final int N_BOMBONES_MAX = 99;
    private static final int TIEMPO_MIN = 200;
    private static final int TIEMPO_MAX = 500;
    //INSTANCIAMOS RC
    RC_Bombonera bombonera;
    //DEFINIMOS CAMPOS BOMBON
    private String[] sabores = {"fresa", "cacao", "coco", "frambuesa"};
    private int aleBombon;
    private int aleSabor;
    private int n;

    //CONSTRUCTOR
    public Chefs(RC_Bombonera bombonera, int n) {
        this.bombonera = bombonera;
        this.n = n;
        this.aleBombon = 0;
        this.aleSabor = 0;
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        try {
            //Nº BOMBONES A HACER
            aleBombon = new Random().nextInt((N_BOMBONES_MAX - N_BOMBONES_MIN) + 1) + N_BOMBONES_MIN;
            System.out.println(getName() + " hará " + aleBombon + " bombones");
            //TIEMPO ENTRE ELABORACIÓN Y ELABORACIÓN DE BOMBONES
            for (int i = 0; i < aleBombon; i++) {
                //FUERA DEL FOR EL SLEEP NO SIRVE PARA QUE SE INTERCALEN PRODUCTORES
                this.sleep(new Random().nextInt((TIEMPO_MAX - TIEMPO_MIN) + 1) + TIEMPO_MIN);
                // ALEATORIO PARA EL SABOR
                aleSabor = new Random().nextInt(sabores.length);
                //INCREMENTAMOS EL CONTADOR
                n++;
                //CREAMOS BOMBON
                Bombones bombon = new Bombones(n, sabores[aleSabor]);
                //METEMOS BOMBON EN RC
                bombonera.addBombon(bombon);
            }
          
        } catch (InterruptedException ex) {
            Logger.getLogger(Chefs.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
