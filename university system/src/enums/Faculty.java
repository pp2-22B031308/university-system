package enums;

public enum Faculty {
	SITE, SBS, SGGE, SEPI, SNSS, ISE;
	
	
	
	public static Faculty convertToFac(int f) {
	switch(f){
	 case 1:
		 return Faculty.ISE;
	 case 2:
		 return Faculty.SBS;
	 case 3:
		 return Faculty.SEPI;
	 case 4:
		 return Faculty.SGGE;
	 case 5:
		 return Faculty.SITE;
	 case 6:
		 return  Faculty.SNSS;
		}
	return null;
	}
}