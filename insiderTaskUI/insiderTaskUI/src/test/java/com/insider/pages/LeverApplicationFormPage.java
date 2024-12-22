package com.insider.pages;

import com.insider.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeverApplicationFormPage {

    public LeverApplicationFormPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath="//a[@class='postings-btn template-btn-submit shamrock']")
    public WebElement applicationForThisJobButton;

}
