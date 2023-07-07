package test;

public class OrderBuilder {
	private int orderId;
	private String productName;
	private String consumerName;
	private int price;
	private int stock;

	public Order build() {
		return new Order(orderId, productName, consumerName, price, stock);
	}

	public OrderBuilder orderId(int orderId) {
		this.orderId = orderId;
		return this;
	}

	public OrderBuilder productName(String productName) {
		this.productName = productName;
		return this;
	}

	public OrderBuilder consumerName(String consumerName) {
		this.consumerName = consumerName;
		return this;
	}

	public OrderBuilder price(int price) {
		this.price = price;
		return this;
	}

	public OrderBuilder stock(int stock) {
		this.stock = stock;
		return this;
	}

}