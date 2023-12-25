package enums;

public enum Gender {
	M, F, UNDEFINED;
	
	
	public static  Gender convertGen(int g) {
		switch(g){
		 case 1 :
			return Gender.M;
		 case 2:
			return Gender.F;
		 case 3:
			 return Gender.UNDEFINED;
		}
		 return Gender.UNDEFINED;
	}
}
