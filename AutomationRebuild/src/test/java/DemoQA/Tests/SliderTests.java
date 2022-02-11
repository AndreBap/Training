package DemoQA.Tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import DemoQA.Pages.SliderPage;
import framework.TestBase;

import static org.testng.Assert.assertTrue;

public class SliderTests extends TestBase {
	@Test
	@Parameters({"slider1"})
	public void canSetTo80(String slider1) {
		SliderPage page = new SliderPage(super.getDriver());
		page.navigate();

		page.set(Integer.parseInt(slider1));

		AssertJUnit.assertTrue(page.checkSliderValue(Integer.parseInt(slider1)));
	}
	@Test
	public void canSetTo17() {
		SliderPage page = new SliderPage(super.getDriver());
		page.navigate();

		page.set(17);

		AssertJUnit.assertTrue(page.checkSliderValue(17));
	}
	@Test
	public void canSetTo0() {
		SliderPage page = new SliderPage(super.getDriver());
		page.navigate();

		page.set(0);

		AssertJUnit.assertTrue(page.checkSliderValue(0));
	}
	@Test
	public void canSetTo100() {
		SliderPage page = new SliderPage(super.getDriver());
		page.navigate();

		page.set(100);

		AssertJUnit.assertTrue(page.checkSliderValue(100));
	}
}
