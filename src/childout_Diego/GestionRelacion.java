/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package childout_Diego;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */

public class GestionRelacion {
    
    Relacion relacion;
    boolean delete(Relacion relacion){
        this.relacion=relacion;
        try {
            Statement stmt = Conexion.conexion.createStatement();
            int rs = stmt.executeUpdate(("DELETE FROM relacion WHERE Id_relaccion=")+relacion.getIdRelaccion());
        } catch (SQLException ex) {
            Logger.getLogger(GestionRelacion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al consultar la base de datos");
            return false;
        }
        return true;
    }   
    
    boolean update(Relacion relacion){
        this.relacion=relacion;
        try {
            Statement stmt = Conexion.conexion.createStatement();
            int rs = stmt.executeUpdate(("UPDATE  relacion SET id_alumno="+relacion.getIdAlumno()+", id_autorizado="+relacion.getIdAutorizado()+"WHERE Id_relaccion=")+relacion.getIdRelaccion());
        } catch (SQLException ex) {
            Logger.getLogger(GestionRelacion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al consultar la base de datos");
            return false;
        }
        return true;
    }   
}