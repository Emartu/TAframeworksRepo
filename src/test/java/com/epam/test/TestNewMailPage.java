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

//    @AfterClass
//    public void closeBrowser() {
//        NewMailPage.driver.quit();
//    }

    @Test(description = "Tests whether email is sent")
    public void testMailIsInDraft() {

        objMailPage = new NewMailPage();
        objMailPage.doLogin();
        objMailPage.goDraft();
        Assert.assertTrue(objMailPage.messageIsInDraft(), "Element is not found, seems like message is not saved in Drafts ... ");
    }

}
