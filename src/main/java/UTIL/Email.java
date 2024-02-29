package UTIL;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import DTO.Aluno;

public class Email {
		private static String emailFrom = "gleisonschlemper532@gmail.com"; // Email institucional 
		private static String passwordFrom = "tnup difh capv dfig"; // Senha de aplicação

	    public static String enviar(Aluno stutent,String subject, String content ) {
	    	Properties properties = new Properties();
	        properties.put("mail.smtp.host", "smtp.gmail.com");
	        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	        properties.setProperty("mail.smtp.starttls.enable", "true");
	        properties.setProperty("mail.smtp.port", "587");
	        properties.setProperty("mail.smtp.user", emailFrom);
	        properties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
	        properties.setProperty("mail.smtp.auth", "true");

	        Session mSession = Session.getDefaultInstance(properties);

	        try {
	            MimeMessage mCorreo = new MimeMessage(mSession);
	            mCorreo.setFrom(new InternetAddress(emailFrom));
	            mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(stutent.getEmail()));
	            mCorreo.setSubject(subject);
	            mCorreo.setText(content, "ISO-8859-1", "html");

	            // Código para enviar o e-mail
	            Transport transport = mSession.getTransport("smtp");
	            transport.connect(emailFrom, passwordFrom);
	            transport.sendMessage(mCorreo, mCorreo.getAllRecipients());
	            transport.close();

	            return "E-mail enviado com sucesso!";
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return "E-mail não enviado";
	    }

	    public static void main(String[] args) {
	        //enviar();
	    }
}
