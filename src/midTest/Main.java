package test;

public class Main {
	public static void main(String[] args) {
		Order order = Order.builder().orderId(100).productName("삼성갤럭시북2프로").consumerName("홍길동").price(1450000).stock(2)
				.build();
		order.showOrderInfo();
	}
}
