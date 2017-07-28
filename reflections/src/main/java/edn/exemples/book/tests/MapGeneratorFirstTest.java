package edn.exemples.book.tests;

import java.util.Iterator;
import java.util.Map;

import edn.examples.book.first.MapGeneratorUtil;
import edn.examples.book.model.Product;

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
