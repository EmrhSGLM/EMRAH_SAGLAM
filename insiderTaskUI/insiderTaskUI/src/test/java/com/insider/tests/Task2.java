package com.insider.tests;

import com.insider.base.Base;
import com.insider.pages.HomePage;
import com.insider.pages.LeverApplicationFormPage;
import com.insider.pages.QualityAssurancePage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task2 extends Hook{

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

    @Test(description = "Task-2")
    public void test02(){
        //base.getHomePage();
        base.click(homePage.navBarCompanyText);
        base.click(homePage.navBarCarrersText);
        base.textVisible(homePage.ourLocationsText);
        base.textVerify(homePage.ourLocationsText, "Our Locations");
        base.componentSizeControl(homePage.carrersPageLocatonsComponent, "li", 25);
        base.textVisible(homePage.lifeAtInsiderText);
        base.textVerify(homePage.lifeAtInsiderText, "Life at Insider");
        base.componentSizeControl(homePage.imgOfLifeAtInsider, "div", 26);
    }

}
