/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zampabombones_v2_demonio;

import zampabombones_v1_interrupcion.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Zampabombones extends Thread {

    //CONSTANTES
    private static final int TIEMPO_MIN = 250;
    private static final int TIEMPO_MAX = 500;
    //INSTANCIAMOS RC
    RC_Bombonera bombonera;
    //VARIABLES
    private int contabilizador;
    //BOOLEANO CONTROLAR INTERRUPCION
    boolean interrupt;

    //CONSTRUCTOR
    public Zampabombones(RC_Bombonera bombonera) {
        this.bombonera = bombonera;
        this.contabilizador = 0;
        this.interrupt = false;
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        while (true) {
            try {
                bombonera.removeBombon();
                //INCREMENTAMOS CONTADOR
                contabilizador++;
            } catch (InterruptedException ex) {
                Logger.getLogger(Zampabombones.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //GETTER
    public int getContabilizador() {
        return contabilizador;
    }

}
