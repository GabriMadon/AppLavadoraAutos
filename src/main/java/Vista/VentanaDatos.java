/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.ClienteDAO;
import Modelo.Cliente;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juand
 */
public class VentanaDatos extends javax.swing.JFrame {

    //ATRIBUTOS
    int filaSeleccionada;//selecciona fila

    //CONSTRUCTOR
    public VentanaDatos() {
        initComponents();
        cargarDatosTabla();

        // Asegura que solo se cierre la ventanaDatos
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    //METODOS
    //CARGAR DATOS EN TABLA
    public void cargarDatosTabla() {
        DefaultTableModel modelo = (DefaultTableModel) jTDatos.getModel();
        modelo.setRowCount(0);

        //LLAMAMOS METODO SelectClientes() DE CLIENTEDAO
        ClienteDAO clienteDAO = new ClienteDAO();
        List<Cliente> listaCliente = clienteDAO.SelectClientes();
        listaCliente = clienteDAO.SelectClientes();

        for (Cliente cliente : listaCliente) {

            Object[] fila = new Object[11];
            fila[0] = cliente.getId_cliente();
            fila[1] = cliente.getNombre();
            fila[2] = cliente.getApellido();
            fila[3] = cliente.getCedula();
            fila[4] = cliente.getCelular();
            fila[5] = cliente.getDireccion();
            fila[6] = cliente.getMarca();
            fila[7] = cliente.getModelo();
            fila[8] = cliente.getAnio();
            fila[9] = cliente.getServicio();
            fila[10] = cliente.getDetalle();

            modelo.addRow(fila);  // Añadimos la fila al modelo
        }
    }

    // Método para mostrar un cliente en la tabla
    public void mostrarClienteEnTabla(Cliente cliente) {
        DefaultTableModel modelo = (DefaultTableModel) jTDatos.getModel();
        modelo.setRowCount(0); // Limpiar la tabla

        Object[] fila = new Object[11];
        fila[0] = cliente.getId_cliente();
        fila[1] = cliente.getNombre();
        fila[2] = cliente.getApellido();
        fila[3] = cliente.getCedula();
        fila[4] = cliente.getCelular();
        fila[5] = cliente.getDireccion();
        fila[6] = cliente.getMarca();
        fila[7] = cliente.getModelo();
        fila[8] = cliente.getAnio();
        fila[9] = cliente.getServicio();
        fila[10] = cliente.getDetalle();

        modelo.addRow(fila);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTDatos = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnBuscarPorCedula = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTDatos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTDatos.setFont(new java.awt.Font("Hack Nerd Font Propo", 0, 14)); // NOI18N
        jTDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id_cliente", "Nombre", "Apellido", "Cedula", "Celular", "Direccion", "Marca", "Modelo", "Año", "Servicio", "Detalle"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTDatos.setRowHeight(25);
        jTDatos.setRowMargin(10);
        jTDatos.setShowGrid(true);
        jScrollPane1.setViewportView(jTDatos);
        if (jTDatos.getColumnModel().getColumnCount() > 0) {
            jTDatos.getColumnModel().getColumn(0).setMinWidth(40);
            jTDatos.getColumnModel().getColumn(0).setPreferredWidth(40);
            jTDatos.getColumnModel().getColumn(0).setMaxWidth(40);
            jTDatos.getColumnModel().getColumn(8).setMinWidth(60);
            jTDatos.getColumnModel().getColumn(8).setPreferredWidth(60);
            jTDatos.getColumnModel().getColumn(8).setMaxWidth(60);
            jTDatos.getColumnModel().getColumn(9).setMinWidth(100);
            jTDatos.getColumnModel().getColumn(9).setPreferredWidth(150);
            jTDatos.getColumnModel().getColumn(9).setMaxWidth(150);
            jTDatos.getColumnModel().getColumn(10).setMinWidth(200);
            jTDatos.getColumnModel().getColumn(10).setPreferredWidth(200);
            jTDatos.getColumnModel().getColumn(10).setMaxWidth(200);
        }

        btnEditar.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        btnEliminar.setText("Eliminar");

        btnBuscarPorCedula.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        btnBuscarPorCedula.setText("Buscar por Cédula");
        btnBuscarPorCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPorCedulaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(507, 507, 507)
                .addComponent(btnBuscarPorCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(432, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarPorCedula, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //btn EDITAR
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        //Seleccionamos con el mouse una Row
        // Obtenemos los datos de la fila seleccionada
        filaSeleccionada = jTDatos.getSelectedRow();
        if (filaSeleccionada != -1) {
            // Obtenemos los datos de la fila seleccionada
            int idCliente = (Integer) jTDatos.getValueAt(filaSeleccionada, 0);
            String nombre = jTDatos.getValueAt(filaSeleccionada, 1).toString();
            String apellido = jTDatos.getValueAt(filaSeleccionada, 2).toString();
            String cedula = jTDatos.getValueAt(filaSeleccionada, 3).toString();
            String celular = jTDatos.getValueAt(filaSeleccionada, 4).toString();
            String direccion = jTDatos.getValueAt(filaSeleccionada, 5).toString();
            String marca = jTDatos.getValueAt(filaSeleccionada, 6).toString();
            String modelo = jTDatos.getValueAt(filaSeleccionada, 7).toString();
            int anio = Integer.parseInt(jTDatos.getValueAt(filaSeleccionada, 8).toString());
            String servicio = jTDatos.getValueAt(filaSeleccionada, 9).toString();
            String detalle = jTDatos.getValueAt(filaSeleccionada, 10).toString();

            // Crear un objeto Cliente y Servicio con los datos seleccionados
            Cliente clienteSeleccionado = new Cliente(idCliente, nombre,
                    apellido, cedula, celular, direccion, marca, modelo, anio, servicio, detalle);

            // Pasamos los datos al constructor de VentanaEdicion
            VentanaEdicion ventanaEdicion = new VentanaEdicion(clienteSeleccionado);
            ventanaEdicion.setVisible(true);
            ventanaEdicion.setLocationRelativeTo(null);

        } else {
            JOptionPane.showMessageDialog(this, "Por favor selecciona una fila.");
        }

    }//GEN-LAST:event_btnEditarActionPerformed
    //btn BUSCAR
    private void btnBuscarPorCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPorCedulaActionPerformed
        // TODO add your handling code here:
        VentanaBusqueda ventanaBusqueda = new VentanaBusqueda(this);
        ventanaBusqueda.setVisible(true);
        ventanaBusqueda.setLocationRelativeTo(null);

    }//GEN-LAST:event_btnBuscarPorCedulaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarPorCedula;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTDatos;
    // End of variables declaration//GEN-END:variables
}
