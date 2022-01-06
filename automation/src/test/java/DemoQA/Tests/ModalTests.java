package DemoQA.Tests;

import org.testng.annotations.Test;

import DemoQA.Pages.ModalPage;
import framework.TestBase;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;

public class ModalTests extends TestBase{
  @Test
  public void canClickSmallModal() {
	  ModalPage page = new ModalPage(super.getDriver());
	  page.navigate();

	  page.click("showSmallModal");

	  assertTrue(page.checkModalContent("Small Modal","example-modal-sizes-title-sm"));
  }
  @Test
  public void canClickLargeModal() {
	  ModalPage page = new ModalPage(super.getDriver());
	  page.navigate();

	  page.click("showLargeModal");

	  assertTrue(page.checkModalContent("Large Modal","example-modal-sizes-title-lg"));
  }
  @BeforeMethod
  public void beforeMethod() {
	  super.setup();
  }

  @AfterMethod
  public void afterMethod() {
	  super.cleanup();
  }

}
