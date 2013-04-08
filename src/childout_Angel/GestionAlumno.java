/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package childout_Angel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class GestionAlumno {
        
    Statement stmt =null;
    ResultSet rsLista = null;
    ArrayList<Alumno> resultadoAlumno = new ArrayList();
    int autoincrementoID = -1;
    
    
    
   
   
   private ArrayList<Alumno> findByNombre(String nombre){
       
       Conexion.conectar("127.0.0.1","root","");
       
       String sql = "SELECT *"
                        + "FROM alumno "
                            + "where(nombre like %"+nombre+"%)";
        
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
   
   private ArrayList<Alumno> findByGrupo(String grupo){
       
       Conexion.conectar("127.0.0.1","root","");
       
       String sql = "SELECT *"
                        + "FROM alumno "
                            + "where(grupo like %"+grupo+"%)";
        
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
   private int insert(Alumno alumno) {

        Conexion.conectar("127.0.0.1","root","");
        
        int id_alumno = alumno.id_alumno;
        String nombre =alumno.nombre;
        String grupo =alumno.grupo;
        
        
        String sql = "INSERT INTO equipos (nombre,grupo) VALUES "
                + "('"+nombre+"','"+grupo+"')";
        
        try {
                 stmt.executeUpdate(sql);
                 
                // Nos devuelve el ultimo ID insertado. 
                ResultSet resulset = stmt.getGeneratedKeys();
 
                if (resulset.next()) {
                // al llamar el método getGeneratedKeys(); devuelve una tabla con una sola columna, solo vamos a usar la columna con índice 1 de tipo int
                autoincrementoID= resulset.getInt(1);
                } else {
                    System.out.print("Error al Sacar el Id del Alumno");
                     
                // agregar una excepcion acá
                }

        }catch (Exception e) {
            System.out.print("Error");
            System.out.print(sql);
            e.printStackTrace();
        }
        return autoincrementoID;
 
    }
   
   

}


