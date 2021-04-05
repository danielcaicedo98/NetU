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
                ResourceBundle rb = ResourceBundle.getBundle("conexion.jdbc");
                String driver = rb.getString("driver");
                String url = rb.getString("url");
                String pwd = rb.getString("pwd");
                String usr = rb.getString("usr");
                
                Class.forName(driver);
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
