package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	private WebElement logoutadmin;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")
	private WebElement logoutbutton;
	@FindBy(xpath = "//b[text()='7rmart supermarket']")
	private WebElement maintitle;

	@FindBy(xpath = "//p[text()='Sub Category']")
	private WebElement clicksubcategory;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']")
	private WebElement clickmoreinfo;

	@FindBy(xpath = "//i[@class='nav-icon fas fa-users']")
	private WebElement selectadminuser;
	@FindBy(xpath = "//p[text()='Manage Users']")
	private WebElement clickmanageuser;

	@FindBy(xpath = "//p[text()='Manage News']")
	private WebElement clickmanagenews;

	public HomePage clickOnAdmin() {
		logoutadmin.click();
		return new HomePage(driver);
	}

	public LoginPage clickOnLogout() {
		logoutbutton.click();
		return new LoginPage(driver);
	}

	public String getTextFromTitle() {
		return maintitle.getText();
	}

	public SubCategoryPage clickOnSubcategory() {
		clicksubcategory.click();
		return new SubCategoryPage(driver);
	}

	public SubCategoryPage clickMoreinfo() {
		clickmoreinfo.click();
		return new SubCategoryPage(driver);
	}

	public AdminUserPage clickOnAdminUser() {
		selectadminuser.click();
		return new AdminUserPage(driver);
	}

	public AdminUserPage clickOnManageUser() {
		clickmanageuser.click();
		return new AdminUserPage(driver);
	}

	public ManageNewsPage clickOnManageNews() {
		clickmanagenews.click();
		return new ManageNewsPage(driver);
	}

}
