/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_extremos_bidireccionales;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Random;

/**
 *
 * @author juanv
 */
public class Servidor {

    //CONSTANTES
    private static final int PUERTO = 5555;
    private static final int N_MAX = 10;
    private static final int N_MIN = 1;

    //SERVIDOR
    ServerSocket serverSocket;

    //SERVIDOR 
    Socket socket;

    //FLUJOS DE ENTRADA Y SALIDA
    DataInputStream flujoEntrada;
    DataOutputStream flujoSalida;

    //VARIABLES
    private int n;
    private int suma;

    public Servidor() throws IOException {
        this.serverSocket = new ServerSocket(PUERTO);
        //ACEPTAMOS CONEXIÓN
        socket = serverSocket.accept();
        this.flujoEntrada = new DataInputStream(socket.getInputStream());
        this.flujoSalida = new DataOutputStream(socket.getOutputStream());
        this.n = 0;
        this.suma = 0;

    }

    public void tratamientoInformacion() throws IOException, InterruptedException {
        //RECIBIMOS MENSAJE
        n = flujoEntrada.readInt();
        //ECO
        System.out.println("Cliente manda nº " + String.valueOf(n));
        //SUMAMOS Nº
        suma += n;
        //ECO
        System.out.println("La suma está en: " + String.valueOf(suma));

        //ENVIAMOS MENSAJE
        n = new Random().nextInt((N_MAX - N_MIN) + 1) + N_MIN;
        System.out.println("Servidor envía nº:" + String.valueOf(n));
        flujoSalida.writeInt(n);

    }

    //GETTER
    public int getSuma() {
        return suma;
    }

    //MAIN
    public static void main(String[] args) throws IOException, InterruptedException {
        try {
            Servidor servidor = new Servidor();
            while (servidor.getSuma() < 100) {
                servidor.tratamientoInformacion();
            }
            System.out.println("Fin del programa");
        } catch (SocketException se) {
            System.out.println("FIN del programa");
        }

    }

}
