package framework;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager extends DriverManager {

	@Override
	public void createDriver() {
		Path resourceDirectory = Paths.get("src","test","resources");
		String absolutePath = resourceDirectory.toFile().getAbsolutePath();
		Path driverFile = Paths.get(absolutePath, "msedgedriver.exe");
		
		System.setProperty("webdriver.edge.driver", driverFile.toFile().getAbsolutePath());

		WebDriver edge = new EdgeDriver();
		
		setDriver(edge);
	}

}
