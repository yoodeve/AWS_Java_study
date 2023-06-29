package ch13_스태틱;

public class MessageUtil {
	// 외부에서 접근 가능하도록 public으로 접근지정자 설정
	public static String data;

	public void sendMail() {
		System.out.println("메일을 전송합니다");
	}

	// 메모리상에 메소드가 존재해야 호출가능
	public static void sendFile() {
		System.out.println("파일을 전송합니다");
	}

}
