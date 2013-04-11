package childout_JesusBueno;


import childout_JesusBueno.GestionAutorizado;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DAW
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Conexion.conectar("localhost","root","");
        GestionAutorizado autorizado = new GestionAutorizado();
        System.out.println(autorizado.findByDNI("11111113c"));
        
    }
}
