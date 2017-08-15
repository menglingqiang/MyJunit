import java.lang.reflect.Constructor;
import java.util.Vector;

public class TestSuite implements Test{

	String name;
	Vector<TestCase> testCases;
	public TestSuite(Class clazz) {
		this.name = clazz.getName();
		testCases = new Vector<TestCase>();
		
	}
	public Constructor getTestConstructor()
	{
		
	}
	@Override
	public void setUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tearDown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void test() {
		for(TestCase testCase:testCases)
		{
			testCase.test();
		}
		
	}

	@Override
	public int countTest() {
		// TODO Auto-generated method stub
		return 0;
	}

}
