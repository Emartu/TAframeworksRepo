package com.epam.page_object.business_objects;


import com.epam.page_object.test_data.TestInput;

public class User {

    private static String password;
    private static String login;
    private static String mailBoxURL;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.mailBoxURL = mailBoxURL;
    }

    public static String getMailBoxURL() {
        return mailBoxURL;
    }

    public void setMailBoxURL(String mailBoxURL) {
        User.mailBoxURL = mailBoxURL;
    }

    public void setPassword(String password) {
        User.password = password;
    }

    public static String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        User.login = login;
    }

    public static String getLogin() {
        return login;
    }

//    public void setUser() {
//        User user = new User();
//        user.setMailBoxURL(TestInput.mailBoxUrl);
//        user.setLogin(TestInput.login);
//        user.setPassword(TestInput.password);
//    }
}
