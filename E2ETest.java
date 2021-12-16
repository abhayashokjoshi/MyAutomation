package com.vtiger.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vtiger.pages.CreateLeadPage;
import com.vtiger.pages.HomePage;
import com.vtiger.pages.LoginPage;

public class E2ETest extends BaseTest {
	
	@BeforeClass
	public void openapplication()
	{
		lauchApp();
	}
	
	@Test
	public void E2ELeadFunctionality_TC03() throws Exception
	{
		logger = extent.createTest("E2ELeadFunctionality_TC03");
		logger.info("Application launched");
		LoginPage lp = new LoginPage(driver,logger);
		HomePage hp =lp.login("admin", "admin");
		logger.pass("Login successfully with valid credentials");
		CreateLeadPage ldp = hp.clickOnCreateLead();
		ldp.verifyCreateLeadwithMandatoryField("Modi", "BJP");
		logger.pass("Lead created successfully");
		ldp.clickOnLogout();
		logger.pass("Logout successfully");
		extent.flush();
	}
	
	@AfterClass
	public void closeApp()
	{
		driver.quit();
	}

}
