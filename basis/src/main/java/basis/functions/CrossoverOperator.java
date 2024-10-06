package basis.functions;

import basis.primitives.Population;
import basis.primitives.Individual;

/**
 * A {@link CrossoverOperator} is responsible for generating new individuals by combining the genes of two parent individuals.
 */
public interface CrossoverOperator {
	/**
	 * Generates new individuals by combining the genes of two parent individuals.
	 * 
	 * @param parent1 the first parent individual
	 * @param parent2 the second parent individual
	 * @return the new individual
	 */
	public Individual crossover(Individual parent1, Individual parent2);
	
	/**
	 * Generates new individuals by combining the genes of two parent individuals.
	 * 
	 * @param parent1     the first parent individual
	 * @param parent2     the second parent individual
	 * @param probability the crossover probability
	 * @return the new individual
	 */
	public Individual crossover(Individual parent1, Individual parent2, double probability);
	
	/**
	 * Generates new individuals by combining the genes of two parent individuals.
	 * 
	 * @param parent1     the first parent individual
	 * @param parent2     the second parent individual
	 * @param probability the crossover probability
	 * @param n           the number of individuals to generate
	 * @return the new population
	 */
	public Population crossover(Individual parent1, Individual parent2, double probability, int n);
}
