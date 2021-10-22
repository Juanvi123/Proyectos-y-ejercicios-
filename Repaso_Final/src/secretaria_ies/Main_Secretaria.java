/*
En la secretaría de un IES los alumnos  se matriculan durante el mes de septiembre. Trabajan
varias administrativas ( aleatorio 2-5 ) y entran varios alumnos.

Los alumnos tienen un número de expediente  ( asignación aleatoria  1-10000 al crear el
alumno ) y un nombre ( cogido al azar de una lista de nombres , al crear el alumno ) .

La solicitud de matrícula se formaliza completando una solicitud que tiene un número de 
expediente y  un nombre del alumno , un número de asignaturas matriculadas ( aleatorio 1-15 )
, una tasa por asignatura ( aleatorio 20 , 40 , 40 ) y un importe total de pago  .

En el despacho de secretaría hay una bandeja donde los alumnos colocan las solicitudes 
completadas hasta llenarla ; caben 5 solicitudes . Y también efectuan el pago de tasas 
incrementado el saldo de un  monedero que hay en la bandeja . Cuando la bandeja está llena ,
una administrativa vacía la bandeja ; entonces los alumnos siguen colocando más solicitudes .

Al inicio de la jornada, en la secretaría entran un número aleatorio de alumnos 
(entre 35 y 100). Cada alumno completará la solicitud ( tarda un tiempo aleatorio 20-200 ) y
lo dejará en la bandeja ( inicialmente vacía ) efectuando el pago y el alumno se marchará de 
secretaria .

Las administrativas cada cierto tiempo ( aleatorio  20-40 ) comprobarán el estado de la
bandeja ; si está llena , la vaciarán  y los alumnos continuarán dejando expedientes . 
Cuando no hay alumnos ( la bandeja estará  llena , vacía o a medias  ) una administrativa
vaciará la bandeja ,  mostrará  el número de solicitudes presentadas esa jornada y el importe
de tasas ;  cerrará secretaría echando a todas administrativas  .

 */
package secretaria_ies;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author juanv
 */
public class Main_Secretaria {

    //CONSTANTES
    private static final int N_MIN_ALUMNOS = 35;
    private static final int N_MAX_ALUMNOS = 100;
    private static final int N_MIN_SECRETARIAS = 2;
    private static final int N_MAX_SECRETARIAS = 5;

    public static void main(String[] args) throws InterruptedException {
        //INSTANCIAMOS RC
        RC_Despacho despacho = new RC_Despacho();
        //DEFINIMOS EL Nº DE ALUMNOS Y SECRETARIAS
        int nAlumnos = new Random().nextInt((N_MAX_ALUMNOS - N_MIN_ALUMNOS) + 1) + N_MIN_ALUMNOS;
        int nAdmins = new Random().nextInt((N_MAX_SECRETARIAS - N_MIN_SECRETARIAS) + 1) + N_MIN_SECRETARIAS;
        System.out.println("Se abre la secretaria, hay " + nAdmins + " secretarias y entran " + nAlumnos + " alumnos");
        //INSTANCIAMOS PRODUCTORES
        List<Alumnos> lstAlumnos = new ArrayList<>();
        for (int i = 0; i < nAlumnos; i++) {
            lstAlumnos.add(new Alumnos(despacho));
            lstAlumnos.get(i).start();
        }
        //INSTANCIAMOS CONSUMIDORES
        List<Administrativas> lstAdmin = new ArrayList<>();
        for (int i = 0; i < nAdmins; i++) {
            lstAdmin.add(new Administrativas(despacho));
            lstAdmin.get(i).setName("Administrativa " + (i + 1));
            lstAdmin.get(i).start();
        }

        //ESPERAMOS A QUE LOS ALUMNOS ACABEN
        for (int i = 0; i < nAlumnos; i++) {
            lstAlumnos.get(i).join();
        }
        for (int i = 0; i < nAlumnos; i++) {
            while (lstAlumnos.get(i).isAlive()) {
                Thread.sleep(10);
            }
        }
        //INTERRUMPIMOS A ADMINISTRATIVAS
          for (int i = 0; i < nAdmins; i++) {
            lstAdmin.get(i).interrupt();
        }

    }

}
