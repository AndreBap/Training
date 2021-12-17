public class Car extends Vehicle {
	public IEngine engine;
	public String model;
	
	public Car(String model) {
		this.model = model;
	}
	public void drive() {
		odometer++;
	}
	public void drive(int distance) {
		odometer += distance;
	}
	public void start() {
		engine.start();
	}
}
