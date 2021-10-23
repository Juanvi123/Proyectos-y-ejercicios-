/*
Programas.
Servidor multihilo N clientes aceptados
cliente
establece conexión con servidor
INFINITAS veces
recibe cadena texto
eco en pantalla de cadena de texto recibida
demora 1 segundo
envía cadena texto
cierra conexión
fin
servidor
abre puerto escucha
N veces
acepta conexión cliente
crea servidorHilo para conexión cliente
fin
servidorHilo
INFINITAS veces
envía cadena texto y número a cliente
recibe cadena texto
eco en pantalla de cadena texto recibida
cierra conexión
fin
¿el servidor aceptará más de una conexión ?
Arrancar el servidor y dos o más clientes ( ver que acepta simultáneamente varios clientes )
Corred cliente y servidor en máquinas distintas
 */
package pkg21_juan_vicente_4_03_00_06_servidormultihilo;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author juanv
 */
public class Servidor_4_03_00_06 {

    //CONSTANTES
    private static final int PUERTO = 5000;

    public static void main(String[] args) throws IOException {
        //CREAMOS SOCKET SERVIDOR Y LE PASAMOS EL PUERTO POR DONDE ESCUCHA
        ServerSocket socketServidor = new ServerSocket(PUERTO);
        //ECO
        System.out.println("ServerSocket abierto:");
        System.out.println("Puerto por el que escucha: " + socketServidor.getLocalPort());
        //BUCLE INFINITO
        Thread_Servidor thread_Servidor = null;
        for (int i = 0; i < 2; i++) {
            //CREAMOS EL SOCKET CLIENTE Y LO CONECTAMOS CON EL DEL SERVIDOR
            Socket socketCliente = socketServidor.accept();
            //CREAMOS EL HILO Y LO ARRANCAMOS
            thread_Servidor = new Thread_Servidor(socketCliente);
            thread_Servidor.setName("Cliente " + (i + 1));
            thread_Servidor.start();

        }
        System.out.println("no acepta a más clientes");
        System.out.println("Puertos usados:");
        for (Integer puertos : thread_Servidor.getLstPuertos()) {
            System.out.println(puertos);

        }

    }

}
