package com.vtiger.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vtiger.pages.CreateLeadPage;
import com.vtiger.pages.HomePage;
import com.vtiger.pages.LoginPage;

public class TestDataCreation extends BaseTest {
	
	@BeforeClass
	public void openapplication()
	{
		lauchApp();
	}
	
	@Test
	public void E2ELeadFunctionality_TC03() throws Exception
	{
		LoginPage lp = new LoginPage(driver,logger);
		HomePage hp =lp.login("admin", "admin");
		CreateLeadPage ldp = hp.clickOnCreateLead();
		ldp.verifyCreateLeadwithMandatoryField("Abhay", "Tester");
		ldp.clickOnLogout();		
	}
	
	@Test(dataProvider = "leadData")
	public void E2ELeadFunctionality_TC05(String lname, String comp) throws Exception
	{
		LoginPage lp = new LoginPage(driver,logger);
		HomePage hp =lp.login("admin", "admin");
		CreateLeadPage ldp = hp.clickOnCreateLead();
		ldp.verifyCreateLeadwithMandatoryField(lname, comp);
		ldp.clickOnLogout();		
	}
	
	@AfterClass
	public void closeApp()
	{
		driver.quit();
	}
	
	
	@DataProvider
	  public Object[][] leadData() {
	    return new Object[][] {
	      new Object[] { "Modi", "BJP"},
	      new Object[] { "Shah", "Amit"},
	      new Object[] { "Singh", "Rajnath"},
	      new Object[] { "Yogi", "Aditya"},
	    };
	  }

}
