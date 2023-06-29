package ch06_반복;

public class For02 {
	public static void main(String[] args) {
		// 지역변수와 전역변수
		// 변수명

		int num = 10;
		System.out.println(num);
		num = 20; // int num = 20(x), 재선언은 불가

		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}
		// i가 두개가 되네..?지역이 달라서(박스가 달라서)
		// 글로벌변수로 int i = 10; 가 있었다면 i는 빨간줄이 떴을 것
		// 근데 또 int i;만 있었으면 되긴 함..(안씀)
		// 메모리 구조상, 스택메모리라는 것이 있는데, 쌓는 것임
		// 명령을 하나씩 쌓으면 하나씩 꺼내서 씀(FILO?)
		// 꺼내서 쓰면 메모리에서 제거됨. 지역변수는 위에 쌓이고 먼저 꺼내짐
		// 지역변수를 글로벌 스택에서 꺼내면 글로벌스택에서 지역만의 스택이 나오는 것임

		// 수업 듣는동안 하란대로 안하면 대구리 아픔.. 하란대로 하시오..
		// 1. 초기화는 0으로 해주세요
		// 2. i를 1씩 증가시켜주세요
		// 3. 조건식은 <= 을 지양하세요('<'를 쓰세요)(ex).substring(0,3)하면 0~2가 찍힘

		// i를 2로 주고싶으면 차라리 println(i+3)

		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}
	}
}
