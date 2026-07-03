package com.sugarfit.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.android.AndroidDriver;

public class ScreenshotUtils {

    public static String captureScreenshot(AndroidDriver driver, String testName) {

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        // Create reports/screenshots folder
        File folder = new File("reports/screenshots");
        if (!folder.exists()) {
            folder.mkdirs();
        }

        String fileName = testName + "_" + timeStamp + ".png";

        File dest = new File(folder, fileName);

        try {
            FileUtils.copyFile(src, dest);
            System.out.println("Screenshot saved: " + dest.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Relative path for Extent Report
        return "screenshots/" + fileName;
    }
}