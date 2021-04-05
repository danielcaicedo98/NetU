/*
 * Programa	: Fachada.java
 * Fecha	: 10/04/2016
 * Objetivo	: Manejar las operaciones de conexión a la BD
 * Programador	: Luis Yovany Romo Portilla
 */

package conexion;
import java.sql.*;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
/**
 *
 * @author Admin
 */
public class Fachada {
    
    private static Connection con = null;
    
    
    
    public static Connection getConnection(){
        try
        {
            if(con == null){
                
                Runtime.getRuntime().addShutdownHook(new MiShDwnHook());                
                String url = "jdbc:mysql://localhost:3306/sistemanetu?characterEncoding=utf8";
                String pwd = "";
                String usr = "root";
                
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, usr, pwd);
            }
                         
        }
        catch(ClassNotFoundException | SQLException ex){
            JOptionPane.showMessageDialog(null,"Error : " + 
                    ex.getMessage());
        }
        return con;
    }
    
    static class MiShDwnHook extends Thread{
        //Justo antes de finaliza el programa la JVM invocará
        //este método donde podemos cerra la conexión
        @Override
        public void run(){
            try{
                Connection con = Fachada.getConnection();
                con.close();                     
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(null,"Error : " + 
                        ex.getMessage());
            }
        }
    }
}
