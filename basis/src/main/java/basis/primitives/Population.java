package basis.primitives;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;
import java.util.stream.StreamSupport;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.IntFunction;
import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.DoubleFunction;
import java.util.function.DoubleSupplier;
import java.util.function.DoubleUnaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoublePredicate;
import java.util.function.LongFunction;
import java.util.function.LongSupplier;
import java.util.function.LongUnaryOperator;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongPredicate;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ObjLongConsumer;
import java.util.function.ToIntFunction;
import java.util.function.ToDoubleFunction;
import java.util.function.ToLongFunction;
import java.util.function.ToIntBiFunction;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToLongBiFunction;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.LongToIntFunction;
import java.util.function.LongToDoubleFunction;


import basis.functions.FitnessFunction;
import basis.functions.BasicFitnessFunction;

public class Population {
	protected List<Individual> individuals;
    protected int size;
    protected int length;
    protected Random random;
    
    /**
     * Creates a new {@link Population} with the given size and length.
     * 
     * @param size the size of the population
     * @param length the length of the individuals
     */
	public Population(int size, int length) {
		this.size = size;
		this.length = length;
		this.random = new Random();
		this.individuals = IntStream.range(0, size).mapToObj(i -> new Individual(length, i))
				.collect(Collectors.toList());
	};
	
	/**
	 * Creates a new {@link Population} given a list of individuals.
	 * 
	 * @param individuals the individuals of the population
	 */
	public Population(List<Individual> individuals) {
		this.size = individuals.size();
		this.length = individuals.get(0).getLength();
		this.random = new Random();
		this.individuals = individuals;
	};
    
    /**
     * Returns the individuals of the population.
     * 
     * @return the individuals of the population
     */
    public List<Individual> getIndividuals() {
        return individuals;
    }
    
    
    /**
	 * Returns the size of the population.
	 * 
	 * @return the size of the population
	 */
	public int getSize() {
		return size;
	};
	
	/**
	 * Returns the length of the individuals.
	 * 
	 * @return the length of the individuals
	 */
	public int getLength() {
		return length;
    };
    
    
	 
     /**
      * Returns an string representation of the population.
      * 
      * @return a string representation of the population
      */
     @Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Population[size=" + size + ", individuals=[\n");
			for (Individual individual : individuals) {
				builder.append("\t" + individual + "\n");
			}
			builder.append("]]");
			return builder.toString();
		};
     
     /**
      * Sorts the individuals in the population according to their fitness
      */
	public void sort() {
		for(int i=0; i<this.getLength(); i++) {
			Individual current = this.getIndividuals().get(i);
			int j = i-1;
			
			while(j>=0 && this.getIndividuals().get(j).getFitness() > current.getFitness()) {
                this.getIndividuals().set(j+1, this.getIndividuals().get(j));
                j--;
			};
			
			this.getIndividuals().set(j+1, current);
		};
	};
     
     //	Main
		public static void main(String[] args) {
        Population population = new Population(10, 8);
		System.out.println(population);
		
		Individual individual = population.getIndividuals().get(0);
		System.out.println(individual);
		
		Gene gene = individual.getGene(0);
		System.out.println(gene);
		
		individual.setGene(0, new Gene(true));
		System.out.println(individual);
		
		Population population2 = new Population(population.getIndividuals());
		System.out.println(population2);
		};
     
}













