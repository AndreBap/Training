import static org.junit.Assert.*;
import org.junit.Test;

public class BicycleTest {

	@Test
	public void canDriveBicycle() {
		Bicycle myBike = new Bicycle();
		int startingOdometer = myBike.getOdometer();
		
		myBike.drive();
		
		assertEquals(startingOdometer + 1, myBike.getOdometer());
	}

}
