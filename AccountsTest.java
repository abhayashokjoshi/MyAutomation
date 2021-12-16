package com.vtiger.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vtiger.lib.CommonFunctions;
import com.vtiger.pages.AccountsPage;
import com.vtiger.pages.CreateLeadPage;
import com.vtiger.pages.HomePage;
import com.vtiger.pages.LoginPage;

public class AccountsTest extends BaseTest{
	
	@BeforeClass
	public void openapplication()
	{
		lauchApp();
	}
	
	@Test
	public void AccountsFunctionality_TC04() throws Exception
	{
		logger = extent.createTest("AccountsFunctionality_TC04");
		logger.info("Application launched");
		LoginPage lp = new LoginPage(driver,logger);
		HomePage hp =lp.login("admin", "admin");
		logger.pass("Login successfully with valid credentials");
		AccountsPage Acp = hp.clickOnCreateNewAccount();
		Acp.verifyCreateAccountswithMandatoryField("Abhay Marketing","www.abhaymarketing.com","1");
		logger.pass("New Account created successfully");
		Acp.clickOnLogout();
		logger.pass("Logout successfully");
		extent.flush();
	}
	
	@Test
	public void verifyDeleteCreatedAccountInfo_TC05()throws Exception
	{
		logger = extent.createTest("AccountsFunctionality_TC04");
		logger.info("Application launched");
		LoginPage lp = new LoginPage(driver,logger);
		HomePage hp =lp.login("admin", "admin");
		logger.pass("Login successfully with valid credentials");
		AccountsPage Acp = hp.clickOnAccounts();
		Acp.clickOnChkbox();
		Thread.sleep(5000);
		Acp.clickOnDelBtn();
		System.out.println("Account Deleted Successfully.");
		logger.pass("Account Deleted Successfully.");
	}

	@AfterClass
	public void closeApp()
	{
		driver.quit();
	}
	
//	@DataProvider
//	  public Object[][] AccountData() {
//	    return new Object[][] {
//	      new Object[] { "Modi", "BJP","1"},
//	      new Object[] { "Shah", "Amit","2"},
//	      new Object[] { "Singh", "Rajnath","3"},
//	      new Object[] { "Yogi", "Aditya","4"},
//	    };
//	  }

}
