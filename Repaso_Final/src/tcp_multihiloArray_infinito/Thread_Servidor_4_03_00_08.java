/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_multihiloArray_infinito;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juanv
 */
public class Thread_Servidor_4_03_00_08 extends Thread {
      //DECLARAMOS VARIABLES
    private Socket socketCliente;
    private int nCliente;
    //CONTENEDOR DE PUERTOS
    int puerto;

    //CONSTRUCTOR
    public Thread_Servidor_4_03_00_08(Socket socketCliente) {
        this.socketCliente = socketCliente;
        this.puerto=0;
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        //GENERAMOS LOS FLUJOS DE ENTRADA Y SALIDA EN UN TRY CON RECURSOS
        try (DataInputStream flujoEntrada = new DataInputStream(socketCliente.getInputStream());
                DataOutputStream flujoSalida = new DataOutputStream(socketCliente.getOutputStream());) {

            //GENERAMOS BUCLE INFINITO UN BUCLE INF AQUI LO Q HACE ES Q SE MANDE COSAS AL CLIENTE INFINITAMENTE
            while(true){ 
                //MENSAJE DE SALIDA
                String mensajeSalidaServidor="Mensaje servidor a "+getName()+", Hola "+getName();
                flujoSalida.writeUTF(mensajeSalidaServidor);
                //MENSAJE DE ENTRADA
                puerto=flujoEntrada.readInt();
                System.out.println("De "+getName()+" a servidor,"
                        + "te secucho por puerto: "+puerto);
                
                System.out.println("Puerto: "+String.valueOf(puerto));
                
          }
        } catch (SocketException ex) {
            System.err.println("Fin conexión con " + getName());
           
        }catch(Exception e){
            e.printStackTrace();
            System.err.println("Error inesperado");
        }
    }  
    //GETTER
    public int getPuerto() {
        return puerto;
    }
    
}
