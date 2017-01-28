package com.epam.pages;

import com.epam.base.Driver;
import com.epam.base.WaitTool;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class NewMailPage {

    private WaitTool waitTool = new WaitTool();

    public NewMailPage(WebDriver driver) {
    }

    public void goToUrl(String URL) {
        Driver.Instance.get(URL);
    }

    public void doLogin(String userName, String passw) {
        waitTool.waitForElementPresent(Driver.Instance, new By.ByXPath("//BUTTON[@class=' nb-button _nb-normal-button new-auth-form-button']"), 5);
        WebElement login = Driver.Instance.findElement(new By.ByXPath("//input[@name='login']"));
        login.sendKeys(userName);
        WebElement password = Driver.Instance.findElement(new By.ByXPath("//input[@name='passwd']"));
        password.sendKeys((passw));
        WebElement submit = Driver.Instance.findElement(new By.ByXPath("//button[@type='submit']"));
        submit.click();

    }

    public void clickCreateNewMail() {
        WebElement createMail = Driver.Instance.findElement(new By.ByXPath("//a[@data-key='view=toolbar-button-compose-go&id=compose-go']"));
        createMail.click();
    }

    public void setToAdress(String toAdress) {
        WebElement sendTo = Driver.Instance.findElement(new By.ByXPath("//*[@class='js-compose-field mail-Bubbles']"));
        sendTo.click();
        sendTo.sendKeys(toAdress);
    }

    public void setMailSubject(String mailSubject) {
        WebElement subject = Driver.Instance.findElement(new By.ByXPath("//*[@class='mail-Compose-Field-Input-Controller js-compose-field js-editor-tabfocus-prev']"));
        subject.click();
        subject.sendKeys(mailSubject);
    }

    public void setMailBody(String mailBody) {
        WebElement Body = Driver.Instance.findElement(new By.ByXPath("//*[@id='cke_1_contents']"));
        Body.click();
        Body.sendKeys(mailBody);
    }

    public void clickPopUpSaveChanges() {
        WebElement popupSaveButton = Driver.Instance.findElement(new By.ByXPath("//button[@data-action='save']"));
        popupSaveButton.click();
    }

    public void clickDraftLink() {
        WebElement draftLink = Driver.Instance.findElement(new By.ByXPath("//a[@data-key='view=folder&fid=6']"));
        draftLink.click();
    }

    public boolean messageIsInDraft() {
        try {
            WebElement element = Driver.Instance.findElement(new By.ByXPath("//span[@title='sent via WebDriver']"));
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
