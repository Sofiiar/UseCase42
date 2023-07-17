package com.example.framework.tests;

import com.example.framework.driver.DriverManager;
import com.example.framework.logger.LoggerUtil;
import com.example.framework.pages.BingChatWindowPage;
import com.example.framework.pages.BingHomePage;
import com.example.framework.pages.BingSearchResultsPage;
import com.example.framework.pages.BingSettingsPage;
import com.example.framework.utils.AllureListener;
import com.example.framework.utils.TestNGListener;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

@Listeners({AllureListener.class, TestNGListener.class})
public class BingTests {
    private BingHomePage homePage;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--disable-features=EnableEphemeralFlashPermission");
        options.addArguments("--disable-features=ImprovedCookieControls");
        // Add more Chrome options to enable the new Bing experience

        homePage = new BingHomePage(options);
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }

    @Test
    public void testWeatherInLviv() {
        homePage.navigateTo("https://www.bing.com/");
        homePage.search("weather in Lviv");

        BingSearchResultsPage resultsPage = new BingSearchResultsPage();
        boolean weatherInfoDisplayed = resultsPage.isWeatherInfoDisplayed();
        // Add assertions or verification steps to check if weather information is displayed
        Assert.assertTrue(weatherInfoDisplayed);
    }

    @Test
    public void testChatLink() {
        BingHomePage homePage = new BingHomePage();
        BingChatWindowPage chatWindowPage = new BingChatWindowPage();
        homePage.navigateTo("https://www.bing.com/");
        try {
            homePage.enableNewBingExperience();
            homePage.clickChatLink();
            Assert.assertTrue(chatWindowPage.isPopUpDisplayed(), "Chat pop-up information window is not displayed");
            LoggerUtil.info("testChatLink passed");
        } catch (NoSuchElementException e) {
            LoggerUtil.error("Chat mode is only available with the new Bing. Skipping testChatLink.");
            LoggerUtil.error(e.getMessage());
        }
    }

    @Test
    public void testSettingsPage() {
        BingHomePage homePage = new BingHomePage();
        homePage.navigateTo("https://www.bing.com/");
        homePage.openMenu();
        homePage.openSettingsMenu();
        homePage.clickMoreOption();

        BingSettingsPage settingsPage = new BingSettingsPage();
        boolean isSettingsPageOpened = settingsPage.isSettingsPageOpened();
        Assert.assertTrue(isSettingsPageOpened, "Settings page is not opened.");
    }
}
