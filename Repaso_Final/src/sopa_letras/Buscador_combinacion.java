/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sopa_letras;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Buscador_combinacion extends Thread{
    //INSTANCIAMOS RC
    RC_Letras letras;
    
    //CONTADOR DE INTENTOS
    private int cont;

    //CONSTRUCTOR
    public Buscador_combinacion(RC_Letras letras) {
        this.letras = letras;
        this.cont=0;
    }

    @Override
    public void run() {
        while(!letras.isCombinacionEncontrada()){
            try {
                this.sleep(10);
                letras.comprobarCadena();
                cont++;
            } catch (InterruptedException ex) {
                Logger.getLogger(Buscador_combinacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(getName()+" encontró la combinación "+letras.getCadena()+" en el intento "+cont);
    }
    
    
}
