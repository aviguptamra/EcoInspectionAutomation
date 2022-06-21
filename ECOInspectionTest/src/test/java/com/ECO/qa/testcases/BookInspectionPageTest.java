package com.ECO.qa.testcases;

import com.ECO.qa.base.TestBase;
import com.ECO.qa.pages.BookInspectionPage;
import com.ECO.qa.pages.HomePage;
import com.ECO.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BookInspectionPageTest extends TestBase {

    HomePage homePage;
    BookInspectionPage BIPage;
    TestUtil testUtil;
    String sheet = "Inspection";

    public BookInspectionPageTest(){super();}

    @BeforeMethod
    public void setup(){
        initialization();
        testUtil = new TestUtil();
        homePage = new HomePage();
        BIPage = homePage.validateBookInspectionBuyerbtn();
    }

    @Test(priority = 1)
    public void loginPageTitleTest(){
        String title = BIPage.validateBIPageTitle();
        Assert.assertEquals(title, "Eco Inspection");
    }

    @Test(priority = 2,enabled = true)
    public void FormTest() throws InterruptedException {
        BIPage.FillBIForm(prop.getProperty("Vehicle"), "Basic");
    }

    @DataProvider
    public Object[][] getBookInspectionTestData(){
        Object data[][] = TestUtil.getTestData(sheet);
        return data;
    }
    @Test(priority = 4, dataProvider = "getBookInspectionTestData", enabled = true)
    public void TestBI(String Vehicle, String Plan) throws InterruptedException {
        BIPage.FillBIForm(Vehicle,Plan);
    }

    @AfterMethod
    public void TearDown(){
        driver.close();
    }

}
