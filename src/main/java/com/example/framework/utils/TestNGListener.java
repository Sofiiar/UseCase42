package com.example.framework.utils;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestNGListener extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult tr) {
        // Log or perform any necessary actions on test failure
    }
}
