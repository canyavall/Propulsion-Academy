package mimicDBExample;


import java.util.HashMap;
import java.util.Map;

import enumExercise.Color;
import enumExercise.Product;
import enumExercise.Size;

public class MapAsDatabaseDemo {

	public static void main(String[] args) {
		Map<String, Product> database = new HashMap<>();

		Product p1 = new Product("jeans", Color.BLUE, Size.L, 149.99);
		Product p2 = new Product("t-shirt", Color.RED, Size.M, 24.99);

		// Create
		database.put(p1.getName(), p1);
		database.put(p2.getName(), p2);
		System.out.println("Created: " + database);

		// Read // find by ID / find by name
		Product found = database.get("jeans");
		System.out.println("Read: " + found);

		found = database.get("shoes");
		System.out.println("Read: " + found);

		// Update
		found = database.get("jeans");
		found.setSize(Size.S);
		System.out.println("Update: " + database);

		// Delete
		database.remove("jeans");
		System.out.println("Delete: " + database);

	}
}
