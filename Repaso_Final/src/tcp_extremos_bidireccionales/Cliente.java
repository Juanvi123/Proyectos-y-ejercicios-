/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_extremos_bidireccionales;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Random;

/**
 *
 * @author juanv
 */
public class Cliente {

    //CONSTANTES
    private static final int PUERTO = 5555;
    private static final String IP = "localhost";
    private static final int N_MAX = 10;
    private static final int N_MIN = 1;

    //SOCKET
    Socket socket;

    //FLUJOS
    DataInputStream flujoEntrada;
    DataOutputStream flujoSalida;

    //VARIABLES
    private int n;
    private int suma;

    public Cliente() throws UnknownHostException, IOException {
        //INICIALIZAMOS VARIABLES
        this.socket = new Socket(InetAddress.getByName(IP), PUERTO);
        this.suma = 0;
        this.n = 0;
        this.flujoEntrada = new DataInputStream(socket.getInputStream());
        this.flujoSalida = new DataOutputStream(socket.getOutputStream());
    }

    //MÉTODOS
    public void tratamientoDatos() throws IOException {
        //ENVIAMOS Nº
        n = new Random().nextInt((N_MAX - N_MIN) + 1) + N_MIN;
        System.out.println("Cliente envía nº " + String.valueOf(n));
        flujoSalida.writeInt(n);

        //RECIBIMOS Nº
        n = flujoEntrada.readInt();
        System.out.println("Servidor manda nº " + n);
        suma += n;
        System.err.println("La suma está en: " + String.valueOf(suma));

    }

    //GETTER
    public int getSuma() {
        return suma;
    }

    //MAIN
    public static void main(String[] args) throws InterruptedException, IOException {
        try {
            Cliente cliente = new Cliente();
            while (cliente.getSuma() < 100) {
                cliente.tratamientoDatos();
            }
        } catch (SocketException se) {
            System.err.println("FIN del programa");
        }

    }
}
