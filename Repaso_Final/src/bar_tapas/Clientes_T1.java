/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bar_tapas;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Clientes_T1 extends Thread {

    //CONSTANTES
    private static final int TIEMPO_MIN_BEBIDAS = 50;
    private static final int TIEMPO_MAX_BEBIDAS = 250;
    private static final int TIEMPO_MIN_TAPAS = 50;
    private static final int TIEMPO_MAX_TAPAS = 250;
    private static final int N_MIN_BEBIDAS = 1;
    private static final int N_MAX_BEBIDAS = 3;

    //INSTANCIAMOS RC
    RC_Barra barra;

    //VARIABLES
    private int nBebidas;
    private double importe;
    private String pedido;

    //BOOLEANO PARA CONTROLAR LA 
    private boolean interrupt;

    //CONSTRUCTOR
    public Clientes_T1(RC_Barra barra) {
        this.barra = barra;
        this.nBebidas = new Random().nextInt((N_MAX_BEBIDAS - N_MIN_BEBIDAS) + 1) + N_MIN_BEBIDAS;
        this.importe = 0.0;
        this.pedido="";
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        try {
            //ECO Nº DE BEBIDAS QUE VA A COGER EL CLIENTE
            System.out.println(getName() + " coge " + nBebidas);
            //MIENTRAS EL CLIENTE NO SEA INTERREUMPIDO
            while (!interrupt) {
                //COMPRA BEBIDAS
                for (int i = 0; i < nBebidas; i++) {
                 //TIEMPO ENTRE BEBIDAS
                 //this.sleep(new Random().nextInt((TIEMPO_MAX_BEBIDAS-TIEMPO_MIN_BEBIDAS)+1)+TIEMPO_MIN_BEBIDAS);
                  Bebidas bebida=  barra.removeBebidas();
                  importe+=bebida.getPrecio();
                  pedido+=bebida.getNombre()+", ";
                }
                
                //COMPRA TAPA
                Tapas tapa=barra.removeTapas();
                importe+=tapa.getPrecio();
                pedido+="y "+tapa.getNombre();
                
                
            }
        } catch (InterruptedException ex) {
            interrupt=true;
            //System.out.println(getName()+" FIN, pagado "+String.format("%.2f", importe)+"€");
        }catch(NullPointerException ne){
            
        }
   
        
    }
     //GETTERS
    public double getImporte() {
        return importe;
    }

    public String getPedido() {
        return pedido;
    }
    

}
