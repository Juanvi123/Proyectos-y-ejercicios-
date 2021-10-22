/*
Puede hacerse con clases del paquete java.util.concurrent .
Codificar un servidor multihilo . El servidor tendrá M hilos para atender a los clientes . En la creación de
estos hilos , una referencia del hilo será guardada en un arrayList para controlar el número de hilos que están
vivos .
El hilo de escucha aceptará conexiones mientras que el número de hilos vivos de atención al cliente sea
menor que M , si no es así rechazará la conexión .
El servidor tiene un contador de clientes ( conexiones atendidas ) .
El comportamiento es el siguiente :
cliente
establece conexión con servidor
recibe N del servidor
N veces (iteración )
recibe cadena texto
eco en pantalla de cadena de texto recibida
demora 1 segundo
envía cadena texto recibida y número de iteración
cierra conexión
fin
servidorHiloEscucha
puerto escucha
INFINITAS veces
acepta conexión cliente
SI hay M hilos atendiendo a clientes , cierra conexión
SINO crea hilo atención a cliente para conexión aceptada
mete hilo atención a cliente en ArrayList
incrementa contador de conexiones atendidas ( número de cliente )
fin
servidorHiloAtenciónCliente
N aleatorio ( 5-50 )
envia a cliente : número de cliente y N
N veces ( iteración )
envia número de iteración .
recibe cadena texto
eco en pantalla de cadena texto recibida
cierra conexión
fin

 */
package tcp_4_03_11_tcp_cliente_servidor_multihilo;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author juanv
 */
public class Servidor_Multihilo {
    //CONSTANTES
    private static final int PUERTO=5555;
     private static final int maxClientes=50;
    //SERVERSOCKET
    ServerSocket serverSocket;
    //RC
    LinkedBlockingQueue<Hilo_Atencion_Cliente> socketCola;

    public Servidor_Multihilo() throws IOException {
        this.serverSocket=new ServerSocket(PUERTO);
        this.socketCola=new LinkedBlockingQueue<>();
    }
    
    public void arrancarHiloEscuha(){
        //ECO INICIAL
        System.out.println(getClass().getSimpleName()+" activo, escuho por puerto "+
                serverSocket.getLocalPort());
        Hilo_Escucha hilo_Escucha=new Hilo_Escucha(serverSocket, socketCola,maxClientes);
        hilo_Escucha.setName("SERVIDOR");
        hilo_Escucha.start();
    }
    
    public static void main(String[] args) throws IOException {
        Servidor_Multihilo servidor=new Servidor_Multihilo();
        servidor.arrancarHiloEscuha();
    }
    
    
}
