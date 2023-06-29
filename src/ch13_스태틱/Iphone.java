package ch13_스태틱;

public class Iphone {
	// 생성될 때 초기화 가능
	private static int autoIncrement = 1;
	private int serialNumber = 2023060;
	private String model;

	public Iphone(String model) {
		super();
		this.serialNumber += autoIncrement;
		this.model = model;
		autoIncrement++;
	}

	public void showInfo() {
		System.out.println("시리얼번호 " + serialNumber);
		System.out.println("모델명 " + model);
	}

	public static void main(String[] args) {
		Iphone[] iphones = new Iphone[5];
		for (int i = 0; i < iphones.length; i++) {
			iphones[i] = new Iphone("아이폰" + i);
		}
		for (int i = 0; i < iphones.length; i++) {
			iphones[i].showInfo();
		}
	}

}
