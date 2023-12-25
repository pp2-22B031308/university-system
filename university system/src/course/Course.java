package course;

import java.io.Serializable;
import java.util.Objects;
import java.util.Vector;

public class Course implements Serializable {

	private String id;
	private String name;
	private String description;
	private Course prerequisite;
	private Faculty faculty;
	private int numOfCredit;

	
	
	public Course(String id, String name, String description, Course prerequisite, Faculty faculty, int numOfCredit) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.prerequisite = prerequisite;
		this.numOfCredit = numOfCredit;
		this.faculty = faculty;
//		this.teachers= new Vector<Course>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDiscription(String description) {
		this.description = description;
	}

	public Course getPrerequisite() {
		return prerequisite;
	}

	public void setPrerequisite(Course prerequisite) {
		this.prerequisite = prerequisite;
	}

	public int getNumOfCredit() {
		return numOfCredit;
	}

	public void setNumOfCredit(int numOfCredit) {
		this.numOfCredit = numOfCredit;
	}
	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", discription=" + description + ", prerequisite=" + prerequisite
				+ ", numOfCredit=" + numOfCredit + "Faculty "+faculty+ "]";
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(description, id, name, numOfCredit, prerequisite);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && numOfCredit == other.numOfCredit
				&& Objects.equals(prerequisite, other.prerequisite);
	}

//	public Vector <Teacher> getCourses() {
//		
//	}

}
