package enumExample;

public enum CssColor {

	RED("#FF0000"),

	GREEN("#00FF00"),

	BLUE("#0000FF");

	private final String hexidecimalValue;

	private CssColor(String hexidecimalValue) {
		this.hexidecimalValue = hexidecimalValue;
	}

	public String getHexidecimalValue() {
		return this.hexidecimalValue;
	}

	public int convertToX() {
		switch (this) {
			case BLUE:
				return 3;
			case GREEN:
				return 2;
			case RED:
				return 1;
			default:
				return 0;
		}
	}

}