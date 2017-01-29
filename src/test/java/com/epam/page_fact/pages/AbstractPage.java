package com.epam.page_fact.pages;

import com.epam.page_fact.base.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {
    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LogInPage goToUrl(String URL) {
        Driver.Instance.get(URL);
        return new LogInPage(driver);
    }

}
