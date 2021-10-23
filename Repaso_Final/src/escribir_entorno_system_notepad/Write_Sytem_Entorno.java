/*
 Crear un txt donde meter el entorno de tu equipo y luego ejecutarlo.
Añade también el nombre de tu SO, la versión de java, el directorio donde se encuentra el jre y el
de tu usuario
 */
package escribir_entorno_system_notepad;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import jdk.jfr.events.FileWriteEvent;

/**
 *
 * @author juanv
 */
public class Write_Sytem_Entorno {

    public static void main(String[] args) throws IOException {
        writeSystemEntorno();
    }

    public static void writeSystemEntorno() throws IOException {
        //CREAMOS FICHERO DE SALIDA
        FileWriter file = new FileWriter("Mi_Entorno.txt");
        PrintWriter print = new PrintWriter(file);
        print.println("\tEl Entorno de mi Systema es el siguiente: ");
        //CREAR UN MAP Y METER LAS VARIABLES DE ENTORNO
        Map<String, String> map = System.getenv();
        //RECORREMOS EL MAP 
        for (String key : map.keySet()) {
            String value = map.get(key);
            print.println(key + "-----------------------" + value);
        }
        print.println("\t-------------------------EXTRAS--------------------------");
        String nombreSO=System.getProperty("os.name");
        String versionJava=System.getProperty("java.version");
        String directorioJava=System.getProperty("java.home");
        String directorioUsuario=System.getProperty("user.home");
        print.println("Nombre SO: "+nombreSO);
        print.println("Versión de Java: "+versionJava);
        print.println("Path JRE: "+directorioJava);
        print.println("Path usuario: "+directorioUsuario);
        //LIBERAMOS RECURSOS
        print.close();
        file.close();
        System.out.println("Entorno de mi sistema volcado con éxito");
        //ABRIMOS TXT
        Desktop desktop = Desktop.getDesktop();
        desktop.open(new File("Mi_Entorno.txt"));
        
    }
}
