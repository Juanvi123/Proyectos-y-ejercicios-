/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_4_03_11_tcp_cliente_servidor_multihilo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Hilo_Atencion_Cliente extends Thread {
    //CONSTANTES
    private static final int N_MIN=3;
    private static final int N_MAX=5;  
    
    //CAMPOS SOCKET_IDENTIFICDOR
    private Socket socket;
    private int id;
    
    //FLUJOS
    private DataInputStream flujoEntrada;
    private DataOutputStream flujoSalida;
    
    //VARIABLES
    private int nAle;

    //CONSTRUCTOR
    public Hilo_Atencion_Cliente(Socket_Identificador socket_Identificador) throws IOException {
        //INICIALIZACIÓN DE CAMPOS
        this.socket=socket_Identificador.getSocket();
        this.id=socket_Identificador.getId();
        this.flujoEntrada=new DataInputStream(socket.getInputStream());
        this.flujoSalida=new DataOutputStream(socket.getOutputStream());
        this.nAle=new Random().nextInt((N_MAX-N_MIN)+1)+N_MIN;
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        try {
            //ENVIAMOS A CLIENTE nº iteracciones y su id
            flujoSalida.writeInt(nAle);
            flujoSalida.writeInt(id);
            for(int i=0;i<nAle;i++){
                //ENVIA Nº DE ITERACION
                flujoSalida.writeUTF("Iteración -> "+i);
                //RECIBE CADENA TEXTO
                System.out.println(flujoEntrada.readUTF());
            }
            //FIN CONEXIOn
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Hilo_Atencion_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
