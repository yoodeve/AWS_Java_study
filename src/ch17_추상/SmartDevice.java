package ch17_추상;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public abstract class SmartDevice {
	private String deviceName;
	private double displaySize;

	// 양 자식클래스에서 오버라이드하기때문에 내용은 필요없고 껍데기만 필요함
	// 이런 껍데기가 있고 밑에서 다시 구체화(오버라이드) 할거야
	public abstract void connectedWifi();
}
