/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuercas_y_tornillos;

/**
 *
 * @author juanv
 */
public class Contable extends Thread {
    //INSTANCIAMOS EL RC
    RC_Caja caja;

    //CONSTRUCTOR
    public Contable(RC_Caja caja) {
        this.caja = caja;
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        System.out.println(getName()+" contabiliza ganacias: "+
                String.format("%.2f", caja.getPasta())+"€");
    }
    
}
