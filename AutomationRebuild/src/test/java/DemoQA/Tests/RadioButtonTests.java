package DemoQA.Tests;

import org.testng.annotations.Test;

import DemoQA.Pages.RadioButtonPage;
import framework.TestBase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class RadioButtonTests extends TestBase{

	@Test
	public void canClickYes() throws InterruptedException {
		RadioButtonPage page = new RadioButtonPage(super.getDriver());
		page.navigate();
		
		page.select("yesRadio");

		assertEquals(page.getSelected(), "yes");
	}

	@Test
	public void canClickImpressive() {
		RadioButtonPage page = new RadioButtonPage(super.getDriver());
		page.navigate();
		
		page.select("impressiveRadio");

		assertEquals(page.getSelected(), "impressive");
	}

	@Test
	public void canNotClickNo() {
		RadioButtonPage page = new RadioButtonPage(super.getDriver());
		page.navigate();
		
		page.select("noRadio");

		assertNotEquals(page.getSelected(), "no");
	}
}
