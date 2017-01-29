package com.epam.page_fact.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {
    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class='mail-User-Name']")
    private WebElement loggedUserName;

    public WebElement getLoggedUserName() {
        return loggedUserName;
    }


    public boolean isDisplayed(WebElement mailPageElement) {
        return mailPageElement.isDisplayed();
    }

    public boolean isElementPresent(By by) {
        // Custom implementation for is ElementPresent
        return !driver.findElements(by).isEmpty();
    }

    public boolean userPresented() {
        try {
            return loggedUserName.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
