package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	private WebElement username;
	@FindBy(name = "password")
	private WebElement password;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginbutton;
	@FindBy(xpath = "//p[text()='Dashboard']")
	private WebElement dashboard;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement alertcomes;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement alertdisplayed;

	// @FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")private
	// WebElement alertpresent;
	public LoginPage enterUsernameOnUsernameField(String usernamevalue) {
		username.sendKeys(usernamevalue);
		return this;
	}

	public LoginPage enterPasswordOnPasswordField(String passwordvalue) {
		password.sendKeys(passwordvalue);
		return this;
	}

	public HomePage clickonloginbutton() {
		loginbutton.click();
		return new HomePage(driver);

	}

	public boolean isDashboardDisplayed() {
		return dashboard.isDisplayed();
	}

	public boolean isAlertDisplayed() {
		return alertcomes.isDisplayed();
	}

	public boolean isValidationMessegeDisplayed() {
		return alertdisplayed.isDisplayed();
	}
	// public boolean isAlertIsDisplayed()
	// {
	// return alertpresent.isDisplayed();
	// }

}
