package com.epam.page_object.business_objects;

public class MailData {

    private static String to;
    private static String subject;
    private static String mailBody;

    public MailData(){

    }

    public static String getTo() {
        return to;
    }

    public static void setTo(String to) {
        MailData.to = to;
    }

    public static String getSubject() {
        return subject;
    }

    public static void setSubject(String subject) {
        MailData.subject = subject;
    }

    public static String getMailBody() {
        return mailBody;
    }

    public static void setMailBody(String mailBody) {
        MailData.mailBody = mailBody;
    }
}
