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
    private String id;
  
    
    private boolean delete (Autorizado autorizado) {
    try {
        String sql = "Delete * From autorizado where"+id+"=id";
        Statement stmt = Conexion.conexion.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()) {
            int id = rs.getInt(id);
            String nombre = rs.getString("nombre");
            String correo = rs.getString("correo");
            String telefono = rs.getString("telefono");
            String dni =rs.getString("dni");
            Blob firma = rs.getBlob("firma");
            String parentesco = rs.getString("parentesco");
            Blob huella = rs.getBlob ("huella");
            return false;
        }

        } catch (SQLException ex) {
            System.out.println("Autorizado no encontrado");
            ex.printStackTrace();
            return false;

        }
     return true;
    }
  
    private Autorizado get (int id){
      
        try{
            String sql = "Select * From autorizado where"+id+"id";
            Statement stmt = Conexion.conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            int id = rs.getInt(id);
            String nombre = rs.getString("nombre");
            String correo = rs.getString("correo");
            String telefono = rs.getString("telefono");
            String dni =rs.getString("dni");
            Blob firma = rs.getBlob("firma");
            String parentesco = rs.getString("parentesco");
            Blob huella = rs.getBlob ("huella");
            
            Autorizado = new autorizado(int id, String nombre, String correo, String telefono, String dni, Blob foto, Blob firma, String parentesco, Blob huella);
        }catch (SQLException ex) {
            System.out.println("Error al encontrar al autorizado");
            ex.printStackTrace();
        }   
    return Autorizado;
    }
    
    private boolean Update(Autorizado autorizado) {
      
       try {
        String sql = "Update autorizado set"+id;
        Statement stmt = Conexion.conexion.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()) {
            int id = rs.getInt(id);
            String nombre = rs.getString("nombre");
            String correo = rs.getString("correo");
            String telefono = rs.getString("telefono");
            String dni =rs.getString("dni");
            Blob firma = rs.getBlob("firma");
            String parentesco = rs.getString("parentesco");
            Blob huella = rs.getBlob ("huella");
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
    

