package ch07_클래스;

public class A {
	// 틀
	int num1;
	int num2;

	// 클래스안에는 메소드(클래스안의 함수)도 넣을 수 있다, 자바는 클래스로 만들어지니까 결국 전부 메소드라고 하는게 편함.
	// void test1(){}
	// 함수 : x+y = z구할때..처음배움
	void test1() {
		System.out.println("test1 함수가 호출됨");
	}

	void test2(int x, int y) {
		System.out.println("x value:" + x);
		System.out.println("y value:" + y);
	}

	void test3() {
		System.out.println("num1:" + num1);
		System.out.println("num2:" + num2);
	}
}
