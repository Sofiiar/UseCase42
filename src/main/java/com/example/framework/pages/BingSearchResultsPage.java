package com.example.framework.pages;

import com.example.framework.driver.DriverManager;
import com.example.framework.logger.LoggerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BingSearchResultsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public BingSearchResultsPage() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, 10); // Set the timeout as needed
    }

    public boolean isWeatherInfoDisplayed() {
        LoggerUtil.info("Verifying weather information is displayed");
        String backgroundColor = driver.findElement(By.cssSelector("#b_pole a.ent-dtab-btn-active")).getCssValue("background-color");
        return (backgroundColor.equalsIgnoreCase("rgba(177, 29, 29, 1)") || backgroundColor.equalsIgnoreCase("#B11D1D"))
                && driver.findElement(By.cssSelector("#b_pole span.ent-dtab-nam-ov-dtp")).getText().equalsIgnoreCase("Lviv");
    }
}
