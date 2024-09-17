/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package iti.main;

import Controlador.ClienteDAO;
import Controlador.ControladorCliente;
import Modelo.ConexionDB;

import Vista.VentanaPrincipal;

/**
 *
 * @author juand
 */
public class Main {
    public static void main(String[] args) {
        ConexionDB conexionDB = new ConexionDB() ;
        ClienteDAO clienteDAO = new ClienteDAO(conexionDB);
        VentanaPrincipal ventana = new VentanaPrincipal(clienteDAO);
        ControladorCliente controlador = new ControladorCliente(clienteDAO, ventana);
    
        ventana.setVisible(true);//visible pantalla principal
        ventana.setLocationRelativeTo(null);// ubicacion en el centro de la pantalla
        
        
    }
}
