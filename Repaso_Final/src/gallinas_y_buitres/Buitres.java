/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gallinas_y_buitres;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Buitres extends Thread {

    //CONSTANTES
    private static final int PESO_MAX = 200;
    private static final int TIEMPO_MIN=500;
    private static final int TIEMPO_MAX=2000;
    //INSTANCIAMOS RC
    RC_Huevera huevera;
    //VARIABLES
    private int peso;

    //CONSTRUCTOR
    public Buitres(RC_Huevera huevera) {
        this.huevera = huevera;
        this.peso = 0;
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
       
        while (peso < PESO_MAX) {
            try {
                //TIEMPO ENTRE BUITRE Y BUITRE
                this.sleep(new Random().nextInt((TIEMPO_MAX-TIEMPO_MIN)+1)+TIEMPO_MIN);
                Huevo huevo = huevera.cogerHuevo();
                //INCREMENTAMOS PESO BUITRE CON PESO DEL HUEVO
                peso += huevo.getPeso();
                //ECOS
                System.out.println(getName() + " se ha llevado "
                        + huevo.getNombreAnimal() + ", peso " + getName() + ": " + peso + "g");
            } catch (InterruptedException ex) {
                //ECO CUANDO EL GRANJERO LO ESPANTA
                System.out.println("Granjero espanta a "+getName());
               
            }
        }
        //ECO CUANDO COME MÁS DE 200g
        System.out.println(getName()+" ha comido "+peso+"g, levanta el vuelo");
    }

}
