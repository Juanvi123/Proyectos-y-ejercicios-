/*
En una pequeña cafetería trabajan dos camareras ; 
venden bocadillos a los clientes. Utilizan una bandeja 
que caben 50 bocadillos . Junto a la bandeja  hay una
caja de  recaudación. Ambos están compartidos 
conjuntamente ( evitamos dos recursos compartidos 
en el ejercicio ).

Los bocadillos pueden ser de jamón (1,5€) ; de bacon 
(1.0 €)  o de salchichas (0,80 €).

La camareras  hacen y  meten B bocadillos en la bandeja 
( B número aleatorio entre 5 y 50 ) antes de abrir la cafetería.

La puerta de la cafetería se abre y entran N clientes ( N número aleatorio 10-70 ) todos al mismo tiempo , es la hora del recreo. ( N y B son números aleatorios , pueden ser iguales o distintos ).

Cada cliente se comporta así : demora ( 5-10 mseg ) , coge bocadillo , demora
( 5-10 mseg ) , paga  ( incrementa la recaudación de la caja ) , demora  
( 5-10 mseg )  y  marcha  por  la  puerta ( fin de ejecución ).

Si hay más clientes que bocadillos en la bandeja , las camareras harán 
los bocadillos necesarios para que todos los  clientes coman bocadillo 
y esperarán a que no haya clientes. En ese comento hacen caja ( eco en pantalla
de la recaudación diaria ) y finaliza la jornada ( fin de ejecución ).

 */
package cafeteria;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author juanv
 */
public class Main_Cafeteria {

    //CONSTANTES
    private static final int N_CAMARERAS = 2;
    private static final int N_MIN_CLIENTES = 50;
    private static final int N_MAX_CLIENTES = 100;

    public static void main(String[] args) throws InterruptedException {
        //INSTANCIAMOS RC
        RC_Bandeja bandeja = new RC_Bandeja();

        //INICIALIZAMOS EL Nº DE CLIENTES
        int nClientes = new Random().nextInt((N_MAX_CLIENTES - N_MIN_CLIENTES) + 1) + N_MIN_CLIENTES;
        System.out.println("Habrá " + nClientes + " clientes");
        //INSTANCIAMOS CONSUMIDORES
        List<Clientes> lstClientes = new ArrayList<>();
        for (int i = 0; i < nClientes; i++) {
            lstClientes.add(new Clientes(bandeja));
            lstClientes.get(i).setName("Cliente " + (i + 1));
        }

        //INSTANCIAMOS PRODUCTORES
        List<Camareras> lstCamareras = new ArrayList<>();
        for (int i = 0; i < N_CAMARERAS; i++) {
            lstCamareras.add(new Camareras(bandeja, lstClientes));
            lstCamareras.get(i).setName("Camarera " + (i + 1));
            lstCamareras.get(i).setDaemon(true);
            lstCamareras.get(i).start();
        }

        //ARRANCAMOS LOS CONSUMIDORES
        for (int i = 0; i < nClientes; i++) {
            lstClientes.get(i).start();
        }

        //ESPERAMOS A QUE FINALICEN LAS CAMARERAS
        for (int i = 0; i < nClientes; i++) {
            lstClientes.get(i).join();
        }
        for (int i = 0; i < nClientes; i++) {
            while (lstClientes.get(i).isAlive()) {
                Thread.sleep(10);
            }
        }
        bandeja.recaudacion();
        for (int i = 0; i < N_CAMARERAS; i++) {
            System.out.println(lstCamareras.get(i).getName() + " FIN, precio stock elaborado: "
                    + String.format("%.2f", lstCamareras.get(i).getRecaudacion()) + "€");
        }
        System.out.println(Thread.currentThread().getName() + " FIN");
    }

}
