package ch07_클래스;

public class BMain {
	public static void main(String[] args) {
		B b1 = new B();
		// 함수 call

		// 호버 시 void(비어있는)라고 뜸
		b1.test1();
		// 호버 시 int라고 뜸(얘가 실행되고 나면 이 메소드는 돌려주는 값이 정수값이다.)
		int num1 = b1.test2(); // 호출도 되고, num1에 리턴값인 100이 담김
		// int num2 = 200;
		System.out.println(num1); // num1의 출력(100)
		System.out.println(b1.test2()); // 호출=실행, 실행도되고 100도 담김
		// 호출과 동시에 리턴값 활용
		if (b1.test3()) {
			System.out.println("if문 실행됨");
		}
		b1.test4(29, "유정");
	}
}
