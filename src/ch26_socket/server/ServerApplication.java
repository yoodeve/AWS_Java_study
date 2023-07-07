package ch26_socket.server;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ServerApplication {
	// static으로 걸어서 이 변수들을 어디서든 쓸 수 있게(공유) => 람다식 내 사용 가능
	public static ServerSocket serverSocket;
	public static int port;

	public static void main(String[] args) {
		// 스레드 생성할수있게
		Thread connectionThread = null;

		System.out.println("[ 서버 프로그램 실행 ]");

		while (true) {
			Scanner scanner = new Scanner(System.in);
			int selectedMenu;
			System.out.println("1. 서버켜기");
			System.out.println("2. 서버끄기");
			System.out.print("선택: ");
			try {
				selectedMenu = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("숫자만 입력해주세요");
				continue;
			}

			switch (selectedMenu) {
			case 1:
				// connectionThread null이면 아래 실행(서버객체가 있느(!null)냐?)
				if (serverSocket != null) {
					System.out.println("이미 서버가 실행중입니다.");
					break;
				}
				System.out.print("서버의 포트번호를 입력하세요: ");
				try {
					// 입력된 포트번호에 서버 실행
					port = scanner.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("숫자만 입력 가능합니다");
					continue;
				}

				connectionThread = new Thread(() -> {
					try {
						serverSocket = new ServerSocket(port);

						// Thread.intterrupted : 인터럽터 = 중간에 끼어드는놈
						// 2번 눌러서 소켓 객체를 죽이면 객체 소멸이 일어나는데, 스레드를 멈춘 것은 아님
						// 스레드도 소멸시켜야 하므로 interrupt(Thread.interrupted();:인터럽트 상태값을 true로 줌)를 시킨다.
						// 그래서 false값일 때(2번을 누르지 않을 때) accept한다.
						while (!Thread.interrupted()) {
							// 연결되면 반응함(socket객체 하나가 하나의 유저, 리스트로 관리해야 여럿이서 채팅 가능)
							// 그러나 싱글스레드로 하면 채팅이 불가해서
							// 스레드로 관리해야함.(보내는쪽, 받는쪽 둘 다)
							// accept: 클라이언트 접속 대기
							Socket socket = serverSocket.accept();
							System.out.println("접속!!");
							System.out.println(socket.getInetAddress().getHostAddress());
						}
					} catch (BindException e) {
						System.out.println("이미 사용중인 포트입니다.");
					} catch (SocketException e) {
						System.out.println("서버와의 연결이 종료되었습니다.");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}, "connectionThread");

				connectionThread.start();

				break;
			case 2:
				// 1번이 선택되지 않아서 connectionThread가 null상태일 때
				if (serverSocket == null) {
					System.out.println("서버가 실행중이지 않습니다.");
					break;
				}
				try {
					serverSocket.close();
				} catch (Exception e) {
				}
				// interrupt 상태값을 true로 변경
				connectionThread.interrupt();

				try {
					// 메인이나 스레드 둘중하나가 랜덤으로 종료된다.
					// 그래서 join으로 스레드가 먼저 종료되도록 기다려준다. (join : 먼저 종료될때까지 기다려줌)
					connectionThread.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("프로그램 종료");
				return; // 프로그램을 빠져나가야하기 때문에 break; 대신 return;
			default:
				System.out.println("다시 선택 하세요");
			}
		}
	}
}
