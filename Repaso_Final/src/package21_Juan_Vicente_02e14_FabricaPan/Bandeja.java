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
//AL EXTENDER LOS CONTENEDORES DEL RC HEREDAN TODOS SUS MÉTODOS
public class Bandeja extends RC_Tablero<Alimentos> {
    //especifico capacidad
    int capacidad=36;

    //CONSTRUCTOR
    public Bandeja() {
        super();
        super.capacidad=capacidad;
    }
    
    
}
