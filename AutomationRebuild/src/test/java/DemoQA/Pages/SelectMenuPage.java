package DemoQA.Pages;

import framework.ControlExtensionBase;
import framework.PageObjectBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SelectMenuPage extends PageObjectBase {
	
	private final String url = "https://demoqa.com/select-menu";
	private SelectMenuControlExtension controller = new SelectMenuControlExtension(this.driver);
	
	@FindBy(how=How.ID, using="oldSelectMenu")
	private WebElement selectMenuElement;


	public SelectMenuPage(WebDriver driver) {
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
		this.driver.manage().window().maximize();
		return this;
	}

	public void select(String selection) {
		controller.select(selectMenuElement);
		controller.selectDropdown(selectMenuElement,selection);
	}

	public String getValue() {
		return controller.getSelected(selectMenuElement);
	}

	public String getOptions() {
		return controller.getOptions(selectMenuElement);
	}

}
