package ch26_socket.simpleGUI.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

//json으로 주고받는 중개자

@AllArgsConstructor
@Data
public class RequestBodyDto<T> {
	// 처리내용 == resource(접속, 메세지 등..)
	private String resource;
	private T body;
}
