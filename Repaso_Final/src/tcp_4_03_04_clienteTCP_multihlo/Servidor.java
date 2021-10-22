/*
 1. ClienteTCP. Bucle repite 3 veces:
- Apertura conexión con servidor.
- Recibe mensaje “LO SIENTO”, espera 5 segundos y reintenta la conexión.
- Recibe mensaje “HOLA” , finaliza el bucle e inicia el diálogo con el servidor.
Diálogo con el servidor. Bucle 10 veces:
– mensaje
– respuesta
– ….
– mensaje “ADIOS”
Finaliza la ejecución del cliente.

 */
package tcp_4_03_04_clienteTCP_multihlo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 *
 * @author juanv
 */
public class Servidor {

    //CONSTANTES
    private static final int PUERTO = 5555;
    private static final int BUCLE = 3;

    //SERVIDOR
    ServerSocket serverSocket;

    //CLIENTE
    Socket socket;

    //FLUJOS
    DataInputStream flujoEntrada;
    DataOutputStream flujoSalida;

    //VARIABLES
    private String mensajeSalida;
    private String mensajeEntrada;
    private int contador;

    public Servidor() throws IOException {
        this.serverSocket = new ServerSocket(PUERTO);
        System.out.println("Conexión abierta\n Servidor escucha en puerto " + serverSocket.getLocalPort());
        //ACEPTAMOS CONEXIÓN 
        this.socket = serverSocket.accept();
        this.flujoSalida = new DataOutputStream(socket.getOutputStream());
        this.flujoEntrada = new DataInputStream(socket.getInputStream());
        this.mensajeSalida = "LO SIENTO";
        this.mensajeEntrada = "";
        this.contador = 0;
    }

    public void tratamientoDatos() throws IOException, InterruptedException {
        //PRIMER BUCLE
        try {
            for (int i = 0; i < BUCLE; i++) {
                flujoSalida.writeUTF(mensajeSalida);
            }
            //CAMBIAMOS MENSAJE
            mensajeSalida = "HoLa";
            while (!mensajeEntrada.trim().toUpperCase().equals("ADIOS")) {
                if (contador < 10) {
                    //TIEMPO ENTRE TANDAS DE MENSAJES
                    Thread.sleep(1000);
                    //MENSAJE QUE MANDA EL SERVIDOR
                    flujoSalida.writeUTF(mensajeSalida);
                    System.out.println("Servidor manda a cliente: " + mensajeSalida);
                    mensajeEntrada = flujoEntrada.readUTF();
                    System.out.println("Servidor recibe de cliente: " + mensajeEntrada);
                    contador++;
                } else {
                    //TIEMPO ENTRE TANDAS DE MENSAJES
                    Thread.sleep(1000);
                    mensajeSalida = "ADIOS";
                    //MENSAJE QUE MANDA EL SERVIDOR
                    flujoSalida.writeUTF(mensajeSalida);
                    System.out.println("Servidor manda a cliente: " + mensajeSalida);
                    mensajeEntrada = flujoEntrada.readUTF();
                    System.out.println("Servidor recibe de cliente: " + mensajeEntrada);
                }
            }
        } catch (SocketException se) {
            System.err.println("Fin de conexión");
        }

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Servidor servidor = new Servidor();
        servidor.tratamientoDatos();
    }

}
