package com.epam.test;

import com.epam.base.SetProperties;
import com.epam.pages.NewMailPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNewMailPage {
    WebDriver driver;
    NewMailPage objMailPage;

    @BeforeClass
    public void setup() {
        new SetProperties().setSystemProperty();
    }

    @Test(description = "Tests whether email is sent")
    public void testSentMail() {

        objMailPage = new NewMailPage();
        objMailPage.doLogin();
        objMailPage.sendNewMail();
        objMailPage.messageIsSent();
        Assert.assertTrue(objMailPage.messageIsSent(), "Element is not found, seems like message is not sent ... ");
    }

    @AfterClass
    public void driverClose() {
        //driver.close();
    }
}
