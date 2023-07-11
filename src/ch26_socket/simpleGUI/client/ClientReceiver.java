package ch26_socket.simpleGUI.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.google.gson.Gson;

import ch26_socket.simpleGUI.client.dto.RequestBodyDto;

public class ClientReceiver extends Thread {

	@Override
	public void run() {
		SimpleGUIClient simpleGUIClient = SimpleGUIClient.getInstance();

		while (true) {
			try {
				BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(simpleGUIClient.getSocket().getInputStream()));
				String requestBody = bufferedReader.readLine();
				requestController(requestBody);

			} catch (IOException e) {
				e.printStackTrace();
			}

		} // while 종료
	} // run 종료

	private void requestController(String requestBody) {
		Gson gson = new Gson();
		String resource = gson.fromJson(requestBody, RequestBodyDto.class).getResource();
		switch (resource) {
		case "showMessage":
			String messageContent = (String) gson.fromJson(requestBody, RequestBodyDto.class).getBody();
			SimpleGUIClient.getInstance().getTextArea().append(messageContent + "\n");
			break;
		case "updateUserList":
			List<String> usernameList = (List<String>) gson.fromJson(requestBody, RequestBodyDto.class).getBody();

			SimpleGUIClient.getInstance().getUserListModel().clear();
			SimpleGUIClient.getInstance().getUserListModel().addAll(usernameList);
			break;
		}
	}
} // 클래스 종료
