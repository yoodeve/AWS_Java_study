package midTest;

public class UserMain {

	public static void main(String[] args) {
		User user = new User();
		user.setUsername("junil");
		user.setPassword("1234");
		user.setName("김준일");
		user.setEmail("junil@gmail.com");

//		System.out.println("[사용자 정보]");
//		System.out.println("username : " + user.getUsername());
//		System.out.println("password : " + user.getPassword());
//		System.out.println("name : " + user.getName());
//		System.out.println("email : " + user.getEmail());
		System.out.println(user);
	}

}
