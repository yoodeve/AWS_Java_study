package ch13_스태틱;

import ch10_배열.Array01;

public class MessageUtilMain {

	private int a;

	public static void main(String[] args) {

		MessageUtilMain meumain = new MessageUtilMain();
		System.out.println(meumain.a);

		// System.out.println(a);
		MessageUtil messageUtil = new MessageUtil();
		//
		// messageUtil.sendMail();
		// messageUtil.sendFile(); // italic 폰트 : 임마는 스태틱
		MessageUtil.sendFile(); // 클래스명 직후 .을 찍어도 실행이 가능(생성을 안했음에도)
		// 스태틱은 생성할 필요가 없다. 바로 사용 가능
		// 아래도 스태틱일걸..
		System.out.println("스태틱이라서 바로 호출이 가능");
		MessageUtil.data = "hi";
		System.out.println(MessageUtil.data);

		// 아래도 가능한데, 이유는 static이 양방향으로 데이터를 공유하는 특성을 가졌기 때문(싱글톤)
		// 스태틱:정적
		System.out.println(messageUtil.data);

		Array01.main(null); // static이라서 바로 호출 가능

	}

}
