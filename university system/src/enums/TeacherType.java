package enums;

public enum TeacherType {


	P, S_l, T;
	
	/*
	 * P - PROFESSOR 
	 * S_L - SENIOR_LECTURES
	 * T - TUTOR
	*/
	
		 public static TeacherType convertTeacherType(int teacherType) {
		  switch(teacherType) {
		  case 1:
		   return TeacherType.P;
		  case 2:
		   return TeacherType.S_l;
		  case 3:
		   return TeacherType.T;
		  }
		  return null;
		 }
		 
}
