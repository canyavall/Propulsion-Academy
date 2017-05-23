package enumExample;

public class EnumDemo {

	public static void main(String[] args) {
		cards();
		cssColors();
	}

	private static void cards() {
		Cardsuite suite1 = Cardsuite.CLUBS;
		Cardsuite suite2 = Cardsuite.HEARTS;
		Cardsuite suite3 = Cardsuite.CLUBS;

		System.out.println("suite 1: " + suite1);
		System.out.println("suite1.equals(suite1): " + suite1.equals(suite1));
		System.out.println("suite1.equals(suite2): " + suite1.equals(suite2));
		System.out.println("suite 1 == suite 3: " + (suite1 == suite3));
		System.out.println("is suite 1 clubs? " + (suite1 == Cardsuite.CLUBS));

		switch (suite1) {
			case DIAMONDS:
				System.out.println("Player has diamonds");
				break;

			case HEARTS:
				System.out.println("Player has hearts");
				break;

			case CLUBS:
				System.out.println("Player has clubs");
				break;

			case SPADES:
				System.out.println("Player has spades");
				break;

			default:
				System.out.println("Unknown suite: " + suite1);
				break;
		}
	}

	private static void cssColors() {
		CssColor color = CssColor.BLUE;

		System.out.println("Hex for blue: " + color.getHexidecimalValue());
		System.out.println("X for blue: " + color.convertToX());

		String userSelectedColor = "red";
		CssColor choice = CssColor.valueOf(userSelectedColor.toUpperCase());
		System.out.println("User choice: " + choice);

		for (CssColor cssColor : CssColor.values()) {
			System.out.println("CSS color name: " + cssColor.name());
		}
	}

}