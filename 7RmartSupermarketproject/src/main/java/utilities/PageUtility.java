package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void selectDropdownWithValue(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByValue(value);
	}

	public void selectIndexWithValue(WebElement element, int value) {
		Select object = new Select(element);
		object.selectByIndex(value);
	}

	public void handlingCheckbox(WebElement element, String value) {
		element.click();
	}

	public void verifyMouseHover(WebElement element) {

		Actions actions = new Actions(null);
		actions.moveToElement(element).build().perform();
	}

	public void handlingRadiobutton(WebElement element) {
		element.click();
	}

	public void verifyRightClick(WebElement element) {

		Actions actions = new Actions(null);
		actions.contextClick().build().perform();
	}
}
