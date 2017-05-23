package ex3;

abstract class AbstractShape implements Shape {

	@Override
	public final String toString() {
		return String.format("%s[area = %s]", getClass().getSimpleName(), getArea());
	}

	/**
	 * Override {@link Object#hashCode()} and redeclare it as
	 * {@code abstract} in order to force concrete subclasses
	 * to provide a reasonable implementation.
	 */
	@Override
	public abstract int hashCode();

	/**
	 * Override {@link Object#equals(Object)} and redeclare it as
	 * {@code abstract} in order to force concrete subclasses
	 * to provide a reasonable implementation.
	 */
	@Override
	public abstract boolean equals(Object obj);

}
