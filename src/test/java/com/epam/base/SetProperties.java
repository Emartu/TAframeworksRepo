package com.epam.base;


public class SetProperties {

    private String name = "webdriver.gecko.driver";
    private String path = "resource\\geckodriver-v0.13.0-win64\\geckodriver.exe";

    public SetProperties() {
    }

    public void setSystemProperty() {
        System.setProperty(name, path);
    }
}
