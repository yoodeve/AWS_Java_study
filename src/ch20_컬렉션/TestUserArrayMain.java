package ch20_컬렉션;

public class TestUserArrayMain {
	public static void main(String[] args) {
		// list(그냥 일반 리스트 ex. 링크드리스트) != ArrayList(배열을 기반으로 만든 리스트)
		TestUser[] testUsers = new TestUser[3];

		testUsers[0] = TestUser.builder().username("한유정").password("2222").build();
		testUsers[1] = TestUser.builder().username("유정한").password("1111").build();
		testUsers[2] = TestUser.builder().username("정유한").password("5555").build();

	}
}
