/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import vista.ChatGUI;
import vista.DescripcionGUI;
import vista.LoginGUI;
import vista.MensajeGUI;
import vista.PerfilGUI;
import vista.PrincipalGUI;
import vista.PublicacionGUI;

/**
 *
 * @author PuntoPC
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        LoginGUI login = new LoginGUI();
        login.setVisible(true);
        
        PrincipalGUI pr = new PrincipalGUI();
        pr.setVisible(true);
        
        DescripcionGUI d = new DescripcionGUI();
        d.setVisible(true);
        
        PublicacionGUI p = new PublicacionGUI();
        p.setVisible(true);
        
        ChatGUI c = new ChatGUI();
        c.setVisible(true);

        PerfilGUI pe = new PerfilGUI();
        pe.setVisible(true);
        
        MensajeGUI m = new MensajeGUI();
        m.setVisible(true);
    }
    
}
