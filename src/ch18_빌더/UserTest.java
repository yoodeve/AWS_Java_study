package ch18_빌더;

public class UserTest {

	// 메소드 사용 : 생성자 생성해야 사용가능
	public static void printUser() {
		System.out.println("user info printed");
		new UserTestTest();
	}

	public void test() {
		System.out.println("test method called");
	}

	// 내부클래스
	public static class UserTestTest {
		public void testTest() {
			System.out.println("testtest method called");
		}
	}
}
