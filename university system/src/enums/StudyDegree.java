package enums;

public enum StudyDegree {
	PHD, MASTER, BACHELOR;
	
	public static StudyDegree convertStudyDegree(int studyDegree) {
		  switch(studyDegree) {
		  case 1:
		   return StudyDegree.PHD;
		  case 2:
		  	return StudyDegree.MASTER;
		  case 3:
		   return StudyDegree.BACHELOR;
		   
		  }
		  return null;
		 }
}
