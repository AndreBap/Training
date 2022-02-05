package DemoQA.Pages;


import framework.PageObjectBase;
import framework.ControlExtensionBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SliderPage extends PageObjectBase {
	
	private final String url = "https://demoqa.com/slider";
	private SliderControlExtension controller = new SliderControlExtension(this.driver);
	
	@FindBy(how=How.CSS, using="#sliderContainer > div.col-9 > span > input")
	private WebElement sliderElement;

	public SliderPage(WebDriver driver) {
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

	public void set(int i) {
		controller.setValue(sliderElement,i);
	}

	public boolean checkSliderValue(int i) {
		String value = controller.getSliderValue(sliderElement);
		return (Integer.parseInt(value) == i);
	}

}
