/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package childout_JesusBueno;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DAW
 */
public class GestionAutorizado {

    Autorizado findByDNI(String dni) {
        
        String sql = "Select * from alumno where dni = '"+dni+"' ";
        
        
        try {
            Statement sentenciaSQL = conexion.createStatement();
            ResultSet rs = sentenciaSQL.executeQuery(sql);
            
            int id = rs.getInt("id");
            String nombre = rs.getNString("nombre");
            String correo = rs.getNString("correo");
            String telefono = rs.getNString("telefono");            
            Blob foto =rs.getBlob("foto");
            Blob firma =rs.getBlob("firma");
            String parentesco = rs.getNString("parentesco");
            Blob huella =rs.getBlob("huella");
            
            
            
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(GestionAutorizado.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
}
