package edn.examples.book.model;

import edn.examples.book.annotations.Ignore;
import edn.examples.book.annotations.PropertyName;

public class Phone {

	private String number;
	
	private String State;
	
	private String type;
	
	private String country;

	public Phone() {
	}

	public Phone(String number, String state, String type, String country) {
		super();
		this.number = number;
		State = state;
		this.type = type;
		this.country = country;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	@Ignore
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@PropertyName("nameRetrievedByAnnotation")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Telefone [number=" + number + ", State=" + State + ", type=" + type + ", country=" + country + "]";
	}

}
