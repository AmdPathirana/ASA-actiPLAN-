package com.actitime.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.ActiPlanPage;
import com.actitime.qa.pages.HomePage;
import com.actitime.qa.pages.LeaveManagmentPage;
import com.actitime.qa.pages.LeaveTimeRequestPage;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.pages.UsersPage;

public class ViewLeaves extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	ActiPlanPage actiPlanPage;
	LeaveManagmentPage leaveMgtPage;
	LeaveTimeRequestPage leaveTimeRequestPage;

	public ViewLeaves() {
		super();
	}
	
	
	@BeforeMethod
	public void seup() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.loging(properties.getProperty("username"), properties.getProperty("password"));
		actiPlanPage = homePage.clickOnSwitchToActiPlans();
		leaveMgtPage = actiPlanPage.clickOnLeaveMgtLink();
	}
	
	
	@Test(priority = 1)
	public void leaveManagementPageLoadedTest() {
		leaveMgtPage.validateLeavePageTitle();
	}
	
	@Test(priority = 2)
	public void leaveRequestsPageLoadedTest() {
		leaveTimeRequestPage = leaveMgtPage.clickOnLeaveTimeRequestLink();
		leaveTimeRequestPage.validateLeavePageTitle();
	}
	
	@Test(priority = 2)
	public void approveLeaveRequest() throws InterruptedException {
		leaveTimeRequestPage = leaveMgtPage.clickOnLeaveTimeRequestLink();
		leaveTimeRequestPage.filterByStatus("Waiting for Approval");
		leaveTimeRequestPage.clickApprove();
	}
	
	
	@Test(priority = 2)
	public void rejectLeaveRequest() throws InterruptedException {
		leaveTimeRequestPage = leaveMgtPage.clickOnLeaveTimeRequestLink();
		leaveTimeRequestPage.filterByStatus("Waiting for Approval");
		leaveTimeRequestPage.clickReject();
	}
	
}
