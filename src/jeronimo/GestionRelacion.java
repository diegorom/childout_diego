package jeronimo;


import java.beans.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DAW
 */
public class GestionRelacion {
    

ArrayList findByAutorizado(int id){

    Statement stmt = Conexion.conexion.createStatement();
    ResultSet resultados = stmt.executeQuery("SELECT * FROM childout");
        return null;

    
}
