package midTest;

public class Order {
	private int orderId;
	private String productName;
	private String consumerName;
	private int price;
	private int stock;

	public Order(int orderId, String productName, String consumerName, int price, int stock) {
		this.orderId = orderId;
		this.productName = productName;
		this.consumerName = consumerName;
		this.price = price;
		this.stock = stock;
	}

	public static OrderBuilder builder() {
		return new OrderBuilder();
	}

	public void showOrderInfo() {
		System.out.println("주문번호:" + orderId + "\n상품명: " + productName + "\n구매자: " + consumerName + "\n가격: " + price
				+ "\n수량: " + stock);
	}

}
