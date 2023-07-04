package ch21_JSON;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonObject;

public class Json01 {

	public static void main(String[] args) {

		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("productCode", "P123123123");
		dataMap.put("productName", "아이폰15");
		System.out.println(dataMap);

		// json은 전체 문자열
		JsonObject jsObj = new JsonObject();
		jsObj.addProperty("productCode", "P123123123");
		jsObj.addProperty("productName", "아이폰15");
		System.out.println(jsObj);
	}

}
