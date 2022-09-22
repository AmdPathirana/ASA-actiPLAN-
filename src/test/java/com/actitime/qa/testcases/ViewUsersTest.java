package com.actitime.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.ActiPlanPage;
import com.actitime.qa.pages.HomePage;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.pages.UsersPage;

public class ViewUsersTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	ActiPlanPage actiPlanPage;
	UsersPage usersPage;
	
	public ViewUsersTest() {
		super();
	}
	
	
	@BeforeMethod
	public void seup() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.loging(properties.getProperty("username"), properties.getProperty("password"));
		actiPlanPage = homePage.clickOnSwitchToActiPlans();
		usersPage = actiPlanPage.clickOnUsersLink();
	}
	
	
	@Test(priority = 1)
	public void viewUsersTable() {	
		usersPage.validateUserHeading();
	}
	
	
	@Test(priority = 2)
	public void changeApprovedAdmin() {	
		usersPage.changeApprovals();
	}
	
	@Test(priority = 2)
	public void changeStatus() throws InterruptedException {	
		usersPage.changeStatus();
	}
	
	@Test(priority = 2)
	public void viewAccountInfo() throws InterruptedException {	
		usersPage.viewInformation();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
}
