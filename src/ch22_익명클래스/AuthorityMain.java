package ch22_익명클래스;

public class AuthorityMain {
	public static void main(String[] args) {
		// 아래와 같이 클래스에 종속되어있는 객체가 아님.
		// 상속을 통해 만든 게 아니라 직접 바로 이름없이 구현
		// 일회용품으로 비유 가능
		// 일회용품은 재사용을 안함!
		// 굳이 한번쓰고 말거를 클래스 만들 필요가 없으니까 익명클래스로 구현하는것임
		// 인터페이스는 상속받으나 따로 생성하지 않음, 나중에 가비지컬렉터 수거대상
		GrantedAuthorities authorities = new GrantedAuthorities() {
			@Override
			public String getAuthority() {
				System.out.println("권한");
				return "role_user";
			}
		};
		A a = new A();
		System.out.println(a.getAuthority());
		System.out.println(authorities.getAuthority());
	}
}

// 위 익명클래스와 동일
class A implements GrantedAuthorities {
	@Override
	public String getAuthority() {
		System.out.println("권한2");
		return "role_admin";
	}
}

// 람다 : 이 익명클래스에서 출발