package ch15_오브젝트;

import java.util.Scanner;

public class ScannerString {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String username = "aaaa";
		String password = "1234";
		String inputUsername, inputPassword;

		System.out.print("아이디입력:");
		inputUsername = scanner.nextLine();
		System.out.print("비밀번호 입력:");
		inputPassword = scanner.nextLine();

		// 문자열 비교시 equals 활용이 필요(주소비교 안함..)
		if (!username.equals(inputUsername)) {
			System.out.println("아이디가 일치하지 않습니다");
			return;
		}

		if (!password.equals(inputPassword)) {
			System.out.println("비밀번호가 일치하지 않습니다");
			return;
		}

		System.out.println("로그인 성공");

	}

}
