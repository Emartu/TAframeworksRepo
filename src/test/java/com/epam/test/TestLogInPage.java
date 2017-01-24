package com.epam.test;


import com.epam.base.SetProperties;
import com.epam.pages.LogInPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestLogInPage {

    LogInPage objLoginPage;

    @BeforeClass
    public void setup() {
        new SetProperties().setSystemProperty();
    }

    @Test(description = "Tests whether user is Logged In", testName = "testLogin")
    public void testLogin() {

        objLoginPage = new LogInPage();
        objLoginPage.doLogin();
        objLoginPage.userPresented();
        Assert.assertTrue(objLoginPage.userPresented(), "Element is not found, seems like User is not logged in ... ");
    }
}



