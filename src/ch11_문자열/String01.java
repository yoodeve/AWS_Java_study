package ch11_문자열;

import java.nio.charset.StandardCharsets;

public class String01 {
	public static void main(String[] args) {
		String str0 = "코리아 아이티 아카데미";
		// 아래처럼 쓰는 경우는
		String str = new String("코리아 아이티 아카데미");
		// 이렇게 인코딩 할 때
		String strEncoded = new String("코리아 아이티 아카데미".getBytes(StandardCharsets.UTF_8));
		// 아래 결과 같음
		// new 안하는 경우 : 자료형이 기존에 존재할 때.(100번주소)
		// new String:새로운 문자열을 담을 공간을 할당하고 리터럴을 또 저장(200번 주소에 100번주소 넣은것)
		// 필요없는 한단계가 추가된 것..?
		System.out.println(str0);
		System.out.println(str);
		// ==은 주소를 비교
		System.out.println(str0 == "코리아 아이티 아카데미"); // true, 100번 == 100번
		System.out.println(str == "코리아 아이티 아카데미"); // false, 200번 == 100번
	}
}
