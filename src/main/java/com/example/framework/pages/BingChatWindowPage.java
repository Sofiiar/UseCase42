package com.example.framework.pages;

import com.example.framework.driver.DriverManager;
import com.example.framework.logger.LoggerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BingChatWindowPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public BingChatWindowPage() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, 10); // Set the timeout as needed
    }

    public boolean isPopUpDisplayed() {
        LoggerUtil.info("Verifying pop-up information window is displayed");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement popUp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bnp_cont")));
            return popUp.isDisplayed();
        } catch (TimeoutException e) {
            LoggerUtil.error("Pop-up information window is not displayed within the specified timeout");
            return false;
        }
    }
}
