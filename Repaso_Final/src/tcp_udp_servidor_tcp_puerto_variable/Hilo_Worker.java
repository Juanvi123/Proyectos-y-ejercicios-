/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_udp_servidor_tcp_puerto_variable;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Hilo_Worker extends Thread {

    //RC
    LinkedBlockingQueue<Socket_Peticion> socketCola;

    //INSTANCIA SOCKET_PETICION
    Socket_Peticion socket_Peticion;

    //FLUJOS
    DataInputStream flujoEntrada;
    DataOutputStream flujoSalida;

    //SOCKET
    Socket socket;

    //VARIABLES
    private int peticion;
    private String mensajeEntrada;
    private String mensajeSalida;

    //CONSTRUCTOR
    public Hilo_Worker(LinkedBlockingQueue<Socket_Peticion> socketCola) {
        this.socketCola = socketCola;
        this.mensajeEntrada = "";
        this.mensajeSalida = "";
        this.peticion = 0;
    }

    @Override
    public void run() {
        try {
           while (true)  {
                //EXTRAEMOS OBJETO DEL RC
                socket_Peticion = socketCola.take();
                socket = socket_Peticion.getSocket();
                peticion = socket_Peticion.getPeticion();
                //INICIALIZAMOS MENSAJE DE SALIDA
                mensajeSalida = getName() + " manda ok";
                System.out.println(getName() + "manda ok");
                //BUCLE CON CLIENTE
                while (!mensajeEntrada.trim().equalsIgnoreCase("fin")) {

                    //MANDAMOS MENSAJE OK
                    flujoSalida = new DataOutputStream(socket.getOutputStream());
                    flujoSalida.writeUTF(mensajeSalida);
                    //ESPERAMOS UN SEGUNDO
                    this.sleep(1000);
                    //RECIBIMOS MENSAJE DE CLIENTE
                    flujoEntrada = new DataInputStream(socket.getInputStream());
                    mensajeEntrada = flujoEntrada.readUTF();
                    //ECO
                    System.out.println("Cliente " + peticion + " manda: " + mensajeEntrada);

                }

            }
        } catch (IOException ex) {
            Logger.getLogger(Hilo_Worker.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo_Worker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
