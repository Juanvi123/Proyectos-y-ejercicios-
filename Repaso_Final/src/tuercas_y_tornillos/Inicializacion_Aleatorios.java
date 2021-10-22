/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuercas_y_tornillos;

import java.util.Random;

/**
 *
 * @author juanv
 */
public class Inicializacion_Aleatorios {

    //CONSTANTES
    private static final double PRECIO_MIN = 0.35;
    private static final double PRECIO_MAN = 2.75;
    private static final double DIAMETRO_MIN = 0.0005;
    private static final double DIAMETRO_MAX = 0.095;
    private static final double LONGITUD_MIN = 0.05;
    private static final double LONGITUD_MAX = 0.95;

    //CONSTRUCTOR
    public Inicializacion_Aleatorios() {
    }

    //MÉTODOS
    public double iniPrecio() {
        double precio = Math.random() * (PRECIO_MAN) + PRECIO_MIN;
        return precio;
    }

    public double iniDiametro() {
        double diametro = Math.random() * (DIAMETRO_MAX) + DIAMETRO_MIN;
        return diametro;
    }

    public double iniLongitud() {
        double longitud = Math.random() * (LONGITUD_MAX) + LONGITUD_MIN;
        return longitud;
    }

    public String iniEtiqueta() {
        int n = new Random().nextInt(2);
        if (n == 0) {
            return "TORNILLO";
        } else {
            return "TUERCA";
        }
    }
}
