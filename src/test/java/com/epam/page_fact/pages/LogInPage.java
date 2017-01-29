package com.epam.page_fact.pages;

import com.epam.page_fact.base.Driver;
import com.epam.page_fact.base.WaitTool;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public NewMailPage doLogin(String userName, String passw) {
        waitTool.waitForElementPresent(Driver.Instance, new By.ByXPath("//BUTTON[@class=' nb-button _nb-normal-button new-auth-form-button']"), 5);
        login.sendKeys(userName);
        password.sendKeys((passw));
        submit.click();
        return new NewMailPage(driver);
    }
}





