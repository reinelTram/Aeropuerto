/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author RT
 */
public class ConsultasHangaresAviones extends BaseDatos {
    private PreparedStatement sentenciaSQL;
    private PreparedStatement sentenciaSQL2;
    private ResultSet resultadoConsulta;     
         

    
    public void insertarAvionHangar(String matriculaAvion){
        //0 obtner fecha y hora
        Date date =new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaActual=format.format(date);
        int contadorCeldas=0;     
         
        //1. Establecer conexion con BD
        Connection conexion=conectarBD();
        
        //2. preparop el query
        String consulta="INSERT INTO hangares_aviones(codigo_hangar, matricula_avion, fecha_ingreso, numero_celda) VALUES (?,?,?,?)";
        String consulta2="SELECT numero_celda from hangares_aviones";
        //3. Intentar ejecutar la consulta
         try{
            //3. Asociar el PS a la conexión
            sentenciaSQL=conexion.prepareStatement(consulta);
            sentenciaSQL2=conexion.prepareStatement(consulta2);
            
            //5. Ejecutar la consulta
            resultadoConsulta=sentenciaSQL2.executeQuery();
            while (resultadoConsulta.next()){
                contadorCeldas+=1;
            }
            contadorCeldas+=1;
            
            
            //4. Diferenciar la consulta (Personalizar)            
            sentenciaSQL.setString(1,"160");        
            sentenciaSQL.setString(2,matriculaAvion);
            sentenciaSQL.setString(3,fechaActual);           
            sentenciaSQL.setInt(4,contadorCeldas);             
  
            //5. Ejecutar la consulta
            int resultado=sentenciaSQL.executeUpdate();
            
            //6. Validar el resultado
            if(resultado>0){
                System.out.println("El Avion ha sido matriculado al Hangar en la celda"+contadorCeldas);
            }else{
                System.out.println("Error al Matricular el avión en el Hangar");
            }
        }catch(Exception error){
            System.out.println("No se puede registrar el avion en el Hangar "+error);
        }finally{
            try{
                conexion.close();
            }catch(Exception error){
                System.out.println("error: "+error);                
            }
        }
        
    }
 
}
