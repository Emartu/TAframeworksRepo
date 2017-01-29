package com.epam.page_object.test;

import com.epam.page_object.base.Driver;
import com.epam.page_object.pages.DraftsPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestDraftPage {
    DraftsPage objDraftPage;

    @BeforeClass(alwaysRun = true, description = "Start browser")
    public void setup() {
        Driver.Initialize();
    }

    @BeforeClass(dependsOnMethods = "setup", description = "Add implicit wait")
    public void addImplicitly() {
        Driver.Instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass (alwaysRun = true, description = "Does Lof Off")
    public void doLogOff(){
        objDraftPage.doLogOff();
    }

    @AfterClass(alwaysRun = true, description = "Add implicit wait")
    public void addImplicityBeforeClose() throws InterruptedException {
        Thread.sleep(4000);
    }

    @AfterClass(alwaysRun = false, dependsOnMethods = "addImplicityBeforeClose")
    public void closeBrowser() throws Exception {
        try {
            Driver.quit();
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

    @Test(dataProvider = "NewMail_Provider", groups = "Draft Page Test", description = "Tests whether email is sent")
    public void testMailIsInDraft(String URL, String LOGIN, String PASSW, String TO, String SUBJ, String BODY) {
        objDraftPage = new DraftsPage(Driver.Instance);
        objDraftPage.goToUrl(URL);
        objDraftPage.doLogin(LOGIN, PASSW);
        objDraftPage.clickCreateNewMail();
        objDraftPage.setToAdress(TO);
        objDraftPage.setMailSubject(SUBJ);
        objDraftPage.setMailBody(BODY);
        objDraftPage.clickDraftLink();
        objDraftPage.clickPopUpSaveChanges();
        objDraftPage.openDraftMessage();
        objDraftPage.setToAdress(TO);
        objDraftPage.sendTheMail();
        objDraftPage.clickOnSentMail();
        Assert.assertTrue(objDraftPage.verifyMessageIsInSent(), "Element is not found, seems like message is not sent ... ");
    }
}
