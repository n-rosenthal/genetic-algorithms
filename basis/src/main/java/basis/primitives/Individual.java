package basis.primitives;

/**
 * A {@link Individual} is a concrete extension of a {@link Chromosome}. Requires an identifier for tracking purposes.
 * If offers additional functionality for genetic algorithms and an easier initialization process.
 * 
 * A {@link Population} is a collection of individuals associated with a {@link basis.functions.FitnessFunction}
 */
public class Individual extends Chromosome{
	protected int identifier;
	
	
	/**
	 * Creates a new {@link Individual} with the given genes.
	 * 
	 * @param genes the genes of the individual
	 */
	public Individual(Gene[] genes, int id) {
		super(genes);
		this.identifier = id;
	}

	/**
	 * Creates a new {@link Individual} with the given length. The genes of the
	 * individual are randomly initialized.
	 * 
	 * @param length the length of the individual
	 */
	public Individual(int length, int id) {
		super(new Gene[length]);
		this.identifier = id;
		for (int i = 0; i < length; i++) {
			genes[i] = new Gene(Math.random() < 0.5);
		}
	}
	
	public Individual(Chromosome newChromosome) {
		super(newChromosome.getGenes());
	};
	
	
	/**
	 * Returns a string representation of the individual.
	 * 
	 * @return a string representation of the individual
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("Individual[id=" + identifier + ", genes=");
		
		for (Gene gene : genes) {
			builder.append(gene.getValue() ? "1" : "0");
		};
		
		builder.append(", fitness=" + fitness + ", probability=" + probability + "]");
		
		return builder.toString();
	};
	

	/**
	 * Returns the length of the individual.
	 * 
	 * @return the length of the individual
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Returns the gene at the given index.
	 * 
	 * @param index the index of the gene
	 * @return the gene at the given index
	 */
	public Gene getGene(int index) {
		return genes[index];
	}

	/**
	 * Sets the gene at the given index.
	 * 
	 * @param index the index of the gene
	 * @param gene  the new gene
	 */
	public void setGene(int index, Gene gene) {
		genes[index] = gene;
	}

	/**
	 * Returns the fitness of the individual.
	 * 
	 * @return the fitness of the individual
	 * @see #setFitness(double)
	 */
	public double getFitness() {
		return fitness;
	}

	/**
	 * Sets the fitness of the individual.
	 * 
	 * @param fitness the new fitness of the individual
	 * @see #getFitness()
	 */
	public void setFitness(double fitness) {
		this.fitness = fitness;
	}

	/**
	 * Returns the probability of the individual.
	 * 
	 * @return the probability of the individual
	 * @see #setProbability(double)
	 */
	public double getProbability() {
		return probability;
	}

	/**
	 * Sets the probability of the individual.
	 * 
	 * @param probability the new probability of the individual
	 * @see #getProbability()
	 */
	public void setProbability(double probability) {
		this.probability = probability;
	}

	public Chromosome getChromosome() {
		return new Chromosome(genes);
    };
};
