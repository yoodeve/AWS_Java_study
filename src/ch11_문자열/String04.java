package ch11_문자열;

public class String04 {
	public static void main(String[] args) {
		String phone = "       010-0333.202 2      ";
		String replacedPhone = phone.replaceAll("-", "").replaceAll(" ", "").replaceAll("[.]", "");
		System.out.println(replacedPhone);
		// trin() : 앞뒤 공백 제거
		String phone2 = phone.trim();
		System.out.println(phone2);
	}
}
