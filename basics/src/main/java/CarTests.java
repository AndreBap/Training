import static org.junit.Assert.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CarTests {
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
	public void canBuildCar() {
		Car car = new Car("Corvette");
		
		car.engine.start();
		
	    assertEquals("Engine Started", outContent.toString().trim());
	}
}
