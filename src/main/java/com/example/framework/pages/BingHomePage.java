package com.example.framework.pages;

import com.example.framework.driver.DriverManager;
import com.example.framework.logger.LoggerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BingHomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public BingHomePage() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, 10); // Set the timeout as needed
    }

    public BingHomePage(ChromeOptions options) {
        this.driver = DriverManager.getDriver(options);
        this.wait = new WebDriverWait(driver, 10); // Set the timeout as needed
    }


    public void navigateTo(String url) {
        LoggerUtil.info("Navigating to: " + url);
        driver.get(url);
    }

    public void search(String query) {
        LoggerUtil.info("Performing search for: " + query);
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        searchInput.sendKeys(query);
        searchInput.submit();
    }

    public void clickChatLink() {
        LoggerUtil.info("Clicking on the chat link");
        WebElement chatLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Chat")));
        chatLink.click();
    }

    public void openSettingsMenu() {
        LoggerUtil.info("Opening the settings menu");
        WebElement settingsMenu = wait.until(ExpectedConditions.elementToBeClickable(By.id("hbsettings")));
        settingsMenu.click();
    }

    public void openMenu() {
        LoggerUtil.info("Opening the settings menu");
        WebElement settingsMenu = wait.until(ExpectedConditions.elementToBeClickable(By.id("id_sc")));
        settingsMenu.click();
    }

    public void clickMoreOption() {
        LoggerUtil.info("Clicking on the 'More' option");
        WebElement moreOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='More']/../../.")));
        moreOption.click();
    }

    public void enableNewBingExperience() {
        LoggerUtil.info("Enabling new Bing experience");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-features=SameSiteByDefaultCookies");
        options.addArguments("--disable-features=SameSiteDefaultChecks");
        options.addArguments("--disable-features=SameSiteDefaultChecksForLocalhost");
        options.addArguments("--disable-features=SameSiteDefaultChecksInCrossSiteContext");
        options.addArguments("--disable-features=SameSiteDefaultChecksMethodMayAffectCookieExistence");
        options.addArguments("--disable-features=SameSiteDefaultChecksMethodRigor");
        options.addArguments("--disable-features=SameSiteDefaultChecksStrictEnforcement");
        options.addArguments("--disable-features=SameSiteDefaultChecksWebInfluence");
        options.addArguments("--disable-features=SameSiteStrictEnforcement");
        options.addArguments("--disable-features=SameSiteSubresourceVisibilit");
        options.addArguments("--disable-features=SecureCookiesSetting");
        options.addArguments("--disable-features=ImprovedCookieControls");

        driver = DriverManager.getDriver(options);
    }
}
