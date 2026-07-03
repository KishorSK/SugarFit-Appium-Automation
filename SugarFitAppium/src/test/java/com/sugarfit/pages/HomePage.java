package com.sugarfit.pages;

// import java.util.List;
// import java.time.Duration;


import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import com.sugarfit.utils.WaitUtils;

public class HomePage {
    AndroidDriver driver;
    WaitUtils waitUtils;

    By noThanksButton = AppiumBy.id("android:id/button2");

    By bannerCloseButton = AppiumBy.androidUIAutomator(
        "new UiSelector().className(\"android.widget.ImageView\").instance(12)");

    By homeText = AppiumBy.androidUIAutomator(
            "new UiSelector().text(\"Home\")");

    public HomePage(AndroidDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public void clickNoThanks() {

        waitUtils.waitForElement(noThanksButton).click();
    }

    public void closeBanner() {
    waitUtils.waitForElement(bannerCloseButton).click();
    }

    public boolean isHomePageDisplayed() {
        return waitUtils.waitForElement(homeText).isDisplayed();
    }
}
