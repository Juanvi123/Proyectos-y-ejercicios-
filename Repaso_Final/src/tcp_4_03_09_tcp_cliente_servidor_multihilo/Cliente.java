/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_4_03_09_tcp_cliente_servidor_multihilo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Cliente extends Thread {

    //CONSTANTES
    private static final int PUERTO = 5555;
    private static final String IP = "localhost";
    private static final int ESPERA = 1000;
    private static final int N_VECES = 3;
    private static final int N_CLIENTES = 50;

    //SOCKET
    Socket socket;

    //FLUJOS
    private DataInputStream flujoEntrada;
    private DataOutputStream flujoSalida;

    //VARIABLES
    private String mensajeEntrada;
    private String mensajeSalida;

    //CONSTRUCTOR
    public Cliente() throws UnknownHostException, IOException {
        //ESTABLECEMOS CONEXIÓN CON SERVIDOR
        this.socket = new Socket(InetAddress.getByName(IP), PUERTO);
        //INICIALIZAMOS CAMPOS
        this.flujoEntrada = new DataInputStream(socket.getInputStream());
        this.flujoSalida = new DataOutputStream(socket.getOutputStream());
        this.mensajeEntrada = "";
        this.mensajeSalida = "";

    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        try {
            //ENVIAMOS MENSAJE A SERVIDOR
            mensajeSalida = getName();
            flujoSalida.writeUTF(mensajeSalida);
            //ESPERA RESPUESTA SERVIDOR
            mensajeEntrada = flujoEntrada.readUTF();
            //SI LA RESPUESTA ES HOLA
            if (mensajeEntrada.trim().equalsIgnoreCase("hola")) {
                //REPITE 3 VECES
                for (int i = 0; i < N_VECES; i++) {
                    //ENVIA MENSAJE NOMBRE CLIENTE
                    flujoSalida.writeUTF(mensajeSalida);
                    //ESCRIBE PUNTITO EN PANTALLA
                    System.out.println(".");
                    //RECIBE RESPUESTA
                    mensajeEntrada = flujoEntrada.readUTF();
                    //ECO
                    System.out.println(getName() + " recibe " + mensajeEntrada);
                    //ESPERA 1 SEGUNDO
                    this.sleep(ESPERA);
                }
                System.out.println(getName()+" FIN");
                socket.close();
            }//SI LA RESPUESTA ES NO ATENDIDO ACABA
            else {
                //MENSAJE RESPUESTA
                System.out.println(mensajeEntrada);
                //ACABA
                socket.close();
            }

        } catch (SocketException e) {
            System.out.println(getName()+" FIN");
        } catch (InterruptedException | IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //MAIN
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < N_CLIENTES; i++) {
            Cliente cliente = new Cliente();
            cliente.setName("Cliente " + (i + 1));
            cliente.start();
        }

    }

}
