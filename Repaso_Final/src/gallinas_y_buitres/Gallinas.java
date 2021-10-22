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
public class Gallinas extends Thread {
    //CONSTANTES
    private static final int PESO_MIN=25;
    private static final int PESO_MAX=75;
    private static final int TIEMPO_MIN=500;
    private static final int TIEMPO_MAX=1000;
    //INSTANCIAMOS RC
    RC_Huevera huevera;
    //CONTADOR DE HUEVOS
    private int cont;
    //BOOL PARA CONTROLAR INTERUPCIÓN
    private boolean interrupt;

    //CONSTRUCTOR
    public Gallinas(RC_Huevera huevera) {
        this.huevera = huevera;
        this.cont=0;
        this.interrupt=false;
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        //MIENTRAS LAS GALLINAS NO SEAN INTERRUMPIDAS
       while(!interrupt){
           try {
               //TIEMPO ENTRE HUEVO Y HUEVO
               this.sleep(new Random().nextInt((TIEMPO_MAX-TIEMPO_MIN))+TIEMPO_MIN);
               //INCREMENTAMOS EL CONTADOR DE HUEVOS
               cont++;
               //CREAMOS UN HUEVO
               Huevo huevo=new Huevo( "huevo "+cont+" de "+getName()
              ,new Random().nextInt((PESO_MAX-PESO_MIN)+1)+PESO_MIN);
               //METEMOS HUEVO EN RC
               huevera.addHuevo(huevo);
           } catch (InterruptedException ex) {
               interrupt=true;
               System.out.println("Granjero mete a "+getName()+" en corral");
           }
       }
    }
    
    
    
}
