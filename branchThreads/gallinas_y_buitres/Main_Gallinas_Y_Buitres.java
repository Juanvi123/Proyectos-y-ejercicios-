/*
Gallinas , pulardas, hurracas y buitres
Los huevos contienen un número y una  string , cuando se ponen hay que
dar valor a ambos. La string  guardará el nombre del animal que lo ha
puesto y el número es el peso del huevo .

La huevera contiene hasta 12 huevos.

La gallina pone un huevo, lo coloca en la huevera  y espera un poco 
hasta poner otro huevo y colocarlo.  Si la huevera está llena esperará. 
l peso del huevo de gallina varía entre 25 y 75 gramos. Entre huevo y 
huevo las gallinas esperan  un ratito.

Las pulardas ponen huevos igual que las gallinas . El huevo de pularda
es más grande y el peso oscila entre 80 y 120 gramos. Entre huevo
y huevo las pulardas esperan un ratito el doble de largo que las 
gallinas.

Los buitres cogerán un huevo, si hay ; sino esperarán . El huevo 
cogido será  roto y en una string concatenerá el nombre del animal
que lo ha puesto  y en un número sumará el peso del huevo ,
acumulando el peso de todos los huevos comidos. Cuando el buitre 
haya comido más de 200 gramos de huevo , levanta el vuelo y se marcha ; 
haciendo eco de la string de animales y del peso de huevos comidos. 
Entre huevo y huevo , el bruitre descansa un poquito.

La hurraca actúa igual que el buitre, salvo que cuando coge un huevo 
se marcha.El buitre es un animal que no se marcha  hasta que llega el 
granjero y le manda un aviso o bien come 200 gramos de huevo.

El granjero es un poco despistado,  echa una siesta y acude al
gallinero , si hay buitres y hurracas los echa   y las gallinas y
pulardas las mete en el corral ( finalizan la ejecución con la 
ejecución del granjero )

En la granja hay un granjero , 5 pulardas, 10 gallinas, 2 buitres y 3 
hurracas.

 */
package gallinas_y_buitres;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juanv
 */
public class Main_Gallinas_Y_Buitres {

    //CONSTANTES
    private static final int NUMERO_PULARDAS = 5;
    private static final int NUMERO_GALLINAS = 10;
    private static final int NUMERO_BUITRES = 2;
    private static final int NUMERO_HURRACAS = 3;
    private static final int TIEMPO_SIESTA_GRANJERO=7000;

    public static void main(String[] args) throws InterruptedException {

        //INSTANCIAMOS RC
        RC_Huevera huevera = new RC_Huevera();
        //INSTANCIAMOS PRODCUTORES
        List<Gallinas> lstGallinas = new ArrayList<>();
        for (int i = 0; i < NUMERO_GALLINAS; i++) {
            lstGallinas.add(new Gallinas(huevera));
            lstGallinas.get(i).setName("Gallina " + (i + 1));
            lstGallinas.get(i).start();
        }
        List<Pulardas> lstPulardas = new ArrayList<>();
        for (int i = 0; i < NUMERO_PULARDAS; i++) {
            lstPulardas.add(new Pulardas(huevera));
            lstPulardas.get(i).setName("Pularda " + (i + 1));
            lstPulardas.get(i).start();
        }
        //INSTANCIAMOS PRODUCTORES
        List<Buitres> lstBuitres = new ArrayList<>();
        for (int i = 0; i < NUMERO_BUITRES; i++) {
            lstBuitres.add(new Buitres(huevera));
            lstBuitres.get(i).setName("Buitres " + (i + 1));
            lstBuitres.get(i).start();
        }
        List<Hurracas>lstHurracas=new ArrayList<>();
        for(int i=0;i<NUMERO_HURRACAS;i++){
            lstHurracas.add(new Hurracas(huevera));
            lstHurracas.get(i).setName("Hurraca "+(i+1));
            lstHurracas.get(i).start();
        }
        //TIEMPO HASTA QUE GRANJERO DESPIERTA
        Thread.sleep(TIEMPO_SIESTA_GRANJERO);
        //CREAMOS GRANJERO Y LO ARRANCAMOS
        Granjero granjero=new Granjero(huevera);
        granjero.setName("Granjero");
        granjero.start();
    }
}
