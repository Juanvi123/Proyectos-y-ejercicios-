/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrera_5_corredores;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juanv
 */
public class Main_Carrera_5_Corredores {

    //CONSTANTES
    private static final int N_CORREDORES = 5;
    
    public static void main(String[] args) throws InterruptedException {
        //INSTANCIAMOS CORREDORES
        List<Thread_Corredor> lstCorredores = new ArrayList<>();
        for (int i = 0; i < N_CORREDORES; i++) {
            lstCorredores.add(new Thread_Corredor());
        }
        //INICIALIZAMOS HILOS
        for (int i = 0; i < N_CORREDORES; i++) {
            lstCorredores.get(0).setName("Ana");
            lstCorredores.get(1).setName("Borja");
            lstCorredores.get(2).setName("Casimiro");
            lstCorredores.get(3).setName("Daniel");
            lstCorredores.get(4).setName("Ezequiel");
        }
        //ARRANCAMOS HILOS
        for (int i = 0; i < N_CORREDORES; i++) {
            lstCorredores.get(i).start();
        }
        //ESPERAMOS A LA FINALIZACIÓN DE TODOS ELLOS
        for (int i = 0; i < N_CORREDORES; i++) {
            lstCorredores.get(i).join();
        }
        for (int i = 0; i < N_CORREDORES; i++) {
            while (lstCorredores.get(i).isAlive()) {
                Thread.sleep(10);
            }
        }
        System.err.println("Finaliza la carrera");
        //IMPRIMIMOS CADENA CONCATENADA
        String cadena="";
          for (int i = 0; i < N_CORREDORES; i++) {
              cadena+=lstCorredores.get(i).getCadena()+", ";
        }
          System.out.println(cadena);
           System.out.println(Thread.currentThread().getName()+" FIN");
        
    }
}
