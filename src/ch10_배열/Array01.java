package ch10_배열;

public class Array01 {

	public static void main(String[] args) {
		// new: 동적할당, 생성
		// 변수명 앞에 자료형:int[]:int로 이루어진 배열 자료형

		// 아래 선언방식 : 공간이 5개다. (1)
		int[] numbers = new int[5];

		System.out.println(numbers); // [I@3d012ddd 정수자료형 5개를 하나로 묶어서 여기에 두겠다.[(배열의 주소라는 명시)
		System.out.println(numbers[0]); // 0: 아무런값도 아직 넣지 않았기 때문
		System.out.println(numbers[1]); // 0: 아무런값도 아직 넣지 않았기 때문
		numbers[0] = 10;
		numbers[1] = 20;
		numbers[2] = 30;
		numbers[3] = 40;
		numbers[4] = 50;

		int index = 0;

		System.out.println(numbers[index]); // 10
		System.out.println(numbers[index + 1]); // 20
		System.out.println(numbers[index + 1 + 1]); // 30

		// 배열은 반복문과 세트 => length속성 꼭 활용하기~ length: 메모리상 배열의 공간의 갯수, 미만'<' 활용하는 것 버릇두기
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " "); // 10 20 30 40 50
		}

		// 배열의 선언 형태
		// 2. 배열이 내가 지정한 갯수만큼 만들어짐. 한번 생성 시 배열의 길이는 바꿀 수 없음 {}안:배열값
		// but 앞의 선언 없이 허공에 {1,2,3,4,5}는 배열이 아님
		// 아래배열방식의 경우 100개 요소가 있다면, 길이를 못바꾸니 1의 방식이 편함.
		int[] numbers2 = { 1, 2, 3, 4, 5 };
		// 3, 초기화 갯수만큼 배열의 길이가 지정됨.
		int[] numbers3 = new int[] { 6, 7, 8, 9, 10 };
		// 아래 에러
		// sum(numbers);
		sum(new int[] { 6, 7, 8, 9, 10 });
	}

	public static void sum(int[] array) {
		int result = 0;
		for (int i = 0; i < array.length; i++) {
			result += array[i];
		}
		System.out.println("\n" + result);
	}

}
