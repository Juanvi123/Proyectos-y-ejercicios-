/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_hilo_worker;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import tcp_reconexion_hilo_servidor.Cosa;

/**
 *
 * @author juanv
 */
public class Hilos_Worker extends Thread {

    //CONSTANTES
    private static final int N = 5;
    private static final int ESPERA=1000;

    //SOCKET
    Socket socket;

    //RC
    LinkedBlockingQueue<Cosa> colaSockets;

    //FLUJOS
    DataInputStream flujoEntrada;
    DataOutputStream flujoSalida;

    //INSTANCIA DE COSA
    Cosa cosa;

    //VARIABLES
    private int peticion;
    private String mensajeSalida;
    private String mensajeEntrada;

    public Hilos_Worker(LinkedBlockingQueue colaSockets) throws InterruptedException, IOException {
        //INICIALIZAMOS ELEMENTOS
        this.colaSockets = colaSockets;
        this.mensajeSalida = "";
        this.mensajeEntrada="";

    }

    @Override
    public void run() {
        //INFINITAS VECES
        while (true) {
            try {
                //SACA SOCKET ACEPTADO DEL RC
                this.cosa = (Cosa) colaSockets.take();
                this.socket = cosa.getSocket();
                this.peticion = cosa.getPeticion();
                this.flujoEntrada = new DataInputStream(socket.getInputStream());
                this.flujoSalida = new DataOutputStream(socket.getOutputStream());
                //N VECES
                for(int i=0;i<N;i++){
                    //ENVIA CADENA TEXTO Y Nº A CLIENTE
                    mensajeSalida=getName()+" envía a Cliente "+String.valueOf(peticion)
                            +": su petición ha sido aceptada";
                    flujoSalida.writeUTF(mensajeSalida);
                    //ESPERA
                    this.sleep(1000);
                    //RECIBE CADENA DE TEXTO
                    mensajeEntrada=flujoEntrada.readUTF();
                    //ECO
                    System.out.println(getName()+" recibe de Cliente "+peticion+": "+mensajeEntrada);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilos_Worker.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Hilos_Worker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
