package Modelo;

import java.sql.*;

public class Conexion {

    private static Connection con = null;
    public static String TipoCon = "";

    //patron singleton
    public static Connection getConexion() {
        try {
            if (con == null) {    
                
                String url = "jdbc:mysql://www.hostinger.co:3306/u543362989_jccs";                
                String pwd = "0cmjGMtv4RyA";             
                String usr = "u543362989_jccs";               
                String driver = "com.mysql.jdbc.Driver"; //el driver varia segun la DB que usemos            
                Class.forName(driver);            
                con = DriverManager.getConnection(url, usr, pwd);                
                System.out.println("conectado");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("error "+e.getMessage());
        }
        return con;
    }

    public static Connection closeConexion() {
        con = null;
        return con;
    }
}
