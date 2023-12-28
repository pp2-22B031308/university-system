package users;



public final class Admin {
	private static String login = "Admin";
	private static String password = "123";
	private static Admin admin;
	private Admin() {};
	private Admin(String login, String password) {
		Admin.login = login;
		Admin.password = password;
	}
	
	public static Admin getAdmin() {
		if (admin == null) 
			admin = new Admin(login, password);
		return admin;
	}
	public static String getPassword() {
		return password;
	}
	public static String getLogin() {
		return login;
	}
	

}
;
