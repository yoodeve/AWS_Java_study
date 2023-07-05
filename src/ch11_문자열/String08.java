package ch11_문자열;

public class String08 {
	public static void main(String[] args) {
		String strNumber = "1,2,3,4,5,6,7,8,9,10";

		String[] strNumbersArr = strNumber.split(",");
		for (int i = 0; i < strNumbersArr.length; i++) {
			System.out.print(strNumbersArr[i] + " ");
		}
	}
}
