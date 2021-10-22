/*
Crear un programa que sea una conexión UDP unicast bidireccional donde el extremo B
mande un nº al extremo A, lo sume, lo mande al extremo B y lo sume, cuando el nº sea superior
a 100 el programa finalizará

Versión 2: hacerlo con letras y cuando llegue a la letra z el programa finalizará
Versión 3: hacerlo con multicast.
 */
package udp_extremos_bidireccionales_multicast;

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
    private int mensaje;
    private int suma;
    private int n;

    //CONSTRUCTOR
    public Extremo_A() throws SocketException, UnknownHostException, IOException {
        this.mensaje = 0;
        this.n = 0;
        this.suma=0;
        this.arrayBytes = new byte[MAXIMA_LONGITUD_ARRAY];
        this.socket = new MulticastSocket(PUERTO_A);
        this.ip=InetAddress.getByName(IP);
        socket.joinGroup(ip);
    }

    public void recibirMensaje() throws IOException, ClassNotFoundException {

        //INICIALIZAMOS EL ARRAY
        arrayBytes = new byte[MAXIMA_LONGITUD_ARRAY];
        //INICIALIZAMOS EL DGP DE ENTRADA
        dgpEntrada = new DatagramPacket(arrayBytes, arrayBytes.length);
        //ECO DE ESPERA
        System.out.println(getClass().getSimpleName() + " Espera nº");
        //RECIBIMOS MENSAJE
        socket.receive(dgpEntrada);
        //TRATAMOS MENSAJE
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(arrayBytes));
        mensaje = Integer.parseInt(ois.readObject().toString());
        System.out.println("nº recibido: "+mensaje);
        suma+=mensaje;
        //ECO
        System.out.println("La suma da: " + suma);
        //LIBERAMOS RECURSOS
        ois.close();
    }

    public void enviarMensaje() throws IOException {
        //INICIALIZAMOS EL ARRAY
        arrayBytes = new byte[MAXIMA_LONGITUD_ARRAY];
        //CREAMOS EL ALEATORIO QUE VAMOS A ENVIAR
        n = new Random().nextInt((N_MAX - N_MIN) + 1) + N_MIN;
        System.out.println(getClass().getSimpleName() + " envía nº " + n);
        //CONVERTIMOS EL Nº EN BYTES
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(n);
        //METEMOS EL VALOR EN EL ARRAY
        arrayBytes = baos.toByteArray();
        //INICIALIZAMOS EL DGP DE ENVIAR
        dgpEntrada = new DatagramPacket(arrayBytes, arrayBytes.length,
                InetAddress.getByName(IP), PUERTO_B);
        //ENVIAMOS Nº
        socket.send(dgpEntrada);

    }

    //GETTER
    public int getMensaje() {
        return suma;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Extremo_A extremo_A = new Extremo_A();
        while (extremo_A.getMensaje() < 100) {
            extremo_A.recibirMensaje();
            extremo_A.enviarMensaje();
        }
        System.out.println("Extremo_A FIN");
    }

}
