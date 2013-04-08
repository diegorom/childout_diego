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
    
    boolean delete(int idRelaccion){
        try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (Exception e) {
                System.out.println("Error Driver MySQL");
                e.printStackTrace();
                return false;
            }
            Connection conexion = null;

            try {
                conexion = DriverManager.getConnection(
                        "jdbc:mysql://sergio/childout",
                        "usuario", "usuario");
            } catch (Exception e) {
                System.out.println("Error al conectarse a la base de datos");
                return false;
            }
            
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(("DELETE * FROM relacion WHERE Id_relaccion=")+idRelaccion);
        } catch (SQLException ex) {
            Logger.getLogger(GestionRelacion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al consultar la base de datos");
            return false;
        }
        return true;
    }   
    
    boolean update(int idRelaccion){
        try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (Exception e) {
                System.out.println("Error Driver MySQL");
                e.printStackTrace();
                return false;
            }
            Connection conexion = null;

            try {
                conexion = DriverManager.getConnection(
                        "jdbc:mysql://sergio/childout",
                        "usuario", "usuario");
            } catch (Exception e) {
                System.out.println("Error al conectarse a la base de datos");
                return false;
            }
            
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(("DELETE * FROM relacion WHERE Id_relaccion=")+idRelaccion);
        } catch (SQLException ex) {
            Logger.getLogger(GestionRelacion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al consultar la base de datos");
            return false;
        }
        return true;
    }   
}
/*
        *boolean delete(Relacion relacion) - Diego
        *boolean update(Relacion relacion) - Diego
        */