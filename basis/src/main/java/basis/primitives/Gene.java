package basis.primitives;

/**
 * A {@link Gene} is a variable that can be adjusted to improve a solution.
 * It is the main building block of a {@link Chromosome}.
 * 
 * A {@link Gene} is a bit associated with methods.
 */
public class Gene {
	private boolean value;

	/**
	 * Creates a new {@link Gene} with the given value.
	 * 
	 * @param value the value of the gene
	 */
	public Gene(boolean value) {
		this.value = value;
	}

	/**
	 * Returns the value of the gene.
	 * 
	 * @return the value of the gene
	 */
	public boolean getValue() {
		return value;
	}

	/**
	 * Sets the value of the gene.
	 * 
	 * @param value the new value of the gene
	 */
	public void setValue(boolean value) {
		this.value = value;
	}

	/**
	 * Flips the value of the gene.
	 */
	public void flip() {
		value = !value;
	}
}
