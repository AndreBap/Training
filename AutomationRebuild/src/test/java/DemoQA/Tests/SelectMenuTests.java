package DemoQA.Tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import DemoQA.Pages.SelectMenuPage;
import framework.TestBase;

public class SelectMenuTests extends TestBase {
  @Test
  public void canSetValue() {
	  SelectMenuPage page = new SelectMenuPage(super.getDriver());
	  page.navigate();
	  
	  page.select("Purple");

	  assertEquals(page.getValue(), "Purple");
  }
  @Test
  public void canGetOptions() {
	  SelectMenuPage page = new SelectMenuPage(super.getDriver());
	  page.navigate();
	  
	  String options = page.getOptions();

	  assertEquals(options,"[Red, Blue, Green, Yellow, Purple, Black, White, Voilet, Indigo, Magenta, Aqua]");
  }
}
