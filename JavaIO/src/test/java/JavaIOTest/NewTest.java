package JavaIOTest;

import static org.testng.Assert.assertNotNull;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import framework.ConfigurationProvider;

public class NewTest {
	@DataProvider(name = "config.properties")
	
	@Test
	public void canGetBrowserType() throws IOException {
		Properties prop = new Properties();
		InputStream inputStream = null;
		
		try {
			inputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties");
			prop.load(inputStream);
		} 
		finally {
			inputStream.close();
		}
		
		System.out.println(prop.getProperty("BrowserType"));
	}
	
	@Test
	public void canReadBasses() throws Exception {
		ConfigurationProvider csvReader = new ConfigurationProvider();
		
		HashMap<String, String> basses = csvReader.getPropertiesFromResourceFile("basses.csv");
		
		System.out.println(basses.keySet());
		assertNotNull(basses.keySet());
	}
	
	@Test
	public void canHydrateObject() throws Exception {
		Basses basses = new Basses();
		ConfigurationProvider csvReader = new ConfigurationProvider();
		Set<String> temp = csvReader.getPropertiesFromResourceFile("basses.csv").keySet();
		Iterator<String> bassesIterator = temp.iterator();
		String currentLine = null;
		String[] parsed;
		
		while(bassesIterator.hasNext()) {
			   currentLine = bassesIterator.next();
			   parsed = currentLine.split(",");
			   basses.setMake(parsed[0]);
			   basses.setModel(parsed[1]);
			   basses.setStringCount(parsed[2]);
			}
		
		System.out.println(basses.getMake());
		System.out.println(basses.getModel());
		System.out.println(basses.getStringCount());
		assertNotNull(basses.getMake());
		assertNotNull(basses.getModel());
		assertNotNull(basses.getStringCount());
	}
	
	public class Basses {
		private List<String> make = new ArrayList<String>();
		private List<String> model = new ArrayList<String>();
		private List<String> stringCount = new ArrayList<String>();
		
		public List<String> getMake() {
			return make;
		}
		public void setMake(String make) {
			this.make.add(make);
		}
		public List<String> getModel() {
			return model;
		}
		public void setModel(String model) {
			this.model.add(model);
		}
		public List<String> getStringCount() {
			return stringCount;
		}
		public void setStringCount(String stringCount) {
			this.stringCount.add(stringCount);
		}
	}
}
