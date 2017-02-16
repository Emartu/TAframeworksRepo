package com.epam.page_object.steps;


import com.epam.page_object.base.Driver;
import com.epam.page_object.business_objects.User;
import com.epam.page_object.pages.LogInPage;
import org.openqa.selenium.WebDriver;


public class TestLoginSteps {

    private WebDriver driver = Driver.Initialize();

    public void closeDriver() {
        driver.quit();
    }

    public void openMailWebAddress(String url) {
        LogInPage logInPage = new LogInPage(driver);
        logInPage.goToUrl(url);
    }

//    public void doLogin(String login, String password) {
//        LogInPage logInPage = new LogInPage(driver);
//        logInPage.doLogin(login, password);
//    }
public void doLogin(User user) {
    LogInPage logInPage = new LogInPage(driver);
    logInPage.doLogin(user.getLogin(),user.getPassword());
}

    public boolean isLoginSuccessful() {
        LogInPage logInPage = new LogInPage(driver);
        return logInPage.userPresented();
    }

}



