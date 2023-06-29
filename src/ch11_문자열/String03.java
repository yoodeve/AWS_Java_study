package ch11_문자열;

import java.util.Arrays;

public class String03 {
	public static void main(String[] args) {
//		String[] addressArray = new String[] { "부산시 남구", "부산시 부산진구", "창원시 마산합포구", "창원시 마산회원구" };
//
//		String[] busanAddrArray = new String[0];
//		String[] elseAddrArray = new String[0];
//
//		for (int i = 0; i < addressArray.length; i++) {
//			String[] emptyArr = new String[addressArray.length + 1];
//			if (addressArray[i].contains("부산시")) {
//				for (int j = 0; j < busanAddrArray.length; j++) {
//					emptyArr[j] = addressArray[j];
//					busanAddrArray = emptyArr;
//				}
//
//			}
//		}
//		System.out.println(busanAddrArray);
		String[] addressArray = new String[] { "부산시 남구", "부산시 부산진구", "창원시 마산합포구", "창원시 마산회원구" };

		String[] busanAddrArray = new String[0];
		String[] elseAddrArray = new String[0];

		for (int i = 0; i < addressArray.length; i++) {
			String[] emptyArr = new String[busanAddrArray.length + 1];
			if (addressArray[i].contains("부산시")) {
				for (int j = 0; j < busanAddrArray.length; j++) {
					emptyArr[j] = busanAddrArray[j];
				}
				emptyArr[emptyArr.length - 1] = addressArray[i];
				busanAddrArray = emptyArr;
			}
		}
		System.out.println(Arrays.toString(busanAddrArray));
	}
}
