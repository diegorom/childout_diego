/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package childout_sergio;

import childout_Diego.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DAW
 */
public class GestionSalida {

    ArrayList<String> findByGrupo(String grupo) {
        ArrayList<String> alumnosgrupo = new ArrayList();
        try {
                      
            Statement sentenciaSQL = Conexion.conexion();


            ResultSet resultados = sentenciaSQL.executeQuery("select id_alumno, nombre from alumno where grupo = \"1ESO-A\"");

            while (resultados.next()) {            
                String nombre = resultados.getString("nombre");            
                alumnosgrupo.add(nombre);
        
            }
    
            
        } catch (SQLException ex) {
            System.out.println("Error - Ejecucion sentencia SQL");
        }
        return alumnosgrupo;
    }
}
