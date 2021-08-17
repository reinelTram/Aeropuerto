/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.util.Scanner;
import modelos.Avion;

/**
 *
 * @author RT
 */
public class VistaAvion {
      public Avion activarVista(){
        Scanner entrada =new Scanner(System.in);
        Avion avion= new Avion();
        
        System.out.println("Bienvenido hangar 160");
        
        System.out.print("Digite la Matricula del avión: ");
        avion.setMatricula(entrada.next());
        
        
        System.out.print("Digite el el modelo del avión: ");
        avion.setModelo(entrada.next());
        
        
        System.out.print("Digite la cedula del propietario: ");
        avion.setCedulaPropietario(entrada.next());
        
        
        System.out.print("Digite el código del contrato: ");
        avion.setCodigoContrato(entrada.next());
        
        return avion;
        
    }
    
}
