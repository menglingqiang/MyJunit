
public class DemoMain extends TestCase{


	public void testHeHe()
	{
		System.out.println("hehe");
	}
	
	public void testWoWo()
	{
		System.out.println("WoWo");
	}
	
	public static void main(String[] args) {
		TestSuite testSuite = new TestSuite(DemoMain.class);
		testSuite.run();
	}
	
}
