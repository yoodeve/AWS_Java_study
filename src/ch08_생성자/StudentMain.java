package ch08_생성자;

public class StudentMain {

	public static void main(String[] args) {
		Student s1 = new Student("yooj", 29, "namgu");
		Student s2 = new Student("yooj"); // 가능
		/*
		 * Student s1 = new Student(); => ㅇㅔ러나는데, final 필드가 있기 때문 but 기본생성자가 있는데 왜 에러?
		 * 생성자가 기본적으로 생략이 되어있다 한들 어떠한 생성자 하나라도 오버로딩되는 순간에 생략된 noArgs생성자는 사라짐. no Args
		 * Constructor를 명시적으로 코드상으로 작성해줘야 기본 생성자 사용 가능 그러나 no가 있거나 required가 있거나 둘중하나만
		 * 사용 가능함에 주의
		 *
		 */

		System.out.println(s1.name);
		System.out.println(s1.age);
		System.out.println(s1.address);
		// s1.name = "yooj";
		// s1.age = 29;
		// s1.address = "namgu";

	}

}
