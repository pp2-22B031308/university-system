package enums;

public enum Gender {
	MALE, FEMALE;
	
	
	public static  Gender convertGen(int g) {
		switch(g){
		 case 1 :
			return Gender.MALE;
		 case 2:
			return Gender.FEMALE;
		}
		 return Gender.MALE;
	}
}
