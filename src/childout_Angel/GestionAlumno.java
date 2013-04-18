/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package childout_Angel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GestionAlumno {
        
    Statement stmt;
    ResultSet rsLista = null;
    ArrayList<Alumno> resultadoAlumno = new ArrayList();
    int autoincrementoID = -1;
    
    
    
   
   
   public ArrayList<Alumno> findByNombre(String nombre){
       
       
       
        try {
            stmt = Conexion.conexion.createStatement();
        } catch (SQLException ex) {
            System.out.print("Error en el statement");
            
        }
       
       String sql = "SELECT *"
                        + "FROM alumno "
                            + "where(nombre like '%"+nombre+"%')";
        
        try {
                
                rsLista = stmt.executeQuery(sql);
                  while (rsLista.next()) 
                   {
                        int id_alumno = rsLista.getInt("id_alumno");
                        nombre = rsLista.getString("nombre");
                        String grupo = rsLista.getString("grupo");
                        
                        Alumno alumno = new Alumno (id_alumno,nombre,grupo);
                        resultadoAlumno.add(alumno);
                    }
   

        }catch (Exception e) {
            System.out.print("Error");
            System.out.print(sql);
            e.printStackTrace();
        }
        
        
       return resultadoAlumno;
   }
   
   public ArrayList<Alumno> findByGrupo(String grupo){
       
    
        try {
            stmt = Conexion.conexion.createStatement();
        } catch (SQLException ex) {
            System.out.print("Error en el statement");
            
        }
        
       
       String sql = "SELECT *"
                        + "FROM alumno "
                            + "where(grupo like '%"+grupo+"%')";
        
        try {
                
                rsLista = stmt.executeQuery(sql);
                  while (rsLista.next()) 
                   {
                        int id_alumno = rsLista.getInt("id_alumno");
                        String nombre = rsLista.getString("nombre");
                        grupo = rsLista.getString("grupo");
                        
                        Alumno alumno = new Alumno (id_alumno,nombre,grupo);
                        resultadoAlumno.add(alumno);
                    }
   

        }catch (Exception e) {
            System.out.print("Error");
            System.out.print(sql);
            e.printStackTrace();
        }
       return resultadoAlumno;
   }
   
   /* hay que modificar la salida de este metodo*/
   public int insert(Alumno alumno) {

         try {
            stmt = Conexion.conexion.createStatement();
        } catch (SQLException ex) {
            System.out.print("Error en el statement");
            
        }
        
        
        String nombre =alumno.nombre;
        String grupo =alumno.grupo;
        
        
        String sql = "INSERT INTO alumno (nombre,grupo) VALUES "
                + "('"+nombre+"','"+grupo+"')";
        
        try {
                 stmt.executeUpdate(sql);

        }catch (Exception e) {
            System.out.print("Error");
            System.out.print(sql);
            e.printStackTrace();
        }
        
        
        
             sql = "SELECT DISTINCT LAST_INSERT_ID() FROM alumno ";
        
        try {
                 rsLista=stmt.executeQuery(sql);
                 if (rsLista.next()) 
                 {
               // al llamar el método getGeneratedKeys(); devuelve una tabla con una sola columna, solo vamos a usar la columna con índice 1 de tipo int
               autoincrementoID= rsLista.getInt(1);
               } else 
                 {
                   System.out.print("Error al Sacar el Id del Alumno");
                 } 
                 
                 
        }catch (Exception e) {
            System.out.print("Error");
            System.out.print(sql);
            e.printStackTrace();
        }
        
        
        
        return autoincrementoID;
 
    }
   
   

}


