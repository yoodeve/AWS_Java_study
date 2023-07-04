package ch20_컬렉션;

import java.util.HashMap;
import java.util.Map.Entry;

public class HashMapMain {
	public static void main(String[] args) {
		HashMap<String, String> strMap = new HashMap<>();
		// 맵에 넣기(set)
		strMap.put("username", "aaa");
		strMap.put("password", "12344");
		strMap.put("name", "yoo");

		System.out.println(strMap);
		System.out.println(strMap.get("username"));
		// 맵을 반복돌릴 때 필요한 메소드
		// 맵에서 빼기(get)
		// Entry는 맵의 키 밸류를 하나로 묶어서 set형태로 관리하는 것
		// Object.emtries
		for (Entry<String, String> entry : strMap.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		System.out.println("===============");
		// Object.keys
		// Object.values
		for (String key : strMap.keySet()) {
			System.out.println(key);
			System.out.println(strMap.get(key));
		}

	}
}
