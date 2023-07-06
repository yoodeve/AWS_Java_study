package ch18_빌더;

//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//@Builder
public class KoreaUser {

	private int userId;
	private String password;
	private String username;
	private String name;
	private String email;

	public KoreaUser(int userId2, String password2, String username2, String name2, String email2) {
		// TODO Auto-generated constructor stub
	}

	public static KoreaUserBuilder builder() {
		return new KoreaUserBuilder();
	}

	public static class KoreaUserBuilder {
		private int userId;
		private String password;
		private String username;
		private String name;
		private String email;

		public KoreaUser build() {
			return new KoreaUser(userId, password, username, name, email);
		}

		public KoreaUserBuilder userId(int userId) {
			this.userId = userId;
			return this;
		}

		public KoreaUserBuilder userName(String username) {
			this.username = username;
			return this;
		}

		public KoreaUserBuilder name(String name) {
			this.name = name;
			return this;
		}

		public KoreaUserBuilder email(String email) {
			this.email = email;
			return this;
		}

	}

}
