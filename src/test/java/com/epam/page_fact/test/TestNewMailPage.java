package com.epam.page_fact.test;

import com.epam.page_fact.base.Driver;
import com.epam.page_fact.pages.AbstractPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNewMailPage {

    AbstractPage objMailPage;

    @BeforeClass(alwaysRun = true, description = "Start browser")
    public void setup() {
        Driver.Initialize();
    }

    @BeforeClass(dependsOnMethods = "setup", description = "Add implicit wait")
    public void addImplicitly() {
        Driver.Instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass(alwaysRun = true, description = "Add implicit wait")
    public void addImplicityBeforeClose() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterClass(alwaysRun = true, dependsOnMethods = "addImplicityBeforeClose")
    public void closeBrowser() throws Exception {
        try {
            Driver.Instance.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DataProvider(name = "NewMail_Provider")
    public Object[][] LoginCredentials() {
        Object[][] NewMail = new Object[1][6];
        NewMail[0][0] = "https://mail.yandex.by/";
        NewMail[0][1] = "testtask28";
        NewMail[0][2] = "testtask28testtask28";
        NewMail[0][3] = "emartu@yandex.ru";
        NewMail[0][4] = "sent via WebDriver";
        NewMail[0][5] = "Test message ... ";
        return NewMail;
    }

    @Test(dataProvider = "NewMail_Provider", groups = "Mail Page Test", description = "Tests whether email is sent")
    public void testMailIsInDraft(String URL, String LOGIN, String PASSW, String TO, String SUBJ, String BODY) {
        objMailPage = new AbstractPage(Driver.Instance);
        Boolean isInDraft = objMailPage.goToUrl(URL).doLogin(LOGIN, PASSW).isInDraft(TO, SUBJ, BODY);
        Assert.assertTrue(isInDraft, "Element is not found, seems like message is not saved in Drafts ... ");
    }

}
