
public class SmallEngine implements IEngine {
	public int cylinderCount = 4;

	public int getcylinderCount() {
		return cylinderCount;
	}

	public void start() {
		System.out.println("Engine Started");
	}

}
