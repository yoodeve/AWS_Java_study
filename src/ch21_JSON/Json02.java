package ch21_JSON;

import com.google.gson.Gson;

public class Json02 {
	public static void main(String[] args) {
		Gson gson = new Gson();

		JsonUser jsonUser = JsonUser.builder().username("한유정").password("bbb").build();
		// @Data 어노테이션 없이도 이건 사용 가능, but 다른 라이브러리에서도 getter, setter등이
		// 필요하기 때문에 어노테이션은 해줘야함
		String jsonifiedUser = gson.toJson(jsonUser);

		System.out.println(jsonUser);
		System.out.println(jsonifiedUser);

		// JsonUser형에 JsonUser.class형태로 변환한 Json문자열을 저장
		JsonUser fromJsonUser = gson.fromJson(jsonifiedUser, JsonUser.class);
		System.out.println(fromJsonUser);
	}
}
