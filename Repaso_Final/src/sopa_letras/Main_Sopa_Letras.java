/*
En un sistema hay tres hilos , dos generan letras (a .. z ) aleatoriamente
y las ponen en un recurso compartido , cuando lo llenan paran ; el tercer
hilo busca una combinación de letras en el recurso compartido ,
si no la encuentra vacía el recurso compartido y lo deja para que sea 
llenado por los otros hilos ; si encuentra la combinación ,  avisa a los 
otros hilos para que acaben y él tambien acaba .

El recurso compartido contiene dos letras .
La combinación buscada es el par (az) .
No puede utilizarse el método interrupt() .

 */
package sopa_letras;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author juanv
 */
public class Main_Sopa_Letras {

    //CONSTANTES
    private static final int NUMERO_GENERADORES = 2;

    public static void main(String[] args) {
        //INSTANCIAMOS RC
        RC_Letras letras = new RC_Letras();
        //INSTANCIAMOS PRODUCTORES
        List<Generadores_Letras> lstGeneradores = new ArrayList<>();
        for (int i = 0; i < NUMERO_GENERADORES; i++) {
           lstGeneradores.add(new Generadores_Letras(letras));
           lstGeneradores.get(i).setName("Generador "+(i+1));
           lstGeneradores.get(i).setDaemon(true);
           lstGeneradores.get(i).start();
        }
        //INSTANCIAMOS CONSUMIDOR
        Buscador_combinacion buscador=new Buscador_combinacion(letras);
        buscador.setName("Buscador");
        buscador.start();
    }

}
