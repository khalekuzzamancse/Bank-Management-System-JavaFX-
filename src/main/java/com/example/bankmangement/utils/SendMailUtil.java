package com.example.bankmangement.utils;


public class SendMailUtil {
    private final EmailSenderUtil emailSenderUtil = new EmailSenderUtil();
    public void send(String email,String sub, String msg) {
            boolean b = emailSenderUtil.sendEmail(email, "khalekuzzamancse@gmail.com", sub,msg);
            if (b) {
                System.out.println("Email is sent successfully to: "+email);
            } else {
                System.out.println("There is problem in sending email to: "+email);
            }
        }
}
