package DemoQA.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HyperlinkControlExtension extends ControlExtensionBase {

	public HyperlinkControlExtension(WebDriver driver) {
		super.driver = driver;
	}
	
	public void select(WebElement element) {
		super.select(element);
	}
}
