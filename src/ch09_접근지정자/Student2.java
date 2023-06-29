package ch09_접근지정자;

public class Student2 {
	private String name;
	private int age;

	private void test() {
		System.out.println("테스트 메소드 호출");
	}

	// setter, 리턴값 없음
	public void setName(String name) {
		test();
		this.name = name;
	}

	void setAge(int age) {
		this.age = age;
	}

	// getter 값을 구하기 위함
	public String getName() {
		return name;
	}

	int agetAge() {
		return age;
	}
}
