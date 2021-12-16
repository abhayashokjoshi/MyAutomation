package com.vtiger.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.vtiger.pages.LoginPage;

public class LoginTest extends BaseTest {
	
	@BeforeClass
	public void openapplication()
	{
		lauchApp();
	}
	
	@Test
	public void verifyLogoOnLoginPage_TC01() throws Exception
	{   
		logger = extent.createTest("verifyLogoOnLoginPage_TC01");
		logger.info("Application launched");
		LoginPage lp = new LoginPage(driver,logger);
		logger.info("Navigated to login page successfully");
		boolean val =lp.verifyLogo();
		Assert.assertEquals(val,true);
		logger.pass("Logo displayed successfully");
		extent.flush();
		
	}
	
	@Test
	public void verifyLoginInValidUser_TC02() throws Exception
	{
		logger = extent.createTest("verifyLoginInValidUser_TC02");
		LoginPage lp = new LoginPage(driver,logger);
		lp.login("admin1", "admin23");
		logger.pass("Login with invalid credentials");
		Assert.assertEquals(lp.verifyErrorMsg(),true);
		logger.pass("Error msg validated");
		extent.flush();
	}
	
	@AfterClass
	public void closeApp()
	{
		extent.flush();
		driver.quit();
	}
}
