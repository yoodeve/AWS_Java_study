package ch26_socket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // final변수 무조건 넣어줘
public class ConnectedSocket extends Thread {
	private final Socket socket;

	// bufferedReader : 생성 시 매개변수 필요(리더라는 객체)
	@Override
	public void run() {
		BufferedReader bufferedReader = null;
		try {
			// 인풋스트림리더로 인풋을 읽어서 데이터 넘어오자마자 처리해서 담아
			// 문자열단위로 받아서 버퍼에 담아둠..?
			// 클라이언트의 out은 서버의 in, 클라이언트의 out은 서버의 in
			while (true) {
				bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String requestBody = bufferedReader.readLine();
				System.out.println("input data==> " + requestBody);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
