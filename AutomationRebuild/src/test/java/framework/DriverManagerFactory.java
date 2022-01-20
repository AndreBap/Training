package framework;

public class DriverManagerFactory {

	public static DriverManager getManager(String browser) {
		DriverManager manager;
		
		if(browser.equalsIgnoreCase("chrome")) {
			manager = new ChromeDriverManager();
		}
		else {
			manager = new EdgeDriverManager();
		}
		return manager;
	}

}
