import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCase extends Assert implements Test {

	String fName;

	public TestCase() {
		
	}
	// 构造器,fName是方法名称
	public TestCase(String fName) {
		this.fName = fName;
	}

	public void run(TestResult tr)
	{
		tr.run(this);
	}
	public void doRun() {
		setUp();
		try {
			runBare();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tearDown();
		}

	}

	public void runBare()
	{
		try {
			Method method = getClass().getDeclaredMethod(fName, null);
			method.invoke(this);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		 catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		 catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	@Override
	public int countTestCase() {
		return 1;
	}

	@Override
	// 初始化方法
	public void setUp() {
		// TODO Auto-generated method stub

	}

	@Override
	// 结束测试时候的方法
	public void tearDown() {
		// TODO Auto-generated method stub

	}

}
