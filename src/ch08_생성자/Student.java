package ch08_생성자;

public class Student {
	// 학생객체는 이름, 나이, 주소를 담을 수 있는 객체
	// final이 붙을 경우 noargs생성자는 생길 수 없음
	final String name;
	int age;
	String address;

	/*
	 * Student( 여기에 args가 올 수 있음 ) { // name = ""; // this가 없는데.. 멤버변수와 일치하는 args값이
	 * 있을 때에 this를 붙임, 잘 안씀 System.out.println("NoArgsConstructor");
	 * System.out.println("학생 한 명을 생성합니다."); }
	 */

	// 매개변수를 통해 오버로딩
	Student(String name, int age, String address) {
		// 클래스 내부 전역변수(this) = 지역변수(색깔로도 구분 가능)
		System.out.println("AllArgsConstructor");
		this.name = name;
		this.age = age;
		this.address = address;

		// all arguments constructor
	}

	Student(String name) {
		// 필수생성자(꼭있어야 함)
		System.out.println("RequiredArgsConstructor");
		this.name = name;
	}

}
