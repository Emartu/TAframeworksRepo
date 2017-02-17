package com.epam.page_object.test;

import com.epam.page_object.base.Driver;
import com.epam.page_object.business_objects.MailData;
import com.epam.page_object.business_objects.User;
import com.epam.page_object.pages.NewMailPage;
import com.epam.page_object.steps.TestNewMailSteps;
import com.epam.page_object.test_data.TestInput;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNewMailPage {

    TestNewMailSteps testNewMailSteps;

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
        Driver.Instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass(alwaysRun = true, dependsOnMethods = "addImplicityBeforeClose")
    public void closeBrowser() throws Exception {
        Driver.Instance.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        Driver.Instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try {
            Driver.Instance.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DataProvider(name = "NewMail_Provider")
    public Object[][] dataProvider() {
        return new Object[][]{
//                {new User(TestInput.login, TestInput.password)},
                {new MailData(TestInput.login, TestInput.password, TestInput.to, TestInput.subject, TestInput.body)}
        };
    }

    @Test(dataProvider = "NewMail_Provider", groups = "Mail Page Test", description = "Tests whether email is sent")
    public void testMailIsInDraft(MailData mailData) {
        testNewMailSteps = new TestNewMailSteps();
        testNewMailSteps.openMailWebAddress(TestInput.mailBoxUrl);
        testNewMailSteps.doLogin(mailData);
        testNewMailSteps.createNewMail(mailData);
//      Assert.assertTrue(objMailPage.messageIsInDraft(), "Element is not found, seems like message is not saved in Drafts ... ");
    }

}
