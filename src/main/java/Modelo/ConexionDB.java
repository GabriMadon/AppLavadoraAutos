/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Class Conexion a db_lavadora_autos Mysql Workbrench
public class ConexionDB {

    //ATRIBUTIS
    //statci variable de instancia // final = constante
    private static final String URL = "jdbc:mysql://";
    private static final String USER = "";
    private static final String PASSWORD = "";
    private Connection connection;

    //CONSTRUCTOR
    //Connection DB
    public ConexionDB() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexxion exitosa a la base de datos");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error de conexion: " + e.getMessage());
        }
    }
    //METODOS

    public Connection getConnection() {
        return connection;
    }
    //cerramos la conexion despues de la consulta para que no consuma recursos
    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
