package framework;

import java.io.FileNotFoundException;

public class DriverManagerFactory {

	public static DriverManager getManager(String browser) {
		DriverManager manager;
		
		if(browser.equalsIgnoreCase("chrome")) {
			manager = new ChromeDriverManager();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			manager = new EdgeDriverManager();
		}
		else {
			throw new FileNotFoundException();  
		}
		return manager;
	}

}
