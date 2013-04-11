/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package childout_jeronimo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author DAW
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       System.out.print("1--");
       
       Connection conexion = null;
       GestionRelacion gestRela = new GestionRelacion();
       Relacion rela = new Relacion(2,2,2);
       
       System.out.print("2--");
        try {
            Conexion.conectar("localhost","root","");
            gestRela.insert(rela);
       
       System.out.print("3--");     

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
    
