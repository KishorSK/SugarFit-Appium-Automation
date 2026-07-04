package com.sugarfit.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class WaitUtils {

    AndroidDriver driver;
    WebDriverWait wait;

    public WaitUtils(AndroidDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

  public WebElement waitForElement(By locator) {

    return wait.until(
            ExpectedConditions.visibilityOfElementLocated(locator));
}

public WebElement waitForClickable(By locator) {

    return wait.until(
            ExpectedConditions.visibilityOfElementLocated(locator));
}
}