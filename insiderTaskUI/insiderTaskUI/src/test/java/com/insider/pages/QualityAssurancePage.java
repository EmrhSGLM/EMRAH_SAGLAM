package com.insider.pages;

import com.insider.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QualityAssurancePage {

    public QualityAssurancePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[contains(text(),'See all QA jobs')]")
    public WebElement seeAllQAJobsButton;

    @FindBy(id = "filter-by-location")
    public WebElement selectFilterByLocation;

    @FindBy(id = "filter-by-department")
    public WebElement selectFilterByDepartment;

    @FindBy(xpath = "//div[@id='jobs-list']//div//div//p")
    public WebElement titleTexts;

    @FindBy(xpath = "//div[@id='jobs-list']//div//div//div")
    public WebElement departmentTexts;

    @FindBy(xpath = "//div[@id='jobs-list']//div//div")
    public WebElement locationTexts;

    @FindBy(xpath = "//h3[contains(text(),'Browse')]")
    public WebElement openPositionText;

    @FindBy(xpath = "//*[.='View Role']")
    public WebElement viewRoleFirstButton;

    public static final By jobLocations = By.xpath("//div[@id='jobs-list']//div//div//div");
    public static final By jobDepartments = By.xpath("//div[@id='jobs-list']//div//div//span");
    public static final By jobTitles = By.xpath("//div[@id='jobs-list']//div//div//p");


}
