package ch08_생성자;

public class ConstructorMain {
	public static void main(String[] args) {
		Constructor01 constructor01 = new Constructor01(); // 하나의 인스턴스를 constructor01에 저장한 것
		// 이 자료형으로 메모리에 할당, new 이후 부분:메쏘드 호출 but 이친구의 이름은 생성자, 메모리에
		// 변수자리를 생성해주는 친구이기 때문
		// `new Constructor01();` : 메소드 호출임. 변수선언없이도 호출 가능 생성자 호출 시 메모리에 주소 할당됨 but
		// 변수없이는
		// 해당 주소에 접근 불가하므로 01이라는 변수에 주소를 저장한 것
		// 메소드 호출 한걸 construecor01에 저장한것, 그러나 리턴값이 없는데.. 오로지 내가 생성한 메모리의 주소만 리턴함.
		System.out.println(constructor01); // ch08_생성자.Constructor01@626b2d4a === 주소값

	}
}
