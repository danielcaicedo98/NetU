package modelo;
import java.io.Serializable;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danie
 */
public class PaqueteEnvio implements Serializable{
    
    private String nick, ip, mensaje;
    
    PeticionSesionC petInSeC;

    public PeticionSesionC getPetInSeC() {
        return petInSeC;
    }

    public void setPetInSeC(PeticionSesionC petInSeC) {
        this.petInSeC = petInSeC;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }    
    
    
}
