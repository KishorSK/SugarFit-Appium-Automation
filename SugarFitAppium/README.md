# Sugar.fit Mobile Automation Assignment

## Technology Used

- Java
- Appium
- TestNG
- Maven
- Page Object Model (POM)
- Extent Reports

## Project Features

- App Launch Validation
- Login Validation
- Meal Logging Validation
- Screenshot on Failure
- Extent HTML Report

## How to Run

1. Start Appium Server
2. Connect Android device
3. Run testng.xml

## Report

Execution report is available under:

reports/SugarFitReport.html




## Framework Structure

## BaseTest

Initializes the Appium driver.
Contains reusable login functionality.
Performs test setup and teardown.

## Page Objects
Each application screen is represented by a separate page class.
UI elements and page-specific actions are encapsulated within their respective classes.

## DriverFactory
Creates and manages the AndroidDriver instance using values from config.properties.

## WaitUtils
Provides reusable explicit wait methods for element synchronization.

## ScreenshotUtils
Captures screenshots automatically on test failures.

## Extent Reports
Generates a detailed HTML execution report.
Includes test status, execution time, logs, and failure screenshots.

## PerformanceUtils
Captures the time spent on important application screens during execution.

This modular design makes the framework scalable and easy to maintain as new test cases are added.

## Challenges Faced

## During the implementation of the automation framework, the following challenges were encountered:

1.Initial Appium and Java environment setup and dependency compatibility.
2.Dynamic UI elements whose locators changed between sessions.
3.Optional permission dialogs and promotional popups that appeared only for certain user accounts.(for new number)
4.Some application overlays (such as promotional banners) were not fully inspectable using Appium Inspector, making locator identification difficult. (gold membership)
5.Certain elements took significantly longer to become interactable through Appium compared to manual interaction, requiring optimization of waits and locator strategies. (taking more than 40sec for closing banner, add icon, food, log manually & prebreakfast )
6.Attaching failure screenshots correctly in Extent Reports required additional configuration.

These challenges were resolved by improving locator strategies, introducing reusable popup handling methods, using explicit waits, and refining the reporting mechanism.

## Improvements (If More Time Were Available)

Given additional time, the framework could be further enhanced by implementing the following:

Data-driven testing using Excel or JSON files.
Integration with Jenkins/GitHub Actions for Continuous Integration (CI).
Performance monitoring for CPU usage, memory consumption, battery usage, and network statistics.
Retry mechanism for flaky tests.
Video recording of test execution.
More comprehensive test coverage including negative scenarios, edge cases, and regression suite