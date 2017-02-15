package com.epam.page_object.steps;


import java.util.concurrent.TimeUnit;

import com.epam.page_object.pages.LogInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestLoginSteps {
    private WebDriver driver;

    public void initBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void closeDriver() {
        driver.quit();
    }

    public void openMailWebAddress(String url) {
        LogInPage logInPage = new LogInPage(driver);
        logInPage.goToUrl(url);
    }

    public void doLogin(String login, String password) {
        LogInPage logInPage = new LogInPage(driver);
        logInPage.doLogin(login, password);
    }

    public boolean isLoginSuccessful() {
        LogInPage logInPage = new LogInPage(driver);
        return logInPage.userPresented();
    }

}



