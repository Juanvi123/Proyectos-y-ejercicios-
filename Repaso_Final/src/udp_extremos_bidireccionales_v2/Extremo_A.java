/*
Crear un programa que sea una conexión UDP unicast bidireccional donde el extremo B
mande un nº al extremo A, lo sume, lo mande al extremo B y lo sume, cuando el nº sea superior
a 100 el programa finalizará

Versión 2: hacerlo con letras y cuando llegue a la letra z el programa finalizará
Versión 3: hacerlo con multicast.
 */
package udp_extremos_bidireccionales_v2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
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
    private static final String IP = "localhost";
    private static final int MAXIMA_LONGITUD_ARRAY = 3000;
    private static final char PRIMERA_LETRA = 'a';
    private static final char ULTIMA_LETRA = 'z';

    //DATAGRAMPACKAGE
    DatagramPacket dgpEntrada;
    DatagramPacket dgpSalida;

    //DATAGRAMSOCKET
    DatagramSocket socket;

    //ARRAY
    byte[] arrayBytes;

    //VARIABLE
    private String mensaje;
    private int nLetra;
    private char letra;

    //CONSTRUCTOR
    public Extremo_A() throws SocketException, UnknownHostException {
        this.mensaje = "";
        this.nLetra = 0;
        this.arrayBytes = new byte[MAXIMA_LONGITUD_ARRAY];
        this.socket = new DatagramSocket(PUERTO_A, InetAddress.getByName(IP));
    }

    public void recibirMensaje() throws IOException, ClassNotFoundException {

        //INICIALIZAMOS EL ARRAY
        arrayBytes = new byte[MAXIMA_LONGITUD_ARRAY];
        //INICIALIZAMOS EL DGP DE ENTRADA
        dgpEntrada = new DatagramPacket(arrayBytes, arrayBytes.length);
        //ECO DE ESPERA
        System.out.println(getClass().getSimpleName() + " Espera letra");
        //RECIBIMOS MENSAJE
        socket.receive(dgpEntrada);
        //TRATAMOS MENSAJE
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(arrayBytes));
        mensaje = ois.readObject().toString();
        letra = mensaje.charAt(0);
        //ECO
        System.out.println("letra recibida: " + letra);
        //LIBERAMOS RECURSOS
        ois.close();
    }

    public void enviarMensaje() throws IOException {
        //INICIALIZAMOS EL ARRAY
        arrayBytes = new byte[MAXIMA_LONGITUD_ARRAY];
        //CREAMOS EL ALEATORIO QUE VAMOS A ENVIAR
        nLetra = new Random().nextInt((ULTIMA_LETRA - PRIMERA_LETRA) + 1) + PRIMERA_LETRA;
        letra=(char)nLetra;
        System.out.println(getClass().getSimpleName() + " envía letra " + letra);
        //CONVERTIMOS EL Nº EN BYTES
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(letra);
        //METEMOS EL VALOR EN EL ARRAY
        arrayBytes = baos.toByteArray();
        //INICIALIZAMOS EL DGP DE ENVIAR
        dgpEntrada = new DatagramPacket(arrayBytes, arrayBytes.length,
                InetAddress.getByName(IP), PUERTO_B);
        //ENVIAMOS Nº
        socket.send(dgpEntrada);

    }

    //GETTER
    public char getLetra() {
        return letra;
    }
    

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Extremo_A extremo_A = new Extremo_A();
        while (extremo_A.getLetra()!='z') {
            extremo_A.recibirMensaje();
            extremo_A.enviarMensaje();
        }
        System.out.println("Extremo_A FIN");
    }

}
