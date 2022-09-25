package com.actitime.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.actitime.qa.base.TestBase;

public class LeaveTimeRequestPage extends TestBase  {
	
	@FindBy(xpath = "//*[@id=\"ext-gen24\"]")
    WebElement statusFilter;
	
	
	@FindBy(xpath = "//*[@id=\"requestsTableContainer\"]/table/tbody[1]/tr[1]/td[7]/table")
    WebElement statusLabel;
	
	@FindBy(xpath = "//*[@id=\"requestsTableContainer\"]/table/tbody[1]/tr[1]/td[7]/table/tbody/tr/td[2]/div/span[1]")
    WebElement status;
	
	
	 @FindBy(xpath = "//*[@id=\"corporateScheduleTable\"]/tbody/tr[1]/td/span/span[2]")
	 WebElement approveBtn;
	
	 @FindBy(xpath = "//*[@id=\"corporateScheduleTable\"]/tbody/tr[1]/td/span/span[3]")
	 WebElement rejectBtn;
	 
	 @FindBy(xpath = "//*[@id=\"rejectDialogDiv\"]/textarea")
	 WebElement rejectReason;

	 @FindBy(xpath = "//*[@id=\"rejectDialogDiv\"]/div[2]/div[1]")
	 WebElement rejectSubmitBtn;
	
	
	public LeaveTimeRequestPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void validateLeavePageTitle() {
		String actualHeading = driver.getTitle();
		String expectedHeading = "actiPLANS - Leave Time Requests";
		Assert.assertEquals(actualHeading,expectedHeading);		
	}
	
	public void filterByStatus(String status) {
        statusFilter.click();
        driver.findElement(By.linkText(status)).click();
    }
	
	public void clickApprove() throws InterruptedException {
		List<WebElement> checkboxes = driver.findElements(By.className("applicableLabel"));
		checkboxes.get(0).click();
		approveBtn.click();
		Thread.sleep(3000);
        Assert.assertEquals(status.getText(),"Approved");
    }
	
	public void clickReject() throws InterruptedException {
		List<WebElement> checkboxes = driver.findElements(By.className("applicableLabel"));
		checkboxes.get(0).click();
		rejectBtn.click();
		rejectReason.sendKeys("invalid request");
        rejectSubmitBtn.click();
		Thread.sleep(1000);
        Assert.assertEquals(status.getText(),"Rejected");
    }

}
