package ch08_생성자;

public class GetTestMain {
	public static void main(String[] args) {
		GetTest getTest = new GetTest(1, "주유구");
		GetTest getTest2 = new GetTest(1, "");

		// System.out.println(getTest.name); // 주유구(private 설정 전)

		System.out.println(getTest.getName()); // 주유구(private 설정 후)
		System.out.println(getTest2.getName()); // 아무것도 안나옴(private 설정 후)
	}
}
