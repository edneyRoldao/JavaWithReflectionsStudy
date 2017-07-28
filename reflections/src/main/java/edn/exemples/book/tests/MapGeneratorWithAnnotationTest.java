package edn.exemples.book.tests;

import java.util.Iterator;
import java.util.Map;

import edn.examples.book.first.MapGeneratorWithAnnotationUtil;
import edn.examples.book.model.Phone;

public class MapGeneratorWithAnnotationTest {

	public static void main(String[] args) {
		
		Phone t = new Phone("2222-5555", "SP", "particular", "US");
		Map<String, Object> props = MapGeneratorWithAnnotationUtil.generateGettersMapWithAnnotations(t);

		Iterator<Map.Entry<String, Object>> mapIterator = props.entrySet().iterator();
		
		while(mapIterator.hasNext()) {
			System.out.println(mapIterator.next());
		}

	}
	
}
