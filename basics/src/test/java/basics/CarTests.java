import org.junit.Assert;
import org.junit.Test;

//@Test
public class CarTests {
	
	@Test
	public void canBuildCar() {
		Car car = new Car("Corvette");
		
		Assert.assertNotNull(car);
		
		car.engine.start();
	}
}
