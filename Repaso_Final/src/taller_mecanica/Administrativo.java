/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller_mecanica;

import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Administrativo extends Thread {

    //CONSTANTES
    private static final int TIEMPO_MIN = 500;
    private static final int TIEMPO_MAX = 1000;

    //INSTANCIAMOS COCHE
    List<Coches> lstCoches;

    //INSTANCIAMOS RC
    RC_Banco_Mecanicos banco_Mecanicos;
    
    //CONSTRUCTOR
    public Administrativo(List<Coches> lstCoches, RC_Banco_Mecanicos banco_Mecanicos) {
        this.lstCoches = lstCoches;
        this.banco_Mecanicos = banco_Mecanicos;
    }
    
    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        try {
            for (Coches coche : lstCoches) {
                this.sleep(new Random().nextInt((TIEMPO_MAX-TIEMPO_MIN)+1)+TIEMPO_MIN);
                banco_Mecanicos.asignarCoche(coche);
            }
            System.out.println(getName()+" FIN");
        } catch (InterruptedException ex) {
            Logger.getLogger(Administrativo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
