package com.epam.page_object.base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    public static WebDriver Instance = null;


    private Driver() {
    }

    public static WebDriver Initialize() {
        System.setProperty("webdriver.gecko.driver", "resource\\geckodriver-v0.13.0-win64\\geckodriver.exe");
        if (Instance == null) {
            Instance = new FirefoxDriver();
            Instance.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            Instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return Instance;
    }

    public static void close() {
        System.out.println("Closing Browser");
        Instance.close();
    }

    public static void quit() {
        Driver.Instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Quit Browser");
        Instance.quit();
    }

}
