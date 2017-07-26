package edn.examples.model;

public class User {

	String name;
	String age;
	
	public User() {}
	
	public User(String n, String a) {
		name = n;
		age = a;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}
