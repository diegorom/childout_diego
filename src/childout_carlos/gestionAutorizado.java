package childout_carlos;



import childout_JesusBueno.Autorizado;
import java.sql.Blob;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
    
/**
 *
 * @author Susana
 */
public class gestionAutorizado {
    
  
    
    private boolean delete (Autorizado autorizado) {
    try {
        String sql = "Delete from autorizado where id= "+autorizado.getId();
        Statement stmt = Conexion.conexion.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()) {
            int id = rs.getInt(autorizado.getId());
            return false;
        }

        } catch (SQLException ex) {
            System.out.println("Autorizado no encontrado");
            ex.printStackTrace();
            return false;

        }
     return true;
    }
  
    private Autorizado get (Autorizado autorizado){
      
        try{
            String sql = "Select id From autorizado where "+"id";
            Statement stmt = Conexion.conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            int id = rs.getInt("id");
        }catch (SQLException ex) {
            System.out.println("Error al encontrar al autorizado");
            ex.printStackTrace();
        }   
    return autorizado;
    }
    
    private boolean Update (Autorizado autorizado) {
      
       try {
        String sql = "Update autorizado set "+autorizado.getId();
        Statement stmt = Conexion.conexion.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()) {
            int id = rs.getInt("id");
            return false;
        }

        } catch (SQLException ex) {
            System.out.println("Autorizado no encontrado");
            ex.printStackTrace();
            return false;

        }
     return true;
    } 
    
}
    

