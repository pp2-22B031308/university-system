package enums;

public enum Faculty {
	SITE, SBS, KMA, MKM, SPE, ISE;
	
	
	
	public static Faculty convertToFac(int f) {
	switch(f){
	 case 1:
		 return Faculty.ISE;
	 case 2:
		 return Faculty.SBS;
	 case 3:
		 return Faculty.KMA;
	 case 4:
		 return Faculty.MKM;
	 case 5:
		 return Faculty.SITE;
	 case 6:
		 return  Faculty.SPE;
		}
	return null;
	}
}
