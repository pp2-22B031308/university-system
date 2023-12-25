package users;



public final class SuperAdmin {
	private static String login = "ADM123";
	private static String password = "123";
	private static SuperAdmin SA;
	private SuperAdmin() {};
	private SuperAdmin(String login, String password) {
		SuperAdmin.login = login;
		SuperAdmin.password = password;
	}
	
	public static SuperAdmin getSuperAdmin() {
		if (SA == null) 
			SA = new SuperAdmin(login, password);
		return SA;
	}
	public static String getPassword() {
		return password;
	}
	public static String getLogin() {
		return login;
	}
	

}
;