package ch17_추상;

public interface Button {
	// static 상수(italic, bold)
	public static final int buttonCount = 4;

	public void powerOn();

	public void powerOff();

	public void voulumeUp();

	public void volumeDown();
}
