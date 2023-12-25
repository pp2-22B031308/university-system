package enums;

public enum TeacherType {


	P, S_l, l, T_A, T, ASSIS_P;
	
	/*
	 * P - PROFESSOR 
	 * S_L - SENIOR_LECTURES
	 * L - LECTURES
	 * T_A - TEACHING_ASSISTENT
	 * T - TUTOR
	 * ASSIS_P - ASSISTENT_PROFESSOR */
	
		 public static TeacherType convertTeacherType(int teacherType) {
		  switch(teacherType) {
		  case 1:
		   return TeacherType.P;
		  case 2:
		   return TeacherType.ASSOS_P;
		  case 3:
		   return TeacherType.S_l;
		  case 4:
		   return TeacherType.l;
		  case 5:
		   return TeacherType.T_A;
		  case 6:
		   return TeacherType.T;
		  case 7:
		   return TeacherType.ASSIS_P;
		  }
		  return null;
		 }
		 
}
