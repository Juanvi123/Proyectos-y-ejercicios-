/*
 En un supermercado se venden artículos. Trabajan un reponedor y una cajera. 
Entran varios clientes.

El artículo tiene un nombre y un precio.

En el supermercado hay una estantería donde el reponedor coloca los artículos
al comienzo de la jornada. Inicialmente está vacía.

Al comienzo de la jornada, el reponedor determina el número de artículos
( entre 40 y 50) que  pondrá en la estantería. A continuación los colocará.
Para ello tomará el nombre del artículo de está lista: sopa, macarrón, arroz,
garganzos y fijará un precio aleatorio entre 2 y 4  euros y lo colocará en la 
estantería, ello conlleva un tiempo de espera aleatorio 5-15 milisegundos. El 
reponedor finaliza cuando la estantería está llena.

Cuando la estantería está llena se abren las puertas del local, entran los
clientes y la cajera va a su puesto. El número de clientes que entran es 
aleatorio entre 5 y 15.

Los clientes cogen un artículo de la estantería, se demoran un tiempo  y pagan 
a la cajera.

Cuando no hay más clientes la cajera calcula el importe total de las ventas y 
acaba.

 */
package supermercado_1_cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author juanv
 */
public class Main_Supermercado_v1 {

    //CONSTANTES
    private static final int NUMERO_MIN_CLIENTES = 5;
    private static final int NUMERO_MAX_CLIENTES = 15;

    public static void main(String[] args) throws InterruptedException {
        //INSTANCIAMOS RC
        RC_Estanteria estanteria = new RC_Estanteria();
        //INSTANCIAMOS PRODUCTOR
        Reponedor reponedor = new Reponedor(estanteria);
        reponedor.setName("Reponedor");
        reponedor.start();

        //CREAMOS ALEATORIAMENTE EL Nº DE CLIENTES
        int nClientes = new Random().nextInt((NUMERO_MAX_CLIENTES - NUMERO_MIN_CLIENTES) + 1) + NUMERO_MIN_CLIENTES;
        //ESPERAMOS A QUE REPONEDOR FINALICE
        reponedor.join();
        while (reponedor.isAlive()) {
            Thread.sleep(10);
        }

        //SE ABREN LAS PUERTAS
        System.out.println("Se abren las puertas del super, entran " + nClientes);
        //INTANCIAMOS CLIENTES
        List<Clientes> lstClientes = new ArrayList<>();
        for (int i = 0; i < nClientes; i++) {
            lstClientes.add(new Clientes(estanteria));
            //INICIALIZAMOS CLIENTES
            lstClientes.get(i).setName("Cliente " + (i + 1));
            //ARRANCAMOS CLIENTES
            lstClientes.get(i).start();
        }

        //ESPERAMOS A QUE LOS CLIENTES ACABEN
        for (int i = 0; i < nClientes; i++) {
            lstClientes.get(i).join();
        }
        for (int i = 0; i < nClientes; i++) {
            while(lstClientes.get(i).isAlive()){
                Thread.sleep(10);
            }
        }
        //INSTANCIAMOS LA CAJERA
        Cajera cajera=new Cajera(estanteria);
        //INICIALIZAMOS CAJERA
        cajera.setName("Cajera");
        //ARRANCAMOS CAJERA
        cajera.start();
    }
}
