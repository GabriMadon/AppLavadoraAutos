/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package iti.main;

import Controlador.ClienteDAO;
import Modelo.Servicio;
import Vista.VentanaPrincipal;

/**
 *
 * @author juand
 */
public class Main {

    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAO();
        Servicio servicio = new Servicio("servicio","detalle");
        

       

        //Ver Ventana Principal 
        VentanaPrincipal princ = new VentanaPrincipal(clienteDAO, servicio);
        princ.setVisible(true);//visible pantalla principal
        princ.setLocationRelativeTo(null);// ubicacion en el centro de la pantalla
        
        clienteDAO.SelectClientes();
        
    }
}
