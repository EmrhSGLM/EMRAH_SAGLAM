package com.insider.report;


import com.insider.utilities.ScreenShotUtils;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {


    @Override
    public void onTestStart(ITestResult result) {
        //log4j kullanarak loglama yapılabilir
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        //log4j kullanarak loglama yapılabilir
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ScreenShotUtils.getScreenshot(result.getName());
    }


}
