package edn.examples.video.xmlBuilder;

import edn.examples.book.model.User;

public class Test {
	
	public static void main(String[] args) {
		
		User u = new User("Edney", "35");
		
		XmlBuilder builder = new XmlBuilderImpl(User.class);
		
		String xml = builder.ObjectToXml(u);
		
		System.out.println(xml);
	}

}
