package ch15_오브젝트;

public class EqualsMain {

	public static void main(String[] args) {
		KoreaStudent koreaStudent1 = new KoreaStudent("20220111", "한유정");
		KoreaStudent koreaStudent2 = new KoreaStudent("20220112", "반유정");
		KoreaStudent koreaStudent3 = new KoreaStudent("20220113", "한유정");
		KoreaStudent koreaStudent4 = new KoreaStudent("20220111", "한유정");
		// 주소비교
		System.out.println(koreaStudent1 == koreaStudent4);

		// 같은학생의 조건 : 이름, 학번 같음
		// 값비교 => 매번 이렇게 줄줄 적을것이냐!
		System.out.println(koreaStudent1.getStudentCode() == koreaStudent4.getStudentCode()
				&& koreaStudent1.getName() == koreaStudent4.getName());

		System.out.println(koreaStudent1.equals(koreaStudent4)); // true
		System.out.println(koreaStudent1.equals(koreaStudent3)); // false
	}
}
