package ch11_문자열;

public class StringBuilder01 {
	public static void main(String[] args) {
		String str = "abc";
		str = str + "def";
		System.out.println(str);

		// StringBuilder, StringBuffer(싱글스레드/멀티스레드의 차이, buffer사용성 높음
		StringBuilder builder = new StringBuilder();
		// 불가 String srt = builder;
		builder.append("이름: ");
		builder.append("한유정");
		builder.delete(builder.indexOf(":"), builder.indexOf(":") + 1);
		builder.insert(builder.indexOf("한"), ":");
		String srt = builder.toString();
		System.out.println(srt);

		String name = "이름: 한유정";
		// == builder.delete(builder.indexOf(":"), builder.indexOf(":") + 1);
		String string = name.substring(0, name.indexOf(":")).concat(name.substring(name.indexOf(":") + 1));
		System.out.println(string);
	}
}
