package ch26_socket.simpleGUI.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SimpleGUIServer {
	public static List<ConnectedSocket> connectedSocketList = new ArrayList<>();

	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(8000);
			System.out.println("[[서버실행  ==> ]]");
			while (true) {
				// 서버소켓 객체 생성
				Socket socket = serverSocket.accept();
				ConnectedSocket connectedSocket = new ConnectedSocket(socket);
				connectedSocket.start(); // 스레드 실행
				connectedSocketList.add(connectedSocket);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
