package ch08_생성자;

public class GetTest {
	private int testCode;
	private String name;

	public GetTest(int testCode, String name) {
		super();
		this.testCode = testCode;
		this.name = name;
	}

	public int getTestCode() {
		return testCode;
	}

	public void setTestCode(int testCode) {
		this.testCode = testCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name.length() != 0)
			this.name = name;
	}

}
