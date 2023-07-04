package ch21_JSON;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Json01 {

	public static void main(String[] args) {
		Gson gson = new Gson();

		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("productCode", "P123123123");
		dataMap.put("productName", "아이폰15");
		System.out.println(dataMap);

		// json은 전체 문자열
		JsonObject jsObj = new JsonObject();
		jsObj.addProperty("productCode", "P123123123");
		jsObj.addProperty("productName", "아이폰15");
		System.out.println(jsObj);

		System.out.println("===============");

		// map에서 json타입 변환(gson인스턴스 내의 toJson코드 사용)
		String toJson = gson.toJson(dataMap);
		System.out.println(toJson);
		Map<String, Object> jsonMap = gson.fromJson(jsObj, Map.class);
		Object jsonmapget = jsonMap.get("productCode");
		System.out.println((String) jsonmapget);
		System.out.println(jsonMap.get("productCode"));

	}

}
