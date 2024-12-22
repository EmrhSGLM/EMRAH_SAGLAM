package com.insider.base;

import com.insider.tests.Hook;
import com.insider.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Base {

    private WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
    private JavascriptExecutor jse;
    private static String comparePageWindowHandle;
    private List<String> handleTorba ;

    public void getHomePage(){
        Driver.getDriver().get(Hook.getBaseUrl());
    }
    public void getPage(String path){
        Driver.getDriver().get(Hook.getBaseUrl()+path);
    }

    public void waitFor(int second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String returnOfAttributeValue(WebElement element, String nameOfAttribute){
        return element.getAttribute(nameOfAttribute);
    }

    public String returnOfTitle(){
        return Driver.getDriver().getTitle();
    }

    public void click(WebElement element){
        //wait.until(ExpectedConditions.elementToBeClickable(element));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public void textVisible(WebElement element){
        ExpectedConditions.visibilityOf(element);
    }

    public void textVerify(WebElement element, String expectedText){
        String actualText = element.getText().trim();
        Assert.assertEquals(actualText, expectedText, "Metinler eşleşmiyor");
    }

    public void componentSizeControl(WebElement element, String tagName, int expectedSize){
        List<WebElement> liElements = element.findElements(By.tagName(tagName));
        Assert.assertEquals(liElements.size(), expectedSize, "Component Size değeri hatalı");
    }

    public void dropDown(WebElement element, String str) {
        // Dropdown icindeki istenilen elemani secme islemini gerceklestirir.
        wait.until(ExpectedConditions.visibilityOf(element));
        Select select = new Select(element);
        select.selectByVisibleText(str);
    }

    public void jobInfoCheck(By by, String expectedText){
        List<WebElement> locationElements = Driver.getDriver().findElements(by);
        List<String> list = new ArrayList<>();
        for(WebElement locationElement : locationElements ){
            Assert.assertEquals(locationElement.getText(), expectedText,"İş başvurusu "+expectedText+" içermiyor");
            list.add(locationElement.getText());
        }
        System.out.println("list = " + list);
    }

    public void scroolIntoElement(WebElement element) {
        jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", element);
        jse.executeScript("window.scrollBy(0,500)", "");
    }

    public void scrool_X_Y_Down(String x, String y){
        jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("window.scrollBy("+x+","+y+")", "");
    }

    public void actionDo(int nu){
        Actions actions = new Actions(Driver.getDriver());
        for(int i =1 ; i <= nu; i++) {
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            System.out.println("i = " + i);
        }
    }

    public void sayfasinin_WindowHandleNumarasi_Listeye_Eklenir(String pageName){
        handleTorba = new ArrayList<>();
        comparePageWindowHandle = Driver.getDriver().getWindowHandle();
        handleTorba.add(comparePageWindowHandle);
        comparePageWindowHandle = null;
    }

    public void driver_EnSonAcilanSekmeye_Tasinir() {
        waitFor(3);
        windowHandleCoklu(handleTorba);
    }

    public void windowHandleCoklu(List<String> oldList) {
        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
        int i = 0;
        for (String handle : windowHandles) {
            i = 0;
            for (int j = 0; j < oldList.size(); j++) {
                if (handle.equals(oldList.get(j))) {
                    i++;
                }
            }
            if (i == 0) {
                Driver.getDriver().switchTo().window(handle); // Switch to the pop-up window
                break;
            }
        }
    }

}
