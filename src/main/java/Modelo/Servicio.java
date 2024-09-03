/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author juand
 */
public class Servicio {
    //ATRIBUTOS
    private String servicio;
    private String detalle;
    
    //CONSTRUCTO
    
    public Servicio(String servicio, String detalle){
        this.servicio = servicio;
        this.detalle = detalle;
    }
    
    public Servicio(){
    }
    
    
    
    //GETERS AN SETTERS

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    @Override
    public String toString() {
        return servicio; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
}
