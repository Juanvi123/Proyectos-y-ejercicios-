/*
En Alcalá hay un zampa bombones que no cesa de comer bombones. En un rincón de la rinconada hay una
pequeña bomboneria con dos chefs bomboneros.

Los chefs hacen bombones y los ponen en una bombonera si la bombonera está vacía;  si está llena esperan 
a que la vacíe el zampa bombones. Los chefs hacen un número limitado de bombones (aleatorio entre 0 y 99) ,
si finalizan y la bombonera no está llena la marcan como si estuviera llena para que el zampa bombones la
zampe.

El zampa bombones coge la bombonera llena y la vacía, entonces pueden llenarla los chefs. Esto lo hace 
indefinidamente y tiene una cuenta secreta para contabilizar los bombones zampados aunque no es revelada  
a nadie.

En la bombonera caben doce bombones. Permite meter bombones y sacar bombones. Cada vez que un chef o el 
zampa la usan escriben un mensaje con su nombre, indicando si sacan o meten un bombón. Sólo puede ser 
utilizada por uno, los demás han de esperar a que finalice. Los mensajes han de permitir verificar el uso 
sincronizado de la bombonera.

El bombón ha de tener un número único para identificarlo y un sabor. El  número identificador lo 
proporcionará el chef bombonero y el sabor se tomará aleatoriamente de una lista (fresa, coco, cacao, 
frambuesa) y se guardará en una string. El chef primero identificará desde 100,.... y el chef segundo desde 
200, …

 */
package zampabombones_v1_interrupcion;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juanv
 */
public class Main_Zampabombones_v1 {

    //CONSTANTES
    private static final int IDENTIFICADOR_CHEF_1 = 100;
    private static final int IDENTIFICADOR_CHEF_2 = 200;
    private static final int NUMERO_CHEFS = 2;
    
    public static void main(String[] args) throws InterruptedException {
        //INSTANCIAMOS RC
        RC_Bombonera bombonera = new RC_Bombonera();
        //INSTANCIAMOS PRODUCTORES
        Chefs chef1 = new Chefs(bombonera, IDENTIFICADOR_CHEF_1);
        chef1.setName("Chef1");
        chef1.start();
        
        Chefs chef2 = new Chefs(bombonera, IDENTIFICADOR_CHEF_2);
        chef2.setName("Chef2");
        chef2.start();

        //INSTANCIAMOS CONSUMIDOR
        Zampabombones zampa = new Zampabombones(bombonera);
        zampa.setName("Zampabombones");
        // zampa.setDaemon(true);
        zampa.start();
        
        chef1.join();
        chef2.join();
        
        while (chef1.isAlive() || chef2.isAlive()) {
            Thread.sleep(1000);
        }
        zampa.interrupt();
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + " FIN");
    }
}
