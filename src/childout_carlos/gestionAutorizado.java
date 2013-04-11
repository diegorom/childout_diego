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
        stmt.executeUpdate(sql);
        
    } catch (SQLException ex) {
            System.out.println("Autorizado no encontrado");
            ex.printStackTrace();
            return false;

        }
     return true;
    }
  
    private Autorizado get (int id){
      Autorizado autorizado= null;
      
        try{
            String sql = "Select * From autorizado where =" + id;
            Statement stmt = Conexion.conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            String correo = rs.getString("correo");
            String telefono = rs.getString("telefono");
            String dni = rs.getString("dni");
            Blob firma = rs.getBlob("firma");
            Blob foto = rs.getBlob("firma");
            String parentesco = rs.getString("parentesco");
            Blob huella = rs.getBlob("huella");
            autorizado = new Autorizado(id,  nombre,  correo,  telefono,  dni,  foto,  firma,  parentesco,  huella);
        }catch (SQLException ex) {
            System.out.println("Error al encontrar al autorizado");
            ex.printStackTrace();
        }   
    return autorizado;
    }
    
    private boolean Update (Autorizado autorizado) {
      
       try {
        String sql = "Update autorizado set "+autorizado.getId()+ autorizado.getDni() + autorizado.getNombre() + autorizado.getParentesco() + autorizado.getTelefono();
        Statement stmt = Conexion.conexion.createStatement();
        stmt.executeUpdate(sql);
        
       } catch (SQLException ex) {
            System.out.println("Autorizado no encontrado");
            ex.printStackTrace();
            return false;

        }
     return true;
    } 
    
}
    

