package ch22_익명클래스;

public class LambdaTest {
	public static void main(String[] args) {
		// 자바식 화살표 함수 : 인터페이스 내에 1개의 추상메소드만 존재해야함.
		// 유일한 추상메소드는 내가 구현하고자 하는 메소드로 작성함
		// 그러나 default로 접근지정자 지정 시 다른 그냥 (추상ㄴㄴ)메소드를 만들 수 있음
		// 화살표함수와 함께 자료형(which contains method)과 변수명이 함께 선언되어야함
		// 람다식 : 매개변수의 자료형 생략 가능
		GrantedAuthorities authorities = () -> {
			System.out.println("권한 출력");
			return "role_user";
		};
		// granted어쩌구 인터페이스에 하나의 함수만 담아져있기에
		// 따로 명시하지 않아도 그 함수인 것을 명시가능함
		authorities.getAuthority();
		System.out.println(authorities.getAuthority());
	}
}
