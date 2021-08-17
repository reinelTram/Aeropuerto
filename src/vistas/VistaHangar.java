/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import modelos.Hangar;

/**
 *
 * @author RT
 */
public class VistaHangar {
    public void activarVista(Hangar hangar){
        System.out.println("***************");
        System.out.println("LOS DATOS DEL HANGAR ");
        System.out.println("");
        
        System.out.println("Cupos Totales del hangar: "+hangar.getCuposTotatales());
        System.out.println("");
        System.out.println("Cupos Disponibles: "+hangar.getCuposDisponibles());
        System.out.println("");
        System.out.println("Cupos reservados: "+hangar.getCuposReservados());
    }
}
