/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heladeria;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Heladeros extends Thread {

    //CONSTANTES
    private static final int TIEMPO = 500;
    private static final int N_MIN_HELADOS = 25;
    private static final int N_MAX_HELADOS = 75;
    //INSTANCIAMOS RC
    RC_Nevera nevera;
    //DEFINIMOS VARIABLES
    private String[] sabores = {"naranja", "limón", "almendras", "nata", "chocolate"};
    private double[] precio = {0.75, 0.95, 1.35, 0.80, 1.50};
    private int aleHelado;
    private int aleNumHelados;

    //CONSTRUCTOR
    public Heladeros(RC_Nevera nevera) {
        this.nevera = nevera;
        this.aleHelado=0;
        this.aleNumHelados= new Random().nextInt((N_MAX_HELADOS - N_MIN_HELADOS) + 1) + 
                N_MIN_HELADOS;
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        //DEFINIMOS Nº ALEATORIO DE HELADOS
        System.out.println(getName() + " hará " + aleNumHelados + " helados");
        for (int i = 0; i < aleNumHelados; i++) {
            try {
                //TIEMPO ENTRE HELADO Y HELADO QUE SE ELABORA
                this.sleep(TIEMPO);
                //INICIALIZAMOS CAMPOS DE HELADO ALEATORIAMENTE
                aleHelado=new Random().nextInt(sabores.length);
                //CREAMOS HELADO
                Helados helado=new Helados(sabores[aleHelado], precio[aleHelado]);
                //METEMOS HELADO EN RC
                nevera.addHelado(helado);
            } catch (InterruptedException ex) {
                Logger.getLogger(Heladeros.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //ECO FINAL HELADERO
        System.out.println(getName()+" FIN");
    }

}
