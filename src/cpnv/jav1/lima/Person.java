package cpnv.jav1.lima;

import java.util.Date;
import java.util.Locale;

public abstract class Person {
	
	private String _lastName;
	private String _firstName;
	protected Date _birthDate;

	public Person(String lastName, String firstName) throws Exception {
		setLastName(lastName);
		setFirstName(firstName);
	}
	public Person(Person person2) throws Exception {
		this(person2.getLastName(), person2.getFirstName());
	}
	
	
	public String toString() {
		return _firstName +' '+ _lastName.toUpperCase(Locale.FRENCH);
	}
	
	
	
	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) throws Exception {
		if (lastName.length() < 2) throw new Exception("Last name must have at least 2 characters");
		_lastName = lastName;
	}

	
	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) throws Exception {
		if (firstName.length() < 2) throw new Exception("First name must have at least 2 characters");
		_firstName = firstName;
	}

	
	public Date getBirthDate() {
		return _birthDate;
	}

	public abstract void setBirthDate(Date birthDate) throws Exception;

}
