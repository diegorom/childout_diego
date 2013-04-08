/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package childout_jeronimo;

import childout.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author DAW
 */
public class GestionRelacion {
 ArrayList<Integer> findByAutorizado(int id_autorizado) {
        ArrayList<Integer> autorizados = new ArrayList();
        try { 
            //esto no acabo de entenderlo, tengo que darle parametros a este metodo
            //y cuales son
            Statement sentenciaSQL = Conexion1.conectar();
            ResultSet resultados = sentenciaSQL.executeQuery("SELECT * FROM autorizado WHERE id_autorizado = "+this.id_autorizado);

            while (resultados.next()) {            
                int id = resultados.getInt("id_autorizado");            
                        
            }
                
        } catch (SQLException ex) {
            System.out.println("error");
        }
        return autorizados;
    }
}
