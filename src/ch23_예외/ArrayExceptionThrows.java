package ch23_예외;

public class ArrayExceptionThrows {

	public static void main(String[] args) {
		Integer[] nums = new Integer[] { 1, 2, 3, 4, 5 };
		// printArray(nums); : 바로 에러남(컴파일에러로 남)
		try {
			printArray(nums);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("프로그램 정상 종료!");
	}

	// throws: 예외처리를 반드시 해야하는 메소드, 예외처리가 꼭 일어날거니깐
	public static void printArray(Integer[] numArray) throws Exception {

		// try {
		//
		// for (int i = 0; i < numArray.length + 1; i++) {
		// System.out.println(numArray[i]);
		// }
		// } catch (Exception e) {
		// System.out.println("예외처리됨");
		// }

		// throws 메소드가 되면 아래에서 예외처리를 하기 보단
		// 메소드 사용부에서 예외처리를 하게끔 미룸
		if (true) {
			// throw: 강제로 예외를 생성(조건 맞으면 아래 포문은 실행되지 않을것)
			throw new RuntimeException("강제로 생성된 예외");

		}
		for (int i = 0; i < numArray.length + 1; i++) {
			System.out.println(numArray[i]);
		}
	}

}
