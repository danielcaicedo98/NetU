package main;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import modelo.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.*;
import java.net.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoCliente mimarco=new MarcoCliente();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //System.out.println("h");
	}

}


class MarcoCliente extends JFrame{
	
	public MarcoCliente(){
		
		//setBounds(600,300,280,350);
                
                setSize(140, 200);
				
		LaminaMarcoCliente milamina=new LaminaMarcoCliente();
		
		add(milamina);                
                
		setVisible(true);                
               
                setLocationRelativeTo(null);
                
	}	
	
}

class LaminaMarcoCliente extends JPanel implements Runnable{
	
	public LaminaMarcoCliente(){     
            
                nickName = "Daniel";
            
                nombreChat = new JLabel();
                
                nombreChat.setText("Nick: "+nickName);
                
                add(nombreChat);
            
		JLabel texto=new JLabel("    Online");		 
                               
                add(texto);    
	
		campo1=new JTextField(10);
                
                contrasenia = new JTextField(10);
                
                JLabel codigo = new JLabel("Codigo: ");
                
                JLabel contrasena = new JLabel("Contraseña: ");
                
                add(codigo);
              	
		add(campo1);	
                
                add(contrasena);
                
                add(contrasenia);
	
		miboton=new JButton("Enviar");
                
                EnviaTexto miEvento = new EnviaTexto();
                
                enviaPeticion = new PeticionSesionC();
                
                miboton.addActionListener(miEvento);
                
		add(miboton);	
		
                Thread miHilo = new Thread(this);
                
                miHilo.start();
                
	}

    
        public void run() {
            
            try{
                ServerSocket servidorCliente = new ServerSocket(12346);
                
                Socket cliente;
                
                PaqueteEnvio paqueteRecibidoC;
                
                while(true){
                    
                    cliente = servidorCliente.accept();
                    
                    ObjectInputStream flujoEntrada = new ObjectInputStream(
                        cliente.getInputStream());
                    
                    paqueteRecibidoC = (PaqueteEnvio) flujoEntrada.readObject();
                    
                    PeticionSesionC confirmacion = paqueteRecibidoC.getPetInSeC();
                    
                    if(confirmacion.isRespuesta()==true){
                        JOptionPane.showMessageDialog(null, 
                                "El usuario se encuentra registrado");
                    }else if(confirmacion.isRespuesta()==false){
                        
                        JOptionPane.showOptionDialog(null,
                                "El usuario no se encuentra registrado", "Aviso"
                                , JOptionPane.CLOSED_OPTION, JOptionPane
                                        .ERROR_MESSAGE, null, null, null);
                        
                   }
                    
                }
            }catch(Exception e){
                System.out.println("Error -> "+e.getMessage());
            }
            
        }    
	
	
	private class EnviaTexto implements ActionListener{

        @Override
            public void actionPerformed(ActionEvent e) {        
                
                                
                try {                         
                    
                    Socket miSocket = new Socket("localhost",12345);                    
                    
                    PaqueteEnvio datos = new PaqueteEnvio();                  
                    
                    datos.setNick(nickName);
                    
                    datos.setIp("localhost");
                    
                    datos.setMensaje(campo1.getText()); 
                    
                    enviaPeticion.setCodigoEmpleado(campo1.getText());
                    
                    enviaPeticion.setContraseniaEmpleado(contrasenia.getText());
                    
                    datos.setPetInSeC(enviaPeticion);
                    
                    ObjectOutputStream flujo_salida = new ObjectOutputStream(
                                                miSocket.getOutputStream());                    
                    
                    
                    flujo_salida.writeObject(datos);
                    
                    flujo_salida.close();
                    
                } catch (IOException ex) {
                    System.out.println("Error "+ex.getMessage());
                }
            }
            
        }
		
	PeticionSesionC enviaPeticion;	
		
	private JTextField campo1, contrasenia;
        
        private JButton miboton;
               
        private String nickName;
        
        private JLabel nombreChat;
	
}

