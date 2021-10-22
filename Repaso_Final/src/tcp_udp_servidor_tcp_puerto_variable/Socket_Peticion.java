/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_udp_servidor_tcp_puerto_variable;

import tcp_4_03_09_tcp_cliente_servidor_multihilo.*;
import java.net.Socket;

/**
 *
 * @author juanv
 */
public class Socket_Peticion {
    
    //DECLARAMOS VARIABLES
    private Socket socket;
    private int peticion;

    //CONSTRUCTOR
    public Socket_Peticion(Socket socket, int peticion) {
        this.socket = socket;
        this.peticion = peticion;
    }

    //GETTERS Y SETTERS
    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public int getPeticion() {
        return peticion;
    }

    public void setPeticion(int peticion) {
        this.peticion = peticion;
    }
    
}
