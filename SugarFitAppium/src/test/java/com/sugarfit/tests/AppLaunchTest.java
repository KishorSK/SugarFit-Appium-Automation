package com.sugarfit.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sugarfit.base.BaseTest;

public class AppLaunchTest extends BaseTest {

    @Test
    public void verifyAppLaunch() {

        System.out.println("Sugar.fit App launched successfully.");

        Assert.assertNotNull(driver);

    }

}