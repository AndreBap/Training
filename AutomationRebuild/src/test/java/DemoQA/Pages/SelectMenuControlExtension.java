package DemoQA.Pages;


import framework.ControlExtensionBase;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectMenuControlExtension extends ControlExtensionBase {

	public SelectMenuControlExtension(WebDriver driver) {
		super.driver = driver;
	}

	public void selectDropdown(WebElement selectMenuElement, String selection) {
		Select dropdown = new Select(selectMenuElement);
		dropdown.selectByVisibleText(selection);
	}

	public String getSelected(WebElement selectMenuElement) {
		Select dropdown = new Select(selectMenuElement);
		return dropdown.getFirstSelectedOption().getText();
	}

	public String getOptions(WebElement selectMenuElement) {
		Select dropdown = new Select(selectMenuElement);
		List<WebElement> options = dropdown.getOptions();
		List<String> printableOptions = new ArrayList<String>();
		for (int i = 0; i < options.size(); i++) {
			printableOptions.add(options.get(i).getText());
		}
		return printableOptions.toString();
	}

}
