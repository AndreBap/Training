package DemoQA.Pages;

import framework.ControlExtensionBase;
import framework.PageObjectBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RadioButtonPage extends PageObjectBase {
	
	private final String url = "https://demoqa.com/radio-button";
	private RadioButtonControlExtension controller = new RadioButtonControlExtension(this.driver);
	
	@FindBy(how=How.ID, using="yesRadio")
	private WebElement yesRadioElement;
	
	@FindBy(how=How.ID, using="impressiveRadio")
	private WebElement impressiveRadioElement;
	
	@FindBy(how=How.ID, using="noRadio")
	private WebElement noRadioElement;
	
	public RadioButtonPage(WebDriver driver) {
		super(driver);
	}

	public String getURL() {
		return url;
	}
	
	public ControlExtensionBase getController() {
		return this.controller;
	}
	
	public PageObjectBase navigate() {
		this.driver.navigate().to(url);
		return this;
	}
	
	public void select(String label) {
		if (label == "yesRadio") {
			controller.select(yesRadioElement);
		}
		else if (label == "impressiveRadio") {
			controller.select(impressiveRadioElement);
		}
		else if (label == "noRadio") {
			//throw new RuntimeException("no option is disabled");
		}
			
	}
	
	public String getSelected() {
		String selected = "none";
		
		if (controller.isSelected(yesRadioElement)) {
			selected = "yes";
		}
		else if (controller.isSelected(impressiveRadioElement)) {
			selected = "impressive";
		}
		else if (controller.isSelected(noRadioElement)) {
			selected = "no";
		}
		return selected;
		
	}

	
}
