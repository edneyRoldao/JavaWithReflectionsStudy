package edn.examples.book.checkReflectionPerformance;

import java.lang.reflect.Method;

public class ReflectionInvokeWithCache implements MethodInvoker {

	@Override
	public void invokeMethod(int times) {
		
		try {
			ClassTest ct = new ClassTest();
			Method m = ct.getClass().getMethod("emptyMethod");

			for(int i = 0; i < times; i++) {
				m.invoke(ct);
			}
			
		} catch (Exception e) {
			throw new RuntimeException("there was an error. We won't able to call the method !");
		}
		
	}

}
