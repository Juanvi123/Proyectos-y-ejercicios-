/*
El cascanueces es un ave lanuda de invierno que come las nueces del bosque 
que maduran en los nogales que crecen en el monte Gurugú.

El nogal es un árbol que crece silvestre, en otoño produce un número aleatorio
de nueces que deposita en una cesta. Cada nogal tiene un nombre. Las nueces que
producen contienen un número y el nombre del nogal.

La cesta es un recurso compartido entre nogales y cascanueces. Se pueden meter 
y sacar nueces. Los nogales han de esperar a meter una nuez si la cesta está 
llena. Los cascanueces han de esperar a sacar nueces si la cesta está vacía. 
Desde fuera de la cesta ha de conocerse el número de nueces que hay dentro.

El cascanueces comerá todas las nueces que pueda (entre nuez y nuez tarda un 
tiempo aleatorio). Acumulará los números contenidos en las nueces comidas. 
Hará eco del contenido de la nuez.

En el bosque hay cuatro nogales “mediterráneo”, “californiano”, “asiático”,
“continental” y diez cascanueces. Llegado el otoño los nogales meten su fruto 
en la cesta y desaparecen. Los cascanueces sacan nueces de la cesta  y comen 
hasta que  la cesta queda vacía. Entonces desaparecen del bosque emigrando 
hacia otros bosques ( main() los destruye u otra forma de finalización).

 */
package cascanueces;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juanv
 */
public class Main_Cascanueces {
    //CONSTANTES

    private static final int NUMERO_NOGALES = 4;
    private static final int NUMERO_CASCANUECES = 10;

    public static void main(String[] args) throws InterruptedException {
        //INSTANCIAMOS RC
        RC_Cesta cesta = new RC_Cesta();
        //INSTANCIAMOS PRODUCTORES
        List<Nogales> lstNogales = new ArrayList<>();
        for (int i = 0; i < NUMERO_NOGALES; i++) {
            lstNogales.add(new Nogales(cesta));
        }
        for (int i = 0; i < NUMERO_NOGALES; i++) {
            lstNogales.get(0).setName("Nogal Mediterráneo");
            lstNogales.get(1).setName("Nogal Californiano");
            lstNogales.get(2).setName("Nogal Asiático");
            lstNogales.get(3).setName("Nogal Continental");

        }
        for (int i = 0; i < NUMERO_NOGALES; i++) {
            lstNogales.get(i).start();
        }
        //INSTANCIAMOS PRODUCTORES
        List<Cascanueces> lstCascanueces = new ArrayList<>();
        for (int i = 0; i < NUMERO_CASCANUECES; i++) {
            lstCascanueces.add(new Cascanueces(cesta));
            lstCascanueces.get(i).setName("Cascanueces " + (i + 1));
            // lstCascanueces.get(i).setDaemon(true);
            lstCascanueces.get(i).start();
        }
        //ESPERAMOS A QUE FINALICEN
        for (int i = 0; i < NUMERO_NOGALES; i++) {
            while (lstNogales.get(i).isAlive()) {
                Thread.sleep(10);
            }
        }
        //ESPERAMOS A QUE SE VACÍE LA CESTA
        while (cesta.getCount() != 0) {
            Thread.sleep(10);
        }
        //INTERRUMPIMOS A LOS CASCANUECES
        for (int i = 0; i < NUMERO_CASCANUECES; i++) {
            lstCascanueces.get(i).interrupt();
        }
//ECO FIN MAIN
        System.out.println(Thread.currentThread().getName() + " FIN");
    }

}
