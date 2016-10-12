package com.apress.prospring2.ch13.simple;

/**
 * @author anirvanc
 */
public class SimpleMailTest {
    private static final String TO = "anirvanc@cakesolutions.net";
    private static final String JAVAMAIL_TEXT = "Hello World! Email generated using JavaMail.";
    private static final String COS_TEXT = "Hello World! Email generated using COS MailMessage.";

    public static void main(String[] args) {
        
        SimpleMailSender sender1 = new JavaMailSimpleMailSender();
        SimpleMailSender sender2 = new CosSimpleMailSender();

        sender1.sendMessage(TO, JAVAMAIL_TEXT);
        sender2.sendMessage(TO, COS_TEXT);
    }    
}
