package ch12_상속;

public class Computers extends Product {
	private String type;

//	public Computers() {
//		super("상품", 90);
//		System.out.println("컴퓨터 객체 생성");
//	}

	public String getType() {
		return type;
	}

	// 부모만 생성
	public Computers(String model, int price) {
		// super가 부모생성자의 this를 호출(suoer 생성자 = 부모생성자, new와 역할이 동일)
		super(model, price);
		// TODO Auto-generated constructor stub
	}

	// 부모자식 모두 생성
	public Computers(String model, int price, String type) {
		super(model, price);
		this.type = type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
