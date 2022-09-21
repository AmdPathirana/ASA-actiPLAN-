package com.actitime.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.actitime.qa.base.TestBase;

import net.bytebuddy.asm.Advice.Return;

public class ActiPlanPage extends TestBase {

	
	//Page Factory - Object Repository
	
		
	
	@FindBy(xpath = "//*[@id=\"topnav\"]/tbody/tr/td[6]/a")
	WebElement usersLink;
	
		
		//initialization
		
		public ActiPlanPage() {
			
			PageFactory.initElements(driver, this);
		}
		
		
		//Action/Methods
		
		
		 public void verifyActiPlanPageTitle() {
		        String expTitle = "actiPLANS - My Schedule";
		        String actTitle = driver.getTitle();
		        Assert.assertEquals(actTitle, expTitle);
		 }
		
		
		public UsersPage clickOnUsersLink() {
			
			usersLink.click();
			return new UsersPage();
			
		}
		
		
       
	
}
