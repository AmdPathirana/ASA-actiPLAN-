package com.actitime.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.actitime.qa.base.TestBase;

public class UsersPage extends TestBase  {
	
	@FindBy(xpath = "//*[@id=\"title\"]")
	WebElement userPageHeading;

	@FindBy(xpath = "//*[@id=\"userListTable\"]/tbody[1]/tr[1]/td[23]")
	WebElement approveCell;
	
	
	@FindBy(xpath = "//*[@id=\"approversDialog_treeContainer\"]/div[1]/div[2]/div/a/span[1]")
	WebElement adminCheckBox;
	
	
	@FindBy(xpath = "//*[@id=\"approversDialog_submitButton\"]")
	WebElement approveBtn;
	
	
	@FindBy(xpath = "//*[@id=\"userListTable\"]/tbody[1]/tr[1]/td[24]/span")
	WebElement status;
	
	
	@FindBy(xpath = "//*[@id=\"userListTable\"]/tbody[1]/tr[1]/td[1]/div[1]/span[2]")
	WebElement userName;
	
	@FindBy(xpath = "//*[@id=\"userDataLightBox_accountInformationSection\"]/div[1]")
	WebElement accountInfoHeading;
	
	
	public UsersPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void validateUserHeading() {
		String actualHeading = userPageHeading.getText();
		String expectedHeading = "User List";
		Assert.assertEquals(actualHeading,expectedHeading);		
	}
	
	public void changeApprovals() {
		approveCell.click();
		adminCheckBox.click();
		approveBtn.click();
	}
	
	public void changeStatus() throws InterruptedException {
		String initialStatus = status.getText();
		status.click();
		Thread.sleep(1000);
		String changedStatus = status.getText();
		Assert.assertNotEquals(initialStatus,changedStatus);
				
	}
	
	public void viewInformation() throws InterruptedException {
		userName.click();
		Thread.sleep(1000);
		Assert.assertEquals(accountInfoHeading.getText(),"Account Information");
	}
	
	

}
