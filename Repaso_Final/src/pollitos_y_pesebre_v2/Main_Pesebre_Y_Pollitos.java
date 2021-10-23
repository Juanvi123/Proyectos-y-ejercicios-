/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pollitos_y_pesebre_v2;

import pesebre_y_pollitos.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juanv
 */
public class Main_Pesebre_Y_Pollitos {

    public static void main(String[] args) throws InterruptedException {
        //CONSTANTES
        final int N_POLLITOS = 10;
        //INSTANCIAMOS EL RC
        RC_Pesebre pesbre = new RC_Pesebre();
        //INSTANCIAMOS CONSUMIDORES
        List<Pollitos> lstPollitos = new ArrayList<>();
        for (int i = 0; i < N_POLLITOS; i++) {
            lstPollitos.add(new Pollitos(pesbre));
            lstPollitos.get(i).setName("Pollito " + (i + 1));
        }
        //INSTANCIAMOS PRDOCUTOR
        Granjero granjero = new Granjero(pesbre,lstPollitos);
        //INICIALIZAMOS GRANJERO
        granjero.setName("Granjero");
        granjero.setDaemon(true);
        //ARRANCAMOS GRANJERO
        granjero.start();
        for (int i = 0; i < N_POLLITOS; i++) {
            lstPollitos.get(i).start();
        }
        //ESPERAMOS A LA FINALIZACIÓN DE TODOS LOS POLLITOS
        for (int i = 0; i < N_POLLITOS; i++) {
            lstPollitos.get(i).join();
        }
        for (int i = 0; i < N_POLLITOS; i++) {
            while (lstPollitos.get(i).isAlive()) {
                Thread.sleep(10);
            }
        }
        // ECO GRANJERO
        System.out.println("Ya no quedan pollitos");
        System.out.println(granjero.getName() + " FIN");
        System.out.println(Thread.currentThread().getName() + " FIN");
    }

}
