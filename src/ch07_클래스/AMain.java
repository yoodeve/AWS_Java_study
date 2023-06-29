package ch07_클래스;

public class AMain {
	public static void main(String[] args) {
		// A는 자료형, int n = 10;이랑 똑같이 할당한것. 메모리에 참조할당
		A a = new A();
		// a안의 데이터 꺼내려면
		System.out.println(a); // ch07_클래스.A@6f2b958e : ch07_클래스패키지의.A클래스를 가져오는데 @6f2b958e 메모리주소는 여기
		System.out.println(a.num1); // 0나옴 아직 할당 x
		a.num1 = 10;
		System.out.println(a.num1); // 할당이후 => 10이 나옴
		a.num2 = 20;
		System.out.println(a.num2);

		A a2 = new A();
		System.out.println(a2); // ch07_클래스.A@5e91993f : a와 주소만 다름
		a2.num1 = 100;
		System.out.println(a.num1); // 10
		System.out.println(a2.num1); // 100
		System.out.println(a2.num1 + a.num1); // 110
		// 입력이 없는 void
		a.test1();
		// 입력이 있는 void
		a.test2(2, 3);

		a.test3(); // num1:10, num2:20
		a2.test3(); // num1:100, num2:0
		// 위의 분리된 공간은 메모리공간이 분리되어 할당되어있기 때문에 가능한 것
	}
}
