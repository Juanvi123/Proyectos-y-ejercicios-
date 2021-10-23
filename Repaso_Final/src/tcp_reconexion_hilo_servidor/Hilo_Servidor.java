/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_reconexion_hilo_servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Hilo_Servidor extends Thread {

    //CONSTANTES
    private static final int PUERTO = 5556;
    private static final int ESPERA = 1000;

    //SERVIDOR
    ServerSocket serverSocket;

    //CLIENTE
    Socket socket;

    //FLUJOS
    DataInputStream flujoEntrada;
    DataOutputStream flujoSalida;

    //VARIABLES
    private String mensajeEntrada;
    private String mensajeSalida;
    private String nombre;
    private int cont;

    public Hilo_Servidor(Socket socket, String nombre) throws IOException {
        this.socket = socket;
        this.nombre = nombre;
        //NUEVO SERVERSOCKET, INDEPENDIENTE DEL SERVIDOR
        this.serverSocket = new ServerSocket(PUERTO);
        this.mensajeEntrada = "";
        this.mensajeSalida = "";
        this.cont = 0;

    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        try {
         
                //NO HAY UN BUCLE INFINITO YA QUE HAY UNO DONDE SE ACEPTA LA CONEXIÓN
                //CIERRA CONEXIÓN CON SERVIDOR
                socket.close();
                //RECONEXIÓN
                socket = serverSocket.accept();
                this.flujoEntrada = new DataInputStream(socket.getInputStream());
                this.flujoSalida = new DataOutputStream(socket.getOutputStream());
                //ECO
                System.out.println("Ciente conectado a hilo servidor en puerto " + serverSocket.getLocalPort());
                //MIENTRAS EL MENSAJE NO SEA FIN
                while (!mensajeEntrada.trim().toUpperCase().equals("FIN")) {
                    //INCREMENTAMOS CONTADOR
                    cont++;
                    //HILO SERVIDOR MANDA MENSAJE
                    mensajeSalida = getName() + " envía ahora estoy conectado en puerto "
                            + serverSocket.getLocalPort() + " a nombre(iteración " + cont;
                    flujoSalida.writeUTF(mensajeSalida);
                    //ESPERA MENSAJE
                    this.sleep(1000);
                    //RECEPCIÓN MENSAJE CLIENTE
                    mensajeEntrada = flujoEntrada.readUTF();
                    //ECO
                    System.out.println(nombre + " envía a " + getName() + ": " + mensajeEntrada);
                }
                System.out.println(getName() + " FIN");
                //LIBERAR RECURSOS PARA QUE PUEDA CORRER OTRO HILO
                socket.close();
                serverSocket.close();
            
        }catch (SocketException ex) {
            //SI ACABA CLIENTE, FORZAMOS A QUE ACABE HILO
            mensajeEntrada = "FIN";
        }catch (InterruptedException ex) {
            Logger.getLogger(Hilo_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
            Logger.getLogger(Hilo_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
