/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.util.Scanner;
import modelos.Propietario;

/**
 *
 * @author RT
 */
public class VistaPropietario {
    public Propietario activarVista(){
        Scanner entrada =new Scanner(System.in);
        Propietario propietario= new Propietario();
        
        System.out.println("Bienvenido hangar 160");
        
        System.out.print("Digite la cedula del propietario: ");
        propietario.setCedula(entrada.next());
        
        
        System.out.print("Digite el nombre del propietario: ");
        propietario.setNombre(entrada.next());
        
        
        System.out.print("Digite el apellido del propietario: ");
        propietario.setApellido(entrada.next());
        
        
        System.out.print("Digite el metodo de pago (1 o 2): ");
        propietario.setMetodoPago(entrada.nextInt());
        
        return propietario;
        
    }
}
