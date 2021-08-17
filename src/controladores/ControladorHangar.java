/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.Scanner;
import modelos.ConsultasHangar;
import modelos.Hangar;
import vistas.VistaHangar;

/**
 *
 * @author RT
 */
public class ControladorHangar {
    //ATRIBUTOS 
   private ConsultasHangar modelo= new ConsultasHangar();
   private VistaHangar vista=new VistaHangar();
    
    //METODOS
    public Hangar consultarInformacionHangar(){
        Hangar hangar=modelo.BuscarHangar();
        Scanner entrada=new Scanner(System.in);
        System.out.print("Desea mirar la informacion actual del Hangar (1: Si, 2:No): ");
        String opcion=(entrada.next()).toLowerCase();
        if (opcion.equals("1")||opcion.equals("si")|| opcion.equals("s")){            
            vista.activarVista(hangar);
            return hangar;     
        }else{
            return hangar;
        }             
    }
    
    public void actualizarHangar(Hangar hangar){
        int cuposDisponiblesAntesMatricula=hangar.getCuposDisponibles();
        int cuposDisponiblesDespuesMatricula=cuposDisponiblesAntesMatricula-1;
        
        int cuposReservadosAntesMatricula=hangar.getCuposReservados();
        int cuposReservadosDespuesMatricula=cuposReservadosAntesMatricula+1;
        
        
        hangar.setCuposDisponibles(cuposDisponiblesDespuesMatricula);
        hangar.setCuposReservados(cuposReservadosDespuesMatricula);
        
        modelo.actualizarHangar(hangar);
        
    }
}
