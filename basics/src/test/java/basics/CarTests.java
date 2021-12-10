package basics;

import org.junit.Test;

public class CarTests {

	@Test
	public void canBuildCar() {
		Car car = new Car("Corvette");
		
		car.engine.start();
	}
}
