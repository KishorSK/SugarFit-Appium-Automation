package com.sugarfit.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    static ExtentReports extent;

    public static ExtentReports getReport() {

        if(extent==null){

            ExtentSparkReporter reporter =
                    new ExtentSparkReporter("reports/SugarFitReport.html");

            reporter.config().setReportName("SugarFit Automation Report");
            reporter.config().setDocumentTitle("Automation Assignment");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }

        return extent;
    }

}