/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package childout_Alejandro;

/**
 *
 * @author DAW
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conexion.conectar("localhost","root","");
        GestionAlumno a = new GestionAlumno();
        
        System.out.println(a.get(1).id_alumno+","+a.get(1).nombre+","+a.get(1).grupo);
    }
}
