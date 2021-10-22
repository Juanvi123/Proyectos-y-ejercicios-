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
public class Thread_Servidor extends Thread {

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
    public Thread_Servidor(Socket socket) throws IOException {
        this.socket = socket;
        flujoEntrada = new DataInputStream(socket.getInputStream());
        flujoSalida = new DataOutputStream(socket.getOutputStream());
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        while (getSuma() < 100) {
            try {
                //RECIBIMOS MENSAJE
                n = flujoEntrada.readInt();
                //ECO
                System.out.println("Cliente manda nº " + String.valueOf(n));
                //SUMAMOS Nº
                suma += n;
                //ECO
                this.sleep(500);
                System.out.println("La suma está en: " + String.valueOf(suma));
                //ENVIAMOS MENSAJE
                n = new Random().nextInt((N_MAX - N_MIN) + 1) + N_MIN;
                System.out.println("Servidor envía a "+getName()+" nº:" + String.valueOf(n));
                flujoSalida.writeInt(n);
            } catch (SocketException se) {
                try {
                    System.out.println("FIN " + getName());
                    //LIBERAMOS RECURSOS
                    flujoEntrada.close();
                    flujoSalida.close();
                    socket.close();
                    //PON LOS 100 Q SI NO TE QUEDAS ATRAPADO EN UN BUCLE
                    suma=100;
                } catch (IOException ex) {
                    Logger.getLogger(Thread_Servidor.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (IOException ex) {
                Logger.getLogger(Thread_Servidor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Thread_Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //GETTER
    public int getSuma() {
        return suma;
    }

}
