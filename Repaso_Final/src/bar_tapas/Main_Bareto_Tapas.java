/*
En un bar venden bebidas y tapas . Trabajan un camarero y un cocinero . A lo 
largo del día entran varios clientes.
La tarifa es la siguiente :
bebidas : vino blanco 2,5 € , vino tinto 3€ , cerveza 2€ , refrescos 3€ ,
licores 5€ .
tapas : pincho calamar 1,30€ , pincho jamón 3€ ; ración patatas 4€ .
El número de clientes es variable 25 .. T .. 500 , van entrando de forma
impulsiva y aleatoria en tres tandas t1, t2
y t3=T-t1-t2 aleatorias . La primera tanda t1 entran a la vez cuando se abre
el bar , la segunda tanda t2 entra
espaciadamente , entre cliente y cliente transcurre un tiempo 5 .. 15 y la 
tercera tanda entran seguidamente , entre
cliente y cliente transcurre un tiempo 1 .. 3 .
El comportamiento del cliente es : decide cuantas 0.. 3 bebidas tomará y las
elige , se demora 40.. 200 y coge
las bebidas ; después elige una tapa , se demora 10 .. 50 . Calcula el importe 
total de bebidas y tapa y paga en caja .
El comportamiento del cocinero es : coge una bandeja vacía de la barra y la 
llena de tapas , en la elaboración de
cada tapa emplea un tiempo 5.. 25 . Cuando la bandeja está llena , caben 12
tapas, la pone en la barra para que los
clientes puedan coger tapas . En la barra caben tres bandejas .
El comportamiento del camarero es : coge una bebida del frigorífico y la coloca 
en la barra para que pueda ser
cogida cogida por los clientes . Pone bebidas hasta que llena la barra , caben
24 bebidas . Mientras hay clientes
en el bar repone bebidas cada 3 segundos . Si no hay clientes hace caja , la 
deja vacía y el importe de la misma lo
pasa a una billetera . Cuando no hay clientes y han entrado todos los posibles
clientes T ( T es un valor
desconocido por el camarero ) , hace caja , imprime el importe total recaudado
ese día , imprime el valor de las
tapas existentes en la barra y cierra el bar .
 */
package bar_tapas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author juanv
 */
public class Main_Bareto_Tapas {

    //CONSTANTES
    private static final int N_MIN_CLIENTES = 5;
    private static final int N_MAX_CLIENTES = 15;

    public static void main(String[] args) throws InterruptedException {
        //DEFINIMOS EL NUMERO DE CLIENTES
        //CLIENTES TANDA 1
        int nT1 = new Random().nextInt((N_MAX_CLIENTES - N_MIN_CLIENTES) + 1) + N_MIN_CLIENTES;
        //CLIENTES TANDA 2
        int nT2 = nT1 * 2;
        //CLIENTES TANDA 3
        int nT3 = nT2 - nT1;
        //CLIENTES TOTALES
        int nClientes = nT1 + nT2 + nT3;
        System.out.println("Entran " + nClientes + " clientes\nT1: " + nT1 + "\nT2:" + nT2 + "\nT3:" + nT3 + "\n");
        //INSTANCIAMOS RC
        RC_Barra barra = new RC_Barra();

        List lstClientes = new ArrayList(nClientes);
        for (int i = 0; i < nClientes; i++) {
            lstClientes.add(i);
        }

        //INSTANCIAMOS PRODUCTORES
        Cocinero cocinero = new Cocinero(barra, lstClientes);
        cocinero.setName("Cocinero");
        cocinero.start();

        Camarero camarero = new Camarero(barra);
        camarero.setName("Camarero");
        camarero.setDaemon(true);
        camarero.start();

        //INTANCIAMOS CONSUMIDORES
        //TANDA 1
        List<Clientes_T1> lstClientes_T1 = new ArrayList<>();
        for (int i = 0; i < nT1; i++) {
            lstClientes_T1.add(new Clientes_T1(barra));
            lstClientes_T1.get(i).setName("Cliente_T1 " + (i + 1));
            lstClientes_T1.get(i).start();
        }
        //TANDA 2
        List<Clientes_T2> lstClientes_T2 = new ArrayList<>();
        for (int i = 0; i < nT2; i++) {
            lstClientes_T2.add(new Clientes_T2(barra));
            lstClientes_T2.get(i).setName("Cliente_T2 " + (i + 1));
            lstClientes_T2.get(i).start();
        }
        //TANDA 3
        List<Clientes_T3> lstClientes_T3 = new ArrayList<>();
        for (int i = 0; i < nT3; i++) {
            lstClientes_T3.add(new Clientes_T3(barra));
            lstClientes_T3.get(i).setName("Cliente_T3 " + (i + 1));
            lstClientes_T3.get(i).start();
        }
        //ESPERAMOS A QUE TODOS LOS CLIENTES MUERAN
        for (int i = 0; i < nT1; i++) {
            lstClientes_T1.get(i).join();
        }
        for (int i = 0; i < nT1; i++) {
            while (lstClientes_T1.get(i).isAlive()) {
                Thread.sleep(10);
            }
        }
        //TANDA 2
        for (int i = 0; i < nT2; i++) {
            lstClientes_T2.get(i).join();
        }
        for (int i = 0; i < nT2; i++) {
            while (lstClientes_T2.get(i).isAlive()) {
                Thread.sleep(10);
            }
        }
        //TANDA 3
        for (int i = 0; i < nT3; i++) {
            lstClientes_T3.get(i).join();
        }
        for (int i = 0; i < nT3; i++) {
            while (lstClientes_T3.get(i).isAlive()) {
                Thread.sleep(10);
            }
        }
        //ECOS DE TODOS LOS CLIENTES
        for (int i = 0; i < nT1; i++) {
            System.out.println(lstClientes_T1.get(i).getName() + " FIN,"
                    + "se ha pedido " + lstClientes_T1.get(i).getPedido() + ".Su "
                    + "importe es de: " + String.format("%.2f", lstClientes_T1.get(i).getImporte()) + "€");
        }
        for (int i = 0; i < nT2; i++) {
            System.out.println(lstClientes_T2.get(i).getName() + " FIN,"
                    + "se ha pedido " + lstClientes_T2.get(i).getPedido() + ".Su "
                    + "importe es de: " + String.format("%.2f", lstClientes_T2.get(i).getImporte()) + "€");
        }
        for (int i = 0; i < nT3; i++) {
            System.out.println(lstClientes_T3.get(i).getName() + " FIN,"
                    + "se ha pedido " + lstClientes_T3.get(i).getPedido() + ".Su "
                    + "importe es de: " + String.format("%.2f", lstClientes_T3.get(i).getImporte()) + "€");
        }
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + " FIN");
    }
}
