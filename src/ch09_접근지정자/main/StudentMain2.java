package ch09_접근지정자.main;

import ch09_접근지정자.Student2;

public class StudentMain2 {

	public static void main(String[] args) {
		Student2 s = new Student2();
		// 접근 : 은행(Student2) 과, 은행원(돈 보호맨들), 돈(Student fields), 손님(student main)
		// 아래코드는 직접적으로 은행에 가서 손님이 돈을 넣는것
		// private 이라서 접근 불가 그럼 private은 왜 쓰는가.. 동일클래스에서만 접근 가능함.
		// s.name = "한유정";
		// getter, setter의 접근지정자가 private일 때 아래 코드 접근 불가, 동일 패키지 내에 있는 값이 아님
		// 동일패키지 내부라도
		// protected:상속관계에서만 사용 가능
		s.setName("한유정");
		System.out.println(s.getName());
	}

}
