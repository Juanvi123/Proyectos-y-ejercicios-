/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrera_5_corredores;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Thread_Corredor extends Thread {
    //CONSTANTES
    private static final int TIEMPO_MIN=500;
    private static final int TIEMPO_MAX=2500;

    //VARIABLES
    private int tiempo;
    private String cadena;
    
    //CONSTRUCTOR
    public Thread_Corredor() {
        this.tiempo=0;
        this.cadena="";
    }
    
    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        try {
            //INICIALIZAMOS TIEMPO ALEATORIO
            tiempo=new Random().nextInt((TIEMPO_MAX-TIEMPO_MIN)+1)+TIEMPO_MIN;
            System.out.println(getName()+" tarda "+(tiempo/100)+"s");
            this.sleep(tiempo);
            setCadena(getName()+" tarda "+(tiempo/100)+" s");
        } catch (InterruptedException ex) {
            Logger.getLogger(Thread_Corredor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //GETTERS
    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }
    
    
    
}
