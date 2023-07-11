package ch26_socket.simpleGUI.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import ch26_socket.simpleGUI.server.dto.RequestBodyDto;
import ch26_socket.simpleGUI.server.dto.SendMessage;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConnectedSocket extends Thread {

	private final Socket socket;
	private String username;

	@Override
	public void run() {
		while (true) {
			try {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String requestBody = bufferedReader.readLine();
				requestController(requestBody);
//				SimpleGUIServer.connectedSocketList.forEach(connectedSocket -> {
//					try {
//						PrintWriter printWriter = new PrintWriter(connectedSocket.socket.getOutputStream(), true);
//						printWriter.println(requestBody);
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//				});
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void requestController(String requestBody) {
		System.out.println("컨트롤러" + requestBody);
		Gson gson = new Gson();
//		TypeToken<?> token = new TypeToken<RequestBodyDto<SendMessage>>() {
//		};
//		RequestBodyDto<?> requestBodyDto = gson.fromJson(requestBody, token.getType()); // type객체 소환, 아래줄과 동일이나 다소 더 명시적
//		RequestBodyDto<?> requestBodyDto = gson.fromJson(requestBody, RequestBodyDto.class);
		String resource = gson.fromJson(requestBody, RequestBodyDto.class).getResource();
		switch (resource) {

		case "join":
			username = (String) gson.fromJson(requestBody, RequestBodyDto.class).getBody();
			SimpleGUIServer.connectedSocketList.forEach(connectedSocket -> {
				List<String> usernameList = new ArrayList<>();
				SimpleGUIServer.connectedSocketList.forEach(con -> {
					usernameList.add(con.username);
				});
				RequestBodyDto<List<String>> updateUserListDto = new RequestBodyDto<List<String>>("updateUserList",
						usernameList);
				RequestBodyDto<String> joinMessageDto = new RequestBodyDto<String>("showMessage", username + "님 입장");
				ServerSender.getInstance().send(connectedSocket.socket, updateUserListDto);
				try {
					// 스레드가 너무 동시에 보내져서 꼬이지 않게 슬립 0.1초
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				ServerSender.getInstance().send(connectedSocket.socket, joinMessageDto);
			});

			break;

		case "sendMessage":
			TypeToken<RequestBodyDto<SendMessage>> typeToken = new TypeToken<>() {
			};
			RequestBodyDto<SendMessage> requestBodyDto = gson.fromJson(requestBody, typeToken.getType());
			SendMessage sendMessage = requestBodyDto.getBody();

			SimpleGUIServer.connectedSocketList.forEach(connectedSocket -> {
				RequestBodyDto<String> dto = new RequestBodyDto<String>("showMessage",
						sendMessage.getFromUsername() + " : " + sendMessage.getMessageBody());
				ServerSender.getInstance().send(connectedSocket.socket, dto);

			});
			break;

		}
	}
}
