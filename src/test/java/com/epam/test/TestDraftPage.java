//package com.epam.test;
//
//import com.epam.base.Driver;
//import com.epam.pages.DraftsPage;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//public class TestDraftPage {
//    DraftsPage objDraftPage;
//
//    @BeforeClass
//    public void setup() {
//        Driver.Initialize();
//    }
//
//    @AfterClass
//    public void closeBrowser() {
//        Driver.Instance.close();
//    }
//
//    @Test
//    public void isMessageInDraft() {
//
//        objDraftPage = new DraftsPage(Driver.Instance);
//        objDraftPage.doLogin("testtask28", "testtask28testtask28");
//        objDraftPage.goDraft();
//        Assert.assertTrue(objDraftPage.messageIsInDraft(), "Element is not found, seems like User mail is not in the draft ... ");
//    }
//
//    @Test
//    public void draftContentToCheck() {
//        objDraftPage = new DraftsPage(Driver.Instance);
//        objDraftPage.doLogin("testtask28", "testtask28testtask28");
//        objDraftPage.goDraft();
//        objDraftPage.openDraftMessage();
//        Assert.assertTrue(objDraftPage.getDraftContentTo().contains("emartu@yandex.ru"));
//    }
//
//    @Test
//    public void isMessageSent() {
//        objDraftPage = new DraftsPage(Driver.Instance);
//        objDraftPage.doLogin("testtask28", "testtask28testtask28");
//        objDraftPage.goDraft();
//        objDraftPage.openDraftMessage();
//        objDraftPage.sendTheMail();
//        objDraftPage.clickOnSentMail();
//        Assert.assertTrue(objDraftPage.verifyMessageIsInSent(), "Message is not sent ... ");
//    }
//}
