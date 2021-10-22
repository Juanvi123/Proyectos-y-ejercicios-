/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package21_Juan_Vicente_02e14_FabricaPan;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author juanv
 */
//TIPO OBJECT
public class RC_Tablero<T> {
    //CONSTANTES
    private final int CAPACIDAD_TABLERO=12;
    //TODO LO QUE QUIERA COMPARTIR CON LAS CLASES HIJAS HA DE ESTAR EN PROTECTED
    protected int capacidad;
    //LIST CONTENIDO
    List<T>lstContenido; 

    //CONSTRUCTOR POR DEFECTO
    public RC_Tablero() {
        lstContenido=new ArrayList<>();
    }
    
    //MÉTODOS
    /**
     * Este método será utilizado tanto para añadir el alimento a sus contenedores (canasta, cesta
     * ,bandeja) como el contenedor al tablero
     */
    public synchronized void addElemento(T elemento){
        lstContenido.add(elemento);
    }
    
    /**
     * Este método nos servirá para comprobar la cantidad de cosas que hay en un contenedor
     * @return 
     */
    public synchronized int getCount(){
        return lstContenido.size();
    }
    /**
     * Retorna la capacidad del recipiente
     * @return 
     */
    public synchronized int getCapacidad(){
        return capacidad;
    }
    
    /**
     * Retorna la capacidad del 
     * @return 
     */
    public synchronized int getCapacidadTablero(){
        return CAPACIDAD_TABLERO;
    }
    
    /**
     * Método que usarán los dependientes (consumidores) y servirá para sacar del tablero los 
     * alimentos
     * @return 
     */
    public T removeElemento(){
        //GENERAMOS UN ALEATORIO PARA QUE SE QUITE UN ALIMENTO ALEATORIO DEL CONTENEDOR
        int ale=new Random().nextInt(lstContenido.size());
        T elemento=lstContenido.get(ale);
        lstContenido.remove(elemento);
        return elemento;
        
    }
    
    /**
     * Retorna los alimentos de un contenedor
     * @return 
     */
    public T[] getContenido(){
        return (T[])lstContenido.toArray();
    }
    
    //SOBREESCRITURAS

    @Override
    public String toString() {
        //QUE EL ECO EMPIECE POR EL NOMBRE DE LA CLASE (CANASTA, CESTA, BANDEJA...)
        String retorno=this.getClass().getSimpleName();
        if(this.getCount()>0){
            //AÑADIMOS UN ESPACIO Y :
            retorno+=": ";
            //VAMOS IMPRIMIENDO CADA ARTÍCULO DEL CONTENEDOR SEPARADOS POR COMAS
            for(T contenido:this.getContenido()){
                retorno+=contenido +", ";
            }
            //LE QUITAMOS LA ÚLTIMA COMA Y LE METEMOS UN PUNTO FINAL
            retorno=retorno.substring(0, retorno.length()-2);
        }
        //FINALIZAMOS CON UN PUNTO FINAL Y CON UN SALTO DE LÍNEA
        return retorno+".\n"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
