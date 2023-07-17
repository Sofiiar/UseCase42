package com.example.framework.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverConfig {

    public static WebDriver createChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // Set additional Chrome options if needed
        // options.addArguments("--headless");
        return new ChromeDriver(options);
    }

    // Add methods for other browser drivers if needed

}
