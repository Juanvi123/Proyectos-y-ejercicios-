/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller_mecanica;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Mecanicos extends Thread {

    //INSTANCIAMOS UN COCHE
    Coches coche;
    List<Coches> lstCoches;

    //INSTANCIAMOS RC
    RC_Banco_Mecanicos banco_Mecanicos;

    //CONSTRUCTOR
    public Mecanicos(RC_Banco_Mecanicos banco_Mecanicos) {
        this.banco_Mecanicos = banco_Mecanicos;
        this.lstCoches = new ArrayList<>();
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        //MECANICOS SERÁN DEMONIOS
        try {
            while (true) {
                this.sleep(500);
                //AÑADIMOS MECANICO AL BANCO DE MECÁNICOS
                banco_Mecanicos.addMecanico(this);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Mecanicos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //SETTERS Y GETTERS
    public Coches getCoche() {
        return coche;
    }

    public void setCoche(Coches coche) {
            this.coche = coche;
    }

}
