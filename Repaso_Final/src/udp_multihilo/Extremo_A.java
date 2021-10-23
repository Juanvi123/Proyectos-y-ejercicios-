/*
Crear un programa que sea una conexión UDP unicast bidireccional donde el extremo B
mande un nº al extremo A, lo sume, lo mande al extremo B y lo sume, cuando el nº sea superior
a 100 el programa finalizará

Versión 2: hacerlo con letras y cuando llegue a la letra z el programa finalizará
Versión 3: hacerlo con multicast.
 */
package udp_multihilo;

import udp_extremos_bidireccionales_multicast.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Random;

/**
 *
 * @author juanv
 */
public class Extremo_A {

    //CONSTANTES
    private static final int PUERTO_A = 5555;
    private static final int PUERTO_B = 5556;
    private static final String IP = "239.255.255.255";
    private static final int MAXIMA_LONGITUD_ARRAY = 3000;
    private static final int N_MIN = 1;
    private static final int N_MAX = 10;

    //DATAGRAMPACKAGE
    DatagramPacket dgpEntrada;
    DatagramPacket dgpSalida;

    //DATAGRAMSOCKET
    MulticastSocket socket;
    InetAddress ip;
    //ARRAY
    byte[] arrayBytes;

    //VARIABLE
    private String mensaje;
    private int suma;
    private int n;

    //CONSTRUCTOR
    public Extremo_A() throws SocketException, UnknownHostException, IOException {
        this.mensaje = "";
        this.n = 0;
        this.suma = 0;
        this.arrayBytes = new byte[MAXIMA_LONGITUD_ARRAY];
        this.socket = new MulticastSocket(PUERTO_A);
        this.ip = InetAddress.getByName(IP);
        socket.joinGroup(ip);

      
      //  System.out.println("Ya no se aceptan más clientes");
    }
    public void recibirMensaje() throws IOException{
          for (int i=0;true;i++) {
            
            //INICIALIZAMOS EL ARRAY
            arrayBytes = new byte[MAXIMA_LONGITUD_ARRAY];
            //INICIALIZAMOS EL DGP DE ENTRADA
            dgpEntrada = new DatagramPacket(arrayBytes, arrayBytes.length);
            //RECIBIMOS MENSAJE
            System.out.println("Conexión con cliente " + (i + 1));
            socket.receive(dgpEntrada);
            //ECO DE ESPERA
            System.out.println(getClass().getSimpleName() + " Espera nº");
            Hilo_Extremo_A hilo = new Hilo_Extremo_A(dgpEntrada, dgpSalida, socket, ip,
                    arrayBytes,mensaje, n);
            hilo.setName("Cliente " + (i + 1));
            hilo.start();
        }
    }

 

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Extremo_A extremo_A = new Extremo_A();
        extremo_A.recibirMensaje();

        System.out.println("Extremo_A FIN");
    }

}
