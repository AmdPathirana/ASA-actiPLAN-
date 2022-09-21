package com.actitime.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.actitime.qa.base.TestBase;

public class LeaveManagmentPage extends TestBase  {
	
	@FindBy(xpath = "//*[@id=\"container_corporate_schedule\"]")
	WebElement leaveMgt;
	
	@FindBy(xpath = "//*[@id=\"title\"]")
	WebElement LeaveMgtHeading;
	
	@FindBy(xpath = "//*[@id=\"leaveTimePlanningPage\"]/tbody/tr[1]/td/div/span[2]/a")
	WebElement LeaveTimeRequestLink;
	
	
	
	public LeaveManagmentPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void validateLeavePageTitle() {
		String actualHeading = driver.getTitle();
		String expectedHeading = "actiPLANS - Leave Time Chart";
		Assert.assertEquals(actualHeading,expectedHeading);		
	}
	
	public LeaveTimeRequestPage clickOnLeaveTimeRequestLink() {
		LeaveTimeRequestLink.click();
		return new LeaveTimeRequestPage();
	}
	

}
