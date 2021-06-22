
package vijay;

import PMS.Connect;
import PMS.ForgotPassword;
import loaders.Loading;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.awt.HeadlessException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javax.swing.JOptionPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Vijay
 */
public class FXMLDocumentController implements Initializable {
        
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs;
    
    @FXML private JFXButton login;
    @FXML private AnchorPane Main;
    @FXML private Label signin;
    @FXML private JFXTextField user;
    @FXML private JFXPasswordField pass;
    /************************************/
    @FXML
    public void exit(){
        System.exit(0);
    }
    /**********************************/
    
    
    @FXML
    private void Forgot() {
        if (user.getText().equals("")) {
            JOptionPane.showMessageDialog( null, "Entet user name","Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
       
        con = Connect.ConnectDB();
        String sql = "SELECT * FROM Login WHERE uname = '"+user.getText()+"'";

        try{
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
                String email = rs.getString("uemail");
                System.out.println(email);
                
                String pass = rs.getString("pass");
                System.out.println(pass);
                
                String user = rs.getString("uname");
                
                ForgotPassword fp = new ForgotPassword();
                fp.Send(email,user, pass);
            }

            else{
                JOptionPane.showMessageDialog(null, " Invalid Username ","Error",JOptionPane.ERROR_MESSAGE);
                
            }
        } catch (SQLException  | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Database Not Connectd or Else ","Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    /**********************************/
    @FXML
    private void LoginUser() throws ClassNotFoundException {
 
       
        
        if (user.getText().equals("")) {
            JOptionPane.showMessageDialog( null, "Entet user name","Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String Password= String.valueOf(pass.getText());
        if (Password.equals("")) {
            JOptionPane.showMessageDialog( null, "Invalid Password","Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        con = Connect.ConnectDB();
        String sql = "SELECT * FROM Login WHERE uname = '"+user.getText()+"' AND pass = '"+pass.getText()+"'";

        try{
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
                Loading frm = new Loading();
                frm.start(0);
                Stage stage = (Stage) login.getScene().getWindow();
                stage.close();
                
            }

            else{
                JOptionPane.showMessageDialog(null, " Invalid User or Password ","Access denied",JOptionPane.ERROR_MESSAGE);
                
            }
        } catch (SQLException  | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Database Not Connectd or Else ","Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
        }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    
    
}
