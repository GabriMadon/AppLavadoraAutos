/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Cliente;
import Vista.VentanaPrincipal;
import javax.swing.JOptionPane;

/**
 *
 * @author juand
 */
public class ControladorCliente {

    //ATRIBUTOS
    private ClienteDAO clienteDAO;
    private VentanaPrincipal ventanaPrincipal;

    //CONSTRUCTOR
    public ControladorCliente(ClienteDAO clienteDAO, VentanaPrincipal ventanaPrincipal) {
        this.clienteDAO = clienteDAO;
        this.ventanaPrincipal = ventanaPrincipal;
        iniciarEventos();
    }

    //METODOS------------------------------
    //iniciarEventos->  inicializa , registra eventos de los botones de la Vista
    //enlaza botones de la interfaz grafia con las acciones a ejecutarse
    private void iniciarEventos() {
        System.out.println("Configuramos eventos");
        ventanaPrincipal.getBtnBuscar().addActionListener(evt -> {
            System.out.println("Soy bntBuscar");
            buscarCliente();
        });
        ventanaPrincipal.getBtnGuardar().addActionListener(ev -> guardarCliente());
        ventanaPrincipal.getBtnEditar().addActionListener(ev -> editarCliente());
        ventanaPrincipal.getBtnEliminar().addActionListener(ev -> eliminarCliente());
        ventanaPrincipal.getBtnCancelar().addActionListener(ev -> cancelar());
        ventanaPrincipal.getjTDatosClientes().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seleccionarCliente();
            }
        });

    }

    //buscarClientes()-> select * from de SQL
    private void buscarCliente() {
        // Obtener del formu campo de texto cedula
        String cedula = ventanaPrincipal.getTxtCedula().getText().trim();

        if (cedula.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese una cédula para buscar.");
            return;
        }

        // Buscar el cliente por cédula
        Cliente cliente = clienteDAO.BuscarCedula(cedula);

        if (cliente != null) {
            // Mostrar los datos del cliente en los campos del formulario
            ventanaPrincipal.getTxtNombre().setText(cliente.getNombre());
            ventanaPrincipal.getTxtApellido().setText(cliente.getApellido());
            ventanaPrincipal.getTxtCedula().setText(cliente.getCedula());
            ventanaPrincipal.getTxtCelular().setText(cliente.getCelular());
            ventanaPrincipal.getTxtDireccion().setText(cliente.getDireccion());
            ventanaPrincipal.getTxtMarcaVehiculo().setText(cliente.getMarca());
            ventanaPrincipal.getTxtModeloVehiculo().setText(cliente.getModelo());
            ventanaPrincipal.getTxtAnioVehiculo().setText(String.valueOf(cliente.getAnio()));
            ventanaPrincipal.getCmbServicioAdquirido().setSelectedItem(cliente.getServicio());
            ventanaPrincipal.getTxtDetalles().setText(cliente.getDetalle());

        } else {
            JOptionPane.showMessageDialog(null, "No se encontró un cliente con la cédula proporcionada.");
        }
        System.out.println("Soy btn buscar");

    }

    //guardarCliente()-> insert de SQL
    private void guardarCliente() {
        //OBTENER DATOS DEL FORMULARIO
        Cliente cliente = new Cliente(
                //.getTxtaccede al campo de txto JtextField del formulario
                ventanaPrincipal.getTxtNombre().getText(),
                ventanaPrincipal.getTxtApellido().getText(),
                ventanaPrincipal.getTxtCedula().getText(),
                ventanaPrincipal.getTxtCelular().getText(),
                ventanaPrincipal.getTxtDireccion().getText(),
                ventanaPrincipal.getTxtMarcaVehiculo().getText(),
                ventanaPrincipal.getTxtModeloVehiculo().getText(),
                Integer.parseInt(ventanaPrincipal.getTxtAnioVehiculo().getText()),
                (String) ventanaPrincipal.getCmbServicioAdquirido().getSelectedItem(),
                ventanaPrincipal.getTxtDetalles().getText()
        );

        //Instancia objeto Cliente con los datos obtenidos del form
        //Cliente cliente = new Cliente(cliente);
        clienteDAO.insertarDatos(cliente);
        JOptionPane.showMessageDialog(null, "Datos Gurdados.");
        //METODO LIMPIAR PANTALLA
        ventanaPrincipal.cargarTabla();
        ventanaPrincipal.limpiarPantalla();
    }

    //editarCliente() -> update de SQL
    private void editarCliente() {
        Cliente cliente = new Cliente(
                //.getTxtaccede al campo de txto JtextField del formulario
                ventanaPrincipal.getTxtNombre().getText(),
                ventanaPrincipal.getTxtApellido().getText(),
                ventanaPrincipal.getTxtCedula().getText(),
                ventanaPrincipal.getTxtCelular().getText(),
                ventanaPrincipal.getTxtDireccion().getText(),
                ventanaPrincipal.getTxtMarcaVehiculo().getText(),
                ventanaPrincipal.getTxtModeloVehiculo().getText(),
                Integer.parseInt(ventanaPrincipal.getTxtAnioVehiculo().getText()),
                (String) ventanaPrincipal.getCmbServicioAdquirido().getSelectedItem(),
                ventanaPrincipal.getTxtDetalles().getText()
        );

        clienteDAO.updateCliente(cliente);
        JOptionPane.showMessageDialog(null, "Datos Actualizados.");
        //METODO LIMPIAR PANTALLA
        ventanaPrincipal.cargarTabla();
        ventanaPrincipal.limpiarPantalla();
    }

    private void eliminarCliente() {
        int fila = ventanaPrincipal.getjTDatosClientes().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún usuario para eliminar");
            return;
        }
        // Obtiene el ID del cliente seleccionado
        int idClienteSeleccionado = Integer.parseInt(ventanaPrincipal.getjTDatosClientes().getValueAt(fila, 0).toString());
        boolean eliminado = clienteDAO.eliminarCliente(idClienteSeleccionado);
        if (eliminado) {
            JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente");
            ventanaPrincipal.cargarTabla(); // Actualiza la tabla para reflejar los cambios
            ventanaPrincipal.limpiarPantalla(); // Limpia el formulario
            ventanaPrincipal.setIdClienteSeleccionado(-1); // Reinicia la selección
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el usuario");
        }
    }

    private void cancelar() {
        ventanaPrincipal.limpiarPantalla();
        ventanaPrincipal.getjTDatosClientes();

    }

    public void seleccionarCliente() {
        int fila = ventanaPrincipal.getjTDatosClientes().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Usuario no sleccionado");

        } else {
            int idClienteSeleccionado = Integer.parseInt(ventanaPrincipal.getjTDatosClientes().getValueAt(fila, 0).toString());
            String nombre = ventanaPrincipal.getjTDatosClientes().getValueAt(fila, 1).toString();
            String apellido = ventanaPrincipal.getjTDatosClientes().getValueAt(fila, 2).toString();
            String cedula = ventanaPrincipal.getjTDatosClientes().getValueAt(fila, 3).toString();
            String celular = ventanaPrincipal.getjTDatosClientes().getValueAt(fila, 4).toString();
            String direccion = ventanaPrincipal.getjTDatosClientes().getValueAt(fila, 5).toString();
            String marca = ventanaPrincipal.getjTDatosClientes().getValueAt(fila, 6).toString();
            String modelo = ventanaPrincipal.getjTDatosClientes().getValueAt(fila, 7).toString();
            String anio = ventanaPrincipal.getjTDatosClientes().getValueAt(fila, 8).toString();
            String servicio = ventanaPrincipal.getjTDatosClientes().getValueAt(fila, 9).toString();
            String detalles = ventanaPrincipal.getjTDatosClientes().getValueAt(fila, 10).toString();

            // Asignar los datos a los campos del formulario
            //txtIdCliente.setText(String.valueOf(id)); // Asumiendo que tienes un campo para el ID del cliente
            ventanaPrincipal.getTxtNombre().setText(nombre);
            ventanaPrincipal.getTxtApellido().setText(apellido);
            ventanaPrincipal.getTxtCedula().setText(cedula);
            ventanaPrincipal.getTxtCelular().setText(celular);
            ventanaPrincipal.getTxtDireccion().setText(direccion);
            ventanaPrincipal.getTxtMarcaVehiculo().setText(marca);
            ventanaPrincipal.getTxtModeloVehiculo().setText(modelo);
            ventanaPrincipal.getTxtAnioVehiculo().setText(anio);
            ventanaPrincipal.getCmbServicioAdquirido().setSelectedItem(servicio);
            ventanaPrincipal.getTxtDetalles().setText(detalles);

            // Actualizar el ID del cliente seleccionado en la vista
            // ventanaPrincipal.setIdClienteSeleccionado(idClienteSeleccionado);
        }
    }
}
