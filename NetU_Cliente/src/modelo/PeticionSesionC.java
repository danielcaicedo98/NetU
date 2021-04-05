/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


/**
 *
 * @author danie
 */


public class PeticionSesionC extends PaqueteEnvio{
    
    String codigoEmpleado;
    
    String contraseniaEmpleado;
    
    boolean respuesta;

    public boolean isRespuesta() {
        return respuesta;
    }

    public void setRespuesta(boolean respuesta) {
        this.respuesta = respuesta;
    }

    public PeticionSesionC getPetInSeC() {
        return petInSeC;
    }

    public void setPetInSeC(PeticionSesionC petInSeC) {
        this.petInSeC = petInSeC;
    }
    
    

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getContraseniaEmpleado() {
        return contraseniaEmpleado;
    }

    public void setContraseniaEmpleado(String contraseniaEmpleado) {
        this.contraseniaEmpleado = contraseniaEmpleado;
    }
        
}
