package course;

import java.io.Serializable;
import java.util.Objects;

public class CourseFile implements Serializable  {
	private Course course;
	private String content;
	private String title;
	
	public CourseFile() 
	{
		
	}
	
	public CourseFile(Course course, String content, String title) {
		this.course = course;
		this.content = content;
		this.title = title;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public int hashCode() {
		return Objects.hash(content, course, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CourseFile other = (CourseFile) obj;
		return Objects.equals(content, other.content) && Objects.equals(course, other.course)
				&& Objects.equals(title, other.title);
	}


	@Override
	public String toString() {
		return "CourseFile [course=" + course + ", content=" + content + ", title=" + title + "]";
	}
}
