/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp_reloj_broadcast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.time.ZonedDateTime;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Reloj {

    //CONSTANTES
    private static final String IP = "192.168.56.255";
    private static final int PUERTO_RELOJ = 5555;
    private static final int PUERTO_PAISANO = 5556;
    private static final int MAXIMO_TAMANO_BUFFER = 3000;

    //DATAGRAMA
    DatagramPacket dgpEnvio;

    //SOCKET
    DatagramSocket socket;

    //BUFFER
    byte[] buffer;

    //VARIABLES
    private String horaActual;

    //CONSTRUCTOR
    public Reloj() throws SocketException {
        //INICIALIZAMOS ELEMENTOS
        this.buffer = new byte[MAXIMO_TAMANO_BUFFER];
        this.socket = new DatagramSocket(PUERTO_RELOJ);
        this.horaActual = "";
    }

    //MÉTODOS
    public void enviarMensaje() throws IOException {
        //ECO INICIAL
        System.out.println(getClass().getSimpleName()+" envía hora");
        //GUARDAMOS EN UN STRING LA HORA ACTUAL
        ZonedDateTime hora = ZonedDateTime.now();
        horaActual = String.valueOf(hora.getHour()) + ":" + String.valueOf(hora.getMinute())
                + ":" + String.valueOf(hora.getSecond());
        //TRANSFORMAMOS LA HORA ACTUAL EN BYTES
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(horaActual);
        //METEMOS LA HORA ACTUAL EN EL BUFFER
        buffer = baos.toByteArray();
        //ENVIAMOS LA HORA ACTUAL A LOS PAISANOS
        dgpEnvio = new DatagramPacket(buffer, buffer.length,
                InetAddress.getByName(IP), PUERTO_PAISANO);
        socket.send(dgpEnvio);
    }

    //MAIN
    public static void main(String[] args) throws SocketException {
        Reloj reloj = new Reloj();
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                try {
                    reloj.enviarMensaje();
                } catch (IOException ex) {
                    Logger.getLogger(Reloj.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        timer.schedule(task, 0,5000);
    }

}
