/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author RT
 */
public class Hangar {
    private String codigoHangar ;
    private int cuposTotatales;
    private int cuposDisponibles;
    private int cuposReservados;

    public String getCodigoHangar() {
        return codigoHangar;
    }

    public void setCodigoHangar(String codigoHangar) {
        this.codigoHangar = codigoHangar;
    }

    public int getCuposTotatales() {
        return cuposTotatales;
    }

    public void setCuposTotatales(int cuposTotatales) {
        this.cuposTotatales = cuposTotatales;
    }

    public int getCuposDisponibles() {
        return cuposDisponibles;
    }

    public void setCuposDisponibles(int cuposDisponibles) {
        this.cuposDisponibles = cuposDisponibles;
    }

    public int getCuposReservados() {
        return cuposReservados;
    }

    public void setCuposReservados(int cuposReservados) {
        this.cuposReservados = cuposReservados;
    }
   
    
}
