/*
 En un taller de mecánica hay un administrativo, siete mecánicos que
esperan sentados en un banco , una caja de útiles con cinco herramientas y un
área de espera de coches.
Cuando un coche entra en el taller es atendido por el administrativo. Se
dirige al banco de mecánicos y le asigna uno ( si hay libres) y sino el 
coche va al área de espera. El administrativo quedará disponible para atender 
otro coche.
El área de espera de coches nunca es desbordada.
El mecánico con coche asignado , tardará un tiempo en examinar el coche, 
cogerá una herramienta, si hay disponibles y sino esperará . Comenzará la 
reparación cuando tenga una  herramienta y tardará un tiempo aleatorio.
Finalizada la reparación anota el importe reparado en el coche,   anota el 
número de coches reparados, devuelve la herramienta , pasa el coche reparado 
al administrativo y busca un coche en el área de espera, si hay toma un coche
y comienza a examinarlo, sino hay se sienta en el banco.
El administrativo toma el coche reparado acumula el importe anotado por el
mecánico y lo borra del sistema.
El main() creará la caja de útiles, el banco de mecánicos y los mecánicos; 
el administrativo y los coches. El número de coches se creará aleatoriamente 
(5-50) y entre coche y coche creado se tardará un tiempo aleatorio (1-3 segundos).
El coche creado se pasa al administrativo (el coche entra en el taller) y actuará.
Los coches se identificarán así: c1, c2, …
Los mecánicos se identificarán así: M1, M2, …
El administrativo se idenficarán así: A1.
Las herramientas se identificarán así: h1, h2, …
Área de espera de coches.

 */
package taller_mecanica;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author juanv
 */
public class Main_Taller_Mecanica {

    //CONSTANTES
    private static final int NUMERO_MECANICOS = 7;
    private static final int NUMERO_HERRAMIENTAS = 5;
    private static final int N_MIN_Cohes = 5;
    private static final int N_MAX_Cohes = 50;

    public static void main(String[] args) {
        //DEFINIR Nº DE COCHES QUE ENTRARÁN EN EL TALLER
        int nCoches=new Random().nextInt((N_MAX_Cohes-N_MIN_Cohes)+1)+N_MIN_Cohes;
        System.out.println("En esta jornada entran "+nCoches+" coches");
        //INSTANCIAMOS RC
        RC_Banco_Mecanicos banco_Mecanicos=new RC_Banco_Mecanicos();
        
        //CREAMOS LOS COCHES
        List<Coches>lstCoches=new ArrayList<>();
        for(int i=0;i<nCoches;i++){
            lstCoches.add(new Coches("Coche "+(i+1)));
        }
        
        //INSTANCIAMOS, INICIALIZAMOS Y ARRANCAMOS ADMINISTRATIVO
        Administrativo administrativo=new Administrativo(lstCoches, banco_Mecanicos);
        administrativo.setName("Administrativo");
        administrativo.start();
        
        //INTSANCIAMOS, INICIALIZAMOS Y ARRANCAMOS A MECANICOS
        List<Mecanicos>lstMecanicos=new ArrayList<>();
        for(int i=0;i<NUMERO_MECANICOS;i++){
            lstMecanicos.add(new Mecanicos(banco_Mecanicos));
            lstMecanicos.get(i).setName("Mecánico "+(i+1));
            lstMecanicos.get(i).setDaemon(true);
            lstMecanicos.get(i).start();
        }
    }
}
