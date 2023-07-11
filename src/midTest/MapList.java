package midTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MapList {

	public static void main(String[] args) {

		Map<String, Object> hong = new HashMap<>();
		hong.put("name", "홍길동");
		hong.put("rating", "vip");
		hong.put("age", 30);

		Map<String, Object> kim = new HashMap<>();
		kim.put("name", "김기영");
		kim.put("rating", "gold");
		kim.put("age", 35);

		ArrayList<Map<String, Object>> people = new ArrayList<>();
		people.add(hong);
		people.add(kim);

		for (Map<String, Object> name : people) {
			name.entrySet().forEach(ent -> System.out.println(ent));
			for (Map.Entry<String, Object> entry : name.entrySet()) {
				System.out.println(entry);
			}
		}
	}
}
