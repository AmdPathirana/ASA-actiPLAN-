package com.actitime.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.actitime.qa.base.TestBase;

import net.bytebuddy.asm.Advice.Return;

public class ApproveTimeTrackPage extends TestBase {

	
	//Page Factory - Object Repository
	
		
	@FindBy(xpath = "//*[@id=\"container\"]/table/tbody/tr/td/div[1]/table/tbody/tr/td[1]")
    WebElement approveTimeTrackHeading;

    @FindBy(xpath = "//*[@id=\"statusFilterButton\"]")
    WebElement filter;
	
		
		//initialization
		
		public ApproveTimeTrackPage() {
			PageFactory.initElements(driver, this);
		}
		
		
		//Action/Methods
		
       
	
}
