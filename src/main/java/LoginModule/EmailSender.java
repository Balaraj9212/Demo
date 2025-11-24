package LoginModule;

import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.util.Arrays;
import java.util.Properties;
import java.io.File;


public class EmailSender {

    public static void sendReportEmail() {
        final String fromEmail = "balaraj@connectm.com"; // Sender's email
        final String password = "Connect@321"; // Use app password if using Gmail
        final String[] toEmail = {"balaraj@connectm.com","balumg195@gmail.com"}; // Receiver's email
    
        // SMTP configuration
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.office365.com"); // Outlook SMTP
        props.put("mail.smtp.port", "587"); // TLS Port
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");


        // Create session with authentication
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            // Compose the email
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(String.join(",", toEmail)));
            message.setSubject("Extent Test Report");

            // Email body
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(
                    "<table style='font-family: Arial, sans-serif; border: 1px solid #ddd; padding: 20px; width: 100%; max-width: 600px;'>" +
                            "<tr>" +
                            "<td style='text-align: center;'>" +
                            "<img src=https://www.connectm.com/wp-content/themes/connectm/assets/img/logo-ConnectM.svg alt='Extent Logo' style='height: 50px; margin-bottom: 20px;'/>" +
                            "</td>" +
                            "</tr>" +
                            "<tr>" +
                            "<td>" +
                            "<h2 style='color: #2E86C1; text-align: center;'>Automation Test Report</h2>" +
                            "<p>Hi Team,</p>" +
                            "<p>Please find the attached <strong>Extent Report</strong> for the latest test execution.</p>" +
                            "<ul>" +
                            "<li><strong>Date:</strong> " + java.time.LocalDate.now() + "</li>" +
                            "<li><strong>Executed By:</strong> Automation Framework</li>" +
                            "</ul>" +
                            "<p>Kindly review the report and reach out in case of any concerns.</p>" +
                            "<p>Regards,<br><b>Automation Team</b></p>" +
                            "<hr>" +
                            "<p style='font-size: 12px; color: gray;'>This is an automated email. Please do not reply.</p>" +
                            "</td>" +
                            "</tr>" +
                            "</table>",
                    "text/html"
            );



            // Attachment
            MimeBodyPart attachmentPart = new MimeBodyPart();
            String filePath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
            attachmentPart.attachFile(new File(filePath));

            // Combine parts
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachmentPart);

            message.setContent(multipart);

            // Send email
            Transport.send(message);
            System.out.println("Email sent successfully with Extent Report!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

