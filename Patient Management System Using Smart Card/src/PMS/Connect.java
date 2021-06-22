/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PMS;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Vijay
 */
public class Connect {
    Connection con = null;
    
     public static Connection ConnectDB(){
             try{
           
          Class.forName("com.mysql.jdbc.Driver");
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hospital","root","root123");
          return con;
            
        }catch(ClassNotFoundException | SQLException e){
                 JOptionPane.showMessageDialog(null, e);
            return null;
    }      
}
}
