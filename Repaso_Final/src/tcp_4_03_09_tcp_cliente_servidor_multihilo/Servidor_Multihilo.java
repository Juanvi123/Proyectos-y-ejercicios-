/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_4_03_09_tcp_cliente_servidor_multihilo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author juanv
 */
public class Servidor_Multihilo {

    //CONSTANTES
    private static final int PUERTO = 5555;
    private static final int N_HILOS_RESPUESTA = 3;

    //SERVIDOR
    ServerSocket serverSocket;

    //RC
    LinkedBlockingQueue<Socket_Identificador> socketCola;

    //CONTENEDOR HILOS RESPUESTA (WORKERS)
    List<Hilo_Respuesta> lstHiloRespuesta;

    //HILO ESCUCHA
    Hilo_Escuha hilo_Escuha;

    //CONSTRUCTOR
    public Servidor_Multihilo() throws IOException {
        this.serverSocket = new ServerSocket(PUERTO);
        this.socketCola = new LinkedBlockingQueue<>();
        this.lstHiloRespuesta = new ArrayList<>();

    }

    public void tratamientoInformacion() {
        //ECO INICIAL
        System.out.println("Servidor abierto, escucho por puerto " + serverSocket.getLocalPort());
        //INSTANCIAMOS INICIALIZAMOS Y ARRANCAMOS HILO ESCUCHA
        hilo_Escuha = new Hilo_Escuha(serverSocket, socketCola);
        hilo_Escuha.setName("Hilo_Escucha");
        hilo_Escuha.start();

        //INSTANCIAMOS INICIALIZAMOS Y ARRANCAMOS HILOS RESPUESTA
        for (int i = 0; i < N_HILOS_RESPUESTA; i++) {
            lstHiloRespuesta.add(new Hilo_Respuesta(socketCola));
            lstHiloRespuesta.get(i).setName("Hilo_Respuesta_" + (i + 1));
            lstHiloRespuesta.get(i).start();
        }

    }

    /**
     * Método para crear Logger
     *
     * @return
     * @throws IOException
     */
    public Logger createLogger() throws IOException {
        Logger logger = Logger.getLogger("Logger_Ejercicio.txt");
        FileHandler fh = new FileHandler("Logger_Clientes_TCP.txt", true);
        logger.addHandler(fh);
        SimpleFormatter sf = new SimpleFormatter();
        fh.setFormatter(sf);

        return logger;
    }

    public static void main(String[] args) throws IOException {
        Servidor_Multihilo servidor_Multihilo = new Servidor_Multihilo();
        servidor_Multihilo.tratamientoInformacion();
    }
}
