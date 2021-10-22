/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado_v2_interrupt_cajera;

import supermercado_1_cliente.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Reponedor extends Thread {

    //CONSTANTES
    private static final int NUMERO_MIN_ARTICULOS = 40;
    private static final int NUMERO_MAX_ARTICULOS = 50;
    private static final int TIEMPO_MIN = 100;
    private static final int TIEMPO_MAX = 300;

    //INSTANCIAMOS RC
    RC_Estanteria estanteria;

    //INICIALIZAMOS CAMPOS ARTICULOS
    private String[] nombreArticulos = {"Sobre de sopa", "Bolsa de macarrones",
        "Saco de arroz", "Saco de garbanzos"};
    private double[] precio = {0.95, 2.17, 2.63, 3.21};
    private int nArticulos;
    private int aleArticulo;

    //CONSTRUCTOR
    public Reponedor(RC_Estanteria estanteria) {
        this.estanteria = estanteria;
        this.nArticulos = 0;
        this.aleArticulo = 0;
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {

        nArticulos = new Random().nextInt((NUMERO_MAX_ARTICULOS - NUMERO_MIN_ARTICULOS) + 1) + NUMERO_MIN_ARTICULOS;
        System.out.println("El reponedor va a colocar " + nArticulos + " artículos");
        for (int i = 0; i < nArticulos; i++) {
            try {
                //TIEMPO ENTRE ARTÍCULO Y ARTÍCULO
                this.sleep(new Random().nextInt((TIEMPO_MAX - TIEMPO_MIN) + 1) + TIEMPO_MIN);
                //INICIALIZAMOS LOS CAMPOS ARTICULO
                aleArticulo = new Random().nextInt(nombreArticulos.length);
                //CREAMOS EL ARTÍCULO
                Articulos articulo = new Articulos(nombreArticulos[aleArticulo] + "(artículo " + (i + 1) + ")",
                        precio[aleArticulo]);
                //METEMOS ARTÍCULO EN RC
                estanteria.addArticulo(articulo);

            } catch (InterruptedException ex) {
                System.out.println("Cajera echa a " + getName());
            }
        }
        System.out.println(getName() + " FIN");
    }

}
