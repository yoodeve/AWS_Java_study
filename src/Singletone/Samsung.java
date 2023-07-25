package Singletone;

public class Samsung {
	private int a = 10;
	private Samsung instance;

	private Samsung() {

	}

	public static Samsung getInstance() {
		if (instance == null) {
			instance = new Samsung();
		}
		return instance;
	}

	public int Samsung1() {
		return a;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

}
