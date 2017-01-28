//package com.epam.pages;
//
//import com.epam.base.Driver;
//import com.epam.base.SetProperties;
//import com.epam.base.WaitTool;
//import org.openqa.selenium.By;
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//
//public class DraftsPage {
//
//    private String URL = "https://mail.yandex.by/";
//
//    SetProperties setProperties = new SetProperties();
//    WaitTool waitTool = new WaitTool();
//
//    public DraftsPage(WebDriver driver) {
//    }
//
//    public void doLogin(String userName, String passw) {
//        Driver.Instance.get(URL);
//        waitTool.waitForElementPresent(Driver.Instance, new By.ByXPath("//BUTTON[@class=' nb-button _nb-normal-button new-auth-form-button']"), 5);
//        WebElement login = Driver.Instance.findElement(new By.ByXPath("//input[@name='login']"));
//        login.sendKeys(userName);
//        WebElement password = Driver.Instance.findElement(new By.ByXPath("//input[@name='passwd']"));
//        password.sendKeys((passw));
//        WebElement submit = Driver.Instance.findElement(new By.ByXPath("//button[@type='submit']"));
//        submit.click();
//
//    }
//
//    public void clickCreateNewMail() {
//        WebElement createMail = Driver.Instance.findElement(new By.ByXPath("//a[@data-key='view=toolbar-button-compose-go&id=compose-go']"));
//        createMail.click();
//    }
//
//    public void setToAdress() {
//        WebElement sendTo = Driver.Instance.findElement(new By.ByXPath("//*[@class='js-compose-field mail-Bubbles']"));
//        sendTo.click();
//        sendTo.sendKeys(setProperties.getToAdress());
//    }
//
//    public void setMailSubject() {
//        WebElement subject = Driver.Instance.findElement(new By.ByXPath("//*[@class='mail-Compose-Field-Input-Controller js-compose-field js-editor-tabfocus-prev']"));
//        subject.click();
//        subject.sendKeys(setProperties.getSubj());
//    }
//
//    public void setMailBody() {
//        WebElement mailBody = Driver.Instance.findElement(new By.ByXPath("//*[@id='cke_1_contents']"));
//        mailBody.click();
//        mailBody.sendKeys(setProperties.getMessage());
//    }
//
//    public void clickPopUpSaveChanges() {
//        WebElement popupSaveButton = Driver.Instance.findElement(new By.ByXPath("//button[@data-action='save']"));
//        popupSaveButton.click();
//    }
//
//    public void clickDraftLink() {
//        WebElement draftLink = Driver.Instance.findElement(new By.ByXPath("//a[@data-key='view=folder&fid=6']"));
//        draftLink.click();
//    }
//
//    public void goDraft() {
//        this.clickCreateNewMail();
//        this.setToAdress();
//        this.setMailSubject();
//        this.setMailBody();
//        this.clickDraftLink();
//        this.clickPopUpSaveChanges();
//    }
//
//    public boolean messageIsInDraft() {
//        try {
//            WebElement element = Driver.Instance.findElement(new By.ByXPath("//span[@title='sent via WebDriver']"));
//            return element.isDisplayed();
//        } catch (NoSuchElementException e) {
//            return false;
//        }
//    }
//
//    public void openDraftMessage() {
//        WebElement draftMessage = Driver.Instance.findElement(new By.ByXPath("//span[@title='sent via WebDriver']"));
//        draftMessage.click();
//        waitTool.waitForElementPresent(Driver.Instance, new By.ByXPath("//button[@type='submit']"),5);
//    }
//
//    public String getDraftContentTo() {
//        WebElement toAdress = Driver.Instance.findElement(new By.ByXPath("//div[@name='to']"));
//        return toAdress.getText().toString();
//    }
//
//    public void clickOnSentMail() {
//        WebElement sentLink = Driver.Instance.findElement(new By.ByXPath("//*[@class='svgicon svgicon-mail--Folder_sent mail-NestedList-Item-Icon']"));
//        sentLink.click();
//
//    }
//
//    public void sendTheMail() {
//        WebElement sendButton = Driver.Instance.findElement(new By.ByXPath("//button[@type='submit']"));
//        sendButton.click();
//    }
//
//    public boolean verifyMessageIsInSent() {
//        try {
//            WebElement element = Driver.Instance.findElement(new By.ByXPath("//span[@title='sent via WebDriver']"));
//            return element.isDisplayed();
//        } catch (NoSuchElementException e) {
//            return false;
//        }
//    }
//
//    public void doLogOff() {
//        WebElement userPict = Driver.Instance.findElement(new By.ByXPath("//*[@class='mail-User-Name']"));
//        userPict.click();
//        WebElement exitButton = Driver.Instance.findElement(new By.ByXPath("//*[@data-click-action='common.exitAll']"));
//        exitButton.click();
//    }
//
//}
//
