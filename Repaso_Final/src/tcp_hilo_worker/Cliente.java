/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_hilo_worker;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author juanv
 */
public class Cliente {
    //CONSTANTES
    private static final int PUERTO=5555;
    private static final String IP="localhost";
    private static final int ESPERA=1000;
    private static final int N=5;
    
    //SOCKET
    Socket socket; 
    
    //FLUJOS
    DataInputStream flujoEntrada;
    DataOutputStream flujoSalida;
    
    //VARIABLES
    private String mensajeEntrada;
    private String mensajeSalida;

    public Cliente() throws UnknownHostException, IOException {
        this.socket=new Socket(InetAddress.getByName(IP), PUERTO);
        this.flujoEntrada=new DataInputStream(socket.getInputStream());
        this.flujoSalida=new DataOutputStream(socket.getOutputStream());
        this.mensajeEntrada="";
        this.mensajeSalida="";
    }
    
    public void tratamientoInformacion() throws IOException, InterruptedException{
        for(int i=0;i<N;i++){
            //RECIBE CADENA DE TEXTO
            mensajeEntrada=flujoEntrada.readUTF();
            //ECO
            System.out.println(mensajeEntrada);
            //DEMORA 1 SEG
            Thread.sleep(ESPERA);
            //ENVÍA CADENA DE TEXTO
            mensajeSalida="Gracias por aceptar mi petición";
            flujoSalida.writeUTF(mensajeSalida);
            
        }
      
    }
      //MAIN
        public static void main(String[] args) throws IOException, InterruptedException {
        Cliente cliente=new Cliente();
        cliente.tratamientoInformacion();
    }
    
}
