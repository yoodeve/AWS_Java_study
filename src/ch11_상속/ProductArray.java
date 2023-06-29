package ch11_상속;

public class ProductArray {
	public static void main(String[] args) {
		Product[] products = new Product[5];

		// 업캐스팅
		products[0] = new Computers("샘숭", 1000, "데스크탑");
		// 프로덕트 객체
		products[2] = new Computers("애플", 1000);
		products[4] = new Computers("LG", 1000, "그램");

		products[1] = new Clothes("티셔츠", 80, "S", "black");
		products[3] = new Clothes("청바지", 100, "L", "purple");

		for (int i = 0; i < products.length; i++) {
			System.out.println("모델명:" + products[i].getModel());
			System.out.println("모델명:" + products[i].getPrice());
			if (i != products.length - 1) {
				System.out.println("---------------------");
			}
		}

	}
}
