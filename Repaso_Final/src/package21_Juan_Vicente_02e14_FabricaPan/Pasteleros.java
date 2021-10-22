/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package21_Juan_Vicente_02e14_FabricaPan;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Pasteleros extends Thread {

    //INSTANCIAMOS EL RC
    RC_Tablero<RC_Tablero<Alimentos>> lstTablero;
    //INICIALIZAMOS LAS VARIABLES DE LOS ALIMENTOS
    private String[] nombreAlimento = {"Bombones", "Caramelos", "Pasteles"};
    private String[] descripcionAlimento = {"Los favoritos de Forrest Gump", "Los fav de la cabalgata", "Ideal para merendar"};
    private double[] precio = {2.5, 0.5, 3.5};
    private int aleatorio;
    //CREAMOS UN BOOLEANO PARA CONTROLAR LA INTERRUPCIÓN DE LOS HILOS
    private boolean interrupt;

    //CONSTRUCTOR
    public Pasteleros(RC_Tablero<RC_Tablero<Alimentos>> lstTablero) {
        this.lstTablero = lstTablero;
        this.interrupt = false;
    }

    @Override
    public void run() {
        //CREAMOS UNA BANDEJA
        Bandeja bandeja = new Bandeja();
        //MIENTRAS NO SE INTERRUMPAN LOS HILOS, LOS PASTELEROS SEGUIRÁN PRODUCIENDO
        while (!interrupt && !isInterrupted()) {
            try {
                //ESPERA ENTRE LA ELEBORACIÓN DE CADA ALIMENTO
                this.sleep(50);

                if (bandeja.getCount() < bandeja.getCapacidad()) {
                    //INICIALIZAMOS EL ALEATORIO
                    aleatorio = new Random().nextInt(nombreAlimento.length);
                    //CREAMOS UN ALIMENTO
                    Alimentos alimento = new Alimentos(nombreAlimento[aleatorio], descripcionAlimento[aleatorio],
                            precio[aleatorio]);
                    //LLENAMOS LA BANDEJA
                    bandeja.addElemento(alimento);
                } else {
                    //SINCRONIZAMOS EL LLENADO DEL TABLERO
                    synchronized (lstTablero) {
                        //SI EL NUMERO DE ELEMENTO DEL TABLERO ES IGUAL A SU CAPACIDAD LOS PRODUCTORES ESPERAN
                        while (lstTablero.getCount() == lstTablero.getCapacidadTablero()) {
                            lstTablero.wait();
                        }
                        //METEMOS BANDEJA EN TABLERO
                        lstTablero.addElemento(bandeja);
                        
                        //ECO
                        System.out.println(getName() + " ha metido " + bandeja);
                        System.out.println("tablero tiene " + lstTablero.getCount() + " elementos");
                       
                        //MEREMANTE ESTÉTICO
                        if (lstTablero.getCount() == lstTablero.getCapacidad()) {
                            System.out.println("El tablero se ha llenado");
                        }
                        //VOLVEMOS A INICIALIZAR LA BANDEJA
                        bandeja=new Bandeja();
                    }
                }
            } catch (InterruptedException ex) {
               interrupt=true;
            }
        }
    }

}
