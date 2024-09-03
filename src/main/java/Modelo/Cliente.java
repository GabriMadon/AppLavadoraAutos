/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author juand
 */
public class Cliente {

    //ATRIBUTOS
    private int id_cliente;
    private String nombre;
    private String apellido;
    private String cedula;
    private String celular;
    private String direccion;
    private String marca;
    private String modelo;
    private int anio;

    //CONSTRUCTORES
    // Constructor sin idCliente (para cuando se crea un nuevo cliente)
    public Cliente(String nombre, String apellido, String cedula, String celular,
            String direccion, String marca, String modelo, int anio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.celular = celular;
        this.direccion = direccion;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }
    //CONSTRUCTOR CON ID CLIENTE (para cuando se obtienen datos de la DB)
    public Cliente(int id_cliente, String nombre, String apellido, String cedula, String celular,
            String direccion, String marca, String modelo, int anio) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.celular = celular;
        this.direccion = direccion;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;

    }
    
    public Cliente(){
    
    }
    //GETTERS AND SETTERS
    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

}

