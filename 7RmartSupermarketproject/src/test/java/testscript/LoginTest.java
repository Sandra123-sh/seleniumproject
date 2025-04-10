package testscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messeges;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	HomePage homepage;

	@Test(description = "verify whether user is able to successfully login with valid credentials", retryAnalyzer = retry.Retry.class)
	public void verifyUserCanLoginWithValidCredentials() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue)
				.clickonloginbutton();
		boolean isDashboardDisplayed = login.isDashboardDisplayed();
		Assert.assertTrue(isDashboardDisplayed, Messeges.VALIDCREDENTIALERROR);

	}

	@Test(description = "verify whether user is able to successfully login with valid credentials", groups = {
			"smoke" })
	public void verifyWhetherUserCanLoginWithValidUsernameAndInvalidPassword() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue)
				.clickonloginbutton();
		boolean isAlertDisplayed = login.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed, Messeges.INVALIDCPASSWORDERROR);

	}

	@Test(description = "verify whether user is able to successfully login with valid credentials")
	public void verifyWhetherUserCanLoginWithInvalidUsernameAndValidPassword() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(2, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue)
				.clickonloginbutton();
		boolean isValidationMessegeDisplayed = login.isValidationMessegeDisplayed();
		Assert.assertTrue(isValidationMessegeDisplayed, Messeges.INVALIDUSERNAMEERROR);

	}

	@Test(description = "verify whether user is able to successfully login with valid credentials", groups = {
			"smoke" }, dataProvider = "loginProvider")
	public void verifyWhetherUserCanLoginWithInvalidCredentials(String usernamevalue, String passwordvalue)
			throws IOException {
		// String usernamevalue=ExcelUtility.getStringData(3, 0,"LoginPage");
		// String passwordvalue=ExcelUtility.getStringData(3, 1,"LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		homepage = login.clickonloginbutton();
		// boolean isAlertIsDisplayed=login.isAlertIsDisplayed();
		// Assert.assertTrue(isAlertIsDisplayed,Messeges.INVALIDCREDENTIALERROR);

	}

	@DataProvider(name = "loginProvider")

	public Object[][] getDataFromDataProvider() throws IOException

	{

		return new Object[][] { new Object[] { "admin", "admin12" },

				new Object[] { "123", "123" },

				// new Object[] {ExcelUtility.getStringData(3,
				// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}

		};
	}
}
