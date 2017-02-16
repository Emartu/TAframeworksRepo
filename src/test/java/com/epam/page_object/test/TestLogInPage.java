package com.epam.page_object.test;


import com.epam.page_object.base.Driver;
import com.epam.page_object.business_objects.User;
import com.epam.page_object.pages.LogInPage;
import com.epam.page_object.steps.TestLoginSteps;
import com.epam.page_object.test_data.TestInput;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.epam.page_object.test_data.TestInput.login;


public class TestLogInPage {

    private TestLoginSteps objTestloginSteps;
    User user = new User(TestInput.login, TestInput.password);

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
            Driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DataProvider(name = "Login_Provider")
    public Object[][] dataProvider() {
        return new Object[][]{
                {user}
        };
    }


    @Test(dataProvider = "Login_Provider", groups = "Login Page Test", description = "Tests whether user is Logged In", testName = "testLogin")
    public void testLogin(String url, String login, String password) {
        objTestloginSteps = new TestLoginSteps();
        objTestloginSteps.openMailWebAddress(url);
        objTestloginSteps.doLogin(login, password);
        Assert.assertTrue(objTestloginSteps.isLoginSuccessful(), "Element is not found, seems like User is not logged in ... ");
    }

}



