package com.kodilla.testing2.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverConfig {
    public final static String CHROME = "CHROME_DRIVER";
    public final static String FIREFOX = "FIREFOX_RIVER";
    public static WebDriver getDriver(final String driver) {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        System.setProperty("webdriver.gecko.driver", "/home/veles/Dokumente/Kodilla/Development/geckodriver");
        if (driver.equals(CHROME)) {
            return new ChromeDriver();
        } else if (driver.equals(FIREFOX)) {
            return new FirefoxDriver();
        } else {
            return null;
        }
    }
}
