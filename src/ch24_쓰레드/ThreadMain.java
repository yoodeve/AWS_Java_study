package ch24_쓰레드;

public class ThreadMain {
	public static void main(String[] args) {

		// 스레드는 동시에 돌아서 실행순서가 바뀔 여지가 있음.
		// 람다 러너블 사용
		Thread thread1 = new Thread(() -> {
			System.out.println("스레드 이름:" + Thread.currentThread().getName());
			for (int i = 0; i < 50; i++) {
				System.out.print(Thread.currentThread().getName() + ": ");
				System.out.println(i);
				try {
					// setTimeout 같은 역할, 스레드가 돌 때 지정된 시간(ms)동안 잠시 멈춤
					// 1번스레드의 for문이 2초에 하나씩 출력됨.
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "1번");

		// 람다 러너블 사용
		Thread thread2 = new Thread(() -> {
			System.out.println("스레드 이름:" + Thread.currentThread().getName());
			for (int i = 0; i < 50; i++) {
				System.out.print(Thread.currentThread().getName() + ": ");
				System.out.println(i);
			}
		}, "2번");

		// 러너블 implements한 객체 생성
		Thread thread3 = new Thread(new ThreadTest(), "3번");
		// 익명클래스
		Thread thread4 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("스레드 이름:" + Thread.currentThread().getName());
				System.out.println("4번이 스레드 실행");
			};
		}, "4번");

		thread1.start();
//		try {
// join(); 이 끝날때까지 나머지 스레드가 기다림(비동기속에서 동기를 원할 때 : 로딩 등에서)
//			thread1.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

		thread2.start();
//		thread3.start();
//		thread4.start();
	}
}
