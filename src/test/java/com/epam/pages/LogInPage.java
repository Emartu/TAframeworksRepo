package com.epam.pages;

import com.epam.base.BaseClass;
import com.epam.base.SetProperties;
import com.epam.base.WaitTool;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;

public class LogInPage {

    SetProperties setProperties = new SetProperties();
    public static WebDriver driver = new BaseClass().initDriver();
    WaitTool waitTool = new WaitTool();

    public void setUserName(String userName) {
        driver.get(setProperties.getUrl());
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
        this.setUserName(setProperties.getUserName());
        this.setPassword(setProperties.getPassw());
        this.clickSubmit();
        waitTool.waitForElementPresent(driver, new By.ByXPath("//*[@class='mail-User-Name']"), 5);
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





