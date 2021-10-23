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
public class Hurracas extends Thread {
    //CONSTANTES
    private static final int TIEMPO_MIN=1500;
    private static final int TIEMPO_MAX=3000;
    //INSTANCIAMOS RC
    RC_Huevera huevera;

    //CONSTRUCTOR
    public Hurracas(RC_Huevera huevera) {
        this.huevera = huevera;
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        try {
            //TIEMPO HASTA QUE LLEGA LA HURRACA
            this.sleep(new Random().nextInt((TIEMPO_MAX-TIEMPO_MIN)+1)+TIEMPO_MIN);
            Huevo huevo=huevera.cogerHuevo();
            System.out.println(getName()+" coge "+huevo.getNombreAnimal());
        } catch (InterruptedException ex) {
            //ECO SI LA HURRACA ES INTERRUMPIDA
            System.out.println("Granjero espanta a Hurraca");
        }
        //ECO SI LA HURRACA NO ES INTERRUMPIDA
        System.out.println(getName()+" levanta el vuelo");
    }
    
    
    
}
