/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package iti.main;

import Controlador.ClienteDAO;

import Vista.VentanaPrincipal;

/**
 *
 * @author juand
 */
public class Main {

    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAO();
    
        //Ver Ventana Principal 
        VentanaPrincipal princ = new VentanaPrincipal(clienteDAO);
        princ.setVisible(true);//visible pantalla principal
        princ.setLocationRelativeTo(null);// ubicacion en el centro de la pantalla
        
        clienteDAO.SelectClientes();
        
    }
}
