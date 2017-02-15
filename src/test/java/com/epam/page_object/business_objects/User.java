package com.epam.page_object.business_objects;


public class User {

    private static String password;
    private static String login;
    private static String mailBoxURL;

    public User() {
    }

    public static String getMailBoxURL() {
        return mailBoxURL;
    }

    public static void setMailBoxURL(String mailBoxURL) {
        User.mailBoxURL = mailBoxURL;
    }

    public static void setPassword(String password) {
        User.password = password;
    }

    public static void setLogin(String login) {
        User.login = login;
    }

    public static String getPassword() {
        return password;
    }

    public static String getLogin() {
        return login;
    }

}
