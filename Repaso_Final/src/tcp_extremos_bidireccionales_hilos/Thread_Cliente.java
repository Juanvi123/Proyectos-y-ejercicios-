/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_extremos_bidireccionales_hilos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Thread_Cliente extends Thread {

    //CONSTANTES
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

    //CONSTRUCTOR
    public Thread_Cliente(Socket socket) throws IOException {
        this.socket = socket;
        this.suma = 0;
        this.n = 0;
        this.flujoEntrada = new DataInputStream(socket.getInputStream());
        this.flujoSalida = new DataOutputStream(socket.getOutputStream());
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        try {
            while (getSuma() < 100) {
                //ENVIAMOS Nº
                n = new Random().nextInt((N_MAX - N_MIN) + 1) + N_MIN;
                System.out.println("Cliente envía nº " + String.valueOf(n));
                flujoSalida.writeInt(n);
                this.sleep(500);
                //RECIBIMOS Nº
                n = flujoEntrada.readInt();
                System.out.println("Servidor manda a nº " + n);
                suma += n;
                System.out.println(("La suma está en: " + String.valueOf(suma)).toUpperCase());
            }
        } catch (SocketException ex) {
            try {
                suma = 100;
                //LIBERAMOS RECURSOS
                flujoEntrada.close();
                flujoSalida.close();
                socket.close();
            } catch (IOException ex1) {
                Logger.getLogger(Thread_Cliente.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (IOException ex) {
            Logger.getLogger(Thread_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Thread_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //GETTER
    public int getSuma() {
        return suma;
    }
}
