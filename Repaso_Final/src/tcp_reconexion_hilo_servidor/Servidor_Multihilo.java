/*
Cliente reconexión hilo servidor
1. TCP. Servidor multihilo.
cliente
– abre conexión TCP con el servidorMultihilo.
– espera mensaje de respuesta.
– abre conexión TCP con hiloSevidor.
- repite 20 veces
- espera mensaje
– envia mensaje. La vez 20 envía “FIN”
– Fin de carrera.
ServidorMutihilo.
Siempre
- acepta conexión.
 - Envia mensaje de respuesta
 - crea hiloServidor
hiloServidor.
Siempre
 acepta conexión con cliente
envía mensaje a cliente
espera mensaje cliente
si el mensaje contiene “FIN” , acaba
 */
package tcp_reconexion_hilo_servidor;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juanv
 */
public class Servidor_Multihilo {

    //CONSTANTES
    private static final int PUERTO = 5555;

    //SERVIDOR
    ServerSocket serverSocket;

    //CLIENTE
    Socket socket;

    //VARIABLES
    private String mensaje;
    private String nombreHilo;
    private List<Hilo_Servidor> lstHiloServidor;

    //FLUJO SALIDA
    DataOutputStream flujoSalida;

    public Servidor_Multihilo() throws IOException {
        this.serverSocket = new ServerSocket(PUERTO);
        System.out.println("Servidor abierto, escuha en puerto " + serverSocket.getLocalPort());
        this.mensaje = "";
        this.nombreHilo = "";
        this.lstHiloServidor = new ArrayList<>();
    }

    public void generarHilo() throws IOException {
        //LO HAREMOS DE MANERA INFINITA PARA QUE SE PUEDAN CONECTAR INFINITOS CLIENTES
        for (int i = 0; true; i++) {
            //SERVIDOR ACEPTA CONEXIÓN CON CLIENTE
            this.socket = serverSocket.accept();
            this.flujoSalida = new DataOutputStream(socket.getOutputStream());
            mensaje = "Abrimos conexión a Cliente " + (i + 1) + " por puerto " + serverSocket.getLocalPort();
            flujoSalida.writeUTF(mensaje);

            Hilo_Servidor hilo_Servidor = new Hilo_Servidor(socket, "Cliente " + (i + 1));
            hilo_Servidor.setName("Hilo_Servidor " + (i + 1));
            hilo_Servidor.start();
        }
    }

    //MAIN
    public static void main(String[] args) throws IOException {
        //INTANCIAMOS UN OBJETO DE LA CLASE SERVIDOR
        Servidor_Multihilo servidor_Multihilo = new Servidor_Multihilo();

        //MÉTODO PARA REALIZAR LA RECONEXIÓN CON EL HILO 
        servidor_Multihilo.generarHilo();

    }

}
