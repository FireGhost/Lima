package cpnv.jav1.lima;

import java.util.Date;

public class Student extends Person {
	
	private int _startYear;
	
	public Student(String lastName, String firstName, int startYear) throws Exception {
		super(lastName, firstName);
		this.setStartYear(startYear);
	}
	public Student(Student student2) throws Exception {
		super(student2);
		this.setStartYear(student2.getStartYear());
	}
	
	
	@Override
	public void setBirthDate(Date birthDate) throws Exception {
		Date birthAdd25 = birthDate;
		birthAdd25.setYear( birthDate.getYear() + 15 );
		if (birthAdd25.after( new Date() )) throw new Exception("A student must be at least 15 years old");
		
		_birthDate = birthDate;
	}
	
	
	public String toString() {
		return this.getFirstName() +" "+ this.getLastName() +" ("+ getStartYear() +")";
	}
	public String dump() { return toString(); }
	
	
	
	public int getStartYear() {
		return _startYear;
	}
	public void setStartYear(int startYear) {
		_startYear = startYear;
	}

}
