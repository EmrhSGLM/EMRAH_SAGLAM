package com.insider.tests;

import com.insider.utilities.Constants;
import com.insider.utilities.Driver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class Hook {

    private static String baseUrl ;
    private static String browser ;
    private static int testAgainCount ;

    @BeforeTest
    @Parameters({"xmlUrl","xmlBrowser","testSuite","xmlTestAgainCount"})
    public void assign(@Optional String xmlUrl, @Optional String xmlBrowser,
                       @Optional String testSuite, @Optional String xmlTestAgainount){
        baseUrl = xmlUrl == null ? Constants.defaultUrl : xmlUrl ;
        browser = xmlBrowser == null ? Constants.defaultBrowser : xmlBrowser;
        testAgainCount = xmlTestAgainount == null ?  Constants.defaultTestAgainCount : Integer.valueOf(xmlTestAgainount);
    }

    public static String getBaseUrl() {
        return baseUrl;
    }

    public static String getBrowser() {
        return browser;
    }

    public static int getTestAgainCount() {
        return testAgainCount;
    }

    @AfterTest
    public void tearDown(){
        Driver.closeDriver();
    }
}
