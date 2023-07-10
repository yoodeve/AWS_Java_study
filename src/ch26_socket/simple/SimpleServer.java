package ch26_socket.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(8000);
			Socket socket = serverSocket.accept();

			Thread thread = new Thread(() -> {
				while (true) {
					System.out.println("waiting");
					BufferedReader bufferedReader;
					try {
						// InputStreamReader : 바이트 단위로 읽어 들이는 InputStream을 통해 입력을 받은 뒤,
						// 문자 단위로 데이터를 변환시키는 중개자 역할을 하는 클래스
						InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
						bufferedReader = new BufferedReader(inputStreamReader);
						System.out.println(bufferedReader.readLine());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});

			thread.start();

		} catch (IOException e) {
		}
	}
}
