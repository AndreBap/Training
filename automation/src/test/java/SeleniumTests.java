import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SeleniumTests {
  @Test
  public void canLaunchWebDriver() {
	  String driverpath = "C:\\\\temp\\msedgedriver.exe";
	  System.setProperty("webdriver.edge.driver", driverpath);
	  
	  String url = "https://www.selenium.dev/";
	  WebDriver driver = new EdgeDriver();
	  
	  driver.navigate().to(url);
	  String currentURL = driver.getCurrentUrl();
	  Assert.assertEquals(url, currentURL);
	  driver.quit();
  }
}
