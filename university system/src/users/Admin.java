package users;



public final class Admin {
	private static String login = "ADM123";
	private static String password = "123";
	private static Admin SA;
	private Admin() {};
	private Admin(String login, String password) {
		Admin.login = login;
		Admin.password = password;
	}
	
	public static Admin getSuperAdmin() {
		if (SA == null) 
			SA = new Admin(login, password);
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
