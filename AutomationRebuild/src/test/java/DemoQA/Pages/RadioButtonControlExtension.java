package DemoQA.Pages;


import framework.ControlExtensionBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonControlExtension extends ControlExtensionBase {
	WebDriver driver;

	public RadioButtonControlExtension(WebDriver driver) {
		super.driver = driver;
	}

	public void select(WebElement element) {
		super.select(element);
	}

	public boolean isSelected(WebElement element) {
		return super.isSelected(element);
	}
		
	
}
