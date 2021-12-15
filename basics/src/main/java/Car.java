public class Car {
	private int odometer;
	public IEngine engine;
	public String model;
	
	public Car(String model) {
		engine = new LargeEngine();
		this.model = model;
	}
	public void drive(int distance) {
		odometer += distance;
	}
	public int get_Odometer() {
		return odometer;
	}
	public void start() {
		engine.start();
	}
}
