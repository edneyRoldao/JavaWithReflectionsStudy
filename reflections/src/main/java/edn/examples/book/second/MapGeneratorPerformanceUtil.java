package edn.examples.book.second;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import edn.examples.book.annotations.Ignore;
import edn.examples.book.annotations.PropertyName;

public class MapGeneratorPerformanceUtil {

	private Map<String, Method> properties = new HashMap<>();
	private Class<?> clazz;
	
	public MapGeneratorPerformanceUtil(Class<?> clazz) {
		this.clazz = clazz;
		
		for(Method m : clazz.getMethods()) {
			if(isGetterWithAnnotation(m)) {
				String prop = null;
				
				if(m.isAnnotationPresent(PropertyName.class)) {
					prop = m.getAnnotation(PropertyName.class).value();
				}else {
					prop = parseGetterToProperty(m.getName());
				}
				
				properties.put(prop, m);
			}
		}
	}

	public Map<String, Object> generateMap(Object obj) {
		
		if(!clazz.isInstance(obj))
			throw new RuntimeException("The current object doesn't belong to this class type: " + clazz.getName());
		
		Map<String, Object> map = new HashMap<>();
		
		for(String key : this.properties.keySet()) {
			try {
				
				Method m = this.properties.get(key);
				Object value = m.invoke(obj);
				map.put(key, value);
				
			} catch (Exception e) {
				throw new RuntimeException("There was a problem when try to generate the map", e);
			}
		}
		
		return map;
	}
	
	private boolean isGetterWithAnnotation(Method m) {
		return m.getName().startsWith("get") 		&& 
			   m.getReturnType() != void.class 		&& 
			   m.getParameterTypes().length == 0	&&
			   !m.isAnnotationPresent(Ignore.class);
	}

	public String parseGetterToProperty(String methodName) {
		StringBuilder sb = new StringBuilder();
		sb.append(methodName.substring(3, 4).toLowerCase());
		sb.append(methodName.substring(4));
		return sb.toString();
	}

}
