package ch24_쓰레드;

public class 분신만들기 {
	public static void main(String[] args) {
		분신 분신1 = new 분신();
		분신 분신2 = new 분신();
		분신 분신3 = new 분신();
		분신 분신4 = new 분신();

		// 쓰레드 객체에 매개변수로 runnable 넣어줌
		Thread thread1 = new Thread(() -> {
			int number = 1;
			while (true) {
				number += 1;
				System.out.println(number + "번 그림자분신술을 반복함");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Runnable runnable = () -> {
			int number = 1;
			while (true) {
				number += 1;
				System.out.println(number + "러너블 객체 반복!!");
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		Thread thread2 = new Thread(runnable);

		분신1.start(); // run실행
		분신2.start();
		분신3.start();
		분신4.start();
		// 분신스타트와 똑같은 짓을 벌임
		thread1.start();
		thread2.start();

	}
}
