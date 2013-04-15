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
    
  
    
    public boolean delete (Autorizado autorizado) {
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
  
    public Autorizado get (int id){
      
        Autorizado autorizado= null;
      
        try{
            String sql = "Select * From autorizado where id_autorizado = " + id;
            Statement stmt = Conexion.conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            id = rs.getInt("id_autorizado");
            String nombre = rs.getString("nombre");
            String apellidos = rs.getString("apellidos");
            String correo = rs.getString("email");
            String telefono = rs.getString("telefono");
            String dni = rs.getString("dni");
            Blob firma = rs.getBlob("firma");
            Blob foto = rs.getBlob("firma");
            String parentesco = rs.getString("parentesco");
            Blob huella = rs.getBlob("huella");
            Autorizado d = new Autorizado(id,  nombre, apellidos,  correo,  telefono,  dni,  foto,  firma,  parentesco,  huella, true);
        }catch (SQLException ex) {
            System.out.println("Error al encontrar al autorizado");
            ex.printStackTrace();
        }   
    return autorizado;
    }
    
    public boolean Update (Autorizado autorizado) {
      
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
    

