package com.epam.page_object.test;


import com.epam.page_object.base.Driver;
import com.epam.page_object.pages.LogInPage;
import com.epam.page_object.steps.TestLoginSteps;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class TestLogInPage {
    //private LogInPage objLoginPage;
    private TestLoginSteps objTestloginSteps;

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
    public void testLogin(String url, String login, String password) {
        objTestloginSteps = new TestLoginSteps();
        objTestloginSteps.openMailWebAddress(url);
        objTestloginSteps.doLogin(login, password);
        Assert.assertTrue(objTestloginSteps.isLoginSuccessful(), "Element is not found, seems like User is not logged in ... ");
    }


//    @Test(dataProvider = "Login_Provider", groups = "Login Page Test", description = "Tests whether user is Logged In", testName = "testLogin")
//    public void testLogin(String URL, String LOGIN, String PASSW) {
//        objLoginPage = new LogInPage(Driver.Instance);
//        objLoginPage.goToUrl(URL);
//        objLoginPage.doLogin(LOGIN, PASSW);
//        Assert.assertTrue(objLoginPage.userPresented(), "Element is not found, seems like User is not logged in ... ");
//    }
}



