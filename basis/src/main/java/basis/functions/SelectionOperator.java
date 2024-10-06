package basis.functions;

import basis.primitives.Population;
import basis.primitives.Individual;

/**
 * A {@link SelectionOperator} is responsible for selecting individuals from a {@link Population} based on their fitness.
 * A {@link SelectionOperator} receives a {@link Population} and a fitness value, and returns a new {@link Population} with the selected individuals.
 */
public interface SelectionOperator {
	/**
	 * Selects individuals from the given {@link Population} based on their fitness.
	 * 
	 * @param population the population to select individuals from
	 * @param fitness    the fitness value
	 * @return a new {@link Population} with the selected individuals
	 */
	public Population select(Population population, double fitness);
	
	/**
	 * Selects up to {@code n} individuals from the given {@link Population} based on their fitness.
	 * 
	 * @param population
	 * @param fitness
	 * @param n
	 * @returns population
	 */
	public Population select(Population population, double fitness, int n);
}
