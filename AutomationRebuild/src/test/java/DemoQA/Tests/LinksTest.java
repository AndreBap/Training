package DemoQA.Tests;

import org.testng.annotations.Test;

import DemoQA.Pages.LinksPage;
import framework.TestBase;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.AfterMethod;

public class LinksTest extends TestBase {
	@Test
	public void canClickHyperlink() {
		LinksPage page = new LinksPage(super.getDriver());
		page.navigate();
		
		page.click("created");
		
		assertTrue(page.getResponse("Created"));
	}
}
