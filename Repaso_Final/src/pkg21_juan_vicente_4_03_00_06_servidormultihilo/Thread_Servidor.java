/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg21_juan_vicente_4_03_00_06_servidormultihilo;

import com.sun.org.apache.bcel.internal.util.ByteSequence;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Thread_Servidor extends Thread {

    //DECLARAMOS VARIABLES
    private Socket socketCliente;
    private List<Integer> lstPuertos;

    //CONSTRUCTOR
    public Thread_Servidor(Socket socketCliente) {
        this.socketCliente = socketCliente;
        this.lstPuertos = new ArrayList<>();
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        //GENERAMOS LOS FLUJOS DE ENTRADA Y SALIDA EN UN TRY CON RECURSOS
        try (DataInputStream flujoEntrada = new DataInputStream(socketCliente.getInputStream());
                DataOutputStream flujoSalida = new DataOutputStream(socketCliente.getOutputStream());) {

            //MENSAJE DE ENTRADA
            System.out.println("De " + getName() + " a servidor: " + flujoEntrada.readInt());
            //GUARDAMOS PUERTO EN LISTA
            lstPuertos.add(flujoEntrada.readInt());
            //MENSAJE DE SALIDA
            String mensajeSalidaServidor = "Mensaje servidor a " + getName() + ", Hola " + getName();
            flujoSalida.writeUTF(mensajeSalidaServidor);
            this.sleep(3000);

        } catch (IOException ex) {
            System.err.println("Error en los flujos de entrada y/o salida");
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error inesperado");
        }
    }

    public List<Integer> getLstPuertos() {
        return lstPuertos;
    }

}
