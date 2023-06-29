package ch06_반복;

public class For03 {
	public static void main(String[] args) {
		// (int i = 0 1 ; i < 5 2 ; i++
//		for (int i = 0; i < 5; i++) {
//			/**
//			 * @author 선생님 풀이
//			 * i = 0
//			 * 바깥포문 조건 부합
//			 * 실행문 실행(안쪽 포문)
//			 * j = 0
//			 * ....
//			 * 0<1, 1번 반복(### 1자리는 반복 횟수)
//			 * j++이 실행, j가 1이 되어 안쪽포문 탈출
//			 * println() => 줄띄움
//			 * *ㄴ
//			 * 다시 i++로 올라가서 i가 1이됨 아래로 내려감
//			 * for문 실행, j = 0, i는 2, * 두개찍히고 j++이 되어 2<2 false, 안쪽포문 탈출
//			 * 줄띄움
//			 * i++이 됨, i는 2가 되고, 2<5니까 아래로 들어감
//			 * (반복)
//			 *  .....
//			 *  i가 5가되면 조건에 부합하지 않아 바깥포 문 탈출함(종료)
//			 * */

//			for (int j = 0; j < i + 1; j++) {

//				System.out.print("*");
//			}
//			System.out.println();
//		}

//		for (int i = 0; i < 5; i++) {
//			for (int j = 0; j < 5 - i; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}

		for (int i = 0; i < 5; i++) {
//			for (int j = 0; j < 5 - i; j++) {
			for (int j = 0; j < 5 - 1 - i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
