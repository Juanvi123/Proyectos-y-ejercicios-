/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafeteria;

import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanv
 */
public class Camareras extends Thread {

    //CONSTANTES
    private static final int N_MIN_BOCATAS = 5;
    private static final int N_MAX_BOCATAS = 50;
    private static final int TIEMPO_MIN = 300;
    private static final int TIEMPO_MAX = 500;

    //INSTANCIAMOS RC
    RC_Bandeja bandeja;

    //CAMPOS BOCADILLOS
    private String nombreBocadillo[] = {"jamón", "bacon", "salchichas"};
    private double precio[] = {1.50, 1.00, 0.80};

    //ALEATORIOS
    private int aleBocadillos;
    private int aleNumBocatas;

    //CONTADOR DE BOCADILLOS
    private int contBocadillos;

    //LIST DE CONSUMIDORES
    private List<Clientes> lstClientes;

    //RECAUDACION PARTICULAR
    private double recaudacion;

    //CONSTRUCTOR
    public Camareras(RC_Bandeja bandeja, List<Clientes> lstClientes) {
        this.bandeja = bandeja;
        this.lstClientes = lstClientes;
        this.aleBocadillos = 0;
        this.aleNumBocatas = new Random().nextInt((N_MAX_BOCATAS - N_MIN_BOCATAS) + 1) + N_MIN_BOCATAS;
        this.contBocadillos = 0;
        this.recaudacion = 0.0;
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        try {
            //INICIALIZAMOS EL Nº DE BOCATAS INICIALES QUE HARÁ EL CAMARERO
            System.out.println(getName() + " hará " + aleNumBocatas + " bocadillos");
            //BUCLE PARA EL LLENADO INICIAL
            while (contBocadillos < aleNumBocatas) {
                //TIEMPO ENTRE BOCATA Y BOCATA
                this.sleep(new Random().nextInt((TIEMPO_MAX - TIEMPO_MIN) + 1) + TIEMPO_MIN);
                //INICIALIZAMOS LOS CAMPOS DEL BOCADILLO
                aleBocadillos = new Random().nextInt(nombreBocadillo.length);
                //CREAMOS EL BOCADILLO
                Bocadillos bocadillo = new Bocadillos(nombreBocadillo[aleBocadillos], precio[aleBocadillos]);
                //INCREMENTAMOS EL CONTADOR DE BOCADILLOS
                contBocadillos++;
                //APUNTAMOS LO QUE VALE
                recaudacion += bocadillo.getPrecio();
                //METEMOS BOCATA EN RC
                bandeja.addBocata(bocadillo);
            }
            //ABRIMOS TIENDA
            System.err.println("SE ABRE LA TIENDA, ENTRAN "+lstClientes.size()+" clientes");
            bandeja.marcarTiendaAbierta();
            
            //MIENTRAS EL Nº DE CLIENTES SEA MAYOR QUE EL Nº DE BOCATAS HECHOS
            while (lstClientes.size() > contBocadillos) {
                //TIEMPO ENTRE BOCATA Y BOCATA
                this.sleep(new Random().nextInt((TIEMPO_MAX - TIEMPO_MIN) + 1) + TIEMPO_MIN);
                //INICIALIZAMOS LOS CAMPOS DEL BOCADILLO
                aleBocadillos = new Random().nextInt(nombreBocadillo.length);
                //CREAMOS EL BOCADILLO
                Bocadillos bocadillo = new Bocadillos(nombreBocadillo[aleBocadillos], precio[aleBocadillos]);
                //INCREMENTAMOS EL CONTADOR DE BOCADILLOS
                contBocadillos++;
                //APUNTAMOS LO QUE VALE
                recaudacion += bocadillo.getPrecio();
                //METEMOS BOCATA EN RC
                bandeja.addBocata(bocadillo);
            }
            //ECO FINAL
            this.sleep(500);
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Camareras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //GETTERS

    public double getRecaudacion() {
        return recaudacion;
    }
    

}
