/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author RT
 */
public class ConsultasHangar extends BaseDatos {
    private PreparedStatement sentenciaSQL;
    private ResultSet resultadoConsulta;
    
    public Hangar BuscarHangar(){
        //0. Crear objeto de tipo Hangar
        Hangar hangar=new Hangar();
        
        //1. Establecer conexion con la BD
        Connection conexion=conectarBD();
        
        //2. Definir el String con la consulta SQL
        String consulta="SELECT * from hangares";
        
        //3.Intentar hacer lo que estoy programando
        
        try{
            //4. Decirle a BD que se prepare con la consulta
            sentenciaSQL=conexion.prepareStatement(consulta);
            
            //5. Ejecutar la consulta
            resultadoConsulta=sentenciaSQL.executeQuery();
            
            //6.Depure los datos que llegan 
            if(resultadoConsulta.next()){
                hangar.setCodigoHangar(resultadoConsulta.getString("codigo_hangar"));
                hangar.setCuposTotatales(resultadoConsulta.getInt("cupos_totales_hangar"));
                hangar.setCuposDisponibles(resultadoConsulta.getInt("cupos_disponibles_hangar"));
                hangar.setCuposReservados(resultadoConsulta.getInt("cupos_reservados_hangar"));
                
                return hangar;
            }else{
                return null;
            }
        }catch(Exception error){
            System.out.println("Error consultando registro: "+ error);
            return null;
        }finally{
            try{
                conexion.close();
            }catch(Exception error){
                System.out.println("error: "+error);
                
                
            }
            
        }
        
    }
   
    public void actualizarHangar(Hangar hangar){
        //1. Establecer conexion con la BD
        Connection conexion=conectarBD();
        
        //2.Definir el String con la consulta SQL
        String consulta="UPDATE hangares SET cupos_disponibles_hangar=?, cupos_reservados_hangar=? WHERE codigo_hangar='160'";
        
        try{
            //3. Asociar el PS a la conexión
            sentenciaSQL=conexion.prepareStatement(consulta);
            
            //4. Diferenciar la consulta (Personalizar)            
            sentenciaSQL.setInt(1,hangar.getCuposDisponibles());
            sentenciaSQL.setInt(2,hangar.getCuposReservados());
             
            
            //5. Ejecutar la consulta
            int resultado=sentenciaSQL.executeUpdate();
            
            //6. Validar el resultado
            if(resultado>0){
                System.out.println("Exito Actualizando el Hangar");
            }else{
                System.out.println("Error al agregar la actualización del Hangar");
            }
        }catch(Exception error){
            System.out.println("No se puede registrar el Hangar "+error);
        }finally{
            try{
                conexion.close();
            }catch(Exception error){
                System.out.println("error: "+error);                
            }
        }
    }
        
    
}
