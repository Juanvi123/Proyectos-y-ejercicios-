/*
 En una heladería se elaboran helados que colocan en una nevera isoterma
que contiene hasta 25 unidades.
Los helados estás etiquetados con un sabor y un precio. Los sabores son:
naranja, limón, almendra, nata y chocolate. Los precios varían en el 
rango (0.45, …, 3 ) €.

Los heladeros elaboran un helado , lo  dejan en la nevera y esperan un 
segundo. Si la nevera está llena los heladeros esperan.

Los niños están encantados con los helados, cogen un helado de la nevera,
hacen eco del sabor y del precio del helado , esperan cinco segundos y
cogen otro helado. Si la nevera está vacía esperan.

En la heladería hay cinco heladeros y diez niños.
Los heladeros elaboran un número aleatorio de helados y se marchan.
Los niños se van de la heladería cuando todos los heladeros se han 
marchado y no hay helados en la nevera.

 */
package heladeria;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juanv
 */
public class Main_Heladeria {
//CONSTANTES

    private static final int CANTIDAD_HELADEROS = 5;
    private static final int CANTIDAD_NINOS = 10;

    public static void main(String[] args) throws InterruptedException {
        //INTANCIAMOS RC
        RC_Nevera nevera = new RC_Nevera();
        //INSTANCIAMOS PRODUCTORES
        List<Heladeros> lstHeladeros = new ArrayList<>();
        for (int i = 0; i < CANTIDAD_HELADEROS; i++) {
            lstHeladeros.add(new Heladeros(nevera));
            lstHeladeros.get(i).setName("Heladero " + (i + 1));
            lstHeladeros.get(i).start();
        }
        //INSTANCIAMOS CONSUMIDORES
        List<Ninos> lstNinos = new ArrayList<>();
        for (int i = 0; i < CANTIDAD_NINOS; i++) {
            lstNinos.add(new Ninos(nevera));
            lstNinos.get(i).setName("Niño " + (i + 1));
            lstNinos.get(i).setDaemon(true);
            lstNinos.get(i).start();
        }
        //ESPERAMOS HASTA QUE LOS PRODUCTORES FINALICEN
        for (int i = 0; i < CANTIDAD_HELADEROS; i++) {
            lstHeladeros.get(i).join();
        }
        for (int i = 0; i < CANTIDAD_HELADEROS; i++) {
           while(lstHeladeros.get(i).isAlive()){
               Thread.sleep(10);
           } 
        }
        //INTERRUMPIMOS A CONSUMIDORES
        for (int i = 0; i < CANTIDAD_NINOS; i++) {
            lstNinos.get(i).interrupt();
        }
        //ECO FINAL MAIN
        Thread.sleep(1500);
        System.out.println(Thread.currentThread().getName()+" FIN");
    }
}
