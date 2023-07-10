package midTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

		List<Map<String, Object>> customers = new ArrayList<>();
		customers.add(hong);
		customers.add(kim);

		for (String key : hong.keySet()) {
			System.out.println(key + "=" + hong.get(key));
		}
	}
}
