package com.epam.test;

import com.epam.base.SetProperties;
import com.epam.pages.DraftsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestDraftPage {
    DraftsPage objDraftPage;

    @BeforeClass
    public void setup() {
        new SetProperties().setSystemProperty();
    }

    @Test
    public void isMessageInDraft() {

        objDraftPage = new DraftsPage();
        objDraftPage.doLogin();
        objDraftPage.goDraft();
        Assert.assertTrue(objDraftPage.messageIsInDraft(), "Element is not found, seems like User mail is not in the draft ... ");
    }

    @Test
    public void draftContentToCheck() {
        objDraftPage = new DraftsPage();
        objDraftPage.doLogin();
        objDraftPage.goDraft();
        objDraftPage.openDraftMessage();
        Assert.assertEquals(objDraftPage.getDraftContentTo(), "emartu@yandex.ru", "Draft Message: mailTo adress is not valid ...");
    }

    @Test
    public void draftContentSubjCheck() {
        objDraftPage = new DraftsPage();
        objDraftPage.doLogin();
        objDraftPage.goDraft();
        objDraftPage.openDraftMessage();
        Assert.assertEquals(objDraftPage.getDraftContentSubject(), "sent via WebDriver", "Draft Message: subject is not valid ...");
    }

    @Test
    public void draftContentBodyCheck() {
        objDraftPage = new DraftsPage();
        objDraftPage.doLogin();
        objDraftPage.goDraft();
        objDraftPage.openDraftMessage();
        Assert.assertEquals(objDraftPage.getMailBody(), "Test message ... ", "Draft Message: mail body is not valid ...");
    }
}
