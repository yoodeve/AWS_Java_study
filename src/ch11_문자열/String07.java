package ch11_문자열;

public class String07 {
	public static void main(String[] args) {
		String name = "유정";
		String address = "부산 남구";
		// 문자열 합치기
		System.out.println(name.concat("\s".concat(address)));
	}
}
