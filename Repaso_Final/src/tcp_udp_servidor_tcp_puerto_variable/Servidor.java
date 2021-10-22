/*
 Un servidor TCP cambia su puerto de escucha cada 60 segundos dentro del rango 12333
hasta 55688.
Para que los clientes puedan hacer las peticiones TCP al puerto cambiado, hace un
broadcast UDP cada vez que cambia el puerto de escucha y acepta peticiones en ese puerto
durante 60 segundos. Transcurrido el tiempo cambia de puerto (aleatoriamente), lo difunde y
acepta peticiones en el nuevo puerto . Las difusiones UDP siempre se hacen en el puerto 2525.
Las peticiones TCP aceptadas serán metidas en un recurso compartido que admitirá un
máximo de 11 por cada puerto TCP cambiado ; si sobrepasa el límite la conexión será cerrada .
Las conexiones metidas en el recurso compartido serán atendidas por un hilo worker . El
servidor tendrá cinco hilos worker ; su función consistirá en atender las peticiones metidas en el
recurso compartido . La atención al cliente finalizará cuando reciba la palabra FIN .
Los clientes, recibirán en UDP el puerto cambiado del servidor TCP. Tras conocerlo
establecerán una conexión TCP y esperarán aceptación de conexión o cierre. Si es cerrada
escribirán un mensaje de error y finalizarán . Si es aceptada , recibirán un mensaje del hilo
servidor conteniendo “OK” . El cliente leerá un mensaje de teclado y lo enviará al servidor ; el
servidor hará eco en pantalla y retornará “OK ” . Cuando en teclado se escriba “FIN” ,
finalizará la conexión .

 */
package tcp_udp_servidor_tcp_puerto_variable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author juanv
 */
public class Servidor extends Thread {

    //CONSTANTES
    private static int PUERTO_TCP = 5555;
    private static final int PUERTO_UDP = 2525;
    private static final String IP = "localhost";
    private static final int MAX_TAMANO_BUFFER = 3000;
    private static final int N_Hilos_Worker = 5;
    private static final int CAPACIDAD_RC = 11;

//VARIABLES UDP
    //BUFFER
    byte[] buffer;

    //DATAGRAMPACKAGE
    DatagramPacket dgpRecibir;
    DatagramPacket dgpEnviar;

    //SOCKET
    DatagramSocket socketUDP;

//VARIABLES TCP
    //SERVERSOCKET
    static ServerSocket serverSocket;

    //SOCKET
    Socket socket;

    //RC
    LinkedBlockingQueue<Socket_Peticion> socketCola;
    List<Hilo_Worker> lstHilosWorker;

    //FLUJOS
    DataInputStream flujoEntrada;
    DataOutputStream flujoSalida;

    //VARIABLE
    private int puertoCliente;
    private int nPeticion;

    public Servidor() throws UnknownHostException, SocketException, IOException {
        //INICIALIZAMOS CAMPOS
        this.socketUDP = new DatagramSocket(PUERTO_UDP);
        socketUDP.setBroadcast(true);
        this.buffer = new byte[MAX_TAMANO_BUFFER];
        this.serverSocket = new ServerSocket(PUERTO_TCP);
        this.socketCola = new LinkedBlockingQueue<>();
        this.lstHilosWorker = new ArrayList<>();
        this.puertoCliente = 0;
    }

    public void recibirUDP() throws IOException, ClassNotFoundException {
        //ECO INICIAL
        System.out.println(getClass().getSimpleName() + " espera mensaje. Escucha en puerto "
                + serverSocket.getLocalPort());
        //INICIALIZAR EL BUFFER
        buffer = new byte[MAX_TAMANO_BUFFER];
        //INICIALIZAMOS EL DGP DE RECIBIR
        dgpRecibir = new DatagramPacket(buffer, buffer.length,InetAddress.getByName(IP),PUERTO_UDP);
        //RECIBIMOS PAQUETE
        socketUDP.receive(dgpRecibir);
        //TRATAMIENTO DE DATOS
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(buffer));
        puertoCliente = Integer.parseInt(ois.readObject().toString());
        //ECO
        System.out.println("Cliente nos ha mandado su puerto: " + puertoCliente);
    }

    public void enviarPuertoUDP() throws IOException {
        Timer timer = new Timer();
        Cambiar_Puerto cambiar_Puerto = new Cambiar_Puerto();
        timer.schedule(cambiar_Puerto, 0, 5000);

        //INICIALIZAR EL BUFFER
        buffer = new byte[MAX_TAMANO_BUFFER];
        //FLUJOS DE SALIDA
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(PUERTO_TCP);
        //INICIALIZAMOS EL BUFFER CON EL ARRAY QUE CONTIENE EL PUERTO
        buffer = baos.toByteArray();

        //INICIALIZAMOS EL DATAGRAMPACKET
        dgpEnviar = new DatagramPacket(buffer, buffer.length,
                InetAddress.getByName(IP), puertoCliente);
        //ENVIAMOS PAQUETE
        socketUDP.send(dgpEnviar);
        //LIBERAMOS RECURSOS
        oos.close();
        baos.close();

    }

    public static void setPuerto(int puerto) throws IOException {
        //CERRAMOS SERVERSOCKET
        serverSocket.close();
        //VOLVEMOS A INICIALIZAR EL PUERTO
        PUERTO_TCP = puerto;
        //VOLVEMOS A INICIALIZAR EL SERVERSOCKET
        serverSocket = new ServerSocket(PUERTO_TCP);
    }

    public void creacionHilosWorker() {
        for (int i = 0; i < N_Hilos_Worker; i++) {
            lstHilosWorker.add(new Hilo_Worker(socketCola));
            lstHilosWorker.get(i).setName("Hilo_Worker_" + (i + 1));
            lstHilosWorker.get(i).start();
        }
    }

    public void hiloEscucha() throws IOException, InterruptedException {
        while (true) {
            //ACEPTAR CONEXIÓN CON SERVIDOR
            socket = serverSocket.accept();
            //INCREMENTAMOS EL CONTADOR DE PETICIONES
            nPeticion++;
            if (socketCola.size() < CAPACIDAD_RC) {
                //METEMOS PETICION EN RC
                Socket_Peticion socket_Peticion = new Socket_Peticion(socket, nPeticion);
                socketCola.put(socket_Peticion);
                //ENVIAMOS MENSAJE DE ACEPTACION
                flujoSalida = new DataOutputStream(socket.getOutputStream());
                flujoSalida.writeUTF(getClass().getSimpleName() + " acepta petición a Cliente "
                        + socket_Peticion.getPeticion());
            } else {
                 //ENVIAMOS MENSAJE DE RECHAZO
                flujoSalida = new DataOutputStream(socket.getOutputStream());
                flujoSalida.writeUTF(getClass().getSimpleName() + " rechaza a Cliente "
                        + nPeticion);
                //CERRAMOS CONEXIÓN
                socket.close();
            }
        }
    }

    //MAIN
    public static void main(String[] args) throws IOException,
            ClassNotFoundException, InterruptedException {
        Servidor servidor = new Servidor();
        servidor.recibirUDP();
        servidor.enviarPuertoUDP();
        servidor.creacionHilosWorker();
        servidor.hiloEscucha();

    }

}
