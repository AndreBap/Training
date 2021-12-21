import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConvertibleCarTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}
	@After
	public void restoreStreams() {
	    System.setOut(originalOut);
	}
	@Test
	public void canStartEngine() {
		ConvertibleCar myCar = new ConvertibleCar("Toyota");
		
		myCar.engine.start();
		
	    assertEquals("Engine Started", outContent.toString().trim());
	}
	@Test
	public void canRaiseTop() {
		ConvertibleCar myCar = new ConvertibleCar("Toyota");
		
		myCar.raiseTop();
		
	    assertEquals("Up", myCar.getTopStatus());
	}
	@Test
	public void canLowerTop() {
		ConvertibleCar myCar = new ConvertibleCar("Toyota");
		
		myCar.lowerTop();
		
	    assertEquals("Down", myCar.getTopStatus());
	}
}
