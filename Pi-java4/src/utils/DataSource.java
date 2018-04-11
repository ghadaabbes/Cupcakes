/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Siala
 */
public class DataSource {
    
    String url="jdbc:mysql://localhost:3306/fos_user";
    String login = "root";
    String password = "";
    private Connection connection;
    private static DataSource insatance;

    private DataSource() {
       
        try {
            
            connection = DriverManager.getConnection(url, login, password);
        } catch (SQLException ex) {
             throw new RuntimeException(ex);
        }
    }

    public Connection getConnection() {
        return connection;
    }
    

    public static DataSource getInsatance() {
        if (insatance == null) {
            insatance = new DataSource();
        }
        return insatance;
    }

}
