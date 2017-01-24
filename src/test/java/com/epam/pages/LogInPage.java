package com.epam.pages;

import com.epam.base.BaseClass;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;

public class LogInPage {

    String url = "https://mail.yandex.by/";
    String userName = "testtask28";
    private String passw = "testtask28testtask28";

    private WebDriver driver = new BaseClass().initDriver();

    public void setUserName(String userName) {
        driver.get(url);
        WebElement login = driver.findElement(new By.ByXPath("//input[@name='login']"));
        login.sendKeys(userName);
    }

    public void setPassword(String passw) {
        WebElement password = driver.findElement(new By.ByXPath("//input[@name='passwd']"));
        password.sendKeys((passw));
    }

    public void clickSubmit() {
        WebElement submit = driver.findElement(new By.ByXPath("//button[@type='submit']"));
        submit.click();
    }

    public void doLogin() {
        this.setUserName(userName);
        this.setPassword(passw);
        this.clickSubmit();
    }

    public boolean userPresented() {
        try {
            WebElement element = driver.findElement(new By.ByXPath("//span[@class='mail-NestedList-Item-Name js-folders-item-name' and text()='Входящие']"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }

    }
}





