package cpnv.jav1.lima;

import java.util.Calendar;
import java.util.Date;

public class Teacher extends Person {
	
	private String _section;

	public Teacher(String firstName, String lastName, String section, Date birthDate) throws Exception {
		super(lastName, firstName);
		this.setBirthDate(birthDate);
		this.setSection(section);
	}
	public Teacher(Teacher teacher2) throws Exception {
		super(teacher2);
		this.setBirthDate(teacher2.getBirthDate());
		this.setSection(teacher2.getSection());
	}
	
	
	
	public String toString() {
		return this.getFirstName() +" "+ this.getLastName() +" ("+ getSection() +")";
	}
	public String dump() { return toString(); }
	
	
	
	public String getSection() {
		return _section;
	}

	public void setSection(String section) {
		_section = section;
	}
	
	
	@Override
	public final void setBirthDate(Date birthDate) throws Exception {
		Date birthAdd25 = birthDate;
		birthAdd25.setYear( birthDate.getYear() + 25 );
		if (birthAdd25.after( new Date() )) throw new Exception("A teacher must be at least 25 years old");
		
		_birthDate = birthDate;
	}

}
