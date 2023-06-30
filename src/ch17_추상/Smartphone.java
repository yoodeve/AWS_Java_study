package ch17_추상;

import lombok.ToString;

@ToString(callSuper = true)
public class Smartphone extends SmartDevice implements Button {

	private String phoneNumber;

	public Smartphone(String deviceName, double displaySize, String phoneNumber) {
		super(deviceName, displaySize);
		this.phoneNumber = phoneNumber;
	}

	@Override
	public void connectedWifi() {
		System.out.println("스마트폰의 와이파이를 연결합니다");
	}

}
