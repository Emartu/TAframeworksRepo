package com.epam.page_fact.pages;

import com.epam.page_fact.base.WaitTool;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


public class NewMailPage {

    private WaitTool waitTool = new WaitTool();
    private final WebDriver driver;

    @FindBy(xpath = "//input[@name='login']")
    private WebElement login;

    @FindBy(xpath = "//input[@name='passwd']")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submit;

    @FindBy(xpath = "//a[@data-key='view=toolbar-button-compose-go&id=compose-go']")
    private WebElement createMail;

    @FindBy(xpath = "//*[@class='js-compose-field mail-Bubbles']")
    private WebElement sendTo;

    @FindBy(xpath = "//*[@class='mail-Compose-Field-Input-Controller js-compose-field js-editor-tabfocus-prev']")
    private WebElement subject;

    @FindBy(xpath = "//*[@id='cke_1_contents']")
    private WebElement body;

    @FindBy(xpath = "//button[@data-action='save']")
    private WebElement popupSaveButton;

    @FindBy(xpath = "//a[@data-key='view=folder&fid=6']")
    private WebElement draftLink;

    @FindBy(xpath = "//span[@title='sent via WebDriver']")
    private WebElement sentSubj;

    @FindBy(xpath = "//*[@class='mail-User-Name']")
    private WebElement loggedUserName;

    public WebElement getLoggedUserName() {
        return loggedUserName;
    }

    public NewMailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }


    public boolean isInDraft(String toAdress, String mailSubject, String mailBody) {
        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            createMail.click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            sendTo.click();
            sendTo.sendKeys(toAdress);
            subject.click();
            subject.sendKeys(mailSubject);
            body.click();
            body.sendKeys(mailBody);
            draftLink.click();
            popupSaveButton.click();

            return sentSubj.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public DraftsPage goDrafts(String toAdress, String mailSubject, String mailBody) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        createMail.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        sendTo.click();
        sendTo.sendKeys(toAdress);
        subject.click();
        subject.sendKeys(mailSubject);
        body.click();
        body.sendKeys(mailBody);
        draftLink.click();
        popupSaveButton.click();

        return new DraftsPage(driver);
    }

    public boolean isDisplayed(WebElement mailPageElement) {
        return mailPageElement.isDisplayed();
    }
}
