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
public class Panaderos extends Thread {

    //INSTANCIAMOS EL RECURSO COMPARTIDO
    RC_Tablero<RC_Tablero<Alimentos>> lstTablero;
    //CREAMOS UN BOOLEANO QUE NOS AYUDE A CONTROLAR QUE TODO FUNCIONE HASTA QUE SE INTERRUMPA
    boolean interrupt;
    //INICIALIZAMOS LAS VARIABLES DEL ALIMENTO
    private String[] nombreAlimento = {"Pan", "Pan Rústico", "Pan de Molde"};
    private String[] descripcionAlimento = {"Típico pan", "Típico pan de pueblo", "Pan para desayunar"};
    private double[] precioAlimento = {0.45, 0.55, 1.25};
    private int aleatorio;

    //CONSTRUCTOR
    public Panaderos(RC_Tablero<RC_Tablero<Alimentos>> lstTablero) {
        this.lstTablero = lstTablero;

    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        interrupt = false;
        //CREAMOS UN CONTENEDOR
        Canasta canasta = new Canasta();
        //MIENTRAS NO SE INTERRUMPA AL PRODUCTOR, SIGUE GENERANDO ALIMENTOS
        while ((!interrupt) && (!super.isInterrupted())) {
            try {
                //TIEMPO QUE TARDAN ENTRE HACER ALIMENTO Y ALIMENTO
                this.sleep(200);

                //MIENTRAS LA CANASTA NO SUPERE SU CAPACIDAD
                if (canasta.getCount() < canasta.getCapacidad()) {
                    //INICIALIZAMOS EL ALEATORIO
                    aleatorio = new Random().nextInt(nombreAlimento.length);
                    //CREAMOS UN ALIMENTO
                    Alimentos alimento = new Alimentos(nombreAlimento[aleatorio], descripcionAlimento[aleatorio],
                            precioAlimento[aleatorio]);
                    canasta.addElemento(alimento);
                    System.out.println(this.getName()+" añaden "+alimento.getNombre()+" a la "+canasta.getClass().getSimpleName());
                }//CUANDO LA CANASTA HA LLEGADO A SU CAPACIDAD LA METEMOS AL TABLERO
                else {
                    synchronized (lstTablero) {
                        //MIENTRAS EL CONTENIDO DEL TABLERA SEA IGUAL A LA CAPACIDAD SE PARA DE LLENAR EL TABLERO
                        while (lstTablero.getCount() == lstTablero.getCapacidadTablero()) {
                            lstTablero.wait();
                        }
                        //AÑADIMOS UN CONTENEDOR AL TABLERO
                        lstTablero.addElemento(canasta);
                        //HACEMOS ECO
                        System.out.println(getName() + " ha añadido: " + canasta.toString());
                        //ECO
                        System.out.printf("Tablero tiene " + lstTablero.getCount() + "\n");
                        //NOTIFICAMOS A TODOS
                        lstTablero.notifyAll();
                    }

                    //ECO DE CUANDO EL TABLERO ESTÁ LLENO
                    if (lstTablero.getCount() == lstTablero.getCapacidad()) {
                        System.out.println("Se ha llenado el tablero");
                    }
                    //VOLVEMOS A INICIALIZAR LA CANASTA
                    canasta = new Canasta();

                }
            } catch (InterruptedException ex) {
                interrupt=true;
            }

        }
    }

}
