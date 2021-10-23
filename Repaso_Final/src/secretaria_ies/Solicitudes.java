/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secretaria_ies;

/**
 *
 * @author juanv
 */
public class Solicitudes {
    //DECLARAR VARIABLES

    private String nombreAlumno;
    private int nExp;
    private int nAsignaturas;
    private double tasa;
    private double importeTotal;

    //CONSTRUCTOR

    public Solicitudes(String nombreAlumno, int nExp, int nAsignaturas, double importeTotal) {
        this.nombreAlumno = nombreAlumno;
        this.nExp = nExp;
        this.nAsignaturas = nAsignaturas;
        this.importeTotal = importeTotal;
    }
   

    //GETTERS Y SETTERS
    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public int getnExp() {
        return nExp;
    }

    public void setnExp(int nExp) {
        this.nExp = nExp;
    }

    public double getTasa() {
        return tasa;
    }

    public void setTasa(double tasa) {
        this.tasa = tasa;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public int getnAsignaturas() {
        return nAsignaturas;
    }

    public void setnAsignaturas(int nAsignaturas) {
        this.nAsignaturas = nAsignaturas;
    }
    

}
