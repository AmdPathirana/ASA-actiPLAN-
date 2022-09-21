package com.actitime.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.actitime.qa.base.TestBase;

import net.bytebuddy.asm.Advice.Return;

public class HomePage extends TestBase {

	
	//Page Factory - Object Repository
	
		@FindBy(xpath = "//a[@class='content tasks']")
		WebElement taskLink;
		
		@FindBy(xpath = "//a[@class='content reports']")
		WebElement reportsLink;
		
		@FindBy(xpath = "//div[@id='logo_aT']")
		WebElement actitimeLogo;
		
	
		
		//initialization
		
		public HomePage() {
			
			PageFactory.initElements(driver, this);
		}
		
		
		//Action/Methods
		
		public Boolean validateActiTimeLogo() {
			return actitimeLogo.isDisplayed();
		}
		
		 public void verifyHomePageTitle() {
		        String expTitle = "actiTIME - Enter Time-Track";
		        String actTitle = driver.getTitle();
		        Assert.assertEquals(actTitle, expTitle);
		 }
		
		
		public TasksPage clickOnTaskLink() {
			
			taskLink.click();
			return new TasksPage();
			
		}
		
		
        public ReportsPage clickOnReportsLink() {
			
	         reportsLink.click();
	         return new ReportsPage();
			
		}
	
}
