/*
 CREAR 4 PROCESOS, UNO PARA ABRIR UN NOTEPAD Y ESCRIBIR 3 URLS Y OTROS 3 PARA ABRIR CADA URL EN 
UN NAVEGADOR DIFERENTE, CADA NAVEGADOR SOLAMENTE SE ABRIRÁ SI EL ANTERIOR HA SIDO CERRADO
 */
package arrancar_urls_varios_navegadores;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author juanv
 */
public class Arrancar_URLS_Varios_Navegadores {

    public static void main(String[] args) throws IOException, InterruptedException {
        arrancarURLS("urls.txt");
    }

    public static void arrancarURLS(String direccion) throws IOException, InterruptedException {

        //CREAR PROCESO ARRANCAR NOTEPAD
        Process pNotePad = Runtime.getRuntime().exec("notepad.exe");
        //ESPERAMOS HASTA QUE EL USUARIO LO CIERRE
        pNotePad.waitFor();
        //CREAMOS PROCESO PARA ARRANCAR NAVEGADOR
        Process pChrome = null;
        Process pFirefox = null;
        Process pExplorer = null;
        //CREAMOS UNA VARIABLE DONDE ALOJAR CADA URL
        List<String> lstTexto = new ArrayList<>();
        String texto = "";
        //EXTRAER LAS URL ESCRITAS
        BufferedReader teclado = new BufferedReader(new FileReader(direccion));
        while ((texto = teclado.readLine()) != null) {
            lstTexto.add(texto);
            System.out.println(texto);
        }
        //ABRIMOS CADA URL EN UN NAVEGADOR DIFERENTE
        pChrome = Runtime.getRuntime().exec("C:\\Program Files\\Google\\Chrome\\Application\\"
                + "chrome.exe" + " " + lstTexto.get(0));
        //ESPERAMOS HASTA QUE SE CIERRE EL NAVEGADOR
        pChrome.waitFor(5,TimeUnit.SECONDS);
        pChrome.destroy();
        pFirefox = Runtime.getRuntime().exec("C:\\Program Files\\Mozilla Firefox\\"
                + "firefox.exe" + " " + lstTexto.get(1));
        //ESPERAMOS HASTA QUE SE CIERRE EL NAVEGADOR
        pFirefox.waitFor(20,TimeUnit.SECONDS);
        pFirefox.destroy();
        pFirefox.destroyForcibly();
        pExplorer = Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe"
                + " " + lstTexto.get(2));
        //ESPERAMOS HASTA QUE SE CIERRE EL NAVEGADOR
        pExplorer.waitFor(50,TimeUnit.SECONDS);
        pExplorer.destroyForcibly();
        //ABRIR TXT
        Desktop dt=Desktop.getDesktop();
        //dt.open(path) si no hay path x q el fichero está en el mismo directorio que el equipo
        //hacemos esto
        dt.open(new File("urls.txt"));
    }
}
