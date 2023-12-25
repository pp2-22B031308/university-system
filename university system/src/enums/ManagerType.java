package enums;

public enum ManagerType {
	OR, DEPARTAMENT;
	 public static ManagerType convertManagerType(int type) {
		  switch(type) {
		  case 1:
		   return ManagerType.OR;
		  case 2:
		   return ManagerType.DEPARTAMENT;
		  }
		  return null;
		 }
}
