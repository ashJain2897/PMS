

import com.mysql.jdbc.Driver;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vijay
 */
public class MysqlType4DriverDemo {
 
  public static void main(String[] args)throws SQLException {
        String url="jdbc:mysql://localhost:3306/hospital";
        Properties prop=new Properties();
        prop.setProperty("user","root");
        prop.setProperty("password","");
        Driver d=new com.mysql.jdbc.Driver();
        Connection con = d.connect(url,prop);
        if(con==null)   {
            System.out.println("connection failed");
            return;
        }
        DatabaseMetaData dm =con.getMetaData();
        String dbversion=dm.getDatabaseProductVersion();
        String dbname=dm.getDatabaseProductName();
        System.out.println("name:"+dbname);
        System.out.println("version:"+dbversion);

    }
}
