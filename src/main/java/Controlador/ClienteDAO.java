/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Cliente;
import Modelo.ConexionDB;
import Modelo.Servicio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author juand
 */
public class ClienteDAO {
    //Select DB 

    public void SelectClientes() {

        String tabla = "SELECT * FROM clientes";//tabla clientes DB

        try {
            Connection connection = ConexionDB.getConnection();//metodo Connection
            //Statement ejecuta consultas SQL (SELECT INSERT UPDATE DELETE)
            Statement statement = connection.createStatement();
            //ResultSet Almacena y procesa resultados de consulta SQL
            ResultSet resultSet = statement.executeQuery(tabla);

            while (resultSet.next()) {
                int id_cliente = resultSet.getInt("id_cliente");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                String cedula = resultSet.getString("cedula");
                String celular = resultSet.getString("celular");
                String direccion = resultSet.getString("direccion");
                String marca = resultSet.getString("marca");
                String modelo = resultSet.getString("modelo");
                int anio = resultSet.getInt("anio");
                String servicio = resultSet.getString("servicio");
                String detalle = resultSet.getString("detalle");

                //Imprimir en consola Tabla
                System.out.println("ID: " + id_cliente + "| Nombre: " + nombre
                        + " |Apellido: " + apellido + " |Cédula: " + cedula
                        + " |Celular: " + celular + " |Dirección: " + direccion
                );
                System.out.println("Marca Vehiculo : " + marca + " |Modelo: " + modelo
                        + " |Año: " + anio + " |Servicio: " + servicio
                        + " |Detalle: " + detalle);

            }

        } catch (SQLException e) {
            System.out.println("Error de consulta a TABLA clientes de DB");
        }

    }

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
