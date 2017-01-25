package com.epam.pages;

import com.epam.base.BaseClass;
import com.epam.base.SetProperties;
import com.epam.base.TimeOut;
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
    TimeOut timeout = new TimeOut();


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
        timeout.sleep(4);

    }

//    public void clickSendButton() {
//        WebElement sendButton = driver.findElement(new By.ByXPath("//button[@type='submit']"));
//        sendButton.click();
//    }

    public void clickPopUpSaveChanges() {
        WebElement popupSaveButton = driver.findElement(new By.ByXPath("//button[@data-action='save']"));
        popupSaveButton.click();
        timeout.sleep(2);
    }

    public void clickDraftLink() {
        WebElement draftLink = driver.findElement(new By.ByXPath("//a[@data-key='view=folder&fid=6']"));
        draftLink.click();
    }

    public void goDraft() {
        this.clickCreateNewMail();
        this.setToAdress();
        this.setMailSubject();
        this.setMailBody();
        this.clickDraftLink();
        this.clickPopUpSaveChanges();
    }

    public boolean messageIsInDraft() {
        try {
            WebElement element = driver.findElement(new By.ByXPath("//span[@title='sent via WebDriver']"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

//    public boolean messageIsSent() {
//        try {
//            WebElement element = driver.findElement(new By.ByXPath("//*[@class='mail-Done-Title js-title-info']"));
//            return true;
//        } catch (NoSuchElementException e) {
//            return false;
//        }
//    }
}
