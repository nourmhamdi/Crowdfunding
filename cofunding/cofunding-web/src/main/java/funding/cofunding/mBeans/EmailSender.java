package funding.cofunding.mBeans;
import java.io.Serializable;
import java.util.Properties;

import javax.faces.bean.ManagedBean;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


@ManagedBean
public class EmailSender implements Serializable {
	public void sendMail () throws AddressException, MessagingException {
	Properties props=System.getProperties();
	props.put("mail.smtp.host", "smtp.gmail.com");
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.port", "465");
	props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	props.put("mail.smtp.socketFactory.port", "465");
	props.put("mail.smtp.socketFactory.failback", "false");
	
	
	try {
	   
	    Session	session= Session.getInstance(props);
	
	    Message		message	    = new MimeMessage(session);
	    InternetAddress	recipient   = new InternetAddress("mellassighada8@gmail.com");
	    message.setRecipient(Message.RecipientType.TO, recipient);
	    message.setSubject("Hello JavaMail");
	    message.setText("JavaMail vous dit bonjour!");
 
	    Transport.send(message);
	}
	catch(NoSuchProviderException e) {
	    System.err.println("Pas de transport disponible pour ce protocole");
	    System.err.println(e);
	}
	catch(AddressException e) {
	    System.err.println("Adresse invalide");
	    System.err.println(e);
	}
	catch(MessagingException e) {
	    System.err.println("Erreur dans le message");
	    System.err.println(e);
	}
    }
}
