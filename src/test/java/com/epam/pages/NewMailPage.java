package com.epam.pages;

import com.epam.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class NewMailPage {

    String url = "https://mail.yandex.by/";
    String userName = "testtask28";
    private String passw = "testtask28testtask28";
    String toAdress = "emartu@yandex.ru";
    String subj = "sent via WebDriver";
    String message = "Test message ... ";
    //private final String CONST = "const xpath";

    private WebDriver driver = new BaseClass().initDriver();

    public void openPage() {
        driver.get(url);
    }

    public void setUserName(String userName) {
        //   driver.get(url);
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
        this.openPage();
        this.setUserName(userName);
        this.setPassword(passw);
        this.clickSubmit();
    }

    public void clickCreateNewMail() {
        WebElement createMail = driver.findElement(new By.ByXPath("//a[@data-key='view=toolbar-button-compose-go&id=compose-go']"));
        createMail.click();
    }

    public void setToAdress() {
        WebElement sendTo = driver.findElement(new By.ByXPath("//*[@class='js-compose-field mail-Bubbles']"));
        sendTo.click();
        sendTo.sendKeys(toAdress);
    }

    public void setMailSubject() {
        WebElement subject = driver.findElement(new By.ByXPath("//*[@class='mail-Compose-Field-Input-Controller js-compose-field js-editor-tabfocus-prev']"));
        subject.click();
        subject.sendKeys(subj);
    }

    public void setMailBody() {
        WebElement mailBody = driver.findElement(new By.ByXPath("//*[@id='cke_1_contents']"));
        mailBody.click();
        mailBody.sendKeys(message);
    }

    public void clickSendButton() {
        WebElement sendButton = driver.findElement(new By.ByXPath("//button[@type='submit']"));
        sendButton.click();
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
