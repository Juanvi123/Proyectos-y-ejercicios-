/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_4_03_11_tcp_cliente_servidor_multihilo;

import java.net.Socket;

/**
 *
 * @author juanv
 */
public class Socket_Identificador {
    //DECLARAMOS VARIABLES
    private Socket socket;
    private int id;

    //CONSTRUCTOR
    public Socket_Identificador(Socket socket, int id) {
        this.socket = socket;
        this.id = id;
    }

    //GETTERS Y SETTERS
    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    
}
