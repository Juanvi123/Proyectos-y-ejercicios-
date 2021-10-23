/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package21_Juan_Vicente_02e14_FabricaPan;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juanv
 */
public class Main_Fabrica_Pan_V1 {

    public static void main(String[] args) throws InterruptedException {
        //CONSTANTES
        final int CANTIDAD_PANADEROS = 3;
        final int CANTIDAD_BOLLEROS = 2;
        final int CANTIDAD_PASTELEROS = 4;
        final int CANTIDAD_DEPENDIENTES = 2;
        //INSTANCIAMOS EL RECURSO COMPARTIDO
        RC_Tablero<RC_Tablero<Alimentos>> tablero = new RC_Tablero();
        //INSTANCIAMOS PRODUCTORES
        List<Panaderos> lstPanaderos = new ArrayList<>();
        List<Pasteleros> lstPasteleros = new ArrayList<>();
        List<Bolleros> lstBolleros = new ArrayList<>();
        //INICIALIZAMOS Y ARRANCAMOS LOS PRODUCTORES
        System.out.println("Se abre la tienda");
        for (int i = 0; i < CANTIDAD_PANADEROS; i++) {
            lstPanaderos.add(new Panaderos(tablero));
            lstPanaderos.get(i).setName("Panadero " + (i + 1));
            lstPanaderos.get(i).start();
        }
        for (int i = 0; i < CANTIDAD_PASTELEROS; i++) {
            lstPasteleros.add(new Pasteleros(tablero));
            lstPasteleros.get(i).setName("Pastelero " + (i + 1));
            lstPasteleros.get(i).start();
        }
        for (int i = 0; i < CANTIDAD_BOLLEROS; i++) {
            lstBolleros.add(new Bolleros(tablero));
            lstBolleros.get(i).setName("Bollero " + (i + 1));
            lstBolleros.get(i).start();
        }
        //CREAMOS LOS CONSUMIDORES
        List<Dependientes> lstDependientes = new ArrayList<>();
        for (int i = 0; i < CANTIDAD_DEPENDIENTES; i++) {
            lstDependientes.add(new Dependientes(tablero));
            lstDependientes.get(i).setName("Dependiente " + (i + 1));
            lstDependientes.get(i).start();
        }
        Thread.sleep(10000);
        
        //INTERRUMPO A TODOS LOS HILOS
         for (int i = 0; i < CANTIDAD_PANADEROS; i++) {
            lstPanaderos.get(i).interrupt();
        }
        for (int i = 0; i < CANTIDAD_PASTELEROS; i++) {
            lstPasteleros.get(i).interrupt();
        }
        for (int i = 0; i < CANTIDAD_BOLLEROS; i++) {
            lstBolleros.get(i).interrupt();
        }
        for (int i = 0; i < CANTIDAD_DEPENDIENTES; i++) {
            lstDependientes.get(i).interrupt();
        }
        //ESPERO A LA FINALIZACIÓN DE TODOS ELLOS
         for (int i = 0; i < CANTIDAD_PANADEROS; i++) {
            while(lstPanaderos.get(i).isAlive()){
                
            }
        }
         System.out.println("Panaderos se van");
        for (int i = 0; i < CANTIDAD_PASTELEROS; i++) {
            while(lstPasteleros.get(i).isAlive()){
                
            }
        }
        System.out.println("Pasteleros se van");
        for (int i = 0; i < CANTIDAD_BOLLEROS; i++) {
            while(lstBolleros.get(i).isAlive()){
                
            }
        }
        System.out.println("Bolleros se van");
        for (int i = 0; i < CANTIDAD_DEPENDIENTES; i++) {
            while(lstDependientes.get(i).isAlive()){
                
            }
        }
        Thread.sleep(1000);
        System.out.println("Dependientes se van ");
        System.out.println("Se cierra la tienda");
        System.out.println(Thread.currentThread().getName()+" FIN");
    }

}
