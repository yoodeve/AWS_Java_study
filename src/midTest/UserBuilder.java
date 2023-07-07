package midTest;

public class UserBuilder {
	private String username;
	private String password;
	private String name;
	private String email;

	public static User builder() {
		return new User(username, password, name, email);
	}

	public User build() {
		return new User();
	}

	public UserBuilder username(String username) {
		this.username = username;
		return this;
	}

	public UserBuilder password(String password) {
		this.password = password;
		return this;
	}

	public UserBuilder name(String name) {
		this.name = name;
		return this;
	}

	public UserBuilder email(String email) {
		this.email = email;
		return this;
	}
}