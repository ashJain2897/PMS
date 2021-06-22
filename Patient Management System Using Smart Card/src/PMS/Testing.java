/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PMS;

import java.io.File;
import vijay.*;
import javafx.application.Application;
import javax.swing.JOptionPane;

/**
 *
 * @author ASH
 */

  public class Testing {
      public static void main(String args[]){
          String user = System.getProperty("user.name");
          File file = new File("C:\\PMS\\");
        if (!file.exists()) {
            if (!file.mkdir()) {
               JOptionPane.showMessageDialog(null, " Error While Creating Diectory ", " Error ", JOptionPane.OK_OPTION);
                System.exit(0);
            } 
        }
         Application.launch(Vijay.class, args);
      }
/*public static void main(String args[]){
  Calendar date = new GregorianCalendar();
int year = date.get(Calendar.YEAR);  // 2012
System.out.println(year);
int month = date.get(Calendar.MONTH);  // 9 - October!!!
System.out.println(month);
int day = date.get(Calendar.DAY_OF_MONTH);  // 5
System.out.println(day);
}*/
  }