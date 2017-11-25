/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author 58011424
 */
public class SendEmailController {
    protected final String host ="smtp.gmail.com" ;
    protected final String user = "owl.express.service@gmail.com";
    protected final String pass = "sabnlbmdbmqhlilq";
    protected String to;
    protected final String from = "owl.express.service@gmail.com";
    protected String verify;
    String subject;
    String messageText;
    
    public SendEmailController(String to) {
        this.to = to;
    }
    public void sendEmail(String subject, String messageText, String verifyCode){
        try{
            this.verify = verifyCode;
            this.subject = subject;
            this.messageText = messageText;
            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", this.host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            //Weneed security so java already provide securrity
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(this.from));
            InternetAddress[] address = {new InternetAddress(this.to)}; //Address of header
            msg.setRecipients(Message.RecipientType.TO, address);//Receiver email
            msg.setSubject(subject); msg.setSentDate(new Date());//Message send data
            msg.setContent(messageText,"text/html");//Actual message

           Transport transport=mailSession.getTransport("smtp");//Server through which we are going to send msg
           transport.connect(this.host, this.user, this.pass);//We need because we have to authenticate sender email and password
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           System.out.println("message send successfully");
        }catch(Exception ex)
        {
            System.out.println(ex);//if any error occur then error message will print3
        }
    }
    public String getVerify() {
        return verify;
    }
    
    public static String getRandomWord() {
        String r = "";
        for(int i = 0; i < 4; i++) {
            r += (char)(Math.random() * 26 + 97);
        }
        return r;
    }
}
