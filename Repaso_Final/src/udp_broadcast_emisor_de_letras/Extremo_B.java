/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp_broadcast_emisor_de_letras;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author juanv
 */
public class Extremo_B {

    //CONSTANTES
    private static final String IP = "192.168.56.255";
    private static final int TAMANO_BUFFER = 3000;
    private static final int PUERTO_A = 5555;
    private static final int PUERTO_B = 5556;

    //DATAGRAMA
    private DatagramPacket dgpRecibir;

    //SOCKET
    private DatagramSocket socket;

    //ARRAY
    byte[] buffer;

    //VARIABLES
    private char letra;
    private int nLetra;
    private String mensaje;

    //CONSTRUCTOR
    public Extremo_B() throws SocketException {
        //INICIALIZAMOS ELEMENTOS
        this.nLetra = 0;
        this.socket = new DatagramSocket(PUERTO_B);
        socket.setBroadcast(true);
        this.buffer = new byte[TAMANO_BUFFER];
        this.mensaje = "";
    }

    //MÉTODOS
    public void recibirMensaje() throws UnknownHostException, IOException, ClassNotFoundException {
        //ECO INICIAL
        System.out.println(getClass().getSimpleName() + " espera mensaje");
        //RECIBE MENSAJE, INICIALIZAMOS DATAGRAMA
        dgpRecibir = new DatagramPacket(buffer, buffer.length);
        //RECIBIMOS MENSAJE
        socket.receive(dgpRecibir);
        //TRATAMIENTO DE DATOS
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(buffer));
        mensaje = ois.readObject().toString();
        letra = mensaje.charAt(0);

        //ECO LETRA
        System.out.println("letra: "+letra);
    }
    
    public static void main(String[]args) throws SocketException, 
            IOException, UnknownHostException, ClassNotFoundException{
        Extremo_B extremo_B=new Extremo_B();
        while(true){
            extremo_B.recibirMensaje();
        }
    }

}
