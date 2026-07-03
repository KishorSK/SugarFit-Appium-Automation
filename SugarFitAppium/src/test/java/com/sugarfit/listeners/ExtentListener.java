package com.sugarfit.listeners;

import org.testng.*;

import com.aventstack.extentreports.*;
import com.sugarfit.utils.ExtentManager;
import com.sugarfit.utils.ScreenshotUtils;
import com.sugarfit.base.BaseTest;

import io.appium.java_client.android.AndroidDriver;

public class ExtentListener implements ITestListener {

    ExtentReports extent = ExtentManager.getReport();

    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(result.getMethod().getMethodName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.pass("Test Passed");

    }

@Override
public void onTestFailure(ITestResult result) {

    System.out.println("Inside onTestFailure");

    test.fail(result.getThrowable());

    try {

        AndroidDriver driver =
        ((BaseTest) result.getInstance()).getDriver();

        System.out.println("Driver found");

        String screenshotPath = ScreenshotUtils.captureScreenshot(
                driver,
                result.getMethod().getMethodName());

        System.out.println("Screenshot Path = " + screenshotPath);

        test.addScreenCaptureFromPath(screenshotPath);

        System.out.println("Screenshot attached");

    } catch (Exception e) {
        e.printStackTrace();
    }
}

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();

    }

}