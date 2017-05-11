package ex3;
import static java.lang.Math.PI;

public class Circle extends AbstractShape {

	private final double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	public final double getRadius() {
		return this.radius;
	}

	@Override
	public final double getArea() {
		return PI * this.radius * this.radius;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(this.radius);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Circle other = (Circle) obj;
		if (Double.doubleToLongBits(this.radius) != Double.doubleToLongBits(other.radius)) {
			return false;
		}
		return true;
	}

}