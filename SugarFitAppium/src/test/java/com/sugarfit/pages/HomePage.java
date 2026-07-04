package com.sugarfit.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import com.sugarfit.utils.WaitUtils;

public class HomePage {

    AndroidDriver driver;
    WaitUtils waitUtils;

    // Existing Popup
    By noThanksButton = AppiumBy.id("android:id/button2");

    // Existing Banner Close
    By bannerCloseButton = AppiumBy.androidUIAutomator(
            "new UiSelector().className(\"android.widget.ImageView\").instance(12)");

    // Home Page Text
    By homeText = AppiumBy.androidUIAutomator(
            "new UiSelector().text(\"Home\")");

    // Permission Popup (Contacts / Notifications)
    By permissionDenyButton = AppiumBy.id(
            "com.android.permissioncontroller:id/permission_deny_button");

    // New Reminder Banner
    By remindMeLaterButton =
            AppiumBy.accessibilityId("Remind Me Later");

    public HomePage(AndroidDriver driver) {

        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);

    }

    /**
     * Click popup if present.
     */
private boolean clickIfPresent(By locator) {

    try {

        List<WebElement> elements = driver.findElements(locator);

        if (!elements.isEmpty()) {

            WebElement element = elements.get(0);

            if (element.isDisplayed()) {

                element.click();

                System.out.println("Clicked : " + locator);

                Thread.sleep(1000);

                return true;
            }
        }

    } catch (Exception e) {

    }

    return false;
}

    /**
     * Handles all optional popups after login.
     */
public void handleOptionalPopups() {

    for (int i = 0; i < 8; i++) {

        clickIfPresent(permissionDenyButton);

        clickIfPresent(remindMeLaterButton);

        clickIfPresent(noThanksButton);

        clickIfPresent(bannerCloseButton);

        if (isHomePageDisplayed()) {
            break;
        }

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
    }
}
    /**
     * Home Page Validation
     */
    public boolean isHomePageDisplayed() {

        return !driver.findElements(homeText).isEmpty();

    }

}