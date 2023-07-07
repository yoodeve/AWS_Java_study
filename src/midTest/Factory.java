package test;

public class Factory {
	private static Factory instance;

	private String FactoryName;

	private Factory() {
		FactoryName = null;
	}

	public static Factory getFactoryInstance() {
		if (instance == null) {
			instance = new Factory();
		}
		return instance;
	}
}
