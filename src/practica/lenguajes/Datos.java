/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practica.lenguajes;

/**
 *
 * @author HUGO
 */
public class Datos {
    private int carne;
    private String nombre;
    private String semestre;
    Datos siguiente;
    

    /**
     * @return the carne
     */
    public int getCarne() {
        return carne;
    }

    /**
     * @param carne the carne to set
     */
    public void setCarne(int carne) {
        this.carne = carne;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the semestre
     */
    public String getSemestre() {
        return semestre;
    }

    /**
     * @param semestre the semestre to set
     */
    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
    
}
