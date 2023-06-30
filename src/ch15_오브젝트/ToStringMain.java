package ch15_오브젝트;

public class ToStringMain {
	public static void main(String[] args) {
		KoreaStudent koreaStudent = new KoreaStudent("20230001", "한유정");

		// 자바는 모든 변수를 출력하면 toString(); 메소드가 호출되기에 생략가능
		System.out.println(koreaStudent);

		String str = koreaStudent.toString();
//		String str2 = koreaStudent;

	}
}
