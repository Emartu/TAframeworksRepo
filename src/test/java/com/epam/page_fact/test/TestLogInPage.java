package com.epam.page_fact.test;


import com.epam.page_fact.base.Driver;
import com.epam.page_fact.pages.AbstractPage;
import com.epam.page_fact.pages.LogInPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class TestLogInPage {
    LogInPage objLoginPage;

    @BeforeClass(alwaysRun = true, description = "Start browser")
    public void setup() {
        Driver.Initialize();
    }

    @BeforeClass(dependsOnMethods = "setup", description = "Add implicit wait")
    public void addImplicitly() {
        Driver.Instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass(alwaysRun = true, description = "Add implicit wait")
    public void addImplicityBeforeClose() throws InterruptedException {
        Thread.sleep(4000);
    }

    @AfterClass(alwaysRun = true, dependsOnMethods = "addImplicityBeforeClose")
    public void closeBrowser() throws Exception {
        try {
            Driver.Instance.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DataProvider(name = "Login_Provider")
    public Object[][] LoginCredentials() {
        Object[][] Login = new Object[1][3];
        Login[0][0] = "https://mail.yandex.by/";
        Login[0][1] = "testtask28";
        Login[0][2] = "testtask28testtask28";
        return Login;
    }

    @Test(dataProvider = "Login_Provider", groups = "Login Page Test", description = "Tests whether user is Logged In", testName = "testLogin")
    public void testLogin(String URL, String LOGIN, String PASSW) {
        WebElement loggedUserNam = new AbstractPage(Driver.Instance).getLoggedUserName();
        objLoginPage = new LogInPage(Driver.Instance);
        objLoginPage.goToUrl(URL);
        Boolean loginDone = new LogInPage(Driver.Instance).doLogin(LOGIN, PASSW).isDisplayed(loggedUserNam);
        Assert.assertTrue(loginDone, "Element is not found, seems like User is not logged in ... ");
    }
}



