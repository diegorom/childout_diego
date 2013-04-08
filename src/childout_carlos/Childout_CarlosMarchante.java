package childout_carlos;


import java.beans.Statement;
import java.sql.SQLException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Susana
 */
public class Childout_CarlosMarchante {

    public boolean get(int id_autorizado) {

        String sql = "Delete * From alumnos where  id_autorizado=" + id_autorizado;
        Statement stmt = Conexion.conexion.createStatement();
        try {
            stmt = Conexion.conexioncreateStatement();

        } catch (SQLException ex) {
            System.out.println("Autorizado no encontrado");
            System.out.println(sql);

        }
        return true;

    }
    public
    
}
