package testscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messeges;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;
import utilities.WaitUtility;

public class ManageNewsTest extends Base {
	ManageNewsPage managenews;
	HomePage homepage;
	@Test
	public void verifyWhetherUserCanManageNews() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(0, 0,"LoginPage");
		String passwordvalue=ExcelUtility.getStringData(0, 1,"LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		homepage=login.clickonloginbutton();
		managenews=homepage.clickOnManageNews();
		//ManageNewsPage managenews=new ManageNewsPage(driver);
		String newsdescription=ExcelUtility.getStringData(0, 0,"ManageNewsPage");
		managenews=homepage.clickOnManageNews();
		managenews.clickOnNew().enterOnNews(newsdescription).clickOnSave();
		boolean isAlertMessegeDisplayed=managenews.isAlertMessegeDisplayed();
		Assert.assertTrue(isAlertMessegeDisplayed,Messeges.USERCANNOTCREATENEW);
		
		
	}
	
	@Test
	public void verifyWhetherUserCanSearchNews() throws IOException
	{
		String username=ExcelUtility.getStringData(0, 0,"LoginPage");
		String passwordvalue=ExcelUtility.getStringData(0, 1,"LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(passwordvalue);
		homepage=login.clickonloginbutton();
		managenews=homepage.clickOnManageNews();
		String titledescription=ExcelUtility.getStringData(0,0,"ManageNewsPage");
		//ManageNewsPage managenews=new ManageNewsPage(driver);
		managenews.clickOnSearch().enterNewsOnTitle(titledescription);
		managenews.clickOnSearchNews();
		boolean isSearchIconDisplayed=managenews.isSearchIconDisplayed();
		Assert.assertTrue(isSearchIconDisplayed,Messeges.USERCANNOTCREATENEWS);
		
		
	}
	
	
	
	
	
	
	
	

}
