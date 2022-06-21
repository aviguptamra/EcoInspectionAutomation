package com.ECO.qa.testcases;

import com.ECO.qa.base.TestBase;
import com.ECO.qa.pages.*;
import com.ECO.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
	HomePage homePage;
	CheckRepairEstimatePage CREPage;
	BookInspectionPage BIPage;
	SignUpPage signUpPage;
	FeaturesPage featuresPage;
	TestUtil testUtil;
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		testUtil = new TestUtil();
		homePage = new HomePage();
		CREPage = new CheckRepairEstimatePage();
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest(){
		String title = homePage.validateHomePageTitle();
		Assert.assertEquals(title, "Check Motor Vehicle Inspection, Auto Mechanic near me for Cars, Bikes & Scooters");
	}
	
	@Test(priority = 2)
	public void ECOLogoImageTest(){
		boolean flag = homePage.validateECOImage();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void CREbuttonTest(){
		CREPage = homePage.validateCREbtn();
	}

	@Test(priority = 4)
	public void BIBbuttonTest(){
		BIPage = homePage.validateBookInspectionBuyerbtn();
	}

	@Test(priority = 5)
	public void RegTechbuttonTest(){
		signUpPage = homePage.validateRegisterTechbtn()	;
	}

	@Test(priority = 6)
	public void FeaturesbtnTest(){
		featuresPage = homePage.validateFeaturesbtn();
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}
