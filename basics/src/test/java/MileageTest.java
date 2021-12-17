import static org.junit.Assert.*;

import org.junit.Test;

public class MileageTest {

	@Test
	public void canTrackMileage() {
		Car myCar = new Car("Toyota");
		int startingOdometer = myCar.getOdometer();
		
		myCar.drive();
		
		assertEquals(startingOdometer + 1, myCar.getOdometer());
	}

}
