package basis.functions;

import basis.primitives.Population;
import basis.primitives.Individual;


import java.util.List;
import java.util.ArrayList;
import basis.primitives.*;

/**
 * A {@code DeathOperator} is an operator over {@code Individual}s that removes some of them from a {@code Population} if they do not meet a certain condition.
 */
public class DeathOperator {
	public static Population kill(Population population, double probability){
		List<Individual> individuals = population.getIndividuals();
		List<Individual> survivors = new ArrayList<Individual>();
		for (Individual individual : individuals) {
			double chance = Math.random();
			
			System.out.println(chance);
			
			if (chance > probability) {
				survivors.add(individual);
			}
		}
		return new Population(survivors);
	};
	
	
	/**
	 * Kills the n worst individuals in the population with a given probability.
	 * 
	 * @param population
	 * @param probability
	 * @param n
	 * @return
	 */
	public static Population kill(Population population, double probability, int n) {
		population.sort();
		
		List<Individual> individuals = population.getIndividuals();
		List<Individual> survivors = new ArrayList<Individual>();
		for (int i = 0; i < n; i++) {
			if (Math.random() > probability) {
				survivors.add(individuals.get(i));
			}
		}
		return new Population(survivors);
	};
}
