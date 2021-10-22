/*
En una pastelería los pasteleros y elaboran dulces que colocan en una 
bandeja de seis unidades.
Cada dulce es distinto de los demás y está etiquetado con un nombre y 
un precio.
Cada seis milisegundos elaboran un dulce. Cuando la bandeja está llena
se deja en la pila de bandejas, y el pastelero coge otra bandeja vacía
y continua elaborando.

Hay seis bandejas en la pila y si todas están llenas los pasteleros 
paran y esperan. Si no hay bandeja llena el vendedor para y espera. 
Si no hay bandeja vacía el pastelero para y espera.

Un vendedor coge una bandeja llena y la vacía . Cada dulce vendido tarda
un tiempo aleatorio, va calculando el importe a medida que vende y una 
cadena con el nombre de todos los dulces vendidos.
Cuando la bandeja está vacía la deja en la pila y coge otra llena. Si
no las hay espera.

En la pastelería hay tres vendedores. v_Luis, v_Pedro, v_Andres y dos
pasteleros: p_Ana y p_Jorge. Calcular el importe vendido a lo largo de 
4 horas de apertura (desde que se abre hasta que se cierra ) de la 
pastelería.

 */
package pasteleria_v1_pasteleria_cierra;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juanv
 */
public class Main_Pasteleria {

    //CONSTANTES
    private static final int NUMERO_PASTELEROS = 2;
    private static final int NUMERO_VENDEDORES = 3;
    private static final int TIEMPO_HASTA_CIERRE = 10000;

    public static void main(String[] args) throws InterruptedException {
        //INSTANCOAMOS RC
        RC_Pila pila = new RC_Pila();
        //INSTANCIAMOS PRODCUTORES
        List<Pasteleros> lstPasteleros = new ArrayList<>();
        for (int i = 0; i < NUMERO_PASTELEROS; i++) {
            lstPasteleros.add(new Pasteleros(pila));
        }
        for (int i = 0; i < NUMERO_PASTELEROS; i++) {
            lstPasteleros.get(0).setName("P_Ana");
            lstPasteleros.get(1).setName("P_Jorge");
        }
        for (int i = 0; i < NUMERO_PASTELEROS; i++) {
            lstPasteleros.get(i).start();
        }
        //INSTANCIAMOS CONSUMIDORES
        List<Vendedores> lstVendedores = new ArrayList<>();
        for (int i = 0; i < NUMERO_VENDEDORES; i++) {
            lstVendedores.add(new Vendedores(pila));
        }
        for (int i = 0; i < NUMERO_VENDEDORES; i++) {
            lstVendedores.get(0).setName("V_Luis");
            lstVendedores.get(1).setName("V_Pedro");
            lstVendedores.get(2).setName("V_Andrés");
        }
        for (int i = 0; i < NUMERO_VENDEDORES; i++) {
            lstVendedores.get(i).start();
        }
        //TIEMPO HASTA CIERRE
        Thread.sleep(TIEMPO_HASTA_CIERRE);
        System.err.println("Se cierra la tienda");

        for (int i = 0; i < NUMERO_PASTELEROS; i++) {
            lstPasteleros.get(i).interrupt();
        }
        for (int i = 0; i < NUMERO_VENDEDORES; i++) {
            lstVendedores.get(i).interrupt();
        }
        //TOTAL RECAUDADO
        double totalRecaudado=0;
         for (int i = 0; i < NUMERO_VENDEDORES; i++) {
            totalRecaudado+=lstVendedores.get(i).getPrecio();
        }
         Thread.sleep(1000);
        System.err.println("Total recaudado: "+String.format("%.2f", totalRecaudado)+"€");
    }

}
