/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PMS;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

/**
 *
 * @author ASH
 */
public class ForgotPassword {
    
    public void Send(String email,String user,String pass) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("pmsmailingsystem@gmail.com","PMS12345");
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("pmsmailingsystem@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(email));
			message.setSubject("Forgot Password");
			message.setText("\n Username : "+ user +
					"\n Password : "+ pass);

			Transport.send(message);

			JOptionPane.showMessageDialog(null," Password Send to your email ", " Information ",JOptionPane.INFORMATION_MESSAGE);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
