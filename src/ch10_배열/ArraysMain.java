package ch10_배열;

import java.util.Arrays;

public class ArraysMain {
	public static void main(String[] args) {
		// Arrays.하면 배열의 기능이 다 사용 가능..내장함수일까
		int[] numbers = new int[] { 10, 4, 8, 3, 9, 7, 1 };

		for (int i = 0; i < numbers.length; i++) {
			if (i == numbers.length - 1) {
				System.out.println("");
			} else {
				System.out.print(numbers[i] + ",");
			}
		}

		System.out.println();

		Arrays.sort(numbers); // 정렬

		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + ",");
			if (i == numbers.length - 1) {
				System.out.println(" ");
			}
		}
	}
}
