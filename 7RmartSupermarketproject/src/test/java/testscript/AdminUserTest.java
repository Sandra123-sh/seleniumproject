package testscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messeges;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUserTest extends Base {
	AdminUserPage adminuser;
	HomePage homepage;

	@Test
	public void verifyWhetherAdminCanManageUsers() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		homepage = login.clickonloginbutton();

		String usernamevalue = ExcelUtility.getStringData(0, 0, "AdminUserPage");
		String passwordvalue = ExcelUtility.getStringData(1, 0, "AdminUserPage");
		homepage.clickOnAdminUser();
		adminuser = homepage.clickOnManageUser();
		// AdminUserPage adminuser=new AdminUserPage(driver);
		adminuser.clickOnNew();
		adminuser.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordTitle(passwordvalue)
				.selectUseridType();
		adminuser.clickOnSave();
		boolean isAlertDisplayed = adminuser.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed, Messeges.ADMINMANAGEUSER);

	}

	@Test
	public void verifyWhetherAdminCanSearchUsers() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		homepage = login.clickonloginbutton();
		adminuser = homepage.clickOnAdminUser();
		adminuser = homepage.clickOnManageUser();
		String usernamevalue = ExcelUtility.getStringData(0, 0, "AdminUserPage");
		// AdminUserPage adminuser=new AdminUserPage(driver);
		adminuser.clickOnSearch().enterUsername1(usernamevalue).selectuserid1();
		adminuser.clickOnSearch1();
		boolean isSearchIconDisplayed = adminuser.isSearchIconDisplayed();
		Assert.assertTrue(isSearchIconDisplayed, Messeges.ADMINCANNOTSEARCHUSER);

	}

}
