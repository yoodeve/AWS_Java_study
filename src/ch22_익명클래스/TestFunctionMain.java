package ch22_익명클래스;

import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class TestFunctionMain {
	public static void main(String[] args) {

		// 1-1 //////////////////////////////////////////////////////////
		// 명령문이 하나인 경우 중괄호 생략(이후 세미콜론은 하나(전체를 위한 세미콜론))
		TestFunction1 function1 = () -> System.out.println("매개변수, 리턴 둘다 x");
		// 위와 같은 코드
		// TestFunction1 function1 = () -> {
		// System.out.println("매개변수, 리턴 둘다 x");
		// };
		// 생성없이 바로 콜
		function1.test();

		// 1-2 //////////////////////////////////////////////////////////
		// 매개변수는 타입 생략 가능, 매개변수가 하나면 소괄호 생략 가능
		TestFunction2 function2 = num -> {
			System.out.println("매개변수 1, 리턴 x");
			System.out.println("num: " + num);
		};
		function2.test(2);
		function2.test(4);

		// 1-3 //////////////////////////////////////////////////////////
		// 오버라이드 시 매개변수 명 변경 가능
		// 매개변수가 하나가 아닌 경우에는 소괄호 필히 기입
		TestFunction3 function3 = (age, name) -> {
			System.out.println("매개변수 2, 리턴x");
			System.out.println("나이: " + age);
			System.out.println("이름: " + name);
		};
		function3.test(1, "한유정");

		// 1-4 //////////////////////////////////////////////////////////
		// 오버라이드 시 매개변수 명 변경 가능
		// 매개변수가 하나가 아닌 경우에는 소괄호 필히 기입
		// TestFunction4 function4 = (age, name) -> {
		// System.out.println("매개변수 2, 리턴o");
		// return "이름 " + name + " 나이 " + age;
		// };
		// 명령문이 한 줄인 경우 중괄호를 생략하고 생략한 경우 즉시 리턴값이 된다.(중괄호 생략 시 리턴 키워드도 제거)
		TestFunction4 function4 = (age, name) -> "이름 " + name + " 나이 " + age;
		String result1 = function4.test(1, "한유정");
		System.out.println(result1);

		// 2-1 //////////////////////////////////////////////////////////
		// Runnable 인터페이스 : 실행때 사용

		Runnable runnable = () -> {
			System.out.println("매개변수, 리턴x");
		};
		runnable.run();

		// 2-2-1 //////////////////////////////////////////////////////////
		// 매개변수 1
		// Consumer: 사용하는 녀석
		Consumer<String> consumerStr = name -> System.out.println(name);
		consumerStr.accept("김준일");

		// 2-2-2 //////////////////////////////////////////////////////////
		// 매개변수2
		BiConsumer<String, Integer> biConsumer = (name, age) -> {
			System.out.println(name + "," + age);
		};
		biConsumer.accept("한유정", 28);

		// 2-3-1 //////////////////////////////////////////////////////////
		// Supplier, 리턴해줌
		// 매개변수는 없으나 리턴은 있음
		Supplier<Integer> supplier = () -> 100;
		System.out.println(supplier.get());

		// 2-4 //////////////////////////////////////////////////////////
		// Functional: 리턴해줌
		// 매개변수도 리턴도 있음
		Function<Integer, String> function = year -> "생일 + " + year;
		System.out.println(function.apply(1995));

		// 2-5 //////////////////////////////////////////////////////////
		// Predicate
		// 매개변수도 리턴도 있음
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		numbers.add(6);
		numbers.add(7);
		numbers.add(8);
		numbers.add(9);
		numbers.add(10);
		System.out.println(numbers);
		// 필터함수 역할(콜백함수가 프래디컷 역할)
		numbers.removeIf(num -> num % 2 == 0);
		System.out.println(numbers);

		// 2-6 //////////////////////////////////////////////////////////
		// forEach: 반복
		// 매개변수로 컨슈머 받음(매개는 있고 리턴은 없음)
		numbers.forEach(num -> System.out.println("forEach출력:" + num));
	}
}
