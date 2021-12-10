package basics;

public class Car {
	private int odometer;
	public LargeEngine engine;
	public String model;
	
	public Car(String model) {
		engine = new LargeEngine();
		this.model = model;
	}
	
	public int get_Odometer() {
		return odometer;
	}

}
