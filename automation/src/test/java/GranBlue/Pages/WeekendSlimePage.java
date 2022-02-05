package GranBlue.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import DemoQA.Pages.HyperlinkControlExtension;
import GranBlue.ControlExtensions.GrindControlExtension;
import framework.ControlExtensionBase;
import framework.PageObjectBase;

public class WeekendSlimePage extends PageObjectBase {
	
	private final String url = "https://game.granbluefantasy.jp/#quest/supporter/400151/4";
	private GrindControlExtension controller = new GrindControlExtension(this.driver);
	
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
	
	public WeekendSlimePage(WebDriver driver) {
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

	public void slime() {
		// TODO Auto-generated method stub
		
	}

}
