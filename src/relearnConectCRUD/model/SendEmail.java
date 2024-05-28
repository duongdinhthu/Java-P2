package relearnConectCRUD.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEmail {
    public static void main(String[] args) {
        final String username = "thuddth2307004@fpt.edu.vn";
        final String password = "kyxm zvbz nvsn uxxx";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2"); // Sử dụng giao thức TLS 1.2

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

            // Đọc nội dung từ file XML và file XSL
            BufferedReader xmlReader = new BufferedReader(new FileReader("product.xml"));
            StringBuilder xmlContent = new StringBuilder();
            String line;
            while ((line = xmlReader.readLine()) != null) {
                xmlContent.append(line);
            }
            xmlReader.close();

            BufferedReader cssReader = new BufferedReader(new FileReader("style.xsl"));
            StringBuilder cssContent = new StringBuilder();
            while ((line = cssReader.readLine()) != null) {
                cssContent.append(line);
            }
            cssReader.close();

            // Tạo phần body của email với file HTML nhúng file XML và file XSL
            MimeMultipart multipart = new MimeMultipart();

            // MimeBodyPart cho CSS content
            MimeBodyPart cssPart = new MimeBodyPart();
            cssPart.setContent("<style>" + cssContent.toString() + "</style>", "text/css");
            message.setContent(cssContent.toString(), "text/css");
            multipart.addBodyPart(cssPart);

            // MimeBodyPart cho HTML content
            MimeBodyPart htmlPart = new MimeBodyPart();
            htmlPart.setContent("<html><head><link rel=\"stylesheet\" type=\"text/css\" href=\"style.xsl\"></head><body><div>" + xmlContent.toString() + "</div></body></html>", "text/html");
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