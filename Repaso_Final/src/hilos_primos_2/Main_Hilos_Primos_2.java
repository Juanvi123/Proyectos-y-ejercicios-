/*
Un número es compartido entre varios hilos. El número es leído por los hilos
primos e incrementado por los hilos incremento .

El hilo incremento: obtiene un número aleatorio e incrementa el número compartido
con el número aleatorio obtenido.

El hilo primo: lee el número compartido , calcula si es primo. Si lo es escribe 
un mensaje, envía una señal a todos los hilos (incremento y primo) para que acaben
y finalicen. Si no es primo continua corriendo, escribe un puntito y lee otro 
número compartido .

El sistema tiene un número aleatorio N (2-12) de hilos incremento y un número
aleatorio M (4-8) de hilos primos.


Versión  2 ( a partir de la solución anterior ) :
	El número compartido sólo puede ser leído una vez ; si otro hilo primo 
intenta  releerlo deberá esperar .

Versión 3 ( a partir  de la soluciónanterior )
	El número compartido sólo puede ser incrementado una vez , los hilos
incremento deberán esperar si el número no ha sido leído por un hilo primo .

 */
package hilos_primos_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author juanv
 */
public class Main_Hilos_Primos_2 {

    //CONSTANTES
    private static final int N_MIN_HILOS_PRIMOS = 4;
    private static final int N_MAX_HILOS_PRIMOS = 8;
    private static final int N_MIN_HILOS_INCREMENTO = 2;
    private static final int N_MAX_HILOS_INCREMENTO = 12;

    public static void main(String[] args) {
        //DEFINIMOS EL Nº DE HILOS PRIMOS E HILOS INCREMENTO
        int nPrimos=new Random().nextInt((N_MAX_HILOS_PRIMOS-N_MIN_HILOS_PRIMOS)+1)+N_MIN_HILOS_PRIMOS;
        int nIncremento=new Random().nextInt((N_MAX_HILOS_INCREMENTO-N_MIN_HILOS_INCREMENTO)+1)+N_MIN_HILOS_INCREMENTO;
        System.out.println("Se han creado "+nPrimos+" Hilos Primos y "+nIncremento+" Hilos Incremento");
        //INSTANCIAMOS RC
       RC_N rc_n=new RC_N();
       //INSTANCIAMOS HILOS INCREMENTO
        List<Hilos_Incremento>lstHilosIncremento=new ArrayList<>();
        for(int i=0;i<nIncremento;i++){
            lstHilosIncremento.add(new Hilos_Incremento(rc_n));
            lstHilosIncremento.get(i).setName("Hilo_Incremento "+(i+1));
            lstHilosIncremento.get(i).start();
        }
        //INSTANCIAMOS HILOS PRIMOS
        List<Hilos_Primos>lstHilosPrimos=new ArrayList<>();
        for(int i=0;i<nPrimos;i++){
            lstHilosPrimos.add(new Hilos_Primos(rc_n));
            lstHilosPrimos.get(i).setName("Hilo_Incremento "+(i+1));
            lstHilosPrimos.get(i).start();
        }
        
        
    }
}
