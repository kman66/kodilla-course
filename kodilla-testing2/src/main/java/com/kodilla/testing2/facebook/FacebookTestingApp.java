package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public static final String XPATH_BIRTH_SPAN = "//div[contains(@class, \"_5k_5\")]/" +
            "span[contains(@class, \"_5k_4\")]/span";
    public static final String XPATH_BIRTH_DAY = XPATH_BIRTH_SPAN + "/select[contains(@name, \"birthday_day\")]";
    public static final String XPATH_BIRTH_MONTH = XPATH_BIRTH_SPAN + "/select[contains(@name, \"birthday_month\")]";
    public static final String XPATH_BIRTH_YEAR = XPATH_BIRTH_SPAN + "/select[contains(@name, \"birthday_year\")]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get("https://www.facebook.com/");

        while (!driver.findElement(By.xpath(XPATH_BIRTH_DAY)).isDisplayed());

        WebElement dayOfBirthWebElem = driver.findElement(By.xpath(XPATH_BIRTH_DAY));
        Select dayOfBirthSelect = new Select(dayOfBirthWebElem);
        dayOfBirthSelect.selectByIndex(10);

        WebElement monthOfBirthWebElem = driver.findElement(By.xpath(XPATH_BIRTH_MONTH));
        Select monthOfBirthSelect = new Select(monthOfBirthWebElem);
        monthOfBirthSelect.selectByIndex(10);

        WebElement yearOfBirthWebElem = driver.findElement(By.xpath(XPATH_BIRTH_YEAR));
        Select yearOfBirthSelect = new Select(yearOfBirthWebElem);
        yearOfBirthSelect.selectByIndex(39);
    }
}
