
public class Bicycle extends Vehicle {
	protected int odometer;
	
	public int getOdometer() {
		return odometer;
	}

	public void drive() {
		odometer++;
	}
}
