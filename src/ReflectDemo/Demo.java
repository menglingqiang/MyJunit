package ReflectDemo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo {

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		try {
			Class clazz = Class.forName("ReflectDemo.ReflctDemo");
			try {
				System.out.println(clazz.getConstructor(String.class));
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Method[] m1	 = clazz.getDeclaredMethods();
			//m1[1].invoke(new ReflctDemo(),new Object[]{3,"3"});
//			for(Method method:m1)
//				System.out.println(method.getName());
//			Method[] m2	 = clazz.getMethods();
//			System.out.println("---------");
//			for(Method method:m2)
//				System.out.println(method.getName());
//			System.out.println(m1.length+":"+m2.length);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
