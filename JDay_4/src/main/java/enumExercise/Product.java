package enumExercise;

public class Product {
	private final String name;
	private final Color color;
	private final Size size;
	private final double price;
	
	public Product(String name, Color color, Size size, double price){
		this.name = name;
		this.color = color;
		this.size = size;
		this.price = price;
	}

	public Color getColor() {
		return color;
	}

	public Size getSize() {
		return size;
	}

	public double getPrice() {
		return price;
	}
	
}
