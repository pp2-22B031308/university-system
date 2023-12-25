package enums;

public enum Gender {
	M, F;
	
	
	public static  Gender convertGen(int g) {
		switch(g){
		 case 1 :
			return Gender.M;
		 case 2:
			return Gender.F;
		 
		}
		 return Gender.F;
	}
}

