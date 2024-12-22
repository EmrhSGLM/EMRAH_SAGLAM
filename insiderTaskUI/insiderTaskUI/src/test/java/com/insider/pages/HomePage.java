package com.insider.pages;

import com.insider.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//link[@rel='canonical']")
    public WebElement canonical;

    @FindBy(xpath = "(//a[@id='navbarDropdownMenuLink'])[5]")
    public WebElement navBarCompanyText;

    @FindBy(xpath = "//*[.='Careers']")
    public WebElement navBarCarrersText;

    @FindBy(xpath = "//h3[contains(text(),'Our Locations')]")
    public WebElement ourLocationsText;

    @FindBy(xpath = "(//ul[@class='glide__slides'])")
    public WebElement carrersPageLocatonsComponent;

    @FindBy(xpath = "//h2[.='Life at Insider']")
    public WebElement lifeAtInsiderText;

    //@FindBy(className = "swiper-wrapper")
    @FindBy(xpath = "//div[@class='swiper-wrapper']")
    public WebElement imgOfLifeAtInsider;









}
