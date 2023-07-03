package ch20_컬렉션;

import java.util.HashSet;

public class HashsetMain {

	public static void main(String[] args) {
		// js의 객체같은 개념
		HashSet<TestUser> testUsers = new HashSet<>();

		testUsers.add(TestUser.builder().username("aaaa").password("1111").build());
		testUsers.add(TestUser.builder().username("bbbb").password("2222").build());
		testUsers.add(TestUser.builder().username("cccc").password("3333").build());
		testUsers.add(TestUser.builder().username("dddd").password("4444").build());

		TestUser val = null;
		for (TestUser testUser : testUsers) {
			if (testUser.getPassword().equals("1111")) {
				val = testUser;
				break;
			}
		}
		System.out.println(val);
	}

}
