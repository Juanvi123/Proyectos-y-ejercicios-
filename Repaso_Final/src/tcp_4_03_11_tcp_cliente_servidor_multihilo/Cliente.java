/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_4_03_11_tcp_cliente_servidor_multihilo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
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
public class Cliente {

    //CONSTANTES
    private static final int PUERTO = 5555;
    private static final String IP = "localhost";
    private static final int ESPERA = 1000;

    //SOCKET
    Socket socket;

    //FLUJOS
    DataInputStream flujoEntrada;
    DataOutputStream flujoSalida;

    //VARIABLES
    private String mensajeEntrada;
    private String mensajeSalida;
    private int n;
    private int id;
    private int maxClientes;

    //CONSTRUCTOR
    public Cliente() throws UnknownHostException, IOException {
        //ESTABLECEMOS CONEXIÓN CON SERVIDOR
        this.socket = new Socket(InetAddress.getByName(IP), PUERTO);
        //INICIALIZAMOS CAMPOS
        this.flujoEntrada = new DataInputStream(socket.getInputStream());
        this.flujoSalida = new DataOutputStream(socket.getOutputStream());
        this.mensajeEntrada = "";
        this.mensajeSalida = "";
        this.id = 0;
        this.n = 0;

    }

    public void tratamientoInformacion() {
        try {
            //RECIBIMOS DEL SERVIDOR
            maxClientes = flujoEntrada.readInt();
            System.out.println("Hay un total de " + maxClientes + " clientes");
            n = flujoEntrada.readInt();
            id = flujoEntrada.readInt();
            //ECO
            System.out.println("Cliente " + id + " hace " + n + " iteraciones");
            //BUCLE
            for (int i = 0; i < n; i++) {
                //RECIBIMOS CADENA DE TEXTO Y ECO
                System.out.println("Cliente " + id + " " + flujoEntrada.readUTF());
                //ESPERA 1 SEG
                Thread.sleep(ESPERA);
                flujoSalida.writeUTF("Cliente " + id + ", iteración -> " + i);
            }
            //CIERRA CONEXIÓN Y FIN
            socket.close();
            System.out.println("Cliente " + id + " FIN");
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //MAIN
    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 50; i++) {
            //HAY QUE CREAR UN NUEVO CLIENTE EN EL BUCLE SI NO, SE CIERRA EL 
            //SOCKET
            Cliente cliente = new Cliente();
            cliente.tratamientoInformacion();
        }

    }

}
