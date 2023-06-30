package ch14_싱글톤;

import java.time.LocalDate;

public class Samsung {
	// 이렇게 하면 외부에서 삼성객체를 생성할 수 없고
	private static Samsung instance;

	private String companyName;
	private int autoIncrementSerialNumber = LocalDate.now().getYear() * 10000;

	private Samsung() {
		companyName = "Samsung";
	}

	// 이 public 메소드를 호출해야만이 삼성객체를 생성가능(Samsung은 static이라 바로접근 가능)
	public static Samsung getInstance() {
		if (instance == null) {
			instance = new Samsung();
		}
		return instance;
	}

	public String getCompanyName() {
		return companyName;
	}

	public int getAutoIncrementSerialNumber() {
		return autoIncrementSerialNumber;
	}

	public void setAutoIncrementSerialNumber(int autoIncrementSerialNumber) {
		this.autoIncrementSerialNumber = autoIncrementSerialNumber;
	}

}
