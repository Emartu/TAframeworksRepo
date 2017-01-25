package com.epam.base;


public class SetProperties {

    private String name = "webdriver.gecko.driver";
    private String path = "resource\\geckodriver-v0.13.0-win64\\geckodriver.exe";
    private String url = "https://mail.yandex.by/";
    private String userName = "testtask28";
    private String passw = "testtask28testtask28";
    private String toAdress = "emartu@yandex.ru";
    private String subj = "sent via WebDriver";
    private String message = "Test message ... ";

    public SetProperties() {
    }

    public void setSystemProperty() {
        System.setProperty(name, path);
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrlValue(String urlValue) {
        this.url = urlValue;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userNameValue) {
        this.url = userNameValue;
    }

    public String getPassw() {
        return this.passw = passw;
    }

    public void setPassw(String passwValue) {
        this.passw = passwValue;
    }

    public String getToAdress() {
        return this.toAdress = toAdress;
    }

    public void setToAdress(String toAdressValue) {
        this.passw = toAdressValue;
    }

    public String getSubj() {
        return this.subj = subj;
    }

    public void setSubj(String subjValue) {
        this.subj = subjValue;
    }

    public String getMessage() {
        return this.message = message;
    }

    public void setMessage(String messageValue) {
        this.message = messageValue;
    }


}
