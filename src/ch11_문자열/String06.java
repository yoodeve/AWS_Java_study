package ch11_문자열;

public class String06 {
	public static void main(String[] args) {
		// JWT
		String token = "Bearer aaaaaaabbbbb.ccccc.ffee";
		// bearer 토큰 확인
		boolean flag = token.startsWith("Bearer");
		// 확장자 확인 등에서
		boolean flag2 = token.endsWith("Bearer");

		System.out.println(flag + "/" + flag2);

		String url = "/api/v1/user/1";
		boolean flagUrlStarts = url.startsWith("/");
		boolean flagUrlEnds = url.endsWith("/");
		if (flagUrlStarts) {

			System.out.println(flagUrlStarts);
		} else {
			System.out.println(flagUrlEnds);
		}
	}
}
