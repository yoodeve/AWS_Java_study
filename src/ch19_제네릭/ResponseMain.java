package ch19_제네릭;

public class ResponseMain {
	public static void main(String[] args) {
		// Response(statusCode=200, data=회원가입 성공!)
		Response<String> res1 = new Response(200, "회원가입 성공!");
//		System.out.println(res1);
		SignUpUser signUpUser = SignUpUser.builder().username("한유정").password("1234").name("yoo").email("gmai@com")
				.build();

		// Response(statusCode=400, data=SignUpUser(username=한유정, password=1234,
		Response<SignUpUser> res2 = new Response<SignUpUser>(400, signUpUser);
		// name=yoo, email=gmai@com))
//		System.out.println(res2);

		AccountUser accountUser = AccountUser.builder().username("aaa").password("1234").build();
		UpdateUser updateUser = UpdateUser.builder().username("yoo").password("1234").address("부산시 남구").build();
		// ? : 와일드카드, 제네릭자리에 ? 있을 시 뒤에 들어오는 제네릭자리의 뭐든지가 될 수 있음.
		Response<AccountUser> res3 = new Response<AccountUser>(200, accountUser);
		Response<UpdateUser> res4 = new Response<UpdateUser>(400, updateUser);

//		res3 = res2;
		printResponse(res2);
		printResponse(res4);
	}

	// Response<String> 작성 시 res1(string으로 타입된 객체)만이 들어갈 수 있음\
	// extends AccountUser : extends 어카운트유저한애들을 와일드카드 내에 받겠다
	// Response<? super SignUpUser> : signup 밑, 옆은 안되고 오직 SU과 SU의 부모는 받겠다.(형제관계는 x)
	public static Response<?> printResponse(Response<? extends AccountUser> res) {
		System.out.println(res);
		return res;
	}
	// 와일드카드에 제약도 줄 수 있음

}
