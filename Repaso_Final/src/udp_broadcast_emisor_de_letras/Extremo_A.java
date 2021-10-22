/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp_broadcast_emisor_de_letras;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Random;

/**
 *
 * @author juanv
 */
public class Extremo_A {

    //CONSTANTES
    private static final String IP = "192.168.56.255";
    private static final int PUERTO_A = 5555;
    private static final int PUERTO_B = 5556;
    private static final int TAMANO_BUFFER = 3000;
    private static final char LETRA_INICIAL = 'a';
    private static final char LETRA_FINAL = 'z';

    //DATAGRAMA
    DatagramPacket dgpEnviar;

    //SOCKET
    DatagramSocket socket;

    //ARRAY DE BYTES
    byte[] buffer;

    //VARIABLES
    private String mensaje;
    private char letra;
    private int nLetra;
    
    public Extremo_A() throws SocketException {
        this.buffer = new byte[TAMANO_BUFFER];
        this.mensaje = "";
        this.nLetra = 0;
        this.socket = new DatagramSocket(PUERTO_A);
        socket.setBroadcast(true);
    }
    
    public void enviarMensaje() throws IOException, InterruptedException {
        //GENERAR ALEATORIAMENTE LA LETRA
        nLetra = new Random().nextInt((LETRA_FINAL - LETRA_INICIAL) + 1) + LETRA_INICIAL;
        letra=(char)nLetra;
        //TRANSFORMAMOS LA LETRA EN BYTES
        ByteArrayOutputStream bais = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bais);
        oos.writeObject(letra);
        //LLENAMOS EL BUFFER CON LA LETRA
        buffer=bais.toByteArray();
        //ENVIAMOS LETRA, INICIALIZAMOS DATAGRAMPACKAGE
        dgpEnviar=new DatagramPacket(buffer, buffer.length, 
                InetAddress.getByName(IP), PUERTO_B);
        //ENVIAMOS LETRA
        socket.send(dgpEnviar);
        //SLEEP 1 SEG
        Thread.sleep(1000);
    }
    
    public static void main(String[]args) throws SocketException, IOException, InterruptedException{
        Extremo_A extremo_A=new Extremo_A();
        while(true){
            extremo_A.enviarMensaje();
        }
    }
    
}
