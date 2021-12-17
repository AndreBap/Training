import static org.junit.Assert.*;

import org.junit.Test;

public class CylinderCountTest {

	@Test
	public void canCountCylinders() {
		LargeEngine largeEngine = new LargeEngine();
		SmallEngine smallEngine = new SmallEngine();
		
		assertEquals(8,largeEngine.getcylinderCount());
		assertEquals(4,smallEngine.getcylinderCount());
	}
}
