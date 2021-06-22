/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PMS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Vijay
 */
public class Test {
    
 public int getRowNumber(){

   int numberRow = 0;
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

try{
    
    
    con = Connect.ConnectDB();
    String query = "select count(*) as vijay from Doctor";
    
    
    pst = con.prepareStatement(query);
    
    rs = pst.executeQuery(query);
    while(rs.next()){
        numberRow = rs.getInt("vijay");
    }
    con.close();
}catch (Exception ex){
    System.out.println(" Error While Connection ");
}

return numberRow;
}
 
}
