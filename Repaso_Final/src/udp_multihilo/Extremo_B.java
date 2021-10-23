/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp_multihilo;

import udp_extremos_bidireccionales_multicast.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
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
public class Extremo_B {
    //CONSTANTES
    private static final int PUERTO_A=5555;
    private static final int PUERTO_B=5556;
    private static final String IP="239.255.255.255";
    private static final int MAXIMO_TAMANO_BYTE=3000;
    private static final int N_MIN=1;
    private static final int N_MAX=10;
    
    //DATAGRAMPACKAGE
    DatagramPacket dgpEntrada;
    DatagramPacket dgpSalida;
    
    //DATAGRAMSOCKET
    MulticastSocket socket;
    InetAddress ip;
    
    //ARRAY BYTES
    byte[] arrayBytes;
    
    //VARIABLES
    private int n;
    private String mensaje;
    private int suma;

    //CONSTRUCTOR
    public Extremo_B() throws SocketException, UnknownHostException, IOException {
        this.socket=new MulticastSocket(PUERTO_B);
        this.ip=InetAddress.getByName(IP);
        socket.joinGroup(ip);
        this.n=0;
        this.mensaje="";
        this.arrayBytes=new byte[MAXIMO_TAMANO_BYTE];
        this.suma=0;
        
    }
    
    public void enviarMensaje() throws IOException{
        //INICIALIZAR EL ARRAY
        n++;
        arrayBytes=new byte[MAXIMO_TAMANO_BYTE];
        //TRATAMOS EL Nº PARA TRANSFORMARLO EN BYTE
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        ObjectOutputStream oos=new ObjectOutputStream(baos);
        oos.writeObject("Cliente "+n+" Hola Servidor");
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
        dgpEntrada=new DatagramPacket(arrayBytes, arrayBytes.length);
        //RECIBIMOS MENSAJE
        socket.receive(dgpEntrada);
        //TRATAMOS EL RESULTADO
        ObjectInputStream ois=new ObjectInputStream(new ByteArrayInputStream(arrayBytes));
        mensaje=ois.readObject().toString();
        System.out.println(mensaje);
    }
    
    //GETTER
    public int getMensaje() {
        return suma;
    }
    
    public static void main(String[]args) throws SocketException, IOException, ClassNotFoundException{
        Extremo_B extremo_B=new Extremo_B();
      
            extremo_B.enviarMensaje();
            extremo_B.recibirMensaje();
        
        System.out.println("Extremo B FIN");
    }
    
    
    
}
