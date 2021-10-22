/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg21_juan_vicente_4_03_00_06_servidormultihilo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

/**
 *
 * @author juanv
 */
public class Cliente_4_03_00_06 {

    //CONSTANTES
    private static final String IP = "localhost";
    private static final int PUERTO = 5000;
    private static final int TIEMPO_DEMORA = 1000;

    public static void main(String[] args) throws IOException, InterruptedException {
        //ESTABLECEMOS CONEXIÓN CON EL SERVIDOR
        Socket socketCliente = new Socket(IP, PUERTO);
        System.out.println("Puerto Cliente "+socketCliente.getLocalPort());
        //CREAMOS LOS FLUJOS DE ENTRADA Y SALIDA 
        try (DataOutputStream flujoSalida = new DataOutputStream(socketCliente.getOutputStream());
                DataInputStream flujoEntrada = new DataInputStream(socketCliente.getInputStream());) {
            //GENERAMOS UN BUCLE INFINITO
            for (;;) {
                //ENVIAMOS MENSAJE AL SERVIDOR
                flujoSalida.writeInt(socketCliente.getLocalPort());
                //RECIBIMOS MENSAJE SERVIDOR Y HACEMOS ECO
                System.out.println(flujoEntrada.readUTF());
                //NOS DEMORAMOS 1 SEGUNDO
                Thread.sleep(TIEMPO_DEMORA);
                
            }
        } catch (SocketException se) {
//CAPTURAMOS LA EXCEPCIÓN PARA CUANDO CERRAMOS LA CONEXIÓN CON EL SERVIDOR
            System.err.println("Cerramos conexión");
        }catch (IOException ex) {
            System.err.println("Error en los flujos de entrada y/o salida");
            ex.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
            System.err.println("Error inesperado");
        }

    }

}
