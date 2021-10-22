/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforo_y_contador;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class HiloA extends Thread {
    //CONSTANTES
    private static final int TIEMPO_MIN=1000;
    private static final int TIEMPO_MAX=1500;
    
    //INSTANCIAMOS RC
    RC_Semaforo semaforo;
    
    //CONSTRUCTOR
    public HiloA(RC_Semaforo semaforo) {
        this.semaforo = semaforo;
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
       //COMO SERÁ UN HILO DEMONIO, LO METO EN UN BUCLE INFINITO
       while(true){
           try {
               //TIEMPO PARA CAMBIAR EL SEMÁFORO
               this.sleep(new Random().nextInt((TIEMPO_MAX-TIEMPO_MIN)+1)+TIEMPO_MIN);
               synchronized(semaforo){
                   //SI EL SEMÁFORO ESTÁ VERDE
                   if(semaforo.isSemaforo()){
                       //CAMBIO SEMÁFORO A ROJO
                       semaforo.setSemaforo(false);
                       System.err.println(getName()+" cambia semáforo a rojo");
                   }//SI EL SEMÁFORO ESTÁ ROJO
                   else{
                       //LO CAMBIO A VERDE
                       semaforo.setSemaforo(true);
                       System.err.println(getName()+" cambia semáforo a verde");
                   }
                   semaforo.notifyAll();
               }
           } catch (InterruptedException ex) {
               Logger.getLogger(HiloA.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    }
    
    
}
