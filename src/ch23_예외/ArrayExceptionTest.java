package ch23_예외;

public class ArrayExceptionTest {
	public static void main(String[] args) {

		Integer[] nums = new Integer[] { 10, 20, 30, 40, 50 };
		// for (int i = 0; i < nums.length; i++) {
		for (int i = 0; i < nums.length + 1; i++) {
			try {
				System.out.println("index[" + i + "]: " + nums[i]);

			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("배열의 크기를 벗어난 예외");

			} catch (NullPointerException e) {
				System.out.println("참조할 수 없는 주소 예외");

			} catch (RuntimeException e) {
				System.out.println("나머지 예외");

				// 순서가 중요, 만약 가장 위에 Exception이 있으면 아래의 예외처리코드에 잡히지 않음
			} catch (Exception e) {
				System.out.println("나머지 예외 최종");

				// 예외든 아니든 실행됨
			} finally {
				// 급 프로그램 뻗었을 때 임시저장 등의 행위를 여기다가 넣어주면 좋음
				System.out.println("모든 상황에 실행");
			}
		}

	}
}
