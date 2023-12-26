package enums;

public enum OrganizationRole {
	HEAD, MEMBER;

	 public static Role convertRole(int role) {
	  switch(role){
	  case 1:
	   return Role.HEAD;
	  case 2:
	   return Role.MEMBER;
	   }
	  return null;
	 }
}
