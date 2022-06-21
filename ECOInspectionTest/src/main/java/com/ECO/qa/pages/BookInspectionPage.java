package com.ECO.qa.pages;

import com.ECO.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BookInspectionPage extends TestBase {

    @FindBy(xpath = "//select[@name='choose']")
    WebElement Vehicle;

    @FindBy(xpath = "//input[@id='when_need_date']")
    WebElement Date;

    @FindBy(xpath = "//select[@id='when_need_time']")
    WebElement Time;

    WebElement Plan;
    @FindBy(xpath = "//a[@id='eco-order-proceed']")
    WebElement Proceed;


    public BookInspectionPage(){
        PageFactory.initElements(driver,this);
    }

    public String validateBIPageTitle(){
        return driver.getTitle();
    }

    public void FillBIForm(String V, String P) throws InterruptedException {
        Thread.sleep(10000);
        //Clicking Vehicle dropdown box
        Vehicle.click();

        //Selecting the vehicle
        Select SelectVehicle = new Select(Vehicle);
        SelectVehicle.selectByVisibleText(V);

        //Selecting the date
//        Date.sendKeys(D);
//        Date.sendKeys(Keys.ENTER);

//        //Selecting the time
//        Select SelectTime = new Select(Time);
//        SelectTime.selectByVisibleText(T);

        //Selecting the plan depending on the vehicle
        if(V.equals("Car")){
            if(P.equals("Basic")) {
                Plan = driver.findElement(By.xpath("//div[@data-product-code='inspection_basic_car']"));
            }
            else if(P.equals("Premium")) {
                Plan = driver.findElement(By.xpath("//div[@data-product-code='inspection_premium_car']"));
            }
            else if(P.equals("Premium Plus")) {
                Plan = driver.findElement(By.xpath("//div[@data-product-code='inspection_premium_plus_car']"));
            }
            else if(P.equals("Title Certificate")) {
                Plan = driver.findElement(By.xpath("//div[@data-product-code='title_certificate_car']"));
            }
            else if(P.equals("Odometer Assurance")) {
                Plan = driver.findElement(By.xpath("//div[@data-product-code='odometer_assurance_car']"));
            }
            else{
                Plan = driver.findElement(By.xpath("//div[@data-product-code='engine_diagnostics_car']"));
            }
        }
        else if(V.equals("Bike")){
            if(P.equals("Basic")){
                Plan = driver.findElement(By.xpath("//div[@data-product-code='inspection_basic_bike']"));
            }
            else if(P.equals("Premium")){
                Plan = driver.findElement(By.xpath("//div[@data-product-code='inspection_premium_bike']"));
            }
            else{
                Plan = driver.findElement(By.xpath("//div[@data-product-code='title_certificate_bike']"));
            }
        }
        else{
            if(P.equals("Basic")){
                Plan = driver.findElement(By.xpath("//div[@data-product-code='inspection_basic_scooter']"));
            }
            else if(P.equals("Premium")){
                Plan = driver.findElement(By.xpath("//div[@data-product-code='inspection_premium_scooters']"));
            }
            else{
                Plan = driver.findElement(By.xpath("//div[@data-product-code='title_certificate_scooters']"));
            }
        }
        Thread.sleep(1000);
        Plan.click();
        Thread.sleep(2000);
        Proceed.click();

        WebElement emailButton = driver.findElement(By.xpath("//button[@id='loginWithEmail']"));
        emailButton.click();
        Thread.sleep(1000);

        WebElement userName = driver.findElement(By.xpath("//input[@id='email']"));
        userName.sendKeys(prop.getProperty("username"));
        Thread.sleep(1000);

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys(prop.getProperty("password"));
        Thread.sleep(1000);

        WebElement continueBtn = driver.findElement(By.xpath("//button[@id='continueEmail']"));
        continueBtn.click();
        Thread.sleep(5000);

        WebElement checkout = driver.findElement(By.xpath(("//div[starts-with(@class,'crtadd')]/button")));
        checkout.click();
        Thread.sleep(5000);

        WebElement continuePayment = driver.findElement(By.xpath("//div[starts-with(@class,'crtadd')]/button/span[contains(text(),'Continue')]"));
        continuePayment.click();
        Thread.sleep(5000);

        WebElement paymentOption = driver.findElement(By.xpath("//span[contains(text(),'Net Banking')]"));
        paymentOption.click();
        Thread.sleep(5000);

        WebElement finalContinue = driver.findElement(By.xpath("//div[starts-with(@class,'crtadd')]/button/span[contains(text(),'Continue')]"));
        finalContinue.click();
        Thread.sleep(5000);

        WebElement paymentBtn = driver.findElement(By.xpath("//button/span[contains(text(),'Pay Now')]"));
        paymentBtn.click();
        Thread.sleep(5000);

        driver.switchTo().frame(driver.findElement(By.className("razorpay-checkout-frame")));
        WebElement bank = driver.findElement(By.xpath("//div[contains(text(),'HDFC')]"));
        bank.click();
        Thread.sleep(5000);

        WebElement PayNow = driver.findElement(By.xpath("//div[@id='footer']"));
        PayNow.click();
        Thread.sleep(5000);

        WebElement success = driver.findElement(By.xpath("//button[@class='success']"));
        success.click();
        Thread.sleep(7000);


    }
}
