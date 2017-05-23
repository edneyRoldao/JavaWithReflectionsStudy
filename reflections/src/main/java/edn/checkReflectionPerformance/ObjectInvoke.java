package edn.checkReflectionPerformance;

public class ObjectInvoke implements MethodInvoker {

	@Override
	public void invokeMethod(int times) {
		ClassTest ct = new ClassTest();
		
		for(int i =0; i < times; i++)
			ct.emptyMethod();
	}

}
