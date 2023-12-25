package enums;

public enum TuitionType {
    GRANT, PAID;

	
	public static TuitionType convertTuitionType(int tuitionType) {
		  switch(tuitionType) {
		  case 1:
		   return TuitionType.GRANT;
		  case 2:
		   return TuitionType.PAID;
		  }
		  return null;
		 }
}
