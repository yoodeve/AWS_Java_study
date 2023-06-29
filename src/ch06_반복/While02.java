package ch06_반복;

public class While02 {
	public static void main(String[] args) {
		// 이 경우 i라는 변수네임을 낭비하게됨
		// continue
		int i = 0;

		while (i < 10) {
			if (i % 2 == 0) {
				// 컨티뉴 의미 : 다음반복으로 넘어가라 => 다음 조건으로 넘어가라, i++ 해라
				// 실행문을 컨티뉴 위에
				i++;
				continue;
			}
			System.out.println(i);
			// 다음 조건으로 넘어가기 위해 증가 필요
			i++;
		}
	}
}
