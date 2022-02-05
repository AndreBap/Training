package DemoQA.Tests;

import org.testng.annotations.Test;

import DemoQA.Pages.SliderPage;
import framework.TestBase;

import static org.testng.Assert.assertTrue;

public class SliderTests extends TestBase {
  @Test
  public void canSetTo80() {
	  SliderPage page = new SliderPage(super.getDriver());
	  page.navigate();
	  
	  page.set(80);

	  assertTrue(page.checkSliderValue(80));
  }
  @Test
  public void canSetTo17() {
	  SliderPage page = new SliderPage(super.getDriver());
	  page.navigate();
	  
	  page.set(17);

	  assertTrue(page.checkSliderValue(17));
  }
  @Test
  public void canSetTo0() {
	  SliderPage page = new SliderPage(super.getDriver());
	  page.navigate();
	  
	  page.set(0);

	  assertTrue(page.checkSliderValue(0));
  }
  @Test
  public void canSetTo100() {
	  SliderPage page = new SliderPage(super.getDriver());
	  page.navigate();
	  
	  page.set(100);

	  assertTrue(page.checkSliderValue(100));
  }
}
