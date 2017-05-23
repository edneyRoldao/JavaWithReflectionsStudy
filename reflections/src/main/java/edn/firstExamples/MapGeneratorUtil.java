package edn.firstExamples;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MapGeneratorUtil {
	
	// First example
	public static Map<String, Object> generateGettersMap(Object obj) {
		Class<?> clazz = obj.getClass();
		Map<String, Object> methodsMap = new HashMap<>();
		
		for(Method m : clazz.getMethods()) {
			try {
				
				if(isGetter(m)) {
					String property = parseGetterToProperty(m.getName());
					Object value = m.invoke(obj);
					methodsMap.put(property, value);
				}
				
			} catch (Exception e) {
				throw new RuntimeException("There was a problem !", e);
			}
		}
		
		return methodsMap;
	}
	
	private static boolean isGetter(Method m) {
		return m.getName().startsWith("get") 		&& 
			   m.getReturnType() != void.class 		&& 
			   m.getParameterTypes().length == 0;
	}
	
	public static String parseGetterToProperty(String methodName) {
		StringBuilder sb = new StringBuilder();
		sb.append(methodName.substring(3, 4).toLowerCase());
		sb.append(methodName.substring(4));
		return sb.toString();
	}
	
}
