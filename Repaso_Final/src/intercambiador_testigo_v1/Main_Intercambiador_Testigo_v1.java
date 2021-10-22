/*
El corredor1 intercambia un testigo con el corredor2 , el testigo es un número aleatorio . Para ello utilizan un
punto de intercambio formado por un semáforo y un número .
Inicialmente el semáforo está en ROJO , el valor del número es indistinto .
Si llega primero el corredor2 , el semáforo está en ROJO , simplemente esperará .
Cuando llega el corredor1 , escribe el número aleatorio en el punto de encuentro ( pone el testigo ) , cambia el
semáforo a VERDE , notifica el cambio y finaliza . El corredor2 recibirá la notificación , cogerá el testigo , hará
eco del valor del testigo y finaliza .
Si el corredor2 llega después del corredor1 , cogerá el testigo , hará eco del valor del testigo y finaliza.
Corredor1:
1. Aleatorio 1..1000
2. Eco : nombre hilo + “ sleep() ”
3. sleep(aleatorio)
4. Punto de encuentro
1. MIENTRAS semáforo ROJO
1. eco : nombre hilo + “ pongo testigo , semáforo en VERDE y wait()”
2. pone testigo
3. pone semáforo VERDE
4. wait()
2. coge testigo entregado por el otro corredor
3. pone testigo propio
4. notify()
5. eco : nombre hilo + testigo cogido + “ FIN “
6. fin
Corredor2: igual
versión 1 : bloque sincronizado en los corredores .
 */
package intercambiador_testigo_v1;

/**
 *
 * @author juanv
 */
public class Main_Intercambiador_Testigo_v1 {

    public static void main(String[] args) {
         //INSTANCIAMOS RC
         RC_Pto_Intercambio pto_Intercambio=new RC_Pto_Intercambio();
         
         //INSTANCIAMOS, INICIALIZAMOS Y ARRANCAMOS CORREDORES
         Corredor1 corredor1=new Corredor1(pto_Intercambio);
         corredor1.setName("Corredor 1");
         Corredor2 corredor2=new Corredor2(pto_Intercambio);
         corredor2.setName("Corredor 2");
         corredor1.start();
         corredor2.start();
    }
}
