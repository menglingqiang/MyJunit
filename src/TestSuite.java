import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Vector;

public class TestSuite extends Assert implements Test{

	String name;
	Vector<Test> testCases;
	public TestSuite(Class clazz) {
		this.name = clazz.getName();
		testCases = new Vector<Test>();
		Constructor constructor = getTestConstructor(clazz);
		Method[] methods = clazz.getDeclaredMethods();
		for(int i=0;i<methods.length;i++)
			addTest(methods[i],constructor);
	}
	public Constructor getTestConstructor(Class clazz)
	{
		try {
			return clazz.getConstructor(String.class);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return null;
	}
	public void addTest(Method method,Constructor constructor)
	{
		if(isPublicAndTest(method))
		{
			if(!testCases.contains(method.getName()))
			{
				Test test=null;
				try {
					test = (Test)constructor.newInstance(method.getName());
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
				testCases.add(test);
			}
		}
	}
	public boolean isPublicAndTest(Method method) {
		if(Modifier.isPublic(method.getModifiers()))
		{
			String fName = method.getName();
			Class<?>[] parameters = method.getParameterTypes();
			Class<?> returnType = method.getReturnType();
			return fName.startsWith("test") && parameters.length==0
					&& returnType.equals(Void.TYPE);
		}else
			return false;
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
	public void run(TestResult result) {
		for(Test test:testCases)
		{
			result.run((TestCase)test);
		}
		
	}
	@Override
	public int countTestCase() {
		int count =0;
		for(Test test:testCases)
		{
			count += test.countTestCase();
		}
		return count;
	}

}
