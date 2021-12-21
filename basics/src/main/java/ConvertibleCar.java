
public class ConvertibleCar extends Car {
	public IEngine engine = new SmallEngine();
	protected String top_status = "Up";

	public ConvertibleCar(String model) {
		super(model);
	}

	public void raiseTop() {
		top_status = "Up";
	}

	public void lowerTop() {
		top_status = "Down";
	}

	public String getTopStatus() {
		return top_status;
	}
}
