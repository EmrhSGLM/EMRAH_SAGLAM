package com.insider.tests;

import com.insider.base.Base;
import com.insider.pages.HomePage;
import com.insider.pages.LeverApplicationFormPage;
import com.insider.pages.QualityAssurancePage;
import com.insider.report.Listener;
import com.insider.utilities.Constants;
import com.insider.utilities.TextConstants;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listener.class)
public class Task1 extends Hook{

    HomePage homePage;
    Base base;
    QualityAssurancePage qualityAssurancePage;
    LeverApplicationFormPage leverApplicationFormPage;

    @BeforeTest
    public void setup(){
        homePage = new HomePage();
        base = new Base();
        base.getHomePage();
        qualityAssurancePage = new QualityAssurancePage();
        leverApplicationFormPage = new LeverApplicationFormPage();
    }

    @Test(description = "Task-1")
    public void test01() {
        //base.getHomePage();
        base.waitFor(3);
        String homePageCanonicalLink  = base.returnOfAttributeValue(homePage.canonical, "href");
        String homePageTitle = base.returnOfTitle();
        Assert.assertEquals(homePageCanonicalLink, Constants.defaultUrl,"HomePage görüntülenemedi !!! - Canonical link uyuşmazlığı");
        Assert.assertEquals(homePageTitle, TextConstants.homePageTitle,"HomePage görüntülenemedi !!! - Title uyuşmazlığı");
    }



}
