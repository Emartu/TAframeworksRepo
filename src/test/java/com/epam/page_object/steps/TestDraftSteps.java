package com.epam.page_object.steps;


import com.epam.page_object.base.Driver;
import com.epam.page_object.base.WaitTool;
import com.epam.page_object.business_objects.MailData;
import com.epam.page_object.pages.DraftsPage;
import com.epam.page_object.pages.NewMailPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class TestDraftSteps {
    private WebDriver driver = Driver.Initialize();


    public void openMailWebAddress(String url) {
        DraftsPage draftsPage = new DraftsPage(driver);
        draftsPage.getURL(url);
    }

    public void doLogin(MailData mailData) {
        NewMailPage newMailPage = new NewMailPage(driver);
        newMailPage.doLogin(mailData.getLogin(), mailData.getPassword());
    }

    public void createNewMail(MailData mailData) {
        DraftsPage draftsPage = new DraftsPage(driver);
        draftsPage.doLogin(mailData.getLogin(),mailData.getPassword());
        draftsPage.clickCreateNewMail();

        draftsPage.setToAdress(mailData.getTo());
        draftsPage.setMailSubject(mailData.getSubject());
        // newMailPage.setMailBody(mailData.getMailBody());

    }

//    public void goDrafts() {
//        DraftsPage draftsPage = new DraftsPage(driver);
//        draftsPage.clickDraftLink();
//        draftsPage.clickPopUpSaveChanges();
//        draftsPage.openDraftMessage();
//    }

    public void sendFromDrafts() {
        Driver.Instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        DraftsPage draftsPage = new DraftsPage(driver);
        draftsPage.clickDraftLink();
        draftsPage.clickPopUpSaveChanges();
        draftsPage.openDraftMessage();
       // DraftsPage draftsPage = new DraftsPage(driver);
        WaitTool.waitForElementPresent(Driver.Instance, new By.ByXPath("//button[@type='submit']"), 10);

        draftsPage.sendTheMail();
        draftsPage.clickOnSentMail();

    }

    public boolean verifyMessageIsSent() {
        DraftsPage draftsPage = new DraftsPage(driver);
        return draftsPage.verifyMessageIsInSent();
    }
}
