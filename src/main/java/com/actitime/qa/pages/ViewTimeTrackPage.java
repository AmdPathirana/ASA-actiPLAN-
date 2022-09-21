package com.actitime.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.actitime.qa.base.TestBase;

import net.bytebuddy.asm.Advice.Return;

public class ViewTimeTrackPage extends TestBase {

	
	//Page Factory - Object Repository

	@FindBy(xpath = "//*[@id=\"viewTTContent\"]/table/tbody/tr/td[2]/table/tbody/tr/td[2]")
    WebElement userDropDown;

    @FindBy(xpath = "//*[@id=\"viewTTDetailsTableContainer\"]/div/div[1]")
    WebElement timeTrackDetailsTopic;
    
  
    @FindBy(xpath = "//*[@id=\"viewTTChartSectionContainer\"]/div")
    WebElement chartSection;
		
		//initialization
		public ViewTimeTrackPage() {
			PageFactory.initElements(driver, this);
		}
		
		
		//Action/Methods
		public void selectRandomUser() throws InterruptedException {
	        userDropDown.click();
	        List<WebElement> users = driver.findElements(By.className("userName"));
	        int random = (int)(Math.random()*(5-1+1)+1);
	        users.get(random).click();
	        Thread.sleep(5000);
	        Assert.assertTrue(chartSection.isDisplayed());
	    }
		
       
}
