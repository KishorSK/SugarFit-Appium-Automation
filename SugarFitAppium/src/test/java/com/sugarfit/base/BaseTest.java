package com.sugarfit.base;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;

import com.sugarfit.pages.HomePage;
import com.sugarfit.pages.LoginPage;
import com.sugarfit.utils.DriverFactory;
import com.sugarfit.utils.ScreenshotUtils;
import org.testng.annotations.Listeners;
import com.sugarfit.listeners.ExtentListener;

@Listeners(ExtentListener.class)
public class BaseTest {

    protected AndroidDriver driver;
    protected long startTime;
    protected long endTime;

    @BeforeMethod
    public void setUp() throws IOException {
        driver = DriverFactory.initializeDriver();
    }

        // Reusable Login Method
    public void loginToApplication() {

        LoginPage loginPage = new LoginPage(driver);

        long appLaunchTime = loginPage.getAppLaunchTime();
        System.out.println("App Launch Time : " + appLaunchTime + " ms");

        Assert.assertTrue(
                loginPage.isLoginScreenDisplayed(),
                "Login screen is NOT displayed after app launch");

        System.out.println("Login screen displayed successfully.");

        loginPage.enterPhoneNumber("8197471516");
        loginPage.clickSendVerificationCode();
        loginPage.enterOtp("132465");

        HomePage homePage = new HomePage(driver);

        homePage.clickNoThanks();
        homePage.closeBanner();

        Assert.assertTrue(
                homePage.isHomePageDisplayed(),
                "Login Failed - Home Page is not displayed");

        System.out.println("Login Successful - Home Page displayed.");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {

        ScreenshotUtils.captureScreenshot(driver, result.getName());
    }
        if (driver != null) {
            // driver.quit();
        }

    }
    
    public AndroidDriver getDriver() {
    return driver;
}

}