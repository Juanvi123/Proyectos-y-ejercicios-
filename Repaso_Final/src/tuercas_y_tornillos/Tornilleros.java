/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuercas_y_tornillos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Tornilleros extends Thread {

    //INSTANCIAMOS EL RC
    RC_Caja caja;

    private double[] tamano = new double[2];
    private int i;
    private int j;

    //CONSTRUCTOR
    public Tornilleros(RC_Caja caja) {
        this.caja = caja;
        this.i = 0;
        this.j = 0;
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        try {
            while (!caja.blisterLleno()) {
                this.sleep(500);
                Inicializacion_Aleatorios aleatorio = new Inicializacion_Aleatorios();
                tamano[0] = aleatorio.iniDiametro();
                tamano[1] = aleatorio.iniLongitud();
                //CREAMOS BLISTER
                Blisters blister = new Blisters(aleatorio.iniEtiqueta(), aleatorio.iniPrecio(), tamano);
                while (blister.getCountBlister() < blister.N_MAX_BLISTERS) {
                    if (blister.getEtiqueta().trim().toUpperCase().equals("TORNILLO")) {
                        i++;
                        Tornillos tornillo = new Tornillos("Tornillo " + i);
                        blister.addTornillo(tornillo);
                    } else {
                        j++;
                        Tuercas tuerca = new Tuercas("Tuerca " + j);
                        blister.addTuerca(tuerca);
                    }
                }
                caja.addBlisters(blister);
            }
            
        } catch (InterruptedException ex) {
          
        }
            
    }
}
