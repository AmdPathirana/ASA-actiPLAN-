package com.actitime.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.ApproveTimeTrackPage;
import com.actitime.qa.pages.HomePage;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.pages.ViewTimeTrackPage;

public class TimeTrackTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	ViewTimeTrackPage viewTimeTrackPage;
	ApproveTimeTrackPage approveTimeTrackPage;

	
	public TimeTrackTest() {
		super();
		
	}
	
	
	@BeforeMethod
	public void seup() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.loging(properties.getProperty("username"), properties.getProperty("password"));
		
	}
	
	
	@Test(priority = 1)
	public void viewTimeTrackTest() throws InterruptedException {
		viewTimeTrackPage = homePage.clickOnSwitchToViewTimeTrack();
		viewTimeTrackPage.selectRandomUser();
	}
	
	
	 @Test(priority = 2)
	    public void approveTimeTrack() throws InterruptedException {
		 approveTimeTrackPage = homePage.clickOnSwitchToApproveTimeTrack();
		 approveTimeTrackPage.viewPendingTimeSheets();
		 approveTimeTrackPage.selectFirstTimeSheet();
		 approveTimeTrackPage.approveSelected();
	    }

	    @Test(priority = 3)
	    public void rejectTimeTrack() throws InterruptedException {
	    	approveTimeTrackPage = homePage.clickOnSwitchToApproveTimeTrack();
	    	approveTimeTrackPage.selectFirstTimeSheet();
	    	approveTimeTrackPage.rejectSelected();
	    }
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
}
