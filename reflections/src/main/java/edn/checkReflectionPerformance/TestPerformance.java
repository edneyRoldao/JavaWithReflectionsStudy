package edn.checkReflectionPerformance;

public class TestPerformance {

	public static void main(String[] args) {
		
		double objCall = executeTest(new ObjectInvoke());
		double reflectionCall = executeTest(new ReflectionInvoke());
		double reflectionCallWithCache = executeTest(new ReflectionInvokeWithCache());
		
		System.out.println((reflectionCall / objCall) + " reflection spending time more than normal");
		System.out.println((reflectionCallWithCache / objCall) + " reflection and cache spending time more than normal");
		
	}
	
	private static double executeTest(MethodInvoker invoker) {		
		long millis = System.nanoTime();
		invoker.invokeMethod(100000);
		String className = invoker.getClass().getName();
		long difTime = System.nanoTime() - millis;
		System.out.println("The class " + className + " spent " + difTime + " nano secunds to execute method");
		
		return difTime;
	}
	
}
