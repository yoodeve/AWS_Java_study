package ch15_오브젝트;

public class KoreaStudent {
	private String studentCode;
	private String name;

	public KoreaStudent(String studentCode, String name) {
		super();
		this.studentCode = studentCode;
		this.name = name;
	}

	// equals는 Object라는 최상위클래스안의 메소드인데, 이를 덮어씀
	@Override
	public boolean equals(Object obj) {
		// equals : 주소비교
		KoreaStudent koreaStudent = (KoreaStudent) obj;
		boolean equalsFlag = this.studentCode == koreaStudent.studentCode && this.name == koreaStudent.name;

		// return obj하면 false인데(주소비교라서) return equalsFlag쓰면 값비교라서 true가 나올것.
		return equalsFlag;
	}

	public void showInfo() {
		System.out.println("학번: " + studentCode);
		System.out.println("이름: " + name);
		System.out.println("=======================");
	}

	public String getStudentCode() {
		return studentCode;
	}

	public String getName() {
		return name;
	}

}
