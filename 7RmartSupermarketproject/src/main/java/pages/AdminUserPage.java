package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminUserPage {

	public WebDriver driver;

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='nav-icon fas fa-users']")
	private WebElement selectadminuser;
	// @FindBy(xpath="//p[text()='Manage Users']")private WebElement
	// clickmanageuser;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement clicknew;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement enterusername;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement enterpassword;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement selectuserid;
	@FindBy(xpath = "//button[@name='Create']")
	private WebElement clicksave;
	// @FindBy(xpath="//i[@class='nav-icon fas fa-users']")private WebElement
	// clickadminuser;
	// @FindBy(xpath="//p[text()='Manage Users']")private WebElement
	// clickmanageuser1;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement clicksearch;
	@FindBy(xpath = "//input[@id='un']")
	private WebElement enterusername1;
	@FindBy(xpath = "//select[@id='ut']")
	private WebElement selectuserid1;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-danger']")
	private WebElement clicksearch1;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement alertdisplayed;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-danger']")
	private WebElement serachicondisplayed;


	public AdminUserPage clickOnNew() {
		clicknew.click();
		return this;
	}

	public AdminUserPage enterUsernameOnUsernameField(String usernamevalue) {
		enterusername.clear();
		enterusername.click();
		enterusername.sendKeys(usernamevalue);
		return this;
	}

	public AdminUserPage enternewPasswordOnPasswordField(String passwordvalue) {
		enterpassword.sendKeys(passwordvalue);
		return this;

	}

	public AdminUserPage selectUseridType() {
		Select select = new Select(selectuserid);
		select.selectByIndex(2);
		return this;
	}

	public AdminUserPage clickOnSave() {
		clicksave.click();
		return this;
	}

	public AdminUserPage clickOnAdminUser() {
		selectadminuser.click();
		return this;
	}

	public AdminUserPage clickOnSearch() {
		clicksearch.click();
		return this;
	}

	public AdminUserPage enterUsername1(String usernamevalue) {
		enterusername1.sendKeys(usernamevalue);
		return this;
	}

	public AdminUserPage selectuserid1() {
		Select select = new Select(selectuserid1);
		select.selectByIndex(2);
		return this;
	}

	public AdminUserPage clickOnSearch1() {
		clicksearch1.click();
		return this;
	}

	public boolean isAlertDisplayed() {
		return alertdisplayed.isDisplayed();
	}

	public boolean isSearchIconDisplayed() {
		return serachicondisplayed.isDisplayed();
	}

	public AdminUserPage enterPasswordOnPasswordTitle(String passwordvalue) {
		enterpassword.sendKeys(passwordvalue);
		return this;

	}

}
