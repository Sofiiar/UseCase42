package com.example.framework.utils;

import io.qameta.allure.Attachment;
import io.qameta.allure.testng.AllureTestNg;

public class AllureListener extends AllureTestNg {
    @Attachment(value = "Page Screenshot", type = "image/png")
    public byte[] attachScreenshot() {
        // Capture and return a screenshot of the page
        return null;
    }
}
