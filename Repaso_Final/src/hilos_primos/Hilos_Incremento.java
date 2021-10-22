/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos_primos;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Hilos_Incremento extends Thread {
    //CONSTANTES
    private static final int N_MIN=1;
    private static final int N_MAX=10;
    private static final int TIEMPO_MIN=300;
    private static final int TIEMPO_MAX=1000;
    
   //INSTANCIAMOS RC
    RC_Comprobar_Numero comprobar_numero;
    
    //NUMERO QUE INCREMENTA
    private int incremento;
    
    //BOOLEANO CONTROLAR INTERRUPCIÓN

    //CONSTRUCTOR
    public Hilos_Incremento(RC_Comprobar_Numero comprobar_numero) {
        this.comprobar_numero = comprobar_numero;
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        while(true){
            try {
                //TIEMPO ENTRE HILOS INCREMENTOS
                this.sleep(new Random().nextInt((TIEMPO_MAX-TIEMPO_MIN)+1)+TIEMPO_MIN);
                //CREAMOS EL Nº ALEATORIAMENTE
                incremento=new Random().nextInt((N_MAX-N_MIN)+1)+N_MIN;
                //METEMOS Nº EN RC
                comprobar_numero.incrementarNumero(incremento);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilos_Incremento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
}
