package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class ManageNewsPage {
	WaitUtility wait = new WaitUtility();
	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// @FindBy(xpath="//p[text()='Manage News']")private WebElement clickmanagenews;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement clicknew;
	@FindBy(xpath = "//textarea[@id='news']")
	private WebElement enternews;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	private WebElement clicksave;
	// @FindBy(xpath="//p[text()='Manage News']")private WebElement
	// clickmanagenews1;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement clicksearch;
	@FindBy(xpath = "//input[@class='form-control']")
	private WebElement entertitle;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	private WebElement clicksearch1;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertmessegedisplayed;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	private WebElement searchicondisplayed;

	public ManageNewsPage clickOnNew() {
		clicknew.click();
		return this;
	}

	public ManageNewsPage enterOnNews(String newsdescription) {
		enternews.sendKeys(newsdescription);
		return this;
	}

	public ManageNewsPage clickOnSave() {
		// wait.waitUntilClickable(driver,clicksave);
		clicksave.click();
		return this;
	}

	public ManageNewsPage clickOnSearch() {
		clicksearch.click();
		return this;
	}

	public ManageNewsPage enterNewsOnTitle(String titledescription) {
		entertitle.sendKeys(titledescription);
		return this;
	}

	public ManageNewsPage clickOnSearchNews() {
		clicksearch1.click();
		return this;
	}

	public boolean isAlertMessegeDisplayed() {
		return alertmessegedisplayed.isDisplayed();
	}

	public boolean isSearchIconDisplayed() {
		return searchicondisplayed.isDisplayed();
	}
}
