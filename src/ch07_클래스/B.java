package ch07_클래스;

public class B {
	// 생성자 생략되어있음

	// 반환x 매개변수x
	void test1() {
		System.out.println("test1 메소드 호출");
	}

	// 반환(정수) 매개변수x
	int test2() {
		System.out.println("test2 메소드 호출");
		return 100;
	}

	// 반환(boolean) 매개변수x
	boolean test3() {
		System.out.println("test3 메소드서비스 실행");
		return test2() == 100;
	}

	// 반환x, 매개변수(name, age):대입용 구멍 / 받는다==메모리 공간이 있다. 매개"변수" 역시 변수
	void test4(String name, int age) {
		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
	}

	void test4(int age, String name) {
		System.out.println("나의 이름: " + name);
		System.out.println("나의 나이: " + age);
	}
	// 위 두개가 되는 이유 : overloading = 매개변수의 자료형이 서로 다르면 똑같은 메소드명을 사용 가능함.
	// 왜냐하면 test4의 매개변수 순서와 자료형에 따라 걸맞는 test4를 찾아갈 수 있기 때문
	// 다만 오버로딩 시에는 리턴을 줄 수 없다.
	// 오버로딩은 자료형이 달라야만이 가능하다.
}
