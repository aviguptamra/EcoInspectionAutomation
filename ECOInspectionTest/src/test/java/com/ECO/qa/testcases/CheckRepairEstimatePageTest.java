package com.ECO.qa.testcases;

import com.ECO.qa.base.TestBase;
import com.ECO.qa.pages.CheckRepairEstimatePage;
import com.ECO.qa.pages.HomePage;
import com.ECO.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckRepairEstimatePageTest extends TestBase {
    HomePage homePage;
    CheckRepairEstimatePage CREPage;
    String sheet = "Repair";
    TestUtil testUtil;
    public CheckRepairEstimatePageTest() {super();}

    @BeforeMethod
    public void setup(){
        initialization();
        testUtil = new TestUtil();
        homePage = new HomePage();
        CREPage = homePage.validateCREbtn();
    }

    @Test(priority = 1)
    public void loginPageTitleTest(){
        String title = CREPage.validateCREPageTitle();
        Assert.assertEquals(title, "Droom :: Repair Estimate");
    }

    @Test(priority = 2,enabled = false)
    public void ECOLogoImageTest(){
        boolean flag = CREPage.validateCREImage();
        Assert.assertTrue(flag);
    }

    @Test(priority = 3,enabled = true)
    public void FormTest() throws InterruptedException {
        CREPage.FillCREForm(prop.getProperty("Make"), prop.getProperty("Model"), prop.getProperty("Trim"), "");
    }

    @DataProvider
    public Object[][] getECOTestData(){
        Object data[][] = TestUtil.getTestData(sheet);
        return data;
    }
    @Test(priority = 4, dataProvider = "getECOTestData")
    public void TestCRE(String Make, String Model, String Trim) throws InterruptedException {
        CREPage.FillCREForm(Make,Model,Trim,"");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
