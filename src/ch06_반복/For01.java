package ch06_반복;

public class For01 {

	public static void main(String[] args) {
		// 배열 : 값이 순서대로 들어가있는 것.
		// 박스안에서 요소를 꺼내려면 index를 선택하여 꺼냄
		int[] numbers = { 1, 2, 3, 4, 5, 6 };
		// @todo TIL적기
		// 초기문(1 - 한번만 실행);조건문(2);후처리문(4)
		// 실행문(3)
		// int i = 0 : 변수선언, 초기화
		// int i의 조건이 조건문에 부합하는지? => 실행문으로 감
		// 실행완료 후 후처리문에서 i가 증가를 하든 감소를 하든

		// for문 특징(초기문과 후처리문에 여러 변수를 선언 가능)
		// for (int i = 0, j = 0; i < 6; i++, j++)
		for (int i = 0; i < 6; i++) {
			System.out.println(numbers[i]);
			System.out.println("i:" + i);
		}

	}
}
