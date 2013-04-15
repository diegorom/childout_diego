/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package childout_carlos;

/**
 *
 * @author Susana
 */
public class prueba {
    
    public static void main(String [] args){
        
        Conexion.conectar("localhost","root","");
    gestionAutorizado auto = new gestionAutorizado();
    
    System.out.println(auto.get(1).getId()+","+ auto.get(1).getNombre()+"," + auto.get(1).getCorreo()+"," + auto.get(1).getTelefono()+"," + auto.get(1).getDni() +"," + auto.get(1).getFoto()+"," + auto.get(1).getFirma()+"," + auto.get(1).getParentesco()+","+ auto.get(1).getHuella());
    }
}
