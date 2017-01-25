package com.epam.pages;

import com.epam.base.BaseClass;
import com.epam.base.SetProperties;
import com.epam.base.WaitTool;
import org.jboss.netty.util.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class NewMailPage {

    //private final String CONST = "const xpath";

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

    public void clickCreateNewMail() {
        WebElement createMail = driver.findElement(new By.ByXPath("//a[@data-key='view=toolbar-button-compose-go&id=compose-go']"));
        createMail.click();
    }

    public void setToAdress() {
        WebElement sendTo = driver.findElement(new By.ByXPath("//*[@class='js-compose-field mail-Bubbles']"));
        sendTo.click();
        sendTo.sendKeys(setProperties.getToAdress());
    }

    public void setMailSubject() {
        WebElement subject = driver.findElement(new By.ByXPath("//*[@class='mail-Compose-Field-Input-Controller js-compose-field js-editor-tabfocus-prev']"));
        subject.click();
        subject.sendKeys(setProperties.getSubj());
    }

    public void setMailBody() {
        WebElement mailBody = driver.findElement(new By.ByXPath("//*[@id='cke_1_contents']"));
        mailBody.click();
        mailBody.sendKeys(setProperties.getMessage());

    }

    public void clickSendButton() {
        WebElement sendButton = driver.findElement(new By.ByXPath("//button[@type='submit']"));
        sendButton.click();
        Timeout.sleep(2);
    }

    public void sendNewMail() {
        this.clickCreateNewMail();
        this.setToAdress();
        this.setMailSubject();
        this.setMailBody();

        this.clickSendButton();
    }

    public boolean messageIsSent() {
        try {
            WebElement element = driver.findElement(new By.ByXPath("//*[@class='mail-Done-Title js-title-info']"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
