package edn.tests;

import java.util.Iterator;
import java.util.Map;

import edn.examples.model.Product;
import edn.firstExamples.MapGeneratorUtil;

public class MapGeneratorFirstTest {

	public static void main(String[] args) {
		
		Product p = new Product("Reflections", "video lesson", 150.00, "A complete guide for Java developers");
		Map<String, Object> props = MapGeneratorUtil.generateGettersMap(p);

		Iterator<Map.Entry<String, Object>> mapIterator = props.entrySet().iterator();
		
		while(mapIterator.hasNext()) {
			System.out.println(mapIterator.next());
		}
		
		
	}
	
}
