package com.sugarfit.pages;

import java.util.List;
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import com.sugarfit.utils.WaitUtils;

public class LoginPage {

    AndroidDriver driver;
    WaitUtils waitUtils;
    WebDriverWait wait;

    // Locators

    By phoneNumberField = AppiumBy.accessibilityId("PHONE_NUMBER_INPUT");

    By sendVerificationButton = AppiumBy.androidUIAutomator("new UiSelector().text(\"Send Verification Code\")");

    By loginScreenText =AppiumBy.androidUIAutomator("new UiSelector().text(\"OR LOGIN WITH\")" );

    // Constructor

    public LoginPage(AndroidDriver driver) {

        this.driver = driver;
        waitUtils = new WaitUtils(driver);

    }

    // Actions

    public void enterPhoneNumber(String mobileNumber) {

        WebElement element = waitUtils.waitForElement(phoneNumberField);

        // System.out.println("Displayed : " + element.isDisplayed());
        // System.out.println("Enabled   : " + element.isEnabled());

        element.click();

        waitUtils.waitForElement(AppiumBy.className("android.widget.EditText"));

        WebElement input = waitUtils.waitForElement(
                AppiumBy.className("android.widget.EditText")
        );

        input.clear();
        input.sendKeys(mobileNumber);

    }
    public void clickSendVerificationCode() {

        waitUtils.waitForElement(sendVerificationButton)
                 .click();

    }

    public void enterOtp(String otp) {

     waitUtils.waitForElement(
            AppiumBy.className("android.widget.EditText")
    );

    List<WebElement> slots =
            driver.findElements(AppiumBy.className("android.widget.EditText"));

    for (int i = 0; i < otp.length(); i++) {
        slots.get(i).click();
        slots.get(i).sendKeys(String.valueOf(otp.charAt(i)));
    }

    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isLoginScreenDisplayed() {

        return waitUtils.waitForElement(loginScreenText).isDisplayed();
    }
    public long getAppLaunchTime() {

        long startTime = System.currentTimeMillis();

        waitUtils.waitForElement(loginScreenText);

        long endTime = System.currentTimeMillis();

        return endTime - startTime;
    }
}