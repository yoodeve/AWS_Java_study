package ch14_싱글톤;

public class FactoryMain {
	public static void main(String[] args) {
		// 싱글톤 작성 후 에러코드, 생성자가 private이기 때문
		// Samsung samsung = new Samsung();
		Samsung samsung = Samsung.getInstance();
		System.out.println(samsung.getCompanyName());

		SamsungFactory factory1 = new SamsungFactory();
		SamsungFactory factory2 = new SamsungFactory();

		// factory1.produce("갤럭시s1") 까지가 Galaxy객체
		factory1.produce("갤럭시s1").showInfo();
		factory2.produce("갤럭시s2").showInfo();
		factory1.produce("갤럭시s3").showInfo();
	}
}
