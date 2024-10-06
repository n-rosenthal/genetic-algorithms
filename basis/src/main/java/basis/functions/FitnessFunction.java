package basis.functions;

import basis.primitives.Chromosome;
import basis.primitives.Population;
import basis.primitives.Individual;

/**
 * A {@link FitnessFunction} is a function that evaluates the fitness of a {@link basis.primitives.Chromosome} or of a {@link basis.primitives.Individual};
 */
public abstract class FitnessFunction {
	/**
	 * Evaluates the fitness of a {@link basis.primitives.Chromosome}.
	 * 
	 * @param chromosome the chromosome to evaluate
	 * @return the fitness of the chromosome
	 */
	public abstract double evaluate(Chromosome chromosome);

	/**
	 * Evaluates the fitness of a {@link basis.primitives.Individual}.
	 * 
	 * @param individual the individual to evaluate
	 * @return the fitness of the individual
	 */
	public double evaluate(Individual individual) {
		return evaluate(individual.getChromosome());
	};

	/**
	 * Evaluates the fitness of a {@link basis.primitives.Population}.
	 * 
	 * @param population the population to evaluate
	 */
	public void evaluate(Population population) {
		population.getIndividuals().forEach(individual -> individual.setFitness(evaluate(individual)));
	};
}
