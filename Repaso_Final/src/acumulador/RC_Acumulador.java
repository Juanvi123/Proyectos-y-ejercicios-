/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acumulador;

/**
 *
 * @author juanv
 */
public class RC_Acumulador {
    //ACUMULADOR
    private int n;

    //CONSTRUCTOR
    public RC_Acumulador() {
        this.n=0;
    }
    /**
     * Con este método los hilos incrementarán el acumulador
     * @param i 
     */
    public synchronized void addIncremento(int i){
        //INCREMENTAMOS ACUMULADOR
        n+=i;
        System.out.println(Thread.currentThread().getName()+" incrementa acumulador");
        System.err.println("Acumulador: "+n);
    }
    
    //GETTER
    public int getN() {
        return n;
    }
    
}
