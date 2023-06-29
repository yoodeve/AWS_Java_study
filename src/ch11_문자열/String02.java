package ch11_문자열;

public class String02 {
	public static void main(String[] args) {
		String phone = "010-6758-1457";
		// phone. 하면 내장함수가 뜨는데, 이는 Stirng이 참조변수, 즉 클래스이기 때문
		int idx = phone.indexOf("14"); // 9 => concat(자르기)에서 활용 가능
		int index = phone.indexOf("-"); // 9 => concat(자르기)에서 활용 가능
		System.out.println(index);

		int lastHypenIndex = phone.lastIndexOf("-"); // 하이픈 여러개일때 : 한번자르고 나머지에서 찾아서 또 자르고...반복
		String midNum = phone.substring(index + 1, lastHypenIndex);
		System.out.println(midNum);

		System.out.println(lastHypenIndex);

		boolean flag = phone.contains("2");
		System.out.println(flag);

	}
}
