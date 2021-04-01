/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author PuntoPC (Camila)
 */

public class Empleado {
    
    //Atributos del Empleado
    private String nombre;
    private String correo;
    private String sexo;
    private String codigo;
    private String dependencia;
    private String subDependencia;
    
    
    //Constructores
    public Empleado(){};

    public Empleado(String nombre, String correo, String sexo, String codigo, String dependencia, String subDependencia) {
        this.nombre = nombre;
        this.correo = correo;
        this.sexo = sexo;
        this.codigo = codigo;
        this.dependencia = dependencia;
        this.subDependencia = subDependencia;
    }
    
    
    //Getters and Setters

    //Nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    //Correo
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    
    //Sexo
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    
    //Codigo
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    
    //Dependencia
    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    
    //Subdependencia
    public String getSubDependencia() {
        return subDependencia;
    }

    public void setSubDependencia(String subDependencia) {
        this.subDependencia = subDependencia;
    }
      
    
}
