package ch18_빌더;

// 객체를 대신 만들어줌
public class KoreaUserBuilder2 {
	private int userId;
	private String password;
	private String username;
	private String name;
	private String email;

	public KoreaUser build() {
		return new KoreaUser(userId, password, username, name, email);
	}

	public KoreaUserBuilder2 userId(int userId) {
		this.userId = userId;
		return this;
	}

	public KoreaUserBuilder2 userName(String username) {
		this.username = username;
		return this;
	}

	public KoreaUserBuilder2 name(String name) {
		this.name = name;
		return this;
	}

	public KoreaUserBuilder2 email(String email) {
		this.email = email;
		return this;
	}

}
