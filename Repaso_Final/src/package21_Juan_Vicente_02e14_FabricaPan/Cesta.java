/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package21_Juan_Vicente_02e14_FabricaPan;

/**
 *
 * @author juanv
 */
public class Cesta extends RC_Tablero<Alimentos>{

    //ESPECIFICAMOS EN EL CONSTRUCTOR, LA CAPACIDAD DE LA CESTA
    //PONER CONSTANTE NO HACER DERIVADO
    public Cesta() {
        super();
        super.capacidad=24;
    }
    
}
