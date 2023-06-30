package ch15_오브젝트;

import java.util.Objects;

public class KoreaStudent {
	private String studentCode;
	private String name;

	public KoreaStudent(String studentCode, String name) {
		super();
		this.studentCode = studentCode;
		this.name = name;
	}

	// equals는 Object라는 최상위클래스안의 메소드인데, 이를 덮어씀
//	@Override
//	public boolean equals(Object obj) {
//		// equals : 주소비교
//		KoreaStudent koreaStudent = (KoreaStudent) obj;
//		boolean equalsFlag = this.studentCode.equals(koreaStudent.studentCode) && this.name.equals(koreaStudent.name);
//
//		// return obj하면 false인데(주소비교라서) return equalsFlag쓰면 값비교라서 true가 나올것.
//		return equalsFlag;
//	}

	public void showInfo() {
		System.out.println("학번: " + studentCode);
		System.out.println("이름: " + name);
		System.out.println("=======================");
	}

	// override하면 super를 잃단 호출하게 됨
	// return super.toString();

	// alt + shift + s 로도 equals 오버라이드 쉽게 가능

	@Override
	public int hashCode() {
		return Objects.hash(name, studentCode);
	}

	@Override
	public String toString() {
		// 객체안의 값을 확인할 때 사용, ctrl shift s 로 생성
		return "KoreaStudent [studentCode=" + studentCode + ", name=" + name + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		// getClass() === instanceof, 클래스타입 반환
		if (getClass() != obj.getClass())
			return false;
		KoreaStudent other = (KoreaStudent) obj;
		return Objects.equals(name, other.name) && Objects.equals(studentCode, other.studentCode);
	}

	public String getStudentCode() {
		return studentCode;
	}

	public String getName() {
		return name;
	}

}
