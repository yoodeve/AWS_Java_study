package ch15_오브젝트;

public class SamsungPhone {
	private String model;

	public SamsungPhone(String model) {
		// 상속을 안했는데 super가 달림?
		// 타고 들어가면 Object클래스 관련 코드가 열림
		// 모든 생성자는 Object를 상속받는다(클래스 파일 생성시 지정됨)
		// extends Object는 생략되어있음
		super();
		this.model = model;
	}

}
