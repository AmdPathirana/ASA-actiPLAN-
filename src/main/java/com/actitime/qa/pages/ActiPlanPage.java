package com.actitime.qa.pages;

import org.openqa.selenium.By;
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
	
	@FindBy(xpath = "//*[@id=\"topnav\"]/tbody/tr/td[4]/a")
	WebElement leaveMgtLink;
	

    @FindBy(xpath = "//*[@id=\"welcomeScreenLightbox_content\"]")
    WebElement modal;

    @FindBy(xpath = "//*[@id=\"welcomeScreenLightbox_content\"]/table/tbody/tr/td/div[1]")
    WebElement modalCloseBtn;
		
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
		
		
		public UsersPage clickOnUsersLink() throws InterruptedException {
			Thread.sleep(5000);
	        if (!driver.findElements(By.xpath("//*[@id=\"welcomeScreenLightbox_content\"]")).isEmpty()) {
	            modalCloseBtn.click();
	        }
			usersLink.click();
			return new UsersPage();
			
		}
		
		public LeaveManagmentPage clickOnLeaveMgtLink() throws InterruptedException {
			Thread.sleep(5000);
	        if (!driver.findElements(By.xpath("//*[@id=\"welcomeScreenLightbox_content\"]")).isEmpty()) {
	            modalCloseBtn.click();
	        }
			leaveMgtLink.click();
			return new LeaveManagmentPage();
			
		}
		
		
       
	
}
