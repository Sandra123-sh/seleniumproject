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
import pages.SubCategoryPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class SubcategoryTest extends Base {
	HomePage homepage;
	SubCategoryPage subcategory;

	@Test
	public void verifyWhetherUserCanAddSubcategoryPage() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		homepage = login.clickonloginbutton();
		// RandomDataUtility randomutility=new RandomDataUtility();
		// String selectsubcategoryvalue= randomutility.createRandomUsername();
		// String subcategoryvalue=randomutility.createRandomPassword();
		subcategory = homepage.clickOnSubcategory();
		subcategory = homepage.clickMoreinfo().clickOnNew();
		// SubCategoryPage subcategory=new SubCategoryPage(driver);
		String selectcategoryvalue1 = ExcelUtility.getStringData(0, 0, "SubcategoryPage");
		String subcategoryvalue1 = ExcelUtility.getStringData(0, 1, "SubcategoryPage");
		subcategory.SelectCategory(selectcategoryvalue1).enterSubCategory(subcategoryvalue1).selectFile().clickOnSave();
		boolean isSubcategoryAlertDisplayed = subcategory.isSubCategoryAlertDisplayed();
		Assert.assertTrue(isSubcategoryAlertDisplayed, Messeges.SUBCATEGORYADDED);
	}

	@Test
	public void verifyWhetherUserCanSearchSubcategoryPage() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		homepage = login.clickonloginbutton();
		String selectcategoryvalue1 = ExcelUtility.getStringData(0, 0, "SubCategoryPage");
		String subcategoryvalue1 = ExcelUtility.getStringData(0, 1, "SubCategoryPage");
		subcategory = homepage.clickOnSubcategory();
		subcategory = homepage.clickMoreinfo();
		// SubCategoryPage subcategory=new SubCategoryPage(driver);
		subcategory.clicksearch().selectcategory1(selectcategoryvalue1).entersubcategory1(subcategoryvalue1)
				.clickSearchbutton();
		boolean isSubCategoryNameDisplayed = subcategory.isSubCategoryNameDisplayed();
		Assert.assertTrue(isSubCategoryNameDisplayed, Messeges.CANNOTADDSUBCATEGORYNAME);
	}

}
