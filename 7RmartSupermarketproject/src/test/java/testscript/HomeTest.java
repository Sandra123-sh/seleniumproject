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
import utilities.ExcelUtility;

public class HomeTest extends Base {
	HomePage homepage;

	@Test
	public void verifyWhetherUserCanLogout() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		homepage = loginpage.clickonloginbutton();
		homepage.clickOnAdmin();
		homepage.clickOnLogout();
		String actualresult = homepage.getTextFromTitle();
		String expectedresult = "7rmart supermarket";
		Assert.assertEquals(actualresult, expectedresult, Messeges.USERCANNOTLOGOUT);

	}

}
