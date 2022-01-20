package DemoQA.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LinksPage extends PageObjectBase {
	
	private final String url = "https://demoqa.com/links";
	private HyperlinkControlExtension controller = new HyperlinkControlExtension(this.driver);
	
	@FindBy(how=How.ID, using="simpleLink")
	private WebElement simpleLinkElement;
	
	@FindBy(how=How.ID, using="dynamicLink")
	private WebElement dynamicLinkElement;
	
	@FindBy(how=How.ID, using="created")
	private WebElement createdElement;
	
	@FindBy(how=How.ID, using="no-content")
	private WebElement noContentElement;
	
	@FindBy(how=How.ID, using="moved")
	private WebElement movedElement;
	
	@FindBy(how=How.ID, using="bad-request")
	private WebElement badRequestElement;
	
	@FindBy(how=How.ID, using="unauthorized")
	private WebElement unauthorizedElement;
	
	@FindBy(how=How.ID, using="forbidden")
	private WebElement forbiddenElement;
	
	@FindBy(how=How.ID, using="invalid-url")
	private WebElement invalidUrlElement;
	
	@FindBy(how=How.ID, using="linkResponse")
	private WebElement linkResponseElement;
	
	public LinksPage(WebDriver driver) {
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
	
	public void click(String label) {
		WebElement element = driver.findElement(By.id(label));
		controller.select(element);
	}

	public Boolean getResponse(String label) {
		Boolean response = false;
		response = linkResponseElement.getText().contains(label);
		return response;
	}

}
