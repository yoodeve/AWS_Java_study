package ch10_배열;

public class CustomerArrayMain2 {
	public static void main(String[] args) {
		// 반복을 통한 생성
		Customer[] customers = new Customer[10];

		for (int i = 0; i < customers.length; i++) {
			String[] ratings = new String[] { "Bronze", "Gold", "Silver", "VIP" };
			customers[i] = new Customer("한유정" + (i + 1), ratings[i % 4]);
		}
		for (int i = 0; i < customers.length; i++) {
			customers[i].showInfo();
		}
	}
}
