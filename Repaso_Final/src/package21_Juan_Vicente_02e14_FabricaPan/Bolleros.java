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
public class Bolleros extends Thread {

    //INSTANCIAMOS EL RECURSO COMPARTIDO
    RC_Tablero<RC_Tablero<Alimentos>> lstTablero;
    //INICIALIZAMOS LAS VARIABLES DE ALIMENTOS
    private String[] nombreAlimentos = {"Bollos", "Bizcochos", "Palmeras"};
    private String[] descripcionAlimentos = {"Los QE son geniales", "Los desayunaba en el cole",
        "las del migas son las mejores"};
    private double[] precio = {0.75, 0.25, 1.15};
    private int aleatorio;
//CREAMOS UN BOOLEANO PARA CONTROLAR LA INTERRUPCIÓN
    boolean interrupt; //TRUE hilo interrumpido FALSE hilo no interrumpido

    //CONSTRUCTOR
    public Bolleros(RC_Tablero<RC_Tablero<Alimentos>> lstTableros) {
        this.lstTablero = lstTableros;
        interrupt = false;
    }
    //BLOQUE DE EJECUCIÓN

    @Override
    public void run() {
        //CREAMOS UNA CESTA
        Cesta cesta = new Cesta();
        //MIENTRAS NO SE INTERRUMPAN LOS HILOS
        while (!interrupt && !this.isInterrupted()) {
            try {
                //HACEMOS UN SLEEP CON EL TIEMPO QUE SE TARDA EN CREAR UN ALIMENTO
                this.sleep(1000);

                //SI EL Nº DE ELEMENTOS DE LA CESTA NO ES SUPERIOR A SU CAPACIDAD, LE PASAMOS EL ALIMENTO
                if (cesta.getCount() == cesta.getCapacidad()) {
                    //INICIALIZAMOS ALEATORIO
                    aleatorio = new Random().nextInt(nombreAlimentos.length);
                    //CREAMOS UN OBJETO ALIMENTO Y LE PASAMOS LOS PARÁMETROS
                    Alimentos alimento = new Alimentos(nombreAlimentos[aleatorio],
                            descripcionAlimentos[aleatorio], precio[aleatorio]);
                    //AÑADIMOS EL ALIMENTO A LA CESTA
                    cesta.addElemento(alimento);
                } else {
                    //UNA VEZ LA CESTA ESTÁ LLENA, LA PASAMOS AL TABLERO
                    synchronized (lstTablero) {
                        while (lstTablero.getCount() == lstTablero.getCapacidadTablero()) {
                            lstTablero.wait();
                        }
                        //METEMOS CESTA EN TABLERO
                        lstTablero.addElemento(cesta);
                        //NOTIFICAMOS A TODOS
                        lstTablero.notifyAll();
                        //HACEMOS ECO
                        System.out.println(getName() + " ha metido " + cesta.toString());
                        System.out.println("Tablero tiene " + lstTablero.getCount() + " elementos");

                        if (lstTablero.getCount() == lstTablero.getCapacidadTablero()) {
                            System.out.println("El tablero se ha llenado");
                        }
                        //VOLVEMOS A INICIALIZAR LA CESTA
                        cesta = new Cesta();
                    }
                }
            } catch (InterruptedException ex) {
                interrupt=true;
            }

        }

    }

}
