/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Cliente;
import Modelo.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

public class ClienteDAO {

    //ATRIBUTOS
    private ConexionDB conexionDB;

    //CONSTRUCTOR
    public ClienteDAO(ConexionDB conexionDB) {
        this.conexionDB = conexionDB;
    }

    //METODO listar SELECT DB ** SELECCIONA TODOS LOS REGISTRO DE LA TABLA
    public List<Cliente> SelectClientes() {
        String tabla = "SELECT * FROM clientes";//tabla clientes DB
        List<Cliente> listaCliente = new ArrayList<>();

        try {
            //Statement ejecuta consultas SQL (SELECT INSERT UPDATE DELETE)
            Statement statement = conexionDB.getConnection().createStatement();
            //ResultSet Almacena y procesa resultados de consulta SQL
            ResultSet resultSet = statement.executeQuery(tabla);

            while (resultSet.next()) {
                Cliente cliente = new Cliente(
                        resultSet.getInt("id_cliente"),
                        resultSet.getString("nombre"),
                        resultSet.getString("apellido"),
                        resultSet.getString("cedula"),
                        resultSet.getString("celular"),
                        resultSet.getString("direccion"),
                        resultSet.getString("marca"),
                        resultSet.getString("modelo"),
                        resultSet.getInt("anio"),
                        resultSet.getString("servicio"),
                        resultSet.getString("detalle")
                );

                //resultSet.getString("cliente");
                listaCliente.add(cliente);
            }

        } catch (SQLException e) {
            System.out.println("(SELECT) Error de consulta a TABLA clientes de DB" + e.getMessage());
        }
        return listaCliente;
    }

    //METODO INSERT DB agregar cliente
    public void insertarDatos(Cliente cliente) {

        String tabla = "INSERT INTO clientes (nombre, apellido, "
                + "cedula,celular, direccion, marca, modelo, anio, servicio, detalle) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?)";

        try {

            PreparedStatement preparedStatement = conexionDB.getConnection().prepareStatement(tabla);
            preparedStatement.setString(1, cliente.getNombre());
            preparedStatement.setString(2, cliente.getApellido());
            preparedStatement.setString(3, cliente.getCedula());
            preparedStatement.setString(4, cliente.getCelular());
            preparedStatement.setString(5, cliente.getDireccion());
            preparedStatement.setString(6, cliente.getMarca());
            preparedStatement.setString(7, cliente.getModelo());
            preparedStatement.setInt(8, cliente.getAnio());
            preparedStatement.setString(9, cliente.getServicio());
            preparedStatement.setString(10, cliente.getDetalle());

            preparedStatement.executeUpdate();
            System.out.println("Usuario registrado correctamente");

        } catch (SQLException e) {
            System.out.println("(INSERT)Error al registrar Cliente" + e.getMessage());
        }

    }

    //METODO BUSCAR POR CEDULA / SELECT * FROM WHERE
    public Cliente BuscarCedula(String cedula) {
        String tabla = "SELECT * FROM clientes WHERE cedula = ?";
        Cliente cliente = null;

        try {

            //Statement ejecuta consultas SQL (SELECT INSERT UPDATE DELETE)
            PreparedStatement preparedStatement = conexionDB.getConnection().prepareStatement(tabla);
            preparedStatement.setString(1, cedula);

            //ResultSet Almacena y procesa resultados de consulta SQL
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                cliente = new Cliente(
                        resultSet.getInt("id_cliente"),
                        resultSet.getString("nombre"),
                        resultSet.getString("apellido"),
                        resultSet.getString("cedula"),
                        resultSet.getString("celular"),
                        resultSet.getString("direccion"),
                        resultSet.getString("marca"),
                        resultSet.getString("modelo"),
                        resultSet.getInt("anio"),
                        resultSet.getString("servicio"),
                        resultSet.getString("detalle")
                );
                //resultSet.getString("cliente");

                // listaCliente.add(cliente);
            }

        } catch (SQLException e) {
            System.out.println("Error de Busqueda a TABLA clientes de DB");
        }
        return cliente;
    }

    //METODO UPDATE DB
    public boolean updateCliente(Cliente cliente) {
        String tabla = "UPDATE clientes SET nombre = ?, apellido = ?,"
                + " celular = ?, direccion = ?, marca = ?, modelo = ? , "
                + "anio = ?, servicio = ? , detalle = ? WHERE cedula = ?";
        System.out.println("Cedula para actualizar " + cliente.getCedula());

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = conexionDB.getConnection().prepareStatement(tabla);
            //preparedStatement.setString(1, tabla);

            preparedStatement.setString(1, cliente.getNombre());
            preparedStatement.setString(2, cliente.getApellido());
            preparedStatement.setString(3, cliente.getCelular());
            //preparedStatement.setString(4, cliente.getCelular());
            preparedStatement.setString(4, cliente.getDireccion());
            preparedStatement.setString(5, cliente.getMarca());
            preparedStatement.setString(6, cliente.getModelo());
            preparedStatement.setInt(7, cliente.getAnio());
            preparedStatement.setString(8, cliente.getServicio());
            preparedStatement.setString(9, cliente.getDetalle());
            preparedStatement.setString(10, cliente.getCedula());

            int filasActualizadas = preparedStatement.executeUpdate();
            System.out.println("Filas actualizadas " + filasActualizadas);
            if (filasActualizadas > 0) {
                System.out.println("Actualizado correctamente.");
                return true;
            } else {
                System.out.println("No se encontró el cliente con la cédula proporcionada.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
            return false;
        } finally {
            // Cerrar recursos
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
    }

    // MEtodo eminiar DB
    public boolean eliminarCliente(int idCliente) {
        String tabla = "DELETE FROM clientes WHERE id_cliente = ?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = conexionDB.getConnection().prepareStatement(tabla);
            preparedStatement.setInt(1, idCliente);

            int filasEliminadas = preparedStatement.executeUpdate();
            System.out.println("Filas eliminadas " + filasEliminadas);
            if (filasEliminadas > 0) {
                System.out.println("Eliminado correctamente.");
                return true;
            } else {
                System.out.println("No se encontró el cliente con el ID proporcionado.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
            return false;
        } finally {
            // Cerrar recursos
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
    }

    //METODO BUSCAR POR CEDULA EXISTENTE  / SELECT COUNT(*) FROM WHERE
    //recibe por parametro cedulaIngresada
    public boolean clienteExistente(String cedula) {
        //consulta SQL cuemta cuantas veces aparece la cedula en la DB
        String tabla = "SELECT COUNT(*) FROM clientes WHERE cedula = ?";

        try {

            //Statement ejecuta consultas SQL (SELECT INSERT UPDATE DELETE)
            PreparedStatement preparedStatement = conexionDB.getConnection().prepareStatement(tabla);
            //establece el valor de cedula en la consulta
            preparedStatement.setString(1, cedula);

            //ejecuta la consulta u obtiene el resultado
            ResultSet resultSet = preparedStatement.executeQuery();
            
            //si hay resultados, se comprueba si COUNT(*) es >0
            if(resultSet.next()){
                //retorna tru si hay al menos un registro con la cedual ingresada
                return resultSet.getInt(1)>0;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //Si no hay coincie¿dencias en las cedulas u ocurre un error, retorna False
        return false;
    }

}
