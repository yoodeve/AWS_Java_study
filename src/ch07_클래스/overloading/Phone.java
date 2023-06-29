package ch07_클래스.overloading;

public class Phone {

	public void send() {
		System.out.println("전송 no args");
	}

	public void send(String message) {
		System.out.println("전송됨2 " + message);
	}

	public void send(String number, String message) {
		System.out.println(number + " 에게로 " + message + " 전송");
	}
}
