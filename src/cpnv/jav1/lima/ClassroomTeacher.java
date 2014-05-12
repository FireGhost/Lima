package cpnv.jav1.lima;

public class ClassroomTeacher extends Teacher {
	
	private String _classroom;
	
	public ClassroomTeacher(String classroom, Teacher teacher) throws Exception {
		super(teacher);
		setClassroom(classroom);
	}
	
	
	
	public String getClassroom() {
		return _classroom;
	}

	public void setClassroom(String classroom) {
		_classroom = classroom;
	}
	
}
