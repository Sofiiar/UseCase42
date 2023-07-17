package com.example.framework.pages;

import com.example.framework.driver.DriverManager;
import com.example.framework.logger.LoggerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BingSettingsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public BingSettingsPage() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, 10); // Set the timeout as needed
    }

    public boolean isSettingsPageOpened() {
        LoggerUtil.info("Verifying settings page is opened");
        return driver.findElement(By.id("profileSet")).isDisplayed();
    }
}
