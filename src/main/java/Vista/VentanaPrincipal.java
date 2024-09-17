/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.ClienteDAO;
import Controlador.ControladorCliente;
import Modelo.Cliente;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.HierarchyBoundsListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class VentanaPrincipal extends javax.swing.JFrame {

    //ATRIBUTOS
    private ClienteDAO clienteDAO;
    private ControladorCliente controladorCliente;
    int idClienteSeleccionado = -1;//valor inicial que indica que no hay nadie seleccionado

    //CONSTRUCTOR
    public VentanaPrincipal(ClienteDAO clienteDAO) {
        initComponents();
        this.setResizable(false);
        this.clienteDAO = clienteDAO;
        cargarTabla();

        // Agregar ActionListener al botón de Buscar
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnBuscarActionPerformed(e);
            }
        });
    }

    //METODOS --------------------------------
    //LIMPIAR PANTALLA 
    public void limpiarPantalla() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtCedula.setText("");
        txtCelular.setText("");
        txtDireccion.setText("");
        txtMarcaVehiculo.setText("");
        txtModeloVehiculo.setText("");
        txtAnioVehiculo.setText("");
        cmbServicioAdquirido.setSelectedIndex(0);
        txtDetalles.setText("");
    }

    //cargarTabla()
    public void cargarTabla() {
        DefaultTableModel modeloTabla = (DefaultTableModel) jTDatosClientes.getModel();
        modeloTabla.setRowCount(0);
        List<Cliente> clientes = clienteDAO.SelectClientes();

        for (Cliente cliente : clientes) {
            Object[] row = new Object[]{
                cliente.getId_cliente(),
                cliente.getNombre(),
                cliente.getApellido(),
                cliente.getCedula(),
                cliente.getCelular(),
                cliente.getDireccion(),
                cliente.getMarca(),
                cliente.getModelo(),
                cliente.getAnio(),
                cliente.getServicio(),
                cliente.getDetalle()
            };
            modeloTabla.addRow(row);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cmbServicioAdquirido = new javax.swing.JComboBox<>();
        btnCancelar = new javax.swing.JButton();
        txtApellido = new javax.swing.JTextField();
        jLDireccion = new javax.swing.JLabel();
        txtModeloVehiculo = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        jLCelular = new javax.swing.JLabel();
        Marca = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        Vehiculo = new javax.swing.JLabel();
        Modelo = new javax.swing.JLabel();
        cmbServicio = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        NombreForm = new javax.swing.JLabel();
        jlNombre = new javax.swing.JLabel();
        jLApellido = new javax.swing.JLabel();
        txtAnioVehiculo = new javax.swing.JTextField();
        txtMarcaVehiculo = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        anio = new javax.swing.JLabel();
        Detalle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDetalles = new javax.swing.JTextArea();
        jLCedula = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTDatosClientes = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        cmbServicioAdquirido.setBackground(new java.awt.Color(255, 255, 255));
        cmbServicioAdquirido.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        cmbServicioAdquirido.setForeground(new java.awt.Color(0, 0, 0));
        cmbServicioAdquirido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", " Solo Carroceria 3$", " Lavado Express 5$", " Lavado Premium 10$", " Detailing 20$", " " }));
        cmbServicioAdquirido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cmbServicioAdquirido.setFocusable(false);

        btnCancelar.setBackground(new java.awt.Color(102, 102, 102));
        btnCancelar.setFont(new java.awt.Font("Hack Nerd Font", 0, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelarMouseExited(evt);
            }
        });
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtApellido.setBackground(new java.awt.Color(255, 255, 255));
        txtApellido.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        txtApellido.setForeground(new java.awt.Color(0, 0, 0));

        jLDireccion.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLDireccion.setForeground(java.awt.Color.white);
        jLDireccion.setText("Dirección : ");

        txtModeloVehiculo.setBackground(new java.awt.Color(255, 255, 255));
        txtModeloVehiculo.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        txtModeloVehiculo.setForeground(new java.awt.Color(0, 0, 0));

        txtCelular.setBackground(new java.awt.Color(255, 255, 255));
        txtCelular.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        txtCelular.setForeground(new java.awt.Color(0, 0, 0));
        txtCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCelularActionPerformed(evt);
            }
        });

        jLCelular.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLCelular.setForeground(java.awt.Color.white);
        jLCelular.setText("Celular  : ");

        Marca.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        Marca.setForeground(java.awt.Color.white);
        Marca.setText("Marca : ");

        txtCedula.setBackground(new java.awt.Color(255, 255, 255));
        txtCedula.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        txtCedula.setForeground(new java.awt.Color(0, 0, 0));

        Vehiculo.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        Vehiculo.setForeground(java.awt.Color.white);
        Vehiculo.setText("Datos Vehículo");

        Modelo.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        Modelo.setForeground(new java.awt.Color(255, 255, 255));
        Modelo.setText("Modelo : ");

        cmbServicio.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        cmbServicio.setForeground(java.awt.Color.white);
        cmbServicio.setText("Servicio : ");

        txtNombre.setBackground(new java.awt.Color(255, 255, 255));
        txtNombre.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(0, 0, 0));
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        NombreForm.setBackground(new java.awt.Color(153, 255, 153));
        NombreForm.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        NombreForm.setForeground(java.awt.Color.white);
        NombreForm.setText("Datos Cliente");

        jlNombre.setBackground(new java.awt.Color(51, 255, 255));
        jlNombre.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jlNombre.setForeground(java.awt.Color.white);
        jlNombre.setText("Nombre : ");

        jLApellido.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLApellido.setForeground(java.awt.Color.white);
        jLApellido.setText("Apellido :");

        txtAnioVehiculo.setBackground(new java.awt.Color(255, 255, 255));
        txtAnioVehiculo.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        txtAnioVehiculo.setForeground(new java.awt.Color(0, 0, 0));

        txtMarcaVehiculo.setBackground(new java.awt.Color(255, 255, 255));
        txtMarcaVehiculo.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        txtMarcaVehiculo.setForeground(new java.awt.Color(0, 0, 0));

        txtDireccion.setBackground(new java.awt.Color(255, 255, 255));
        txtDireccion.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        txtDireccion.setForeground(new java.awt.Color(0, 0, 0));

        btnGuardar.setBackground(new java.awt.Color(102, 102, 102));
        btnGuardar.setFont(new java.awt.Font("Hack Nerd Font", 0, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGuardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGuardarMouseExited(evt);
            }
        });
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        anio.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        anio.setForeground(java.awt.Color.white);
        anio.setText("Año : ");

        Detalle.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        Detalle.setForeground(java.awt.Color.white);
        Detalle.setText("Detalles : ");

        txtDetalles.setBackground(new java.awt.Color(255, 255, 255));
        txtDetalles.setColumns(20);
        txtDetalles.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        txtDetalles.setForeground(new java.awt.Color(0, 0, 0));
        txtDetalles.setLineWrap(true);
        txtDetalles.setRows(5);
        jScrollPane1.setViewportView(txtDetalles);

        jLCedula.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLCedula.setForeground(java.awt.Color.white);
        jLCedula.setText("Cédula : ");

        titulo.setBackground(new java.awt.Color(51, 51, 51));
        titulo.setFont(new java.awt.Font("Ebrima", 1, 36)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setText(" AutoClean Pro");
        titulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        titulo.setOpaque(true);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\juand\\Documents\\iti\\PIC-PROYECTOS-ITI\\Main\\src\\main\\java\\img\\logo2.jpg")); // NOI18N
        jLabel14.setLabelFor(jLabel14);

        jTDatosClientes.setBackground(new java.awt.Color(204, 204, 204));
        jTDatosClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id_cliente", "Nombre", "Apellido", "Cedula", "Celular", "Direccion", "Marca", "Modelo", "Año", "Servicio", "Detalle"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTDatosClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTDatosClientesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTDatosClientes);

        btnEditar.setBackground(new java.awt.Color(102, 102, 102));
        btnEditar.setFont(new java.awt.Font("Hack Nerd Font", 0, 14)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Actualizar Datos");
        btnEditar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditarMouseExited(evt);
            }
        });
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(102, 102, 102));
        btnEliminar.setFont(new java.awt.Font("Hack Nerd Font", 0, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarMouseExited(evt);
            }
        });
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(102, 102, 102));
        btnBuscar.setFont(new java.awt.Font("Hack Nerd Font", 0, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBuscarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBuscarMouseExited(evt);
            }
        });
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLCedula, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlNombre, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombre)
                                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLCelular))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLDireccion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(156, 156, 156)
                                .addComponent(NombreForm, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(141, 141, 141)
                                .addComponent(Vehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(Marca)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtMarcaVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(Modelo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtModeloVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(anio)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtAnioVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cmbServicio)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbServicioAdquirido, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50)
                                        .addComponent(Detalle, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 25, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombreForm)
                    .addComponent(Vehiculo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlNombre)
                    .addComponent(jLApellido)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Marca)
                    .addComponent(txtMarcaVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Modelo)
                    .addComponent(txtModeloVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anio)
                    .addComponent(txtAnioVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLCedula)
                            .addComponent(jLCelular)
                            .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLDireccion)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbServicioAdquirido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbServicio)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(Detalle)))
                .addGap(55, 55, 55)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //btn GUARDAR - INSERT EN TABLA CLIENTE
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        System.out.println("soy");
    }//GEN-LAST:event_btnGuardarActionPerformed

    @Override
    public void addHierarchyBoundsListener(HierarchyBoundsListener l) {
        super.addHierarchyBoundsListener(l); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }


    private void btnGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseExited
        // TODO add your handling code here:
        btnGuardar.setBackground(new Color(100, 100, 100));
    }//GEN-LAST:event_btnGuardarMouseExited

    //HOVER                                  

    private void btnGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseEntered
        btnGuardar.setBackground(new Color(153, 153, 153));
    }//GEN-LAST:event_btnGuardarMouseEntered

    //METODOS EVENTOS BOTONES
    //METODO CANCELAR
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        //METODO PARA LIMPIAR FORMULARIO AL CANCELAR
        limpiarPantalla();
        //MENSAJE CANCELAD
        JOptionPane.showMessageDialog(this, "Cancelado.");
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseExited
        // TODO add your handling code here:
        btnCancelar.setBackground(new Color(100, 100, 100));
    }//GEN-LAST:event_btnCancelarMouseExited

    //HOVER

    private void btnCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseEntered
        btnCancelar.setBackground(new Color(153, 153, 153));
    }//GEN-LAST:event_btnCancelarMouseEntered


    private void jTDatosClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTDatosClientesMouseClicked

    }//GEN-LAST:event_jTDatosClientesMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCelularActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:    

    }//GEN-LAST:event_btnBuscarActionPerformed

    //btns eventos
    private void btnEditarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarMouseExited
        // TODO add your handling code here:
        btnEditar.setBackground(new Color(100, 100, 100));
    }//GEN-LAST:event_btnEditarMouseExited

    private void btnEditarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarMouseEntered
        // TODO add your handling code here:
        btnEditar.setBackground(new Color(153, 153, 153));

    }//GEN-LAST:event_btnEditarMouseEntered

    private void btnBuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseExited
        // TODO add your handling code here:
        btnBuscar.setBackground(new Color(100, 100, 100));
    }//GEN-LAST:event_btnBuscarMouseExited

    private void btnBuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseEntered
        // TODO add your handling code here:
        btnBuscar.setBackground(new Color(153, 153, 153));
    }//GEN-LAST:event_btnBuscarMouseEntered

    private void btnEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseExited
        // TODO add your handling code here:
        btnEliminar.setBackground(new Color(100, 100, 100));
    }//GEN-LAST:event_btnEliminarMouseExited

    private void btnEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseEntered
        // TODO add your handling code here:
        btnEliminar.setBackground(new Color(153, 153, 153));
    }//GEN-LAST:event_btnEliminarMouseEntered

    //Getters and Setters-------------------------------------------
    public JLabel getCmbServicio() {
        return cmbServicio;
    }

    public void setCmbServicio(JLabel cmbServicio) {
        this.cmbServicio = cmbServicio;
    }

    public JComboBox<String> getCmbServicioAdquirido() {
        return cmbServicioAdquirido;
    }

    public void setCmbServicioAdquirido(JComboBox<String> cmbServicioAdquirido) {
        this.cmbServicioAdquirido = cmbServicioAdquirido;
    }

    public JTextField getTxtAnioVehiculo() {
        return txtAnioVehiculo;
    }

    public void setTxtAnioVehiculo(JTextField txtAnioVehiculo) {
        this.txtAnioVehiculo = txtAnioVehiculo;
    }

    public JTextField getTxtApellido() {
        return txtApellido;
    }

    public void setTxtApellido(JTextField txtApellido) {
        this.txtApellido = txtApellido;
    }

    public JTextField getTxtCedula() {
        return txtCedula;
    }

    public void setTxtCedula(JTextField txtCedula) {
        this.txtCedula = txtCedula;
    }

    public JTextField getTxtCelular() {
        return txtCelular;
    }

    public void setTxtCelular(JTextField txtCelular) {
        this.txtCelular = txtCelular;
    }

    public JTextArea getTxtDetalles() {
        return txtDetalles;
    }

    public void setTxtDetalles(JTextArea txtDetalles) {
        this.txtDetalles = txtDetalles;
    }

    public JTextField getTxtDireccion() {
        return txtDireccion;
    }

    public void setTxtDireccion(JTextField txtDireccion) {
        this.txtDireccion = txtDireccion;
    }

    public JTextField getTxtMarcaVehiculo() {
        return txtMarcaVehiculo;
    }

    public void setTxtMarcaVehiculo(JTextField txtMarcaVehiculo) {
        this.txtMarcaVehiculo = txtMarcaVehiculo;
    }

    public JTextField getTxtModeloVehiculo() {
        return txtModeloVehiculo;
    }

    public void setTxtModeloVehiculo(JTextField txtModeloVehiculo) {
        this.txtModeloVehiculo = txtModeloVehiculo;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public void setBtnBuscar(JButton btnBuscar) {
        this.btnBuscar = btnBuscar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public JButton getBtnEditar() {
        return btnEditar;
    }

    public void setBtnEditar(JButton btnEditar) {
        this.btnEditar = btnEditar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public void setBtnGuardar(JButton btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    public JTable getjTDatosClientes() {
        return jTDatosClientes;
    }

    public void setjTDatosClientes(JTable jTDatosClientes) {
        this.jTDatosClientes = jTDatosClientes;
    }

    public int getIdClienteSeleccionado() {
        return idClienteSeleccionado;
    }

    public void setIdClienteSeleccionado(int idClienteSeleccionado) {
        this.idClienteSeleccionado = idClienteSeleccionado;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Detalle;
    private javax.swing.JLabel Marca;
    private javax.swing.JLabel Modelo;
    private javax.swing.JLabel NombreForm;
    private javax.swing.JLabel Vehiculo;
    private javax.swing.JLabel anio;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel cmbServicio;
    private javax.swing.JComboBox<String> cmbServicioAdquirido;
    private javax.swing.JLabel jLApellido;
    private javax.swing.JLabel jLCedula;
    private javax.swing.JLabel jLCelular;
    private javax.swing.JLabel jLDireccion;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTDatosClientes;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField txtAnioVehiculo;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextArea txtDetalles;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtMarcaVehiculo;
    private javax.swing.JTextField txtModeloVehiculo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

}
