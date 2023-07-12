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
import ch26_socket.simpleGUI.server.entity.Room;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConnectedSocket extends Thread {

	private final Socket socket;
	private String username;
	private Gson gson;

	@Override
	public void run() {
		gson = new Gson();
		while (true) {
			try {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String requestBody = bufferedReader.readLine();
				requestController(requestBody);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void requestController(String requestBody) {
		String resource = gson.fromJson(requestBody, RequestBodyDto.class).getResource();

		switch (resource) {

		case "connection":
			connection(requestBody);

			break;

		case "createRoom":
			createRoom(requestBody);

			break;

		case "join":
			join(requestBody);

			break;

		case "sendMessage":
			sendMessage(requestBody);

			break;

		}
	}

	private void connection(String requestBody) {
		username = (String) gson.fromJson(requestBody, RequestBodyDto.class).getBody();

		List<String> roomNameList = new ArrayList<>();
		SimpleGUIServer.roomList.forEach(room -> {
			roomNameList.add(room.getRoomName());
		});

		RequestBodyDto<List<String>> updateRoomListRequestBodyDto = new RequestBodyDto<List<String>>("updateRoomList",
				roomNameList);

		ServerSender.getInstance().send(socket, updateRoomListRequestBodyDto);
	}

	private void createRoom(String requestBody) {
		String roomName = (String) gson.fromJson(requestBody, RequestBodyDto.class).getBody();
		Room newRoom = Room.builder().roomName(roomName).owner(username).userList(new ArrayList<ConnectedSocket>())
				.build();
		SimpleGUIServer.roomList.add(newRoom);

		List<String> roomNameList = new ArrayList<>();
		SimpleGUIServer.roomList.forEach(room -> {
			roomNameList.add(room.getRoomName());
		});

		RequestBodyDto<List<String>> updateRoomListRequestBodyDto = new RequestBodyDto<List<String>>("updateRoomList",
				roomNameList);

		SimpleGUIServer.connectedSocketList.forEach(con -> {
			ServerSender.getInstance().send(con.socket, updateRoomListRequestBodyDto);
		});
	}

	private void join(String requestBody) {
		String roomName = (String) gson.fromJson(requestBody, RequestBodyDto.class).getBody();
		SimpleGUIServer.roomList.forEach(room -> {
			// 같은 방 찾기
			if (room.getRoomName().equals(roomName)) {
				// this는 connectedSocket
				room.getUserList().add(this);

				List<String> usernameList = new ArrayList<>();
				// 방 동접 사람들
				room.getUserList().forEach(con -> {
					usernameList.add(con.username);
				});
				// 동접사람들한테 유저리스트도 업데이트하고, 입장메세지도 띄우고
				room.getUserList().forEach(connectedSocket -> {
					RequestBodyDto<List<String>> updateUserListDto = new RequestBodyDto<List<String>>("updateUserList",
							usernameList);
					RequestBodyDto<String> joinMessageDto = new RequestBodyDto<String>("showMessage",
							username + "님 입장");
					ServerSender.getInstance().send(connectedSocket.socket, updateUserListDto);
					try {
						// 스레드가 너무 동시에 보내져서 꼬이지 않게 슬립 0.1초 해주고
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					// 메세지 보내고
					ServerSender.getInstance().send(connectedSocket.socket, joinMessageDto);
				});

			}
		});
	}

// 내가 든 방과 내가 든 방의 유저들에게 메세지를 전송
	private void sendMessage(String requestBody) {
		TypeToken<RequestBodyDto<SendMessage>> typeToken = new TypeToken<>() {
		};
		RequestBodyDto<SendMessage> requestBodyDto = gson.fromJson(requestBody, typeToken.getType());
		SendMessage sendMessage = requestBodyDto.getBody();

		SimpleGUIServer.roomList.forEach(room -> {
			if (room.getUserList().contains(this)) {
				room.getUserList().forEach(connectedSocket -> {
					RequestBodyDto<String> dto = new RequestBodyDto<String>("showMessage",
							sendMessage.getFromUsername() + " : " + sendMessage.getMessageBody());
					ServerSender.getInstance().send(connectedSocket.socket, dto);
				});
			}
		});
	}
}
