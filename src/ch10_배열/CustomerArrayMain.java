package ch10_배열;

public class CustomerArrayMain {
	public static void main(String[] args) {
		Customer customer1 = new Customer("한유정", "GOLD"); // 커스터머 인스턴스 1개
		Customer customer2 = new Customer("홍길동", "SILVER");
		Customer customer3 = new Customer("김영희", "VIP");

		// 고객정보를 1000번 출력해야한다면 1000번 적을건지? => 반복문 결합
		customer1.showInfo(); // 고객명 : 한유정 / 등급 : GOLD
		customer2.showInfo(); // 고객명 : 홍길동 / 등급 : SILVER
		customer3.showInfo(); // 고객명 : 김영희 / 등급 : VIP

		System.out.println("========");
		// 개선코드////////////////////////////////////////////////////////////////////
		Customer[] customers = new Customer[10]; // 고객 10명읠 담을 수 있는 배열(customer10명을 만든 것은 아님)

		customers[1] = new Customer("한유정", "GOLD");
		customers[2] = new Customer("홍길동", "SILVER");
		customers[3] = new Customer("김영희", "VIP");

		for (int i = 0; i < customers.length; i++) {
			// System.out.println(customers[i]); // null 10개 반복출력됨 => null : 주소의 가장 첫번째,
			// 아무것도 없는 주소 -> 비어있는 주소
			if (customers[i] == null) {
				continue;
			}
			customers[i].showInfo(); // NullPointerException => 왜떠요? 10개의 공간에 3~부터의 인덱스에 암것도 없어서.
		}

	}
}
