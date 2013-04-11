/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package childout_jeronimo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author DAW
 */
public class GestionRelacion {
    
    ArrayList<Alumno> findByAutorizado(int id_autorizado) {
        ArrayList<Alumno> alumnos = new ArrayList();
        try { 
            
            Statement sentenciaSQL = Conexion.conexion.createStatement();
            ResultSet resultados = sentenciaSQL.executeQuery("SELECT * FROM alumno NATURAL JOIN relacion WHERE Id_autorizado = "+ id_autorizado);
            
            while (resultados.next()) { 
                Alumno alumno = new Alumno(resultados.getInt("Id_Alumno"), resultados.getString("nombre"), resultados.getString("grupo"));
                alumnos.add(alumno);
                
                           
                        
            }
                
        } catch (SQLException ex) {
            System.out.println("error");
        }
        return alumnos;
    }
    
    
    
    
 
    int insert(Relacion relacion) {
        try { 
            
            Statement sentenciaSQL = Conexion.conexion.createStatement();
            ResultSet resultados = sentenciaSQL.executeQuery("INSERT relacion(Id_Alumno,Id_Autorizado) VALUES  ("+ Relacion.IdAlumno +","+Relacion.IdAutorizado+")");
            // otro problema es insertar una nueva relacion sobre una consulta de la
            // que tengo un JOIN
            
                
        } catch (SQLException ex) {
            System.out.println("error");
        }
        return 0;
        //executeUpdate
    }
}
