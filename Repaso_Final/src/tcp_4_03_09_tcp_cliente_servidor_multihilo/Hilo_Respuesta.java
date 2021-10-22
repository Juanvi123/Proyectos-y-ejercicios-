/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_4_03_09_tcp_cliente_servidor_multihilo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Hilo_Respuesta extends Thread {

    //CONSTANTES
    private static final int ESPERA = 1000;

    //RC
    LinkedBlockingQueue<Socket_Identificador> socketCola;

    //FLUJOS
    DataInputStream flujoEntrada;
    DataOutputStream flujoSalida;

    //VARIABLES
    private String mensajeEntrada;
    private String mensajeSalida;

    //INSTANCIA sOCKET_iDENTIFICADOR
    Socket_Identificador socket_Identificador;

    //CONSTRUCTOR
    public Hilo_Respuesta(LinkedBlockingQueue<Socket_Identificador> socketCola) {
        this.socketCola = socketCola;
        this.mensajeEntrada = "";
        this.mensajeSalida = "";

    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        try {
            //SI NO HAGO EL BUCLE INFINITO SOLO RECIBE A LA PRIMERA TANDA
            while (true) {
                //COGE MENSAJE DEL CLIENTE
                socket_Identificador = socketCola.take();
                //ENVIAMOS MENSAJE HOLA A CLIENTE
                Socket socket = socket_Identificador.getSocket();
                //INICIALIZAMOS FLUJO SALIDA
                flujoSalida = new DataOutputStream(socket.getOutputStream());
                //INICIALIZAMOS FLUJO DE ENTRADA
                flujoEntrada = new DataInputStream(socket.getInputStream());
                mensajeSalida = "Hola";
                //ENVIAMOS MENSAJE SALIDA
                flujoSalida.writeUTF(mensajeSalida);
                //ECO NOMBRE CLIENTE 
                System.out.println(getName() + " recibe " + socket_Identificador.getId());
                //REPITE HASTA QUE CIERRA CONEXIÓN
                if(!socket.isClosed()) {
                    //RECIBIMOS MENSAJE
                    mensajeEntrada = flujoEntrada.readUTF();
                    //ECO MENSAJE RECIBIDO
                    System.out.println(getName()+"mensaje recibido: "+mensajeEntrada);
                    //ESPERA 1 SEGUNDO
                    this.sleep(ESPERA);
                    //ENVIA MENSAJE
                    mensajeSalida = "seguimos";
                    flujoSalida.writeUTF(mensajeSalida);
                    if(socket.isClosed()){
                        break;
                    }
                }
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo_Respuesta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SocketException e) {

        } catch (IOException ex) {
            Logger.getLogger(Hilo_Respuesta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
