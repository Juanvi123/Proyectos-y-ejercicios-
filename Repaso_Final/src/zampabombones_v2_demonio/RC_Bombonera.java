/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zampabombones_v2_demonio;

import zampabombones_v1_interrupcion.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author juanv
 */
public class RC_Bombonera {
    //CONSTANTES
    private static final int CAPACIDAD_BOMBONERA=12;
    //CONTENEDOR
    private List<Bombones>lstBombones;
    //SEMAFORO
    private boolean bomboneraLlena;

    //CONSTRUCTOR
    public RC_Bombonera() {
        this.lstBombones=new ArrayList<>();
        this.bomboneraLlena=false;
    }
    
    //MÉTODOS
    public synchronized void addBombon(Bombones bombon) throws InterruptedException{
        //MIENTRAS LA BOMBONERA ESTÉ LLENA, LOS CHEFS ESPERAN
        while(bomboneraLlena)
            wait();
        //CHEF METE BOBÓN EN BOMBONERA
        lstBombones.add(bombon);
        //ECOS
        System.out.println(Thread.currentThread().getName()+" mete "+bombon.getN()+" de "+bombon.getSabor());
        System.err.println("La bombonera tiene "+getCount()+" bombones");
        //CUANDO LA BOMBONERA SE LLENA, NOTIFICAMOS AL RESTO
        if(getCount()==CAPACIDAD_BOMBONERA){
            //CAMBIAMOS EL VALOR DEL SEMAFORO
            bomboneraLlena=true;
            //NOTIFICAMOS A TODOS
            notifyAll();
        }
    }
    
    public int getCount(){
        return lstBombones.size();
    }
    public synchronized boolean marcarLlena(){
        return bomboneraLlena=true;
    }
    
    public synchronized Bombones removeBombon() throws InterruptedException{
        //MIENTRAS LA BOMBONERA NO ESTÉ VACÍA ESPERAN
        while(!bomboneraLlena)
            wait();
        //ELIMINAMOS UN BOMBÓN DE LA BOMBONERA DE MANERA ALEATORIA
        int ale=new Random().nextInt(getCount());
        Bombones bombon=lstBombones.get(ale);
        lstBombones.remove(bombon);
        //ECOS
        System.out.println(Thread.currentThread().getName()+" se ha comido "+bombon.getN()+" de "+bombon.getSabor());
        System.err.println("La bombonera tiene "+getCount()+" bombones");
        if(lstBombones.isEmpty()){
            //CAMBIAMOS SEMAFORO
            bomboneraLlena=false;
            //NOTIFICAMOS A TODOS
            notifyAll();
            //ECO
            System.err.println("La bombonera se ha vaciado");
        }
        return bombon;
    }
}
