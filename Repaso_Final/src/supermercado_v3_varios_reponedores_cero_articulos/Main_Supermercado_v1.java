/*
versión 3
5 y 10 reponedores y entre 25 y 75 clientes.
Programa acaba cuando no hay más artículos
RC max Articulos en la estantería 50
Cliente. eco de nº de cosas compradas y cuanto se ha gastado
 */
package supermercado_v3_varios_reponedores_cero_articulos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author juanv
 */
public class Main_Supermercado_v1 {

    //CONSTANTES
    private static final int NUMERO_MIN_REPONEDORES = 5;
    private static final int NUMERO_MAX_REPONEDORES = 10;
    private static final int NUMERO_MIN_CLIENTES = 25;
    private static final int NUMERO_MAX_CLIENTES = 75;
    private static final int TIEMPO_CAJERA_CIERRA = 20000;

    public static void main(String[] args) throws InterruptedException {

        //CREAMOS ALEATORIAMENTE EL Nº DE REPONEDORES
        int nReponedores = new Random().nextInt((NUMERO_MAX_REPONEDORES - NUMERO_MIN_REPONEDORES) + 1) + NUMERO_MIN_REPONEDORES;
        System.out.println("Hay " + nReponedores + " reponedores");
        //CREAMOS ALEATORIAMENTE EL Nº DE CLIENTES
        int nClientes = new Random().nextInt((NUMERO_MAX_CLIENTES - NUMERO_MIN_CLIENTES) + 1) + NUMERO_MIN_CLIENTES;
        //SE ABREN LAS PUERTAS
        System.out.println("Se abren las puertas del super, entran " + nClientes + " clientes");
        //INSTANCIAMOS RC
        RC_Estanteria estanteria = new RC_Estanteria();
        //INSTANCIAMOS PRODUCTOR
        List<Reponedor> lstReponedor = new ArrayList<>();
        for (int i = 0; i < nReponedores; i++) {
            lstReponedor.add(new Reponedor(estanteria));
            lstReponedor.get(i).setName("Reponedor " + (i + 1));
            lstReponedor.get(i).start();
        }

        //INTANCIAMOS CLIENTES
        List<Clientes> lstClientes = new ArrayList<>();
        for (int i = 0; i < nClientes; i++) {
            lstClientes.add(new Clientes(estanteria));
            //INICIALIZAMOS CLIENTES
            lstClientes.get(i).setName("Cliente " + (i + 1));
            lstClientes.get(i).setDaemon(true);
            //ARRANCAMOS CLIENTES
            lstClientes.get(i).start();
        }
        //ESPERAMOS A LA FINALIZACIÓN DE LOS REPONEDORES
        for (int i = 0; i < nReponedores; i++) {
            lstReponedor.get(i).join();
        }
        for (int i = 0; i < nReponedores; i++) {
            while (lstReponedor.get(i).isAlive()) {
                Thread.sleep(10);
            }
        }
        //INTERRUMPIMOS A CLIENTES
        for (int i = 0; i < nClientes; i++) {
            lstClientes.get(i).interrupt();
        }
        //ESPERAMOS A QUE LOS CLIENTES FINALICEN
        for (int i = 0; i < nClientes; i++) {
            lstClientes.get(i).join();
        }
        for (int i = 0; i < nClientes; i++) {
            while (lstClientes.get(i).isAlive()) {
                Thread.sleep(10);
            }
        }
        //INSTANCIAMOS LA CAJERA
        Cajera cajera = new Cajera(estanteria);
        //INICIALIZAMOS CAJERA
        cajera.setName("Cajera");
        //ARRANCAMOS CAJERA
        cajera.start();
    }
}
