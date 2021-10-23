/*
 Programas.
Servidor multihilo ArrayList contenedor de M hilos
cliente
establece conexión con servidor
N veces
recibe cadena texto
eco en pantalla de cadena de texto recibida
demora 1 segundo
envía cadena texto
cierra conexión
fin
servidor
puerto escucha
INFINITAS veces
acepta conexión cliente
verifica el número de servidorHilo corriendo conexiones aceptadas
SI hay M hilos cierra conexión aceptada
SINO crea servidorHilo para conexión aceptada
mete hilo en ArrayList
incrementa contador de conexiones aceptadas
fin
servidorHilo
N veces ( iteración )
envía cadena texto , número de cliente (conexión) y número de iteración
recibe cadena texto
eco en pantalla de cadena texto recibida
cierra conexión
fin
¿el servidor aceptará más de una conexión ?
¿ cuál es el máximo de conexiones aceptadas ?
Corred cliente y servidor en misma máquina , en el servidor M = 3 y corred 4 clientes . Observad lo que pasa con
el cliente 4 .
Corred cliente y servidor en máquinas distintas
 */
package tcp_multihiloArray_infinito;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

/**
 *
 * @author juanv
 */
public class Servidor_4_03_00_08 {
    //CONSTANTES

    private static final int PUERTO = 5000;
    private static final int TAMANO_LIST = 5;

    public static void main(String[] args) throws IOException, InterruptedException {
        //CREAMOS SOCKET SERVIDOR Y LE PASAMOS EL PUERTO POR DONDE ESCUCHA
        ServerSocket socketServidor = new ServerSocket(PUERTO);
        //CREAMOS LA LIST DE HILOS Y DEFINIMOS SU TAMAÑO
        List<Thread_Servidor_4_03_00_08> lstThreads = new ArrayList(TAMANO_LIST);
        //ECO
        System.out.println("ServerSocket abierto:");
        System.out.println("Puerto por el que escucha: " + socketServidor.getLocalPort());
        //BUCLE INFINITO ASI EL SERVIDOR PERMANECERÁ A LA ESCUCHA HASTA QUE LLEGUE OTRO CLIENTE
        for (int i = 0; true; i++) {
            //CREAMOS EL SOCKET CLIENTE Y LO CONECTAMOS CON EL DEL SERVIDOR
            Socket socketCliente = socketServidor.accept();
            //SI LA LIST NO HA LLEGADO AL MAXIMO DE SU CAPACIDAD, CREAMOS HILOS
            //if (lstThreads.size() < TAMANO_LIST) {
                //CREAMOS EL HILO Y LO ARRANCAMOS
                lstThreads.add(new Thread_Servidor_4_03_00_08(socketCliente));
                lstThreads.get(i).setName("Cliente " + (i + 1));
                lstThreads.get(i).start();
                //METEMOS HILO EN LA LIST
           /* } else {
               //MENSAJE SALIDA
               
                System.out.println("FIN del programa");
                socketCliente.close();
                break;
            }*/
        }

    }
}
