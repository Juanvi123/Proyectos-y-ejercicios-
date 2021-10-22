/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp_extremos_bidireccionales_v2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
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
public class Extremo_B {
    //CONSTANTES
    private static final int PUERTO_A=5555;
    private static final int PUERTO_B=5556;
    private static final String IP="localhost";
    private static final int MAXIMO_TAMANO_BYTE=3000;
    private static final char ULTIMA_LETRA='z';
    private static final char PRIMERA_LETRA='a';
    
    //DATAGRAMPACKAGE
    DatagramPacket dgpEntrada;
    DatagramPacket dgpSalida;
    
    //DATAGRAMSOCKET
    DatagramSocket socket;
    
    //ARRAY BYTES
    byte[] arrayBytes;
    
    //VARIABLES
    private int nLetra;
    private char letra;

    //CONSTRUCTOR
    public Extremo_B() throws SocketException, UnknownHostException {
        this.socket=new DatagramSocket(PUERTO_B,InetAddress.getByName(IP));
        this.nLetra=0;
        this.arrayBytes=new byte[MAXIMO_TAMANO_BYTE];     
    }
    
    public void enviarMensaje() throws IOException{
        //INICIALIZAR EL ARRAY
        arrayBytes=new byte[MAXIMO_TAMANO_BYTE];
        //CREAMOS EL Nº
        nLetra=new Random().nextInt((ULTIMA_LETRA-PRIMERA_LETRA)+1)+PRIMERA_LETRA;
        // ECO Nº
        letra=(char)nLetra;
        System.out.println(getClass().getSimpleName()+" envía letra "+letra);
        //TRATAMOS EL Nº PARA TRANSFORMARLO EN BYTE
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        ObjectOutputStream oos=new ObjectOutputStream(baos);
        oos.writeObject(letra);
        arrayBytes=baos.toByteArray();
        //ENVIAMOS VALOR
        dgpSalida=new DatagramPacket(arrayBytes,arrayBytes.length, 
                InetAddress.getByName(IP), PUERTO_A);
        socket.send(dgpSalida);
        //LIBERAMOS RECURSOS
        oos.close();
        baos.close();
        
    }
    
    public void recibirMensaje() throws IOException, ClassNotFoundException{
        //INICIALIZAMOS EL ARRAY
        arrayBytes=new byte[MAXIMO_TAMANO_BYTE];
        //INICIALIZAMOS EL DGP DE RECIBIR
        dgpEntrada=new DatagramPacket(arrayBytes, MAXIMO_TAMANO_BYTE);
        //RECIBIMOS MENSAJE
        socket.receive(dgpEntrada);
        //TRATAMOS EL RESULTADO
        ObjectInputStream ois=new ObjectInputStream(new ByteArrayInputStream(arrayBytes));
        String mensaje=ois.readObject().toString();
        letra= mensaje.charAt(0);
        System.out.println("letra recibida: "+letra);
    }
    
    //GETTER
    public char getLetra() {
        return letra;
    }
    
    
    public static void main(String[]args) throws SocketException, IOException, ClassNotFoundException{
        Extremo_B extremo_B=new Extremo_B();
        while(extremo_B.getLetra()!='z'){
            extremo_B.enviarMensaje();
            extremo_B.recibirMensaje();
        }
        System.out.println("Extremo B FIN");
    }
    
    
    
}
