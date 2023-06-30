package ch17_추상;

import lombok.ToString;

// super까지 콜 하기 위함
@ToString(callSuper = true)
public class Pad extends SmartDevice {

	private boolean availabilityPen;

	public Pad(String deviceName, double displaySize, boolean availabilityPen) {
		super(deviceName, displaySize);
		this.availabilityPen = availabilityPen;
	}

	// phone에서 오버라이드 한 것 또 오버라이드
	@Override
	public void connectedWifi() {
		System.out.println("패드의 와이파이를 연결합니다");
	}
}
