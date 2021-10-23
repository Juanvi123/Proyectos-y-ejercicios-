/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_hilo_worker;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import tcp_reconexion_hilo_servidor.Cosa;

/**
 *
 * @author juanv
 */
public class Servidor {

    //CONSTANTES
    private static final int PUERTO = 5555;
    private static final int N_WORKERS = 3;

    //SERVIDOR
    ServerSocket serverSocket;

    //CLIENTE
    Socket socket;

    //RC
    LinkedBlockingQueue<Cosa> colaSockets;

    //CONTENEDOR HILOS WORKER
    List<Hilos_Worker> lstHilos_Workers;

    //CONSTRUCTOR
    public Servidor() throws IOException {
        this.serverSocket = new ServerSocket(PUERTO);
        this.colaSockets = new LinkedBlockingQueue<>(/*size*/);
        this.lstHilos_Workers = new ArrayList<>();
    }

    public void crearWorkers() throws InterruptedException, IOException {
        //ECO
        System.out.println("Servidor abierto. Puerto de escucha: "
                + serverSocket.getLocalPort());

        //CREAR HILOS WORKER
        for (int i = 0; i < N_WORKERS; i++) {
            lstHilos_Workers.add(new Hilos_Worker(colaSockets));
            lstHilos_Workers.get(i).setName("Hilo_Worker " + (i + 1));
            lstHilos_Workers.get(i).start();
        }
    }

    public void aceptarConexionCliente() throws IOException, InterruptedException {

        //INFINITAS VECES
        for (int i = 0; true; i++) {
            //ACEPTAR CONEXIÓN CON CLIENTE
            socket = serverSocket.accept();
            //CREAR UNA COSA Y METERLA EN RC 
            Cosa cosa = new Cosa(socket, i + 1);
            colaSockets.put(cosa);
        }
        /*AQUÍ ES DONDE YO METERÍA LA CONDICIÓN DE QUE CUANDO SE LLEGUE A 
        UN TOPE, SE ACABA LA EJECUCIÓN
         */

    }

    //MAIN
    public static void main(String[] args) throws IOException, InterruptedException {
        Servidor servidor = new Servidor();
        servidor.crearWorkers();
        servidor.aceptarConexionCliente();
    }

}
