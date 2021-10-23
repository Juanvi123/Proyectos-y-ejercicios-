/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp_multihilo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Hilo_Extremo_A extends Thread {
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

    //CONTADOR
    private int n;

    public Hilo_Extremo_A(DatagramPacket dgpEntrada, DatagramPacket dgpSalida,
            MulticastSocket socket, InetAddress ip, byte[] arrayBytes, String mensaje, int n) {
        this.dgpEntrada = dgpEntrada;
        this.dgpSalida = dgpSalida;
        this.socket = socket;
        this.ip = ip;
        this.arrayBytes = arrayBytes;
        this.mensaje = mensaje;
        this.n = n;
    }

    @Override
    public void run() {
        try {
            while (n<=3) {
                try {
                    Thread.sleep(1000);
                    n++;
                    recibirMensaje();
                    enviarMensaje();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Hilo_Extremo_A.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        } catch (IOException ex) {
            Logger.getLogger(Hilo_Extremo_A.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Hilo_Extremo_A.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void recibirMensaje() throws IOException, ClassNotFoundException {

        //TRATAMOS MENSAJE
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(arrayBytes));
        mensaje = ois.readObject().toString();
        //ECO
        System.out.println(mensaje);
        //LIBERAMOS RECURSOS
        ois.close();
    }

    public void enviarMensaje() throws IOException {
        //INICIALIZAMOS EL ARRAY
        arrayBytes = new byte[MAXIMA_LONGITUD_ARRAY];
        //CONVERTIMOS EL Nº EN BYTES
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject("Hola " + getName()+" supercalifragilisticoespialidoso");
        //METEMOS EL VALOR EN EL ARRAY
        arrayBytes = baos.toByteArray();
        //INICIALIZAMOS EL DGP DE ENVIAR
        dgpEntrada = new DatagramPacket(arrayBytes, arrayBytes.length,
                InetAddress.getByName(IP), PUERTO_B);
        //ENVIAMOS Nº
        socket.send(dgpEntrada);

    }
}
