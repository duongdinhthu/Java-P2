package relearnConectCRUD.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailSender {

    public static void main(String[] args) {
        final String username = "thuddth2307004@fpt.edu.vn";
        final String password = "kyxm zvbz nvsn uxxx";

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("thuddth2307004@fpt.edu.vn"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("duongthutb94@gmail.com"));
            message.setSubject("XML File Email");

            BufferedReader xmlReader = new BufferedReader(new FileReader("product.xml"));
            StringBuilder xmlContent = new StringBuilder();
            String line;
            while ((line = xmlReader.readLine()) != null) {
                xmlContent.append(line);
            }
            xmlReader.close();

            BufferedReader cssReader = new BufferedReader(new FileReader("style.css"));
            StringBuilder cssContent = new StringBuilder();
            while ((line = cssReader.readLine()) != null) {
                cssContent.append(line);
            }
            cssReader.close();

            MimeMultipart multipart = new MimeMultipart();

            MimeBodyPart cssPart = new MimeBodyPart();
            cssPart.setContent("<style>" + cssContent.toString() + "</style>", "text/css");
            multipart.addBodyPart(cssPart);

            MimeBodyPart htmlPart = new MimeBodyPart();
            String htmlContent = "<html><head><style>" + cssContent.toString() + "</style></head><body><div>" + xmlContent.toString() + "</div></body></html>";
            htmlPart.setContent(htmlContent, "text/html");
            htmlPart.setFileName("invoice.html");
            multipart.addBodyPart(htmlPart);

            message.setContent(multipart);

            Transport.send(message);
            System.out.println("Email sent successfully");

        } catch (MessagingException | IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}