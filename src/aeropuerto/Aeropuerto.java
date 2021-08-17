/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aeropuerto;

import controladores.ControladorAvion;
import controladores.ControladorHangar;
import controladores.ControladorHangarAvion;
import controladores.ControladorPropietario;
import java.util.Scanner;
import modelos.Avion;
import modelos.Hangar;
import modelos.Propietario;
import vistas.VistaAvion;
import vistas.VistaPropietario;

/**
 *
 * @author RT
 */
public class Aeropuerto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("**************************************************");
            System.out.println ("**** 1.Consultar información del hangar");        
            System.out.println("**** 2.Registrar un propietario");
            System.out.println("**** 3.Registrar un avion y matricularlo en un Hangar");            
            System.out.println("**** 4.Salir");
            System.out.println("**************************************************");
            System.out.print("Por favor digite la opcion deseada: ");
            opcion = entrada.nextInt();
            
            if(opcion==1){
                ControladorHangar controladorHangar = new ControladorHangar();
                Hangar hangar = controladorHangar.consultarInformacionHangar();
                continue;
                
                
            }else{
                ControladorHangar controladorHangar = new ControladorHangar();
                Hangar hangar = controladorHangar.consultarInformacionHangar();
                if (hangar.getCuposDisponibles() > 0) {
                     switch (opcion){                         
                        case 2:
                            //2. Registro en BD el propietario
                            VistaPropietario vistaPropietario = new VistaPropietario();
                            Propietario propietario = vistaPropietario.activarVista();
                            ControladorPropietario controladorPropietario = new ControladorPropietario();
                            controladorPropietario.registrarPropietario(propietario);
                            break;
                        case 3:
                            //3. Registro en BD el avion
                            VistaAvion vistaAvion = new VistaAvion();
                            Avion avion = vistaAvion.activarVista();
                            ControladorAvion controladorAvion = new ControladorAvion();
                            controladorAvion.registrarAvion(avion);
                            
                            //4. Matricular en BD (hangares-aviones) el avion en el hangar
                            ControladorHangarAvion controladorHangarAvion = new ControladorHangarAvion();
                            controladorHangarAvion.matricularAvionEnHangar(avion.getMatricula());
                            
                            //5. Actualizar los cupos dispoibles y reservados en la BD (TABLA HANGAR)
                            controladorHangar.actualizarHangar(hangar);
                            break;
                            
                         
                        case 4:
                             System.exit(0);
                             break;
                    }
                }else{
                    System.out.println("No tenemos cupos disponibles");
                }
 
            }
  
        } while (opcion != 4);
 
    }

}
