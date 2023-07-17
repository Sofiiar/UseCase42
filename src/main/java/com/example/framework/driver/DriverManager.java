package com.example.framework.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {
    private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        if (driverThread.get() == null) {
            WebDriverManager.chromedriver().setup();
            driverThread.set(new ChromeDriver());
        }
        return driverThread.get();
    }

    public static WebDriver getDriver(ChromeOptions options) {
        if (driverThread.get() == null) {
            WebDriverManager.chromedriver().setup();
            driverThread.set(new ChromeDriver(options));
        }
        return driverThread.get();
    }

    public static void quitDriver() {
        if (driverThread.get() != null) {
            driverThread.get().quit();
            driverThread.remove();
        }
    }
}
