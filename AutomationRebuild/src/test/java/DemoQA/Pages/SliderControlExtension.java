package DemoQA.Pages;


import framework.ControlExtensionBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SliderControlExtension extends ControlExtensionBase {

	public SliderControlExtension(WebDriver driver) {
		super.driver = driver;
	}

	public void setValue(WebElement sliderElement, int i) {
		JavascriptExecutor j = (JavascriptExecutor)driver;
		j.executeScript("arguments[0].value=arguments[1];", sliderElement,i);
	}

	public String getSliderValue(WebElement sliderElement) {
		return sliderElement.getAttribute("value");
	}

}
