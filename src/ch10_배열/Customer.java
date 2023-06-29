package ch10_배열;

public class Customer {
	private String name;
	private String rating;

	// 생성자도 public, 타패키지에서도 접근 가능하게 하도록
	// All arguments Constructor
	public Customer(String name, String rating) {
		this.name = name;
		this.rating = rating;
	}

	public void showInfo() {
		System.out.println("고객명 : " + name);
		System.out.println("등급 : " + rating);
		System.out.println();
	}
}
