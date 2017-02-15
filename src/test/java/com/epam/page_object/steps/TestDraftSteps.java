package com.epam.page_object.steps;


import com.epam.page_object.pages.DraftsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class TestDraftSteps {
    private WebDriver driver;

    public void initBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void openMailWebAddress(String url) {
        DraftsPage draftsPage = new DraftsPage(driver);
        draftsPage.goToUrl(url);
    }

    public void doLogin(String login, String password) {
        DraftsPage draftsPage = new DraftsPage(driver);
        draftsPage.doLogin(login, password);
    }

    public void createNewMail(String toAdress, String mailSubject, String mailBody) {
        DraftsPage draftsPage = new DraftsPage(driver);
        draftsPage.clickCreateNewMail();
        draftsPage.setToAdress(toAdress);
        draftsPage.setMailSubject(mailSubject);
        draftsPage.setMailBody(mailBody);
    }

    public void goDrafts() {
        DraftsPage draftsPage = new DraftsPage(driver);
        draftsPage.clickPopUpSaveChanges();
        draftsPage.clickDraftLink();
        draftsPage.openDraftMessage();
    }
}
