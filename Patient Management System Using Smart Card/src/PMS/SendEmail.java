/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PMS;

/**
 *
 * @author ASH
 */

import java.util.Properties;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;
import loaders.Sending;

public class SendEmail {
     
//public  SendEmail(String filename , String id){
    
//}
public void send2(String filename , String id , String mail_id) {

    //Sending frm = new Sending();
    
    final String username = "pmsmailingsystem@gmail.com"; //ur email
    final String password = "PMS12345";

    Properties props = new Properties();
    props.put("mail.smtp.auth", true);
    props.put("mail.smtp.starttls.enable", true);
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");

    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
    }                            
});

    try {
        
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("pmsmailingsystem@gmail.com"));//ur email
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(mail_id));//u will send to
        message.setSubject("Success");    
        message.setText("PFA");
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        Multipart multipart = new MimeMultipart();


     
     
    //attached  --------------------------------------------
        String file = "C:\\PMS\\"+id+"\\"+filename;
        String fileName = filename;
        messageBodyPart = new MimeBodyPart();   
        DataSource source = new FileDataSource(file);      
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName(fileName);
        multipart.addBodyPart(messageBodyPart);
    /*------------------------------------------------------------------*/
        message.setContent(multipart);

        //JOptionPane.showMessageDialog(null,"Sending");
        
        //System.out.println("sending");
        
        JOptionPane.showMessageDialog(null," Sending ");
        Transport.send(message);
       
        //frm.dispose();
        
        JOptionPane.showMessageDialog(null," Mail is Send ");
        
        //System.out.println("Done");
        
   

            
    }catch (MessagingException e) {
        //frm.dispose();
        System.out.println(e);
        JOptionPane.showMessageDialog(null," Error while send the mail");
        //System.out.println("Error");
    }
  }

    public static void main(String[] args) {
        //SendEmail s = new SendEmail();
        //send2();
    }
}
    
