package ch18_빌더;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class KoreaUser {

	private int userId;
	private String password;
	private String username;
	private String name;
	private String email;

//	public static KoreaUserBuilder builder() {
//		return new KoreaUserBuilder();
//	}

//	public static class KoreaUserBuilder {
//		private int userId;
//		private String password;
//		private String username;
//		private String name;
//		private String email;
////
//		public KoreaUser build() {
//			return new KoreaUser(userId, password, username, name, email);
//		}
//
//		public KoreaUserBuilder userId(int userId) {
//			this.userId = userId;
//			return this;
//		}
//
//		public KoreaUserBuilder userName(String username) {
//			this.username = username;
//			return this;
//		}
//
//		public KoreaUserBuilder name(String name) {
//			this.name = name;
//			return this;
//		}
//
//		public KoreaUserBuilder email(String email) {
//			this.email = email;
//			return this;
//		}

}

//}
