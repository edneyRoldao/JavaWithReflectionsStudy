package edn.examples.xmlBuilder;

import java.lang.reflect.Method;

public class XmlBuilderImpl implements XmlBuilder {
	
	private final Class<?> clazz;

	public XmlBuilderImpl(Class<?> clazz) {
		this.clazz = clazz;
	}
	
	@Override
	public String ObjectToXml(Object object) {
		
		if(!clazz.isInstance(object)) {
			String inst = object.getClass().getName();
			String rInst = clazz.getName();
			throw new RuntimeException("The instance" + inst + "doesn't match with class that the builder is able to read " + rInst);
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(Method m : clazz.getMethods()) {
			if(isGetter(m)) {
				sb.append("<");
				sb.append(getterToProperty(m.getName()));
				sb.append(">");
				
				try {
					sb.append(m.invoke(object));
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				sb.append("</");
				sb.append(getterToProperty(m.getName()));
				sb.append(">\n");
				
			}
		}
		
		return sb.toString();
	}
	
	public boolean isGetter(Method m) {
		return m.getName().startsWith("get") 		&& 
			   m.getReturnType() != void.class 		&& 
			   m.getParameterTypes().length == 0	&&
			   !m.getName().toLowerCase().endsWith("class");
	}

	public String getterToProperty(String methodName) {
		StringBuilder sb = new StringBuilder();
		sb.append(methodName.substring(3, 4).toLowerCase());
		sb.append(methodName.substring(4));
		return sb.toString();
	}
	
	public boolean isNotPrimitive(Object obj) {
		if(obj instanceof String) return false;
		if(obj instanceof Number) return false;
		if(obj instanceof Boolean) return false;
		if(obj instanceof Character) return false;
				
		return true;
	};
	
}
