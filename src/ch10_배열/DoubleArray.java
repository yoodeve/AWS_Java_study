package ch10_배열;

public class DoubleArray {
	public static void main(String[] args) {
		// 이중배열 => 이중포문 필요, 간혹 쓰임
		// 앞쪽 인덱스(i)_, 뒤쪽 인덱스(j)
		String[][] students = new String[2][2];
		students[0][0] = "한유정";
		students[0][1] = "홍길동";
		students[1][0] = "부산";
		students[1][1] = "서울";
		for (int i = 0; i < students.length; i++) {
			for (int j = 0; j < students[i].length; j++) {
				System.out.println(students[i][j]);
			}
		}

	}
}
