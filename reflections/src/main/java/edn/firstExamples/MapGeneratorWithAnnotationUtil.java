package edn.firstExamples;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import edn.examples.annotations.Ignore;
import edn.examples.annotations.PropertyName;

public class MapGeneratorWithAnnotationUtil {

	// Second example with annotations
	public static Map<String, Object> generateGettersMapWithAnnotations(Object obj) {
		Class<?> clazz = obj.getClass();
		Map<String, Object> methodsMap = new HashMap<>();
		
		for(Method m : clazz.getMethods()) {
			try {
				
				if(isGetterWithAnnotation(m)) {
					String prop = null;
					
					if(m.isAnnotationPresent(PropertyName.class)) {
						prop = m.getAnnotation(PropertyName.class).value();
					}else {
						prop = MapGeneratorUtil.parseGetterToProperty(m.getName());
					}
					
					Object value = m.invoke(obj);
					methodsMap.put(prop, value);
				}
				
			} catch (Exception e) {
				throw new RuntimeException("There was a problem when to try generate Map !", e);
			}
		}
		
		return methodsMap;	
	}

	private static boolean isGetterWithAnnotation(Method m) {
		return m.getName().startsWith("get") 		&& 
			   m.getReturnType() != void.class 		&& 
			   m.getParameterTypes().length == 0	&&
			   !m.isAnnotationPresent(Ignore.class);
	}

}
