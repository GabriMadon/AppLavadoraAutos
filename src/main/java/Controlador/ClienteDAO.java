/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Cliente;
import Modelo.ClienteServicio;
import Modelo.ConexionDB;
import Modelo.Servicio;
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
    //METODO SELECT DB

    public List<ClienteServicio> SelectClientes() {
        List<ClienteServicio> listaClienteServicio = new ArrayList<>();

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
                        resultSet.getInt("anio")
                );
                Servicio servicio = new Servicio(
                        resultSet.getString("servicio"),
                        resultSet.getString("detalle"));

             ClienteServicio clienteServicio = new ClienteServicio(cliente, servicio);
             listaClienteServicio.add(clienteServicio);
            }

        } catch (SQLException e) {
            System.out.println("Error de consulta a TABLA clientes de DB");
        }
        return listaClienteServicio;
    }

    //METODO INSERT DB
    public void insertarDatos(Cliente cliente, Servicio servicio) {
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
            preparedStatement.setString(9, servicio.getServicio());
            preparedStatement.setString(10, servicio.getDetalle());

            preparedStatement.executeUpdate();
            System.out.println("Usuario registrado correctamente");

        } catch (SQLException e) {
            System.out.println("Error al registrar Cliente" + e.getMessage());
        }

    }

}
