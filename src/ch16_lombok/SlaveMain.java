package ch16_lombok;

public class SlaveMain {
	public static void main(String[] args) {
		Slave slave1 = new Slave("한유정", 28);
		Slave slave2 = new Slave();

		System.out.println(slave1.getAge());
		System.out.println(slave2.equals(slave1));
	}
}
