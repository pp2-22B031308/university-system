package system;

import java.io.BufferedReader;



import java.io.IOException;

import java.io.InputStreamReader;

import additional.*;
import charge.*;
import users.*;
import course.*;
import database.*;
import enums.*;
import research.*;
import exceptions.*;

public final class UniversityWSP {
	static UniversityWSP  universityWSP = new  UniversityWSP();
	
	
	private  UniversityWSP () {};
	
	public static UniversityWSP getUWSP() {
		return universityWSP;
	}
	
	
	public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        operationMessage("Enter login and password");
        
        System.out.println("Login:");
        String login = br.readLine();
        
        System.out.println("Password:");
        String password = br.readLine();

        try {
        	if (loginPasswordValidator(login, password) == 2) {
                operationMessage("Admin is enrolled");
                adminMenu();
            } 
        	else if (loginPasswordValidator(login, password) == 1) {
                User user = DataBase.getUsers().stream().filter(n -> n.getLogin().equals(login)).findAny().orElse(null);

                if (user instanceof Teacher) {
                    Teacher teacher = (Teacher) user;
                    operationMessage("Teacher " + teacher.getName() + " " + teacher.getSurname() + " is enrolled");
                    teacherMenu(teacher);
                } 
                else if (user instanceof Student) {
                    Student student = (Student) user;
                    operationMessage("Student " + student.getName() + " " + student.getSurname() + " is enrolled");
                    studentMenu(student);
                } 
                else if (user instanceof Manager) {
                    Manager manager = (Manager) user;
                    operationMessage("Manager " + manager.getName() + " " + manager.getSurname() + " is enrolled");
                    managerMenu(manager);
                }
                else if (user instanceof GraduateStudent) {
                	GraduateStudent graduateStudent = (GraduateStudent) user;
                    operationMessage("Manager " + graduateStudent.getName() + " " + graduateStudent.getSurname() + " is enrolled");
                    graduateStudentMenu(graduateStudent );
                }
                else if (user instanceof TechSupportSpecialist) {
                	TechSupportSpecialist techSupportSpecialist = (TechSupportSpecialist) user;
                    operationMessage("Manager " + techSupportSpecialist.getName() + " " + techSupportSpecialist.getSurname() + " is enrolled");
                    techSupportSpecialistMenu(techSupportSpecialist);
                }
//                else if (user instanceof Researcher) {
//                	Researcher researcher = (Researcher) user;
//                    operationMessage("Researcher " + Researcher.getName() + " " + Researcher.getSurname() + " is enrolled");
//                    techSupportSpecialistMenu(researcher);
//                }
            }
        	
        	throw new WrongLogInException();
        	
        } 
        catch (WrongLogInException e) {
            operationMessage(WrongLogInException.printMessage(loginPasswordValidator(login, password)));
            run();
        }
    }

    

	 public void adminMenu() throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        while (true) {
	            System.out.println("Choose option:\n1.Add User\n2.View Users\n3.Delete User\n4.See Log Files\\n5.Exit\"");
	            int choice;
	            try {
	                choice = Integer.parseInt(br.readLine());
	                if (choice == 1) {
	                    System.out.println("Choose option:\n1.Add Student\n2.Add Teacher\n3.Add Manager\n4.Add Graduate Student \n5.Tech Support Specialist");
	                    
	                    try {
	                    	
	                        AdminСharge.addUser(Integer.parseInt(br.readLine()));
	                    } 
	                    catch (NumberFormatException e) {
	                        e.printStackTrace();
	                    } 
	                    catch (IOException e) {
	                        e.printStackTrace();
	                    }
	                } 
	                else if (choice == 2) {
	                    AdminСharge.viewUsers();
	                } 
	                else if (choice == 3) {
	                    AdminСharge.deleteUser(br.readLine());
	                } 
	                else if (choice == 4) {
	                    AdminСharge.viewLogs();  
	                } else if (choice == 5) {
	                    exit();
	                    break;
	                }
	            } 
	            catch (NumberFormatException e1) {
	                e1.printStackTrace();
	            } 
	            catch (IOException e1) {
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
	        System.out.println("Choose option:\n1.View Courses\n2.View Students\n3.Put marks\n4.Send Complaint\n5.Exit");
	        int choice;
			try {
				choice = Integer.parseInt(br.readLine());
		        if(choice==1) {
				    System.out.println("Which faculty course belongs:\n1.ISE\n2.SBS\n3.KMA\n4.MKM\n5.SITE\n6.SPE");
				    Faculty faculty = Faculty.convertToFac(Integer.parseInt(br.readLine()));
		        	
				    TeacherСharge.viewCourses(faculty);
		        }
		        else if(choice==2) {
		        	TeacherСharge.viewStudents();
		        	System.out.println("Choose option:\1n.View Info About Student\n2.Return back");
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
				        		TeacherСharge.putMarks(student, course , mark);
			        		}
			            	else {
			   
			            		operationMessage("Sorry you cannot put mark to this course! Choose another one");
			            	}
		        	}
		        	else {
		        		operationMessage("There are no courses");
		        	}

		        }
		        else if (choice == 4) {
	                System.out.println("Enter Student ID:");
	                String studentId = br.readLine();
	                Student student = (Student) DataBase.getUsers().stream().filter(n -> n.getId().equals(studentId)).findAny().orElse(null);

	                if (student != null) {
	                	System.out.println("Enter Complaint Urgency (1.LOW 2.MEDIUM 3.HIGH):");
	                	int urgencyChoice = Integer.parseInt(br.readLine());
	                	UrgencyLevel urgency = UrgencyLevel.convertToUrgency(urgencyChoice);

	                    System.out.println("Enter Complaint Details:");
	                    String details = br.readLine();

	                    Complaint complaint = TeacherСharge.sendComplaint(teacher, student, urgency, details);
	                    operationMessage("Complaint sent successfully! Complaint ID: " + complaint.getId());
	                } else {
	                    operationMessage("Invalid Student ID.");
	                }
	            } else if (choice == 5) {
	                exit();
	                break;
	            }
			} 
			catch (NumberFormatException e1) {
				e1.printStackTrace();
			} 
			catch (IOException e1) {
				e1.printStackTrace();
			}

		}
	}
	
	
	public void studentMenu(Student student) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
	        System.out.println("Choose option:\n1.View Marks\n2.Make Request to Register for Course\n3.View courses\n4.View Transcript\n5.View Teachers\n6.Exit");
	        int choice;
			try {
				choice = Integer.parseInt(br.readLine());
		        if(choice==1) {
		        	System.out.println("Your current marks:");
		        	StudentСharge.viewMarks(student);
		        }
		        else if(choice==2) {
		            System.out.println("All available courses:");
		            DataBase.getCourses().forEach(course -> System.out.println(course.getId() + ": " + course.getName()));

		            System.out.println("Enter Course id:");
		            String id = br.readLine();
		            Course course = DataBase.getCourses().stream().filter(n->n.getId().equals(id)).findAny().orElse(null);

		            if (course != null) {
		                StudentСharge.RegisterForCourses(student, course);
		                System.out.println("Registration request for " + course.getName() + " submitted successfully!");

		            } 
		        else {
		                System.out.println("Course not found with ID: " + id);
		            }
		        }

		        else if(choice==3) {
		        	StudentСharge.viewCourses(student.getFaculty());
		        }
		        else if(choice==4) {
		        	StudentСharge.ViewTranscript(student);
		        }
		        else if(choice==5){
		        	StudentСharge.viewTeachers();
		        }
		        else if(choice==6) {
		        	exit();
		        	break;
		        }
		        
			} 
			catch (NumberFormatException e1) {
				e1.printStackTrace();
			} 
			catch (IOException e1) {
				e1.printStackTrace();
			}
			finally {
				 DataBase.saveUsers();
			}
		}
	}
	
	
	public void managerMenu(Manager manager) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
	        System.out.println("Choose option:\n1.Assign course for Teacher\n2.Approve Student's Registration\n3.View Teachers\n4.View Students\n5.Add course\n6.Exit");
	        int choice;
			try {
				choice = Integer.parseInt(br.readLine());
		        if(choice==1) {
		        	System.out.println("Enter Teacher's Id:");
		        	String id = br.readLine();
		        	
		        	Teacher teacher = (Teacher) DataBase.getUsers().stream().filter(n -> n.getId().equals(id)).findAny().orElse(null);
		        	
		        	System.out.println("Enter Course id:");
	                String courseId = br.readLine();
	                
	                Course course = DataBase.getCourses().stream().filter(n -> n.getId().equals(courseId)).findAny().orElse(null);

	                if (teacher != null && course != null && course.getFaculty().equals(teacher.getFaculty())) {
	                    ManagerСharge.assignCourseForTeacher(teacher, course);
	                } 
	                else {
	                    operationMessage("Invalid Teacher ID, Course ID, or Faculty mismatch.");
	                }
	            }
		        else if (choice == 2) {
		            System.out.println("Enter Student ID:");
		            String studentId = br.readLine();
		            
		            Student student = (Student) DataBase.getUsers().stream().filter(n -> n.getId().equals(studentId)).findAny().orElse(null);

		            System.out.println("Enter Course ID:");
		            String courseId = br.readLine();
		            
		            Course course = DataBase.getCourses().stream().filter(n -> n.getId().equals(courseId)).findAny().orElse(null);

		            if (student != null && course != null) {
		                ManagerСharge.approveStudentRegistration(student, course);
		                operationMessage("Student registration for " + course.getName() + " approved successfully!");
		            } 
		            else {
		                operationMessage("Invalid Student or Course.");
		            }
		        }

		        else if(choice==3) {
		        	ManagerСharge.viewTeachers();
		        }
		        else if(choice==4) {
		        	System.out.println("Enter Student id:");
		        	String id = br.readLine();
		        	
		        	Student student = (Student) DataBase.getUsers().stream().filter(n -> n.getId().equals(id)).findAny().orElse(null);
		        	ManagerСharge.viewStudentInfo(student);

		        }
		        else if (choice == 5) {
		            System.out.println("Enter course details:");
		            System.out.println("ID:");
		            String id = br.readLine();
		            
		            System.out.println("Name:");
		            String name = br.readLine();
		            
		            System.out.println("Description:");
		            String description = br.readLine();
		            
		            System.out.println("Faculty (1.ISE 2.SBS 3.KMA 4.MKM 5.SITE 6.SPE):");
		            
		            int facultyChoice = Integer.parseInt(br.readLine());
		            Faculty faculty = Faculty.convertToFac(facultyChoice);

		            Course newCourse = new Course(id, name, description, null, faculty, 0);
		            
		            ManagerСharge.addCourseForRegistration(newCourse);
		        }
		        

	            else if(choice==6) {
	                exit();
	                break;
	            }
			} 
			catch (NumberFormatException e1) {
				e1.printStackTrace();
			} 
			catch (IOException e1) {
				e1.printStackTrace();
			}
			finally {
				 DataBase.saveUsers();
			}
		}
	}
	
	
	public void graduateStudentMenu(GraduateStudent graduateStudent) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    while (true) {
	        System.out.println("Choose option:\n1.View Diploma Projects\n2.Submit Diploma Project\n3.View My Diploma Project\n4.Exit");
	        int choice;
	        try {
	            choice = Integer.parseInt(br.readLine());
	            if (choice == 1) {
	                GraduateStudentСharge.viewDiplomaProjects();
	            } else if (choice == 2) {
	                System.out.println("Enter the ID of the Diploma Project you want to submit:");
	                String projectId = br.readLine();
	                DiplomaProject diplomaProject = GraduateStudentСharge.findDiplomaProjectById(projectId);
	                if (diplomaProject != null) {
	                    GraduateStudentСharge.submitDiplomaProject(graduateStudent, diplomaProject);
	                    operationMessage("Diploma Project submitted successfully!");
	                } else {
	                    operationMessage("Diploma Project not found with ID: " + projectId);
	                }
	            } else if (choice == 3) {
	                GraduateStudentСharge.viewMyDiplomaProject(graduateStudent);
	            } else if (choice == 4) {
	                exit();
	                break;
	            }
	        } catch (NumberFormatException e1) {
	            e1.printStackTrace();
	        } catch (IOException e1) {
	            e1.printStackTrace();
	        }
	    }
	}
	
	
	
	

	public static void techSupportSpecialistMenu(TechSupportSpecialist techSupportSpecialist) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("Choose option:\n1.Send Tech Support Request to Manager\n2.Exit");
			int choice;
			try {
				choice = Integer.parseInt(br.readLine());
				if (choice == 1) {
					TechSupportSpecialistCharge.sendTechSupportRequestToManager(techSupportSpecialist);
	                	} else if (choice == 2) {
	                		exit();
	                		break;
	                	}
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			}
		}
	}
	

	public void researcherMenu() throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
	        System.out.println("What do you want to do?\n1.Join ResearchProject\n2.Print Papers\n3.Calculate h-index\n4.View research papers\n5.View researchProjects\n6.Exit");
	        int choice;
	        Researcher researcher = (Researcher) DataBase.getCurrentUser();
			try {
				choice = Integer.parseInt(br.readLine());
		        if(choice==1) {
		        	System.out.println("Enter Project id:");
		        	String projectId = br.readLine();
		        	ResearchProject project = DataBase.getProjects().stream().filter(n -> n.getId() == projectId).findAny().orElse(null);
		        	if(researcher instanceof Researcher) {
		        		ManagerСharge.assignProjectForResearcher(researcher,project);
		        	}
		        	else operationMessage("User "+researcher.getId()+" "+researcher.getResearchProjects()+" cannot join project "+ project.getId()+" because the user is not a researcher");
		        }
		        else if(choice==2) {
		        	System.out.println("Enter Research Paper's ID:");
		        }
		        else if(choice==3) {

		        }else if(choice==4) {
		        	ResearcherCharge.ViewResearchPapers(researcher);
		        }
		        else if(choice==5){
		        	ResearcherCharge.viewResearchProjects(researcher);
		        }
		        else if(choice==6) {
		        	exit();
		        	break;
		        
			}
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			finally {
				 DataBase.saveUsers();
			}
		}
	}
	
	
	public static void exit() throws Exception {
		operationMessage("Logging out the account");
		DataBase.saveUsers();
	}
	
	public int loginPasswordValidator(String login, String password) {
        if (login.equals(Admin.getLogin()) && password.equals(Admin.getPassword())) {
            return 2;
        } else if (!DataBase.getUsers().isEmpty()) {
            if (DataBase.getUsers().stream().anyMatch(user -> user.getLogin().equals(login) && !user.getPassword().equals(password))) {
                return 0;
            } else if (DataBase.getUsers().stream().anyMatch((user -> (user.getLogin().equals(login)) && (user.getPassword().equals(password))))) {
                return 1;
            } else {
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
	    String separator = new String(new char[85]).replace("\0", "~");
	    System.out.printf("%15s%n%-20s%-20s%n%15s%n", separator, " ", message, separator);
	}
}
