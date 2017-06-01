package edn.tests;

import java.util.Map;

import edn.examples.model.Phone;
import edn.examples.model.Product;
import edn.secundExamples.MapGeneratorPerformanceUtil;

public class SecondMapGeneratorTest {

	public static void main(String[] args) {
		
		MapGeneratorPerformanceUtil mapGenerator = new MapGeneratorPerformanceUtil(Phone.class);
		Phone t = new Phone("2222-7777", "SP", "phone", "Brazil");
		Product p = new Product("IPhone", "Cellphone", 1800.00, "good phone");
		
		Map<String, Object> map = mapGenerator.generateMap(t);
		
		for(String key : map.keySet())
			System.out.println(map.get(key));
		
		map = mapGenerator.generateMap(p);
		
	}
	
}
