package com.epam.base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
    WebDriver driver;

    public BaseClass() {
        initDriver();
    }

    public WebDriver initDriver() {
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

}
