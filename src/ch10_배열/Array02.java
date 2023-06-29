package ch10_배열;

public class Array02 {
	public static void main(String[] args) {
		// all 자료형의 배열을 만들 수 있음
		String[] names = new String[] { "한유정", "홍길동", "김영희" };
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}
	}
}
