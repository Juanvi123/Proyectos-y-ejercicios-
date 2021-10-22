/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafeteria2;

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
    private static final int TIEMPO_MIN = 250;
    private static final int TIEMPO_MAX = 500;
    private static final int N_MIN_BOCATAS = 5;
    private static final int N_MAX_BOCATAS = 50;

    //INSTANCIAMOS RC
    RC_Bandeja bandeja;

    //DEFINIMOS CAMPOS BOCATA
    private String[] nombreBocatas = {"Bocata de Jamón", "Bocata de Bacon", "Bocata de Salchichas"};
    private double[] precioBocatas = {1.50, 1.00, 0.80};
    private int aleBocata;
    private int aleNBocatas;

    //CONTADOR DE BOCATAS
    private int contBocatas;

    //LA LISTA DE CLIENTES
    private List<Clientes> lstClientes;

    //CONSTRUCTOR
    public Camareras(RC_Bandeja bandeja, List<Clientes> lstClientes) {
        this.bandeja = bandeja;
        this.lstClientes = lstClientes;
        this.aleNBocatas = new Random().nextInt((N_MAX_BOCATAS - N_MIN_BOCATAS) + 1) + N_MIN_BOCATAS;
        this.aleBocata = 0;
        this.contBocatas = 0;
    }

    //BLOQUE DE EJECUCIÓN
    @Override
    public void run() {
        try {
            //ECO INICIAL CAMARERA
            System.out.println(getName() + " hace " + aleNBocatas + " bocatas");
            //PRIMER LLENADO
            //MIENTRAS EL Nº DE BOCATAS SEA MAYOR QUE EL Nº DE BOCATAS HECHOS
            while (aleNBocatas > contBocatas) {
                //TIEMPO ENTRE BOCATA Y BOCATA
                this.sleep(new Random().nextInt((TIEMPO_MAX - TIEMPO_MIN) + 1) + TIEMPO_MIN);
                //CREAMOS BOCATA
                aleBocata = new Random().nextInt(nombreBocatas.length);
                Bocatas bocata = new Bocatas(nombreBocatas[aleBocata], precioBocatas[aleBocata]);
                //INCREMENTAMOS EL CONTADOR DE BOCATAS
                contBocatas++;
                //METEMOS BOCATA EN RC
                bandeja.addBocata(bocata);
            }
            //MARCAMOS BANDEJA LLENA 
            bandeja.marcarBandejaLlena();
            //SEGUNDO LLENADO
            //MIENTRAS EL Nº DE CLIENTES SEA SUPERIOR AL Nº DE BOCATAS 
            while (lstClientes.size() > contBocatas) {
                //TIEMPO ENTRE BOCATA Y BOCATA
                this.sleep(new Random().nextInt((TIEMPO_MAX - TIEMPO_MIN) + 1) + TIEMPO_MIN);
                //CREAMOS BOCATA
                aleBocata = new Random().nextInt(nombreBocatas.length);
                Bocatas bocata = new Bocatas(nombreBocatas[aleBocata], precioBocatas[aleBocata]);
                //INCREMENTAMOS EL CONTADOR DE BOCATAS
                contBocatas++;
                //METEMOS BOCATA EN RC
                bandeja.addBocata(bocata);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Camareras.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
