/*
En una pequeña cafetería trabajan dos camareras ; venden bocadillos a los clientes.
Utilizan una bandeja que caben 50 bocadillos . Junto a la bandeja  hay una caja de 
recaudación. Ambos están compartidos conjuntamente ( evitamos dos recursos compartidos
en el ejercicio ).

Los bocadillos pueden ser de jamón (1,5€) ; de bacon (1.0 €)  o de salchichas (0,80 €)
La camareras  hacen y  meten B bocadillos en la bandeja ( B número aleatorio entre 5 y 
50 ) antes de abrir la cafetería.
La puerta de la cafetería se abre y entran N clientes ( N número aleatorio 10-70 )
todos al mismo tiempo , es la hora del recreo. ( N y B son números aleatorios ,
pueden ser iguales o distintos ).
Cada cliente se comporta así : demora ( 5-10 mseg ) , coge bocadillo , demora 
( 5-10 mseg ) , paga  ( incrementa la recaudación de la caja ) , demora 
( 5-10 mseg )  y  marcha  por  la  puerta ( fin de ejecución ).

Si hay más clientes que bocadillos en la bandeja , las camareras harán los
bocadillos necesarios para que todos los  clientes coman bocadillo y esperarán 
a que no haya clientes. En ese momento hacen caja ( eco en pantalla de la recaudación
diaria ) y finaliza la jornada ( fin de ejecución ).

 */
package cafeteria2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author juanv
 */
public class main_Cafetria2 {

    //CONSTANTES
    private static final int NUMERO_MIN_CLIENTES = 10;
    private static final int NUMERO_MAX_CLIENTES = 70;
    private static final int NUMERO_CAMARERAS = 2;
    private static final int TIEMPO_ABRIR=5000;

    public static void main(String[] args) throws InterruptedException {
        
        //DEFFINIMOS EL Nº DE CLIENTES QUE VAN A ENTRAR
        int nClientes = new Random().nextInt((NUMERO_MAX_CLIENTES - NUMERO_MIN_CLIENTES) + 1) + NUMERO_MIN_CLIENTES;
        System.out.println("Van a entrar " + nClientes+" clientes");
        
        //INSTANCIAMOS RC
        RC_Bandeja bandeja = new RC_Bandeja();
        
        //INSTANCIAMOS E INICIALIZAMOS CONSUMIDORES
        List<Clientes> lstClientes = new ArrayList<>();
        for(int i=0;i<nClientes;i++){
            lstClientes.add(new Clientes(bandeja));
            lstClientes.get(i).setName("Cliente "+(i+1));
        }
        
        //INSTANCIAMOS, INICIALIZAMOS Y ARRANCAMOS PRODUCTORES
        List<Camareras>lstCamareras=new ArrayList<>();
        for(int i=0;i<NUMERO_CAMARERAS;i++){
            lstCamareras.add(new Camareras(bandeja, lstClientes));
            lstCamareras.get(i).setName("Camarera "+(i+1));
            lstCamareras.get(i).setDaemon(true);
            lstCamareras.get(i).start();
        }
        
        //ESPERAMOS HASTA QUE ABRAN
        Thread.sleep(TIEMPO_ABRIR);
        //ABRIMOS LA TIENDA
        bandeja.setAbrirTienda(true);
        
        //ARRANCAMOS CONSUMIDORES
           for(int i=0;i<nClientes;i++){
            lstClientes.get(i).start();
        }
        
        //ESPERAMOS A QUE LOS CLIENTES ACABEN
         for(int i=0;i<nClientes;i++){
            lstClientes.get(i).join();
        }
          for(int i=0;i<nClientes;i++){
           while(lstClientes.get(i).isAlive()){
               Thread.sleep(10);
           }
        }
          //IMPRIMIMOS GANANCIAS
          Thread.sleep(1000);
          System.out.println("Ganancias totales: "+
                  String.format("%.2f", bandeja.getGanancias())+"€");
          System.out.println(Thread.currentThread().getName()+" FIN");
    }
}
