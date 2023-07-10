package ch26_socket.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SimpleServer {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(8000);
			List<Socket> socketList = new ArrayList<>();
			while (true) {
				Socket socket = serverSocket.accept();
				socketList.add(socket);
				// 클래스 하나 빼서 thread 상속받고 run 오버라이드 하면 됨
				// 그러나 람다로 쓸 경우 매개변수로 주고받아야하는 수고를 덜 수 있음(socket.getInputStream()) 처럼
				Thread thread = new Thread(() -> {
					Socket threadSocket = socket;
					while (true) {
						System.out.println("data waiting");
						BufferedReader bufferedReader;
						try {
							// InputStreamReader : 바이트 단위로 읽어 들이는 InputStream을 통해 입력을 받은 뒤,
							// 문자 단위로 데이터를 변환시키는 중개자 역할을 하는 클래스
							InputStreamReader inputStreamReader = new InputStreamReader(threadSocket.getInputStream());
							bufferedReader = new BufferedReader(inputStreamReader);
							String requestBody = bufferedReader.readLine();
							socketList.forEach(s -> {
								try {
									PrintWriter printWriter = new PrintWriter(s.getOutputStream(), true);
									printWriter.println("메세지내용(" + requestBody + ")");
								} catch (IOException e) {
									e.printStackTrace();
								}
							});

						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				});

				thread.start();

			}

		} catch (IOException e) {
		}
	}
}
