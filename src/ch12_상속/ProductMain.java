package ch12_상속;

public class ProductMain {
	public static void main(String[] args) {
		Computers computers = new Computers("apple", 1000, "macbook");
		Clothes clothes = new Clothes("t-shirt", 8000, "L", "pink");

		System.out.println(computers.getModel()); // apple
		System.out.println(clothes.getColor()); // pink

		Product product = computers;
		// product.하면 getModel, getPrice는 뜨지만 getType, getSize등은 안뜸.
		System.out.println(product.getModel());
		System.out.println(computers.getType());
	}
}
