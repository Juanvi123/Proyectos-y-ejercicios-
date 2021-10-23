/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_multihiloArray_infinito;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Cliente_4_03_00_08 extends Thread {

    //CONSTANTES
    private static final String IP = "localhost";
    private static final int PUERTO = 5000;
    private static final int TIEMPO_DEMORA = 1000;
    private static final int n_CLIENTES = 3;

    DataOutputStream flujoSalida;
    DataInputStream flujoEntrada;

    Socket socketCliente;

    public Cliente_4_03_00_08() throws IOException {
        //ESTABLECEMOS CONEXIÓN CON EL SERVIDOR
        socketCliente = new Socket(IP, PUERTO);
        //CREAMOS LOS FLUJOS DE ENTRADA Y SALIDA 
        flujoSalida = new DataOutputStream(socketCliente.getOutputStream());
        flujoEntrada = new DataInputStream(socketCliente.getInputStream());
    }

    @Override
    public void run() {
        //GENERAMOS UN BUCLE INFINITO
        for (int i=0;i<3;i++) {
            try {
                //RECIBIMOS MENSAJE SERVIDOR Y HACEMOS ECO
                System.out.println(flujoEntrada.readUTF());
                //NOS DEMORAMOS 1 SEGUNDO
                Thread.sleep(TIEMPO_DEMORA);
                //ENVIAMOS MENSAJE AL SERVIDOR
                flujoSalida.writeInt(socketCliente.getLocalPort());
                //NOS DEMORAMOS 1 SEGUNDO
                Thread.sleep(TIEMPO_DEMORA);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cliente_4_03_00_08.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Cliente_4_03_00_08.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        for (int i = 0; i < n_CLIENTES; i++) {
             Cliente_4_03_00_08 cliente=new Cliente_4_03_00_08();
             cliente.start();
             cliente.join();
        }

    }
}


