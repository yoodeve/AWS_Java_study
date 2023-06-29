package ch11_문자열;

public class String05 {
	public static void main(String[] args) {
		String name = " ";
		// nullPointerException
		// String name = null;

		// 공백" "도 빈 것으로 간주(null말고 " "), 사용빈도 높음
		boolean flag = name.isBlank();
		System.out.println(flag);
		// 공백또한 문자열로 간주
		boolean flag2 = name.isEmpty();
		System.out.println(flag2);
	}
}
