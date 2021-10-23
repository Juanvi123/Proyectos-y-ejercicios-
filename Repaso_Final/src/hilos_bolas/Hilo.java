/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos_bolas;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Hilo extends Thread {
    //CONSTANTES
    private static final int TIEMPO_MIN=1;
    private static final int TIEMPO_MAX=25;
    
    //CREAMOS INSTANCIA DE BOLA
    Bola bola;

    //CONSTRUCTOR
    public Hilo(Bola bola) {
        this.bola = bola;
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        
       if(bola.getCont()>=15||bola.getAcumulador()>=100){
           System.out.println("NO PASO LA BOLA A NADIE");
           System.out.println("Fin del programa");
       }else{
           try {
               //TIEMPO
               int tiempo=new Random().nextInt((TIEMPO_MAX-TIEMPO_MIN)+1)+TIEMPO_MIN;
               this.sleep(tiempo*100);
               //INCREMENTAMOS VARIABLES
               bola.setCont(bola.getCont()+1);
               bola.setAcumulador(bola.getAcumulador()+tiempo);
               //ECOS
               System.out.println("Contador: "+bola.getCont());
               System.out.println("Acumulador: "+bola.getAcumulador());
               //CREAMOS OTRO HILO
               Hilo hilo=new Hilo(bola);
               hilo.setName("Hilo "+(bola.getCont()+1));
               hilo.start();
           } catch (InterruptedException ex) {
               Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    }
    
}
