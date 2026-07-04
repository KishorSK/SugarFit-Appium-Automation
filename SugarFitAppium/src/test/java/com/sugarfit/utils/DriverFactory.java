package com.sugarfit.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class DriverFactory {

    public static AndroidDriver driver;

    public static AndroidDriver initializeDriver() throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
        prop.load(fis);

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName(prop.getProperty("platformName"));
        options.setAutomationName(prop.getProperty("automationName"));
        options.setDeviceName(prop.getProperty("deviceName"));

        options.setAppPackage(prop.getProperty("appPackage"));
        options.setAppActivity(prop.getProperty("appActivity"));


        driver = new AndroidDriver(
                new URL(prop.getProperty("appiumServer")),
                options);

        return driver;
    }
}