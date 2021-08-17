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
public class ConsultasAvion extends BaseDatos {
    private PreparedStatement sentenciaSQL;
    
    public void insertarAvion(Avion avion){
        //1. Establecer conexion con la BD
        Connection conexion=conectarBD();
        
        String consulta="INSERT INTO aviones (matricula_avion, modelo_avion, cedula_propietario, codigo_contrato) VALUES (?, ?, ?, ?)";
        //2. INTENTO LLEVAR DATOS 
        try{
            //3. Asociar el PS a la conexión
            sentenciaSQL=conexion.prepareStatement(consulta);
            
            //4. Diferenciar la consulta (Personalizar)            
            sentenciaSQL.setString(1,avion.getMatricula());        
            sentenciaSQL.setString(2,avion.getModelo());
            sentenciaSQL.setString(3,avion.getCedulaPropietario());
            sentenciaSQL.setString(4,avion.getCodigoContrato()); 
            
            //5. Ejecutar la consulta
            int resultado=sentenciaSQL.executeUpdate();
            
            //6. Validar el resultado
            if(resultado>0){
                System.out.println("Exito registrando el avion");
            }else{
                System.out.println("Error al agregar el registro de avion");
            }
        }catch(Exception error){
            System.out.println("No se puede registrar el avion "+error);
        }finally{
            try{
                conexion.close();
            }catch(Exception error){
                System.out.println("error: "+error);                
            }
        }
    }
    
}
