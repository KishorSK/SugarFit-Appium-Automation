package com.sugarfit.tests;

import org.testng.annotations.Test;

import com.sugarfit.base.BaseTest;

public class Logintest extends BaseTest {

    @Test
    public void loginWithValidMobile() {

        loginToApplication();

    }
}