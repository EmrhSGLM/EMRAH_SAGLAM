package com.insider.tests;

import com.insider.base.Base;
import com.insider.pages.HomePage;
import com.insider.pages.LeverApplicationFormPage;
import com.insider.pages.QualityAssurancePage;
import com.insider.report.Listener;
import com.insider.utilities.Constants;
import com.insider.utilities.TextConstants;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listener.class)
public class Task5 extends Hook{

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

    @Test(description = "Task-5")
    public void test05(){
        base.getPage(Constants.qaPageLinkPath);
        base.click(qualityAssurancePage.seeAllQAJobsButton);
        base.dropDown(qualityAssurancePage.selectFilterByLocation, TextConstants.istanbulText);
        base.dropDown(qualityAssurancePage.selectFilterByDepartment,TextConstants.qualityAssuranceText);
        base.getPage(Constants.qaPageLinkPath);
        base.click(qualityAssurancePage.seeAllQAJobsButton);
        base.dropDown(qualityAssurancePage.selectFilterByLocation, TextConstants.istanbulText);
        base.dropDown(qualityAssurancePage.selectFilterByDepartment,TextConstants.qualityAssuranceText);
        base.waitFor(2);
        base.scrool_X_Y_Down("0","700");
        base.sayfasinin_WindowHandleNumarasi_Listeye_Eklenir("Quality Assurance Position");
        base.click(qualityAssurancePage.viewRoleFirstButton);
        base.waitFor(2);
        base.driver_EnSonAcilanSekmeye_Tasinir();
        base.textVerify(leverApplicationFormPage.applicationForThisJobButton, "Application For This Job");
    }

}
