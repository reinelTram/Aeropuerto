/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author RT
 */
public class ConsultasPropietario extends BaseDatos {
    private PreparedStatement sentenciaSQL;
    
    public void insertarPropietario(Propietario propietario){
        //1. Establecer conexion con la BD
        Connection conexion=conectarBD();
        
        String consulta="INSERT INTO propietarios(cedula_propietario, nombre_propietario, apellido_propietario, codigo_metodo_pago) VALUES (?,?,?,?)";
        //2. INTENTO LLEVAR DATOS 
        try{
            //3. Asociar el PS a la conexión
            sentenciaSQL=conexion.prepareStatement(consulta);
            
            //4. Diferenciar la consulta (Personalizar)            
            sentenciaSQL.setString(1,propietario.getCedula());        
            sentenciaSQL.setString(2,propietario.getNombre());
            sentenciaSQL.setString(3,propietario.getApellido());
            sentenciaSQL.setInt(4,propietario.getMetodoPago()); 
            
            //5. Ejecutar la consulta
            int resultado=sentenciaSQL.executeUpdate();
            
            //6. Validar el resultado
            if(resultado>0){
                System.out.println("Exito registrando el propietario");
            }else{
                System.out.println("Error al agregar el registro");
            }
        }catch(Exception error){
            System.out.println("No se puede registrar el propietario "+error);
        }finally{
            try{
                conexion.close();
            }catch(Exception error){
                System.out.println("error: "+error);                
            }
        }
    }
    
}

