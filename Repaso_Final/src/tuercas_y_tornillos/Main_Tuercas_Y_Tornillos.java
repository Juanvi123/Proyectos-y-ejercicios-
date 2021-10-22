/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuercas_y_tornillos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author juanv
 */
public class Main_Tuercas_Y_Tornillos {

    public static void main(String[] args) throws InterruptedException {
        //CONSTANTES
        final int CANTIDAD_TORNILLEROS = 5;
        //INSTANCIAMOS RC
        RC_Caja caja = new RC_Caja();
        //INSTANCIAMOS PRODUCTORES
        List<Tornilleros> lstTornilleros = new ArrayList<>();
        for(int i=0;i<CANTIDAD_TORNILLEROS;i++){
            lstTornilleros.add(new Tornilleros(caja));
            lstTornilleros.get(i).setName("Tornillero "+(i+1));
            lstTornilleros.get(i).start();
        }
        //ESPERAMOS A QUE MUERAN LOS TORNILLEROS
         for(int i=0;i<CANTIDAD_TORNILLEROS;i++){
            lstTornilleros.get(i).join();
        }
          for(int i=0;i<CANTIDAD_TORNILLEROS;i++){
           while(lstTornilleros.get(i).isAlive()){
               Thread.sleep(10);
           }
        }
          //CREAMOS AL CONTABLE
          Contable contable=new Contable(caja);
          contable.setName("Contable");
          contable.start();
          while(contable.isAlive())
              Thread.sleep(10);
          System.out.println(Thread.currentThread().getName()+" FIN");
    }
}
