/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package21_Juan_Vicente_02e14_FabricaPan;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * SERÁ EL HILO CONSUMIDOR
 *
 * @author juanv
 */
public class Dependientes extends Thread {

    //INSTANCIAMOS EL RC
    RC_Tablero<RC_Tablero<Alimentos>> lstTablero;
    //BOOLEANO QUE CONTROLE LA INTERRUPCIÓN DE LOS HILOS
    boolean interrupt;
    //CREAMOS UN RECIPIENTE DEL RC DE DONDE EXTRAEREMOS LOS ALIMENTOS DE LAS CANASTAS, CESTAS Y BANDEJAS
    RC_Tablero tablero = null;

    //CONSTRUCTOR
    public Dependientes(RC_Tablero<RC_Tablero<Alimentos>> lstTablero) {
        this.lstTablero = lstTablero;
        interrupt = false;
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        //MIENTRAS LOS DEPENDIENTES NO SEAN INTERRUMPIDOS, SACAN PRODUCTOS
        while ((!interrupt && !this.isInterrupted()) || (lstTablero.getCount() != 0)) {
            try {

                synchronized (lstTablero) {
                    if (tablero == null || tablero.getCount() == 0) {
                        synchronized (lstTablero) {
                            //MIENTRAS EL TABLERO NO TENGA NADA, ESPERAMOS
                            while (lstTablero.getCount() == 0) {
                                lstTablero.wait();
                            }
                            tablero = lstTablero.removeElemento();
                            this.sleep(200);
                            lstTablero.notifyAll();
                            //EL ECO DEL DEPENDIENTE SERÁ ROJO PARA QUE SE VEA MEJOR POR CONSOLA
                            System.err.println(getName() + " ha sacado una " + tablero);
                            System.out.println("El tablero tiene "+lstTablero.getCount()+" elementos");

                        }
                    } else {
                        tablero.removeElemento();
                    }
                }
            } catch (InterruptedException ex) {
                interrupt = true;
            }

        }
    }

}
