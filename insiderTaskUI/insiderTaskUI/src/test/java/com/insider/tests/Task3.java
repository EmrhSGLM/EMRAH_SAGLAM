package com.insider.tests;

import com.insider.base.Base;
import com.insider.pages.HomePage;
import com.insider.pages.LeverApplicationFormPage;
import com.insider.pages.QualityAssurancePage;
import com.insider.utilities.Constants;
import com.insider.utilities.TextConstants;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task3 extends Hook{
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


    @Test(description = "Task-3")
    public void test03(){
        base.getPage(Constants.qaPageLinkPath);
        base.click(qualityAssurancePage.seeAllQAJobsButton);
        base.dropDown(qualityAssurancePage.selectFilterByLocation, TextConstants.istanbulText);
        base.dropDown(qualityAssurancePage.selectFilterByDepartment,TextConstants.qualityAssuranceText);
    }


}
