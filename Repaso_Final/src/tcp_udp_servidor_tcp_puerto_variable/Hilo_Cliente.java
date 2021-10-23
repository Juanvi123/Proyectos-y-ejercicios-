/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_udp_servidor_tcp_puerto_variable;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Hilo_Cliente extends Thread {

    private static final String IP = "localhost";
    //SOCKET
    Socket socket;

    //FLUJOS
    DataInputStream flujoEntrada;
    DataOutputStream flujoSalida;

    //VARIABLES
    private int puertoTCP;
    private String mensajeEntrada;
    private String mensajeSalida;
    private int contador;

    public Hilo_Cliente(Socket socket, int puertoTCP) {
        this.socket = socket;
        this.puertoTCP = puertoTCP;
        this.mensajeEntrada = "";
        this.mensajeSalida = "";
        this.contador = 0;
    }

    @Override
    public void run() {
        try {
            while (true) {
                //INICIALIZAMOS SOCKET
                this.socket = new Socket(InetAddress.getByName(IP), puertoTCP);
                //MENSAJE DE ACEPTACION O RECHAZO
                flujoEntrada = new DataInputStream(socket.getInputStream());
                System.out.println(flujoEntrada.readUTF());
                //INTERACCIÓN CON EL WORKER
                while (!mensajeSalida.trim().equalsIgnoreCase("fin")) {
                    //INCREMENTAMOS EL CONTADOR
                    contador++;
                    //RECIBIMOS MENSAJE DEL WORKER
                    mensajeEntrada = flujoEntrada.readUTF();
                    //ECO
                    System.out.println(mensajeEntrada);
                    //MANDAMOS MENSAJE AL WORKER
                    //INICIALIZAMOS MENSAJE DE SALIDA
                    flujoSalida = new DataOutputStream(socket.getOutputStream());
                    mensajeSalida = "iteración " + contador;
                    flujoSalida.writeUTF(mensajeSalida);
                    if (contador == 5) {
                        mensajeSalida = "FIN";
                        flujoSalida.writeUTF(mensajeSalida);
                    }
                }
                //CERRAMOS CONEXION
                socket.close();
            }

        } catch (EOFException eof) {
            System.err.println("");
        } catch (UnknownHostException ex) {
            Logger.getLogger(Hilo_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Hilo_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
