package com.ECO.qa.pages;

import com.ECO.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckRepairEstimatePage extends TestBase {

    @FindBy(xpath="//span[@id='select2-chosen-1']")
    WebElement Car_Make;

    @FindBy(xpath="//a[@id='eco-repest-step-one']")
    WebElement NextBtn;

    @FindBy(xpath="//img[@alt='Estimated Information']")
    WebElement CREImage;

    public CheckRepairEstimatePage() { PageFactory.initElements(driver, this); }

    public String validateCREPageTitle(){
        return driver.getTitle();
    }

    public boolean validateCREImage(){
        return CREImage.isDisplayed();
    }

    public void FillCREForm(String Make, String Model, String Trim, String Location) throws InterruptedException {
        Car_Make.click();
        Car_Make = driver.findElement(By.xpath("//input[@class='select2-input' and starts-with(@id,'s2id_autogen') and starts-with(@aria-activedescendant,'select2-result')]"));
        Car_Make.sendKeys(Make);
        Car_Make.sendKeys(Keys.ENTER);

        Thread.sleep(5000);
        WebElement Car_Model = driver.findElement(By.xpath("//input[@class='select2-input' and starts-with(@id,'s2id_autogen') and starts-with(@aria-activedescendant,'select2-result')]"));
        Car_Model.sendKeys(Model);
        Car_Model.sendKeys(Keys.ENTER);

        Thread.sleep(5000);
        WebElement Car_Trim = driver.findElement(By.xpath("//div[@id='select2-drop']/div/input"));
        Car_Trim.sendKeys(Trim);
        Car_Trim.sendKeys(Keys.ENTER);

        Thread.sleep(2000);
        WebElement Loc = driver.findElement(By.xpath("//div[@class='lp-element location-plugin']/input[@type='text']"));
        Loc.click();
        Loc = driver.findElement(By.xpath("//span[@class='lp-locate-me-btn']"));
        Loc.click();
        Thread.sleep(3000);

        NextBtn.click();

        Thread.sleep(10000);
        WebElement EngineRepair = driver.findElement(By.xpath("//div[@class='check-price']/label[@class='wrapper']/input[@value='Radiator']/following-sibling::span"));
        EngineRepair.click();

        Thread.sleep(3000);
        WebElement BrakeRepair = driver.findElement(By.xpath("//div[@id='heading-brakes-repair-service']/h4/a"));
        BrakeRepair.click();
        WebElement BrakeRepair_Oil = driver.findElement(By.xpath("//input[@value='Brake Oil']/following-sibling::span"));
        BrakeRepair_Oil.click();
        Thread.sleep(1000);

        WebElement GetEstimate = driver.findElement(By.xpath("//a[@id='eco-repest-step-two']"));
        GetEstimate.click();
    }
}
