package com.sugarfit.tests;
import org.testng.annotations.Test;
import com.sugarfit.base.BaseTest;
import com.sugarfit.pages.MealLogPage;

import org.testng.Assert;

public class searchMealTest extends BaseTest {
    @Test
    public void searchAndAddMeal() {

        loginToApplication();

        MealLogPage mealLogPage = new MealLogPage(driver);

        mealLogPage.clickAddIcon();
        mealLogPage.clickFood();
        mealLogPage.clickLogManually();
        mealLogPage.selectPreBreakfast();

        mealLogPage.clickSearchField();
        mealLogPage.searchFood("briyani");

        mealLogPage.selectFirstSearchResult();

        mealLogPage.clickAddToPreBreakfast();

        mealLogPage.clickLogButton();

        Assert.assertTrue(
                mealLogPage.isMealLoggedSuccessfully(),
                "Meal was not logged successfully.");

        System.out.println("Meal logged successfully.");
    }
}
