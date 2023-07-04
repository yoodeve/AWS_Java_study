package ch20_컬렉션;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListAndMapMain {
	// 굳이 클래스까지 만들고자 하지 않을 때 맵 활용하면 좋음******
	public static void main(String[] args) {
		List<TestUser> testUsers = new ArrayList<>();
		testUsers.add(TestUser.builder().username("aaaa").password("1234").build());
		testUsers.add(TestUser.builder().username("bbbb").password("1111").build());
		testUsers.add(TestUser.builder().username("cccc").password("2222").build());
		testUsers.add(TestUser.builder().username("dddd").password("3333").build());
		testUsers.add(TestUser.builder().username("eeee").password("4444").build());

		// 타입을 옵젝으로 잡아줘야 뒤에 들어오는 자료형을 고정시키지 않을 수 있음
		// 와일드카드는 안됨
		// 업캐스팅?
		Map<String, Object> resData = new HashMap<>();
		// put(key, value)
		resData.put("testUserList", testUsers);
		resData.put("statusCode", "200");

		// 현재 Object타입으로 맵 내에 저장되어있기 때문에 다시 TestUser형을 담는 리스트로 다운캐스팅
		for (TestUser testUser : (List<TestUser>) resData.get("testUserList")) {
			System.out.println(testUser);
		}
	}
}
