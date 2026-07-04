package com.sugarfit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import com.sugarfit.utils.WaitUtils;

public class MealLogPage {

    AndroidDriver driver;
    WaitUtils waitUtils;

    // + icon
    By addIcon = AppiumBy.xpath(
            "//android.view.View[@content-desc='LOGGING']/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.View");

    // Food
    By foodButton = AppiumBy.accessibilityId("FOOD");

    // Log Manually
    By logManuallyButton = AppiumBy.xpath(
            "//android.view.ViewGroup[@content-desc='Log Manually']/android.view.ViewGroup");

    // Meal Slot
    By preBreakfast =  AppiumBy.androidUIAutomator(
    "new UiSelector().textContains(\"Pre Breakfast\")");

    // Search Field
    By searchField = AppiumBy.className("android.widget.EditText");

    // First Food (+)
    By firstSuggestion = AppiumBy.xpath(
    "(//android.view.ViewGroup[contains(@content-desc,'Cal')])[1]");

    By firstSearchResult = AppiumBy.xpath(
    "(//android.view.ViewGroup[contains(@content-desc,'Cal')])[1]");

    // Second Food (+)
    By secondSuggestion = AppiumBy.xpath(
    "(//android.view.ViewGroup[contains(@content-desc,'Cal')])[2]");

    // Log Button
    By logButton = AppiumBy.androidUIAutomator(
    "new UiSelector().descriptionContains(\"Log Pre Breakfast\")");

    // Meal Summary
    By mealSummaryButton = AppiumBy.xpath(
            "//android.view.ViewGroup[@content-desc='View Meal Diary']/android.view.ViewGroup");

    By addToPreBreakfastButton =
        AppiumBy.accessibilityId("Add to Pre Breakfast");
    
    public MealLogPage(AndroidDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public void clickAddIcon() {
        driver.findElement(addIcon).click();
    }

    public void clickFood() {
        driver.findElement(foodButton).click();
        
    }
    public void clickLogManually() {
       driver.findElement(logManuallyButton).click();
    }

    public void selectPreBreakfast() {
        waitUtils.waitForElement(preBreakfast).click();
        
    }

    public void clickSearchField() {
        waitUtils.waitForElement(searchField).click();
        
    }

    public void addFirstFood() {
        waitUtils.waitForElement(firstSuggestion).click();
    }

    public void addSecondFood() {
        waitUtils.waitForElement(secondSuggestion).click();
    }

   public void clickLogButton() {

    waitUtils.waitForClickable(logButton).click();
    }

    public boolean isMealLoggedSuccessfully() {
        return waitUtils.waitForElement(mealSummaryButton).isDisplayed();
    }

    public void clickAddToPreBreakfast() {

    waitUtils.waitForElement(addToPreBreakfastButton).click();
    waitUtils.waitForElement(logButton);
    }
    public void selectFirstSearchResult() {

        waitUtils.waitForElement(firstSearchResult).click();
    }
    public void searchFood(String foodName) {

        WebElement search = waitUtils.waitForElement(searchField);
        search.sendKeys(foodName);
    }
}