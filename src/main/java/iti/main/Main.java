/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package iti.main;

import Controlador.ClienteDAO;
import Modelo.Cliente;
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

        //Insert 
        /* Cliente nuevoCliente = new Cliente("Jose","Angulo","1234569877",
                "0995523657","Av. America","Chevrolet", "Aveo",
                2008  );
        Servicio servicio = new Servicio("LavadoExpress", "carroceria rayada");
        
        ClienteDAO clienteDao = new ClienteDAO();
        
        clienteDao.insertarDatos(nuevoCliente, servicio);
        
         */
        
        clienteDAO.SelectClientes();
        
    }
}
