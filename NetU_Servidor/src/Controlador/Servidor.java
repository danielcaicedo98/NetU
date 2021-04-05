package Controlador;


import conexion.*;
import modelo.PaqueteEnvio;
import javax.swing.*;

import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.PeticionSesionC;

public class Servidor  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoServidor mimarco=new MarcoServidor();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	}	
}

class MarcoServidor extends JFrame implements Runnable{
	
	public MarcoServidor(){
		
		setBounds(1200,300,280,350);				
			
		JPanel milamina= new JPanel();
		
		milamina.setLayout(new BorderLayout());
		
		areatexto=new JTextArea();
		
		milamina.add(areatexto,BorderLayout.CENTER);
		
		add(milamina);
		
		setVisible(true);
                
                Thread miHilo = new Thread (this);
                
                miHilo.start();
		
                setLocationRelativeTo(null);
                
        }
	
	private	JTextArea areatexto;

        @Override
        public void run() {
            try {
                
                ServerSocket servidor = new ServerSocket(12345);
                
                String nickS, ipS, mensajeS;
                
                PaqueteEnvio paquete_recibido;
                
                ArrayList <String> listaIP = new ArrayList<String>();
                
                while(true){
                    
                    Socket miSocket = servidor.accept();                    
                   
                    ObjectInputStream flujo_entrada = new ObjectInputStream(
                                                     miSocket.getInputStream()); 

                    paquete_recibido  = (PaqueteEnvio)flujo_entrada.readObject();
                    
                    nickS = paquete_recibido.getNick();
                    
                    ipS = paquete_recibido.getIp();
                    
                    mensajeS = paquete_recibido.getMensaje();                    
                    
                     areatexto.append(miSocket.getInetAddress() + " nick " + 
                        nickS + " mensaje " + mensajeS + " para " + ipS + "\n");
                    
                    buscarInicioSesion(paquete_recibido);
                    
                    miSocket.close();                      
                    
                }    
                
            } catch (IOException ex) {
                System.out.println("Error -> " + ex.getMessage());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MarcoServidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    public void buscarInicioSesion(PaqueteEnvio p) {
        
        PaqueteEnvio paqueteReenvio = p;
                
        PeticionSesionC peticion = paqueteReenvio.getPetInSeC();
        
        String codigoEmpleado = peticion.getCodigoEmpleado();
        
        String contrasenia = peticion.getContraseniaEmpleado();
        
        Connection miConexion = null;
        
        PreparedStatement pstm = null;
       
        ResultSet rs = null;  
        
        try{
            
            miConexion = Fachada.getConnection();
            
            String sql = "select * from login"; 
            
            pstm = miConexion.prepareStatement(sql);
            
            rs = pstm.executeQuery();            
                        
            String x[] = new String[2];
            
            while(rs.next()){
               
                x[0] = rs.getString("codigo_empleado");
                
                x[1] = rs.getString("contraseña");
                
            }
          
            if(contrasenia.equals(x[1]) && x[0].equals(""+codigoEmpleado)){
                peticion.setRespuesta(true);
            }else if(!(contrasenia.equals(x[1]) && x[0].equals(""+codigoEmpleado))){
                peticion.setRespuesta(false);
            }
            
            paqueteReenvio.setPetInSeC(peticion);
            
            respuestaInicioSesion(paqueteReenvio);
            
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }        
    }
    
    public void respuestaInicioSesion(PaqueteEnvio p){
        
        try {

            Socket enviaDestinatario;

            enviaDestinatario = new Socket(p.getIp(), 12346);
            ObjectOutputStream paqueteReenvio = new ObjectOutputStream(
                    enviaDestinatario.getOutputStream());

            paqueteReenvio.writeObject(p);

            paqueteReenvio.close();

            enviaDestinatario.close();

        } catch (IOException ex) {
            Logger.getLogger(MarcoServidor.class.getName()).log(Level.SEVERE, null, ex);
        }     
            
    }
    
}
