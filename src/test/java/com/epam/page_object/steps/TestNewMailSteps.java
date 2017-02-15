package com.epam.page_object.steps;


import com.epam.page_object.pages.NewMailPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class TestNewMailSteps {
    private WebDriver driver;

    public void initBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void openMailWebAddress(String url) {
        NewMailPage newMailPage = new NewMailPage(driver);
        newMailPage.goToUrl(url);
    }

    public void doLogin(String login, String password) {
        NewMailPage newMailPage = new NewMailPage(driver);
        newMailPage.doLogin(login, password);
    }

    public void createNewMail(String toAdress,String mailSubject, String mailBody) {
        NewMailPage newMailPage = new NewMailPage(driver);
        newMailPage.clickCreateNewMail();
        newMailPage.setToAdress(toAdress);
        newMailPage.setMailSubject(mailSubject);
        newMailPage.setMailBody(mailBody);
    }
}
