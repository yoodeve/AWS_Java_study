package midTest;

public class User {
	public User() {

	}

	public User(String username2, String password2, String name2, String email2) {
	}

	private String username;
	private String password;
	private String name;
	private String email;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
//		System.out.println("[사용자 정보]");
//		System.out.println("username : " + username);
//		System.out.println("password : " + password);
//		System.out.println("name : " + name);
//		System.out.println("email : " + email);
		return "[사용자 정보]" + "\nusername : " + username + "\npassword : " + password + "\nname : " + name + "\nemail : "
				+ email;
	}

}
