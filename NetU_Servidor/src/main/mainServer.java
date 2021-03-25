package main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danie
 */
public class mainServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Servidor miServer = new Servidor();
        miServer.setVisible(true);
        miServer.setResizable(false);
        miServer.setLocationRelativeTo(null);
        LoginServidor miLogin = new LoginServidor();
        miLogin.setVisible(true);
    }
    
}
