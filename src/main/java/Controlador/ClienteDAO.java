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

/**
 *
 * @author juand
 */
public class ClienteDAO {

    //METODO SELECT DB ** SELECCIONA TODOS LOS REGISTRO DE LA TABLA
    public List<Cliente> SelectClientes() {
        List<Cliente> listaCliente = new ArrayList<>();

        String tabla = "SELECT * FROM clientes";//tabla clientes DB

        try {
            Connection connection = ConexionDB.getConnection();//metodo Connection
            //Statement ejecuta consultas SQL (SELECT INSERT UPDATE DELETE)
            Statement statement = connection.createStatement();
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

    //METODO INSERT DB
    public void insertarDatos(Cliente cliente) {

        String tabla = "INSERT INTO clientes (nombre, apellido, "
                + "cedula,celular, direccion, marca, modelo, anio, servicio, detalle) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?)";

        try {
            Connection connection = ConexionDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(tabla);
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
        Cliente cliente = null;
        
        String tabla;//tabla clientes DB
        tabla = "SELECT * FROM clientes WHERE cedula = ?";

        try {
            Connection connection = ConexionDB.getConnection();//metodo Connection
            //Statement ejecuta consultas SQL (SELECT INSERT UPDATE DELETE)
            PreparedStatement preparedStatement = connection.prepareStatement(tabla);
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
            System.out.println("(UPDATE) Error de Busqueda a TABLA clientes de DB");
        }
        return cliente;
    }

    //METODO UPDATE DB
    public void updateCliente(Cliente cliente) {
        String tabla = "UPDATE clientes WHERE cedula=?"
                + "WHERE id_cliente";
        try {
            Connection connection = ConexionDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(tabla);
            preparedStatement.setString(1, tabla);
            
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
            System.out.println("Actualizado correctamente");

        } catch (SQLException e) {
            System.out.println("Error al actualizar" + e.getMessage());
        }

    }

}
