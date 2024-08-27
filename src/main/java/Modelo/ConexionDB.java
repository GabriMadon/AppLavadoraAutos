/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Controlador.ClienteDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author juand
 */
//Class Conexion a db_lavadora_autos Mysql Workbrench
public class ConexionDB {
    //ATRIBUTIS
    //statci variable de instancia // final = constante
    private static final String URL ="jdbc:mysql://localhost:3306/db_lavadora_autos";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    //METODOS
    //Connection DB
    public static Connection getConnection(){
        Connection connection = null;
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("Conexxion exitosa a la base de datos");
        }catch(SQLException| ClassNotFoundException e){
            System.out.println("Error de conexion: " + e.getMessage());
        }
        return connection;
    }
    
   
    
    //Main para probar conexio DB
     public static void main(String[] args) {
        ConexionDB db = new ConexionDB();
        Connection conn = db.getConnection();
        ClienteDAO clienteDao = new ClienteDAO();
        clienteDao.SelectClientes();
        
      
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Conexión cerrada correctamente.");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
     
}
