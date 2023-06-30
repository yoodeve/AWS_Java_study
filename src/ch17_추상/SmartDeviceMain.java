package ch17_추상;

public class SmartDeviceMain {
	public static void main(String[] args) {
		Smartphone smartphone = new Smartphone("아이폰", 6.1, "010-6758-1457");
		Pad pad = new Pad("아이패드", 11.0, false);

		// 필요없는 코드, abstract class기 때문에 생성 불가(아래)
		// SmartDevice device = new SmartDevice(null, 0);

		System.out.println(smartphone);
		System.out.println(pad);

		smartphone.connectedWifi();
		pad.connectedWifi();
	}
}
