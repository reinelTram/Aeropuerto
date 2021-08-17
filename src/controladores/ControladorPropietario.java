/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import modelos.ConsultasPropietario;
import modelos.Propietario;

/**
 *
 * @author RT
 */
public class ControladorPropietario {
    private ConsultasPropietario modelo=new ConsultasPropietario();
    
    public void registrarPropietario(Propietario propietario){
        //Validaciones
        modelo.insertarPropietario(propietario);
        
    }
    
}
