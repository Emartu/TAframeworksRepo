package com.epam.pages;

import com.epam.base.Driver;
import com.epam.base.WaitTool;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LogInPage {

    private WaitTool waitTool = new WaitTool();
    private final WebDriver driver;

    @FindBy(xpath = "//input[@name='login']")
    private WebElement login;

    @FindBy(xpath = "//input[@name='passwd']")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submit;

    @FindBy(xpath = "//*[@class='mail-User-Name']")
    private WebElement loggedUserName;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void goToUrl(String URL) {
        Driver.Instance.get(URL);
    }

    public void doLogin(String userName, String passw) {

        waitTool.waitForElementPresent(Driver.Instance, new By.ByXPath("//BUTTON[@class=' nb-button _nb-normal-button new-auth-form-button']"), 5);
        login.sendKeys(userName);
        password.sendKeys((passw));
        submit.click();

    }

    public boolean userPresented() {
        try {
            return loggedUserName.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }

    }
}





