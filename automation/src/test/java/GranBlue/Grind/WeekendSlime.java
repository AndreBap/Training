package GranBlue.Grind;

import org.testng.annotations.Test;
import GranBlue.Pages.WeekendSlimePage;
import framework.TestBase;


public class WeekendSlime extends TestBase {
  @Test
  public void canSlime() {
	  WeekendSlimePage page = new WeekendSlimePage(super.getDriver());
	  page.navigate();
	  
	  page.slime();
  }
}
