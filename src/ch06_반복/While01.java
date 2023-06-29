package ch06_반복;

import java.util.Scanner;

public class While01 {
	public static void main(String[] args) {

//		while() {
//		}

		// for와 while의 사용목적은 동일함
		// 그러나 for의 사용량이 더 많음
		// index가 있는 경우, index에 포커스다, i가 증가한다,,? => for
		// 반복문이지만 초점이 좀 더 조건에 의한다 => while
		// switch, for, while에 break필요..

		Scanner scanner = new Scanner(System.in);
		int selectedNumber = 0;
		boolean flag = true;

		while (flag) {
			System.out.println("[메뉴]");
			System.out.println("1.1번");
			System.out.println("2.2번");
			System.out.println("3.3번");
			System.out.println("4.4번");
			System.out.println("5.종료");
			// 무한루프 안타는 이유: 스캐너 입력을 기다리는 코드(다음라인)가 존재하기 때문
			selectedNumber = scanner.nextInt();
			if (selectedNumber == 5) {
				flag = false;
			} else if (selectedNumber == 1) {
				char selectedMenu;
				boolean flag2 = true;
				while (flag2) {
					System.out.println("[1번 메뉴 안쪽]");
					System.out.println("a a메뉴");
					System.out.println("b b메뉴");
					System.out.println("c.뒤로가기");
					System.out.println("d. 종료");
					System.out.println("메뉴 선택 : ");
					selectedMenu = scanner.next().charAt(0);
					if (selectedMenu == 'c') {
						flag2 = false;
					}
				}
			}
		}
		System.out.println("프로그램 종료");
	}
}
