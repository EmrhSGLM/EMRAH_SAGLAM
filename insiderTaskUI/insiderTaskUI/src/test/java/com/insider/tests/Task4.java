package com.insider.tests;

import com.insider.base.Base;
import com.insider.pages.HomePage;
import com.insider.pages.LeverApplicationFormPage;
import com.insider.pages.QualityAssurancePage;
import com.insider.utilities.Constants;
import com.insider.utilities.TextConstants;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task4 extends Hook {

    Base base;
    QualityAssurancePage qualityAssurancePage;

    @BeforeTest
    public void setup(){
        base = new Base();
        base.getHomePage();
        qualityAssurancePage = new QualityAssurancePage();
    }

    @Test(description = "Task-4")
    public void test04(){
        base.getPage(Constants.qaPageLinkPath);
        base.click(qualityAssurancePage.seeAllQAJobsButton);
        base.dropDown(qualityAssurancePage.selectFilterByLocation, TextConstants.istanbulText);
        base.dropDown(qualityAssurancePage.selectFilterByDepartment,TextConstants.qualityAssuranceText);
        base.waitFor(5);
        base.scroolIntoElement(qualityAssurancePage.viewRoleFirstButton);
        base.scroolIntoElement(qualityAssurancePage.departmentTexts);
        base.jobInfoCheck(qualityAssurancePage.jobLocations, TextConstants.istanbulText);
        base.jobInfoCheck(qualityAssurancePage.jobDepartments, TextConstants.qualityAssuranceText);
        base.jobInfoCheck(qualityAssurancePage.jobTitles, TextConstants.qualityAssuranceText);
    }

}
