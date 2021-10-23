/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huevo_pasado;

/**
 *
 * @author juanv
 */
public class Huevo {
    //DECLARAMOS VARIABLES
    private char letra;
    private int contador;

    //CONSTRUCTOR
    public Huevo(char letra, int contador) {
        this.letra = letra;
        this.contador = contador;
    }
    
    //GETTERS Y SETTERS
    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    
}
