/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package childout_Alejandro;

import childout.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author DAW
 */
public class GestionAlumno {

    ArrayList<String> grupos = new ArrayList();
    Alumno alumno;

    private Alumno get(int id_alumno) {

        try {

            String sql = ("SELECT * FROM alumno where id_alumno =" + id_alumno);
            Statement stmt = Conexion.conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            id_alumno = rs.getInt("id_alumno");
            String nombre = rs.getString("nombre");
            String grupo = rs.getString("grupo");
            alumno = new Alumno(id_alumno, nombre, grupo);
            
        } catch (SQLException ex) {
            System.out.println("Error al consultar la base de datos");
            ex.printStackTrace();
        }
        return alumno;
    }

    private ArrayList<String> findGrupos() {
        try {
            String sql = ("Select grupo from alumno group by grupo");
            Statement stmt = Conexion.conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id_alumno = rs.getInt("id_alumno");
                String nombre = rs.getString("nombre");
                String grupo = rs.getString("grupo");
            }
        } catch (SQLException ex) {
            System.out.println("Error al consultar la base de datos");
            ex.printStackTrace();
        }
        return grupos;
    }

    private boolean delete(Alumno alumno) {
        
        try {
            String sql = ("Delete * from alumno where id_alumno ="+ alumno.getId_alumno());
            Statement stmt = Conexion.conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id_alumno = rs.getInt("id_alumno");
                String nombre = rs.getString("nombre");
                String grupo = rs.getString("grupo");
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error al consultar la base de datos");
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    private boolean update(Alumno alumno) {
        try {
            String sql = ("Update alumno set " + alumno.getId_alumno());
            Statement stmt = Conexion.conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id_alumno = rs.getInt("id_alumno");
                String nombre = rs.getString("nombre");
                String grupo = rs.getString("grupo");
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error al consultar la base de datos");
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}
