package Control;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thinkpad
 */
public class MySQLConn {
    public PreparedStatement connect(String query){
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MySQLConn.class.getName()).log(Level.SEVERE, null, ex);
            }

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kkp", "root", "");

            PreparedStatement stm = conn.prepareStatement(query);
            return stm;

        } catch (SQLException ex) {
            Logger.getLogger(MySQLConn.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    
    public Connection getConnection(){
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MySQLConn.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/kkp", "root","");
            
            return conn;
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}