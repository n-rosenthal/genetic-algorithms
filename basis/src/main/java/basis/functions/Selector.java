package basis.functions;

import basis.primitives.Population;
import basis.primitives.Individual;
import java.util.List;
import java.util.ArrayList;

public class Selector implements SelectionOperator {
	/**
	 * Selects the individuals of the population that have a fitness greater or
	 * equal to the given fitness.
	 * 
	 * @param population the population to select from
	 * @param fitness    the fitness threshold
	 * @return the population of selected individuals
	 */
	@Override
	public Population select(Population population, double fitness) {
		List<Individual> newPopulation = new ArrayList<Individual>();
		
		for (Individual individual : population.getIndividuals()) {
			if(individual.getFitness() >= fitness) {
				newPopulation.add(individual);
			};
		};
		
		return new Population(newPopulation);
	};

	/**
	 * Selects the individuals of the population that have a fitness greater or equal to the given fitness.
	 * 
	 * @param population the population to select from
	 * @param fitness the fitness threshold
	 * @param n the number of individuals to select
	 * @return the population of selected individuals
     */
	@Override
	public Population select(Population population, double fitness, int n) {
		int counter = 0;
		List<Individual> newPopulation = new ArrayList<Individual>();
		
		//	Sorts the population by fitness
		population.sort();
		
		for (Individual individual : population.getIndividuals()) {
			if (individual.getFitness() >= fitness && counter < n) {
				newPopulation.add(individual);
				counter++;
			};
		};
		
		return new Population(newPopulation);
	};
}
