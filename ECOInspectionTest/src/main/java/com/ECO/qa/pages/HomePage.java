package com.ECO.qa.pages;

import com.ECO.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {
	
	//Page Factory - OR:
	@FindBy(xpath="//a[text()='Check repair estimate']")
	WebElement CheckRepairEstimatebtn;
	
	@FindBy(xpath="//a[text()='Check repair estimate']/following-sibling::a")
	WebElement BookInspectionBuyerbtn;
	
	@FindBy(xpath="//img[@alt='ECO' and @class = 'default-img']")
	WebElement ECOLogo;

	@FindBy(xpath="//ul[@class='rounded-3 list-unstyled px-lg-4 px-2 py-2 py-lg-3 d-flex align-content-start flex-wrap']/following-sibling::div/a[text()='Register as Technician']")
	WebElement RegisterTechbtn;

	@FindBy(xpath="//a[text()='Features']")
	WebElement Featuresbtn;
	@FindBy(xpath="//a[text()='Register as Vendor']/following-sibling::a")
	WebElement BookInspectionSellerbtn;
	//Initializing the Page Objects:
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateECOImage(){
		return ECOLogo.isDisplayed();
	}

	public CheckRepairEstimatePage validateCREbtn() {
		CheckRepairEstimatebtn.click();
		return new CheckRepairEstimatePage();
	}

	public BookInspectionPage validateBookInspectionBuyerbtn() {
		BookInspectionBuyerbtn.click();
		return new BookInspectionPage();
	}
	public BookInspectionPage validateBookInspectionSellerbtn(){
		BookInspectionSellerbtn.click();
		return new BookInspectionPage();
	}

	public SignUpPage validateRegisterTechbtn() {
		RegisterTechbtn.click();
		return new SignUpPage();
	}

	public FeaturesPage validateFeaturesbtn() {
		Featuresbtn.click();
		return new FeaturesPage();
	}

}
