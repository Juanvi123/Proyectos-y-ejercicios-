/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huevo_pasado;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Hilo extends Thread {

    //CONSTANTES
    private static final int TIEMPO_MIN = 50;
    private static final int TIEMPO_MAX = 100;
    private static final char LETRA_INICIAL = 'a';
    private static final char LETRA_FINAL = 'z';

    //INSTANCIAMOS HUEVO
    private Huevo huevo;
    private char letra;
    private int nLetra;

    //CONSTRUCTOR
    public Hilo(Huevo huevo) {
        this.huevo = huevo;
        this.nLetra = 0;
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        if (huevo.getContador() >= 25 || huevo.getLetra() == 'z') {
            System.out.println(getName() + " FIN\n");
        } else {
            try {
                //TIEMPO ENTRE HILO E HILO
                this.sleep(new Random().nextInt((TIEMPO_MAX-TIEMPO_MIN)+1)+TIEMPO_MIN);
                //INICIALIZAMOS ALEATORIAMENTO LA NUEVA LETRA
                nLetra = new Random().nextInt((LETRA_FINAL - LETRA_INICIAL) + 1) + LETRA_INICIAL;
                letra = (char) nLetra;
                //INCRMENTAMOS CONTADOS
                huevo.setContador(huevo.getContador() + 1);
                //METEMOS LA NUEVA LETRA EN EL HUEVO
                huevo.setLetra(letra);
                //ECOS
                System.out.println("contador: " + huevo.getContador());
                System.out.println("letra: " + huevo.getLetra());
                //CREAMOS NUEVO HILO
                Hilo hilo = new Hilo(huevo);
                hilo.setName("Hilo " + (huevo.getContador() + 1));
                hilo.start();
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
