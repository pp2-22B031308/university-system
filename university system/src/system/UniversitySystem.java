package system;

import java.io.BufferedReader;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import repository.DataBase;
import service.AdminService;
import service.ManagerService;
import service.MarkFactory;
import service.StudentService;
import service.TeacherService;
import service.UserFactory;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Vector;
import java.util.stream.Stream;

import model.Course;
import model.Faculty;
import model.Mark;
import model.Student;
import model.SuperAdmin;
import model.Teacher;
import model.User;

public final class UniversitySystem {
	static UniversitySystem  universitySystem = new  UniversitySystem();
	
	
	private  UniversitySystem () {};
	public static UniversitySystem getUS() {
		return universitySystem;
	}
	
	
	public void run() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		operationMessage("Enter login and password");
		System.out.println("Login:");
		String login = br.readLine();
		System.out.println("Password:");
		String password = br.readLine();
		try {
			if(loginPasswordValidator(login, password)==2) {
				operationMessage("Admin is enrolled");
				adminMenu();
			}
			else if(loginPasswordValidator(login, password)==1) {
				User user = DataBase.getUsers().stream().filter(n -> n.getLogin().equals(login)).findAny().orElse(null);
				if(user instanceof Teacher) {
					Teacher teacher = (Teacher)user;
					operationMessage("Teacher "+teacher.getName()+" "+teacher.getSurname()+" is enrolled");
					teacherMenu(teacher);
				}
				else if(user instanceof Student) {
					Student student = (Student)user;
					operationMessage("Student "+student.getName()+" "+student.getSurname()+" is enrolled");
					studentMenu(student);
				}
				
				
			}
			throw new EnrollException();
		}
		catch(EnrollException e){
			operationMessage(EnrollException.printMessage(loginPasswordValidator(login, password)));
			run();
		}
		
	}
	

	public void adminMenu() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
	        System.out.println("What do you want to do?\n1.Add User\n2.View Users\n3.Delete User\n4.Update User\n5.Exit");
	        int choice;
			try {
				choice = Integer.parseInt(br.readLine());
		        if(choice==1) {
		        	System.out.println("What do you want to do?\n1.Add Student\n2.Add Teacher\n3.Add Manager");
		        	 try {
						AdminService.addUser(Integer.parseInt(br.readLine()));
					} catch (NumberFormatException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
		        }
		        else if(choice==2) {
		        	AdminService.viewUsers();
		        }
		        else if(choice==3) {
		        	AdminService.deleteUser(br.readLine());
		        }
		        else if(choice==4) {
		        	System.out.println("User's ID:");
		        	String id = br.readLine();
		        	try {
		        		if(idValidator(id)==1){
		        			operationMessage(AdminService.updateUser(id));
		        		}
		        		else {
		        			
		        		}
		        		throw new EnrollException();
		        	}
		        	catch(EnrollException e) {
		        		operationMessage(EnrollException.printMessage(idValidator(id)));
		        	}

		        }
		        else if(choice==5) {
		        	exit();
		        	break;
		        
			}
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			finally {
				 DataBase.saveUsers();
			}
		}
	}
	
	public void teacherMenu(Teacher teacher) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
	        System.out.println("What do you want to do?\n1.View Courses\n2.View Students\n3.Put marks\n4.Exit");
	        int choice;
			try {
				choice = Integer.parseInt(br.readLine());
		        if(choice==1) {
				    System.out.println("Enter to which faculty course belongs:\n1.ISE\n2.SBS\n3.SEPI\n4.SGGE\n5.SITE\n6.SNSS");
				    Faculty faculty = Faculty.convertToFac(Integer.parseInt(br.readLine()));
		        	TeacherService.viewCourses(faculty);
		        }
		        else if(choice==2) {
		        	TeacherService.viewStudents();
		        	System.out.println("What do you want to do?\1n.View Info About Student\n2.Return back");
		        }
		        else if(choice==3) {
		        	System.out.println("Enter Student ID:");
		        	String id = br.readLine();
		        	Student student = (Student)DataBase.getUsers().stream().filter(user -> user.getId().equals(id)).findAny().orElse(null);
		        	System.out.println(student.toString());
		        	
		        	if(!student.getMarks().isEmpty()) {
		        		System.out.println("Student's Courses:");
		        		System.out.println(student.toString());
		        		student.getMarks().entrySet().stream().forEach(n->System.out.println(n.getKey().getId()+n.getKey().getDescription()));
			        	System.out.println("Enter course's id");
			        	String courseId = br.readLine();
			        	Course course  = teacher.getCourses().stream().filter(n-> n.getId().equals(courseId)).findFirst().orElse(null);
			            	if(student.getMarks().containsKey(course) && course !=null) {
			        			System.out.println(student.toString());
			        			Mark mark = MarkFactory.createMark();
				        		TeacherService.putMarks(student, course , mark);
			        		}
			            	else {
			   
			            		operationMessage("Sorry you cannot put mark to this course! Choose another one");
			            	}
		        	}
		        	else {
		        		operationMessage("There are no courses");
		        	}

		        }
		        else if(choice==4) {
		        	exit();
		        	break;
			}
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}
	public void studentMenu(Student student) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
	        System.out.println("What do you want to do?\n1.View Marks\n2.Make Request to Register for Course\n3.View courses\n4.View Transcript\n5.\n6.Exit");
	        int choice;
			try {
				choice = Integer.parseInt(br.readLine());
		        if(choice==1) {
		        	System.out.println("Your current marks:");
		        	StudentService.viewMarks(student);
		        }
		        else if(choice==2) {
		        	System.out.println("Enter Course' id:");
		        	String id = br.readLine();
		        	Course course = DataBase.getCourses().stream().filter(n->n.getId().equals(id)).findAny().orElse(null);
		        	StudentService.RegisterForCourses(student, course);
		        }
		        else if(choice==3) {
		        	StudentService.viewCourses(student.getFaculty());
		        }
		        else if(choice==4) {
		        	StudentService.ViewTranscript(student);
		        }
		        else if(choice==5){
		        	StudentService.viewTeachers();
		        }
		        else if(choice==6) {
		        	exit();
		        	break;
		        
			}
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			finally {
				 DataBase.saveUsers();
			}
		}
	}
	
	public void managerMenu() throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
	        System.out.println("What do you want to do?\n1.Assign course for Teacher\n2.Approve Student's Registration\n3.View Teachers\n4.View Students\n5.Add course\n6.Exit");
	        int choice;
			try {
				choice = Integer.parseInt(br.readLine());
		        if(choice==1) {
		        	System.out.println("Enter Teacher's Id:");
		        	String id = br.readLine();
		        	Teacher teacher = (Teacher) DataBase.getUsers().stream().filter(n -> n.getId().equals(id)).findAny().orElse(null);
		        	System.out.println("Enter Course id:");
		        	Course course = DataBase.getCourses().stream().filter(n->n.getId().equals(id)).findAny().orElse(null);
		        	if(course.getFaculty().equals(teacher.getFaculty())) {
		        		ManagerService.assignCourseForTeacher(teacher,course);
		        	}
		        	else operationMessage("Teacher "+teacher.getId()+" "+teacher.getFaculty()+" cannot teach course "+course.getId()+" "+course.getFaculty());
		        }
		        else if(choice==2) {
		        	System.out.println("Enter Teacher ID:");
		        	String id = br.readLine();
		        	Teacher teacher = (Teacher) DataBase.getUsers().stream().filter(n -> n.getId().equals(id)).findAny().orElse(null);
		        	Course course = DataBase.getCourses().stream().filter(n->n.getId().equals(id)).findAny().orElse(null);
		        	ManagerService.assignCourseForTeacher(teacher, course);
		        	operationMessage(course.getId()+" "+course.getName()+" is assigned to teacher"+ teacher.getId()+" "+teacher.getName()+" "+teacher.getSurname());
		        }
		        else if(choice==3) {
		        	ManagerService.viewTeachers();
		        }
		        else if(choice==4) {
		        	System.out.println("Enter Student id:");
		        	String id = br.readLine();
		        	Student student = (Student) DataBase.getUsers().stream().filter(n -> n.getId().equals(id)).findAny().orElse(null);
		        	ManagerService.viewStudentInfo(student);

		        }
		        else if(choice==5) {
		        	exit();
		        	break;
		        
			}
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			finally {
				 DataBase.saveUsers();
			}
		}
	}
	public void exit() throws Exception {
		operationMessage("Logging out the account");
		DataBase.saveUsers();
	}
	
	public int loginPasswordValidator(String login, String password) {
		if(login.equals(SuperAdmin.getLogin()) && password.equals(SuperAdmin.getPassword())) {
			return 2;
		}
		else if(!DataBase.getUsers().isEmpty()) {
			if(DataBase.getUsers().stream().anyMatch(user -> user.getLogin().equals(login) && !user.getPassword().equals(password))){
				return 0;
			}
			else if(DataBase.getUsers().stream().anyMatch((user -> (user.getLogin().equals(login)) && (user.getPassword().equals(password))))) {
				return 1;
			}
			else {
			return -1;
			}
		}
		return -2;
	}
	public static int idValidator(String id) {
		if(DataBase.getUsers().stream().anyMatch((user -> user.getId().equals(id)))) {
			return 1;
		}
		return -1;
	}
	public static void operationMessage(String message) {
		System.out.printf("%15s%n%-20s%-20s%n%15s%n",new String(new char[85]).replace("\0", "-"), " ", message ,new String(new char[85]).replace("\0", "-"));
		
	}
	
	

}