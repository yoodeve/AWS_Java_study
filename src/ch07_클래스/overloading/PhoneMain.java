package ch07_클래스.overloading;

public class PhoneMain {
	public static void main(String[] args) {
		Phone ph1 = new Phone();
		Phone ph2 = new Phone();

		ph1.send();
		ph1.send("ㅁㄴㅇㄻㄴㅇㄹ");
		ph1.send("0105555", "ssss");

		ph2.send("ㅁㅁㅁㅁㅁ");
		ph1.send();
	}
}
