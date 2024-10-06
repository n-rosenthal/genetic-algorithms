package basis.experiments.Experiment_1;

import basis.functions.CrossoverOperator;
import basis.primitives.Population;
import basis.primitives.Individual;
import basis.primitives.Chromosome;

import java.util.List;
import java.util.ArrayList;

import java.util.Random;

/**
 * The {@code CrossoverFunction} is a implementation of the {@link CrossoverOperator} interface.
 * Does one-point crossover at a random point in the chromosome.
 */
public class CrossoverFunction implements CrossoverOperator {
	/**
	 * Generates new individuals by combining the genes of two parent individuals.
	 * 
	 * @param parent1 the first parent individual
	 * @param parent2 the second parent individual
	 * @return the new individual
	 */
	@Override
	public Individual crossover(Individual parent1, Individual parent2) {
		if (parent1.getChromosome().getGenes().length != parent2.getChromosome().getGenes().length) {
			throw new IllegalArgumentException("The chromosomes of the parents must have the same length.");
		};
		
		//	Random number generator
		Random random = new Random();
		
		//	Random crossover point
		int crossoverPoint = random.nextInt(parent1.getChromosome().getGenes().length);
		
		
		//	New chromosome
		Chromosome newChromosome = new Chromosome(parent1.getChromosome().getGenes().length);
		
		//	Combines the genes of the parents
		for (int i = 0; i < parent1.getChromosome().getGenes().length; i++) {
			if (i < crossoverPoint) {
				newChromosome.setGene(i, parent1.getChromosome().getGene(i));
			} else {
				newChromosome.setGene(i, parent2.getChromosome().getGene(i));
			};
		};
		
		return new Individual(newChromosome);
	}

	/**
	 * Generates new individuals by combining the genes of two parent individuals.
	 * 
	 * @param parent1     the first parent individual
	 * @param parent2     the second parent individual
	 * @param probability the crossover probability
	 * @return the new individual
	 */
	@Override
	public Individual crossover(Individual parent1, Individual parent2, double probability) {
		if (Math.random() < probability) {
			return crossover(parent1, parent2);
		} else {
			return parent1;
		}
	}

	/**
	 * Generates new individuals by combining the genes of two parent individuals.
	 * 
	 * @param parent1     the first parent individual
	 * @param parent2     the second parent individual
	 * @param probability the crossover probability
	 * @param n           the number of individuals to generate
	 * @return the new population
	 */
	@Override
	public Population crossover(Individual parent1, Individual parent2, double probability, int n) {
		List<Individual> newPopulation = new ArrayList<Individual>();
		
		for (int i = 0; i < n; i++) {
			newPopulation.add(crossover(parent1, parent2, probability));
		};
		
		return new Population(newPopulation);
	}
}
