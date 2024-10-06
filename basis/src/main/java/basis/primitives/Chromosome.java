package basis.primitives;

import basis.functions.FitnessFunction;
import basis.primitives.Gene;


/**
 * A {@link Chromosome} is a sequence of genes that represents a potential solution to a problem.
 * Each gene in a chromosome is a variable that can be adjusted to improve the solution.
 * The genes in a chromosome are encoded as a binary string.
 */
public class Chromosome {
	protected Gene[] genes;
	protected double fitness;
	protected double probability;
	protected int length;
	
	/**
	 * Creates a new {@link Chromosome} with the given genes.
	 * 
	 * @param genes the genes of the chromosome
	 */
	public Chromosome(Gene[] genes) {
		this.genes = genes;
		this.length = genes.length;
	};
	
	public Chromosome(int length) {
		this.length = length;
		genes = new Gene[length];
		for (int i = 0; i < length; i++) {
			genes[i] = new Gene(false); 
		};
	};

	/**
	 * Returns the genes of the chromosome.
	 * 
	 * @return the genes of the chromosome
	 */
	public Gene[] getGenes() {
		return genes;
    };
    
    /**
     * Returns the fitness of the chromosome.
     * 
     * @return the fitness of the chromosome
     * @see #setFitness(double)
     */
    public double getFitness() {
        return fitness;
    };
    
	/**
	 * Sets the fitness of the chromosome.
	 * 
	 * @param fitness the new fitness of the chromosome
	 * @see #getFitness()
	 */
	public void setFitness(double fitness) {
		this.fitness = fitness;
	};
	
	/**
	 * Returns the probability of the chromosome.
	 * 
	 * @return the probability of the chromosome
	 * @see #setProbability(double)
	 */
	public double getProbability() {
		return probability;
    };
    
    /**
     * Sets the probability of the chromosome.
     * 
     * @param probability the new probability of the chromosome
     */
    public void setProbability(double probability) {
        this.probability = probability;
    };
    
	/**
	 * Returns the length of the chromosome.
	 * 
	 * @return the length of the chromosome
	 */
	public int getLength() {
		return length;
	};
	
	/**
	 * Flips the gene at the given index.
	 * 
	 * @param index the index of the gene to flip
	 */
	public void flipGene(int index) {
		genes[index].flip();
    };
    
	/**
	 * Returns a string representation of the chromosome.
	 * 
	 * @return a string representation of the chromosome
	 */
    @Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Gene gene : genes) {
			sb.append(gene.getValue() ? "1" : "0");
		}
		return sb.toString();
	};
	
	/**
	 * Returns a copy of the chromosome.
	 * 
	 * @return a copy of the chromosome
	 */
	public Chromosome copy() {
		Gene[] genesCopy = new Gene[length];
		for (int i = 0; i < length; i++) {
			genesCopy[i] = new Gene(genes[i].getValue());
		}
		Chromosome chromosomeCopy = new Chromosome(genesCopy);
		chromosomeCopy.setFitness(fitness);
		chromosomeCopy.setProbability(probability);
		return chromosomeCopy;
	};
	
	/**
	 * Returns the gene at the given index.
	 * 
	 * @param index the index of the gene to return
	 * @return the gene at the given index
	 */
	public Gene getGene(int index) {
		return genes[index];
    };
    
	/**
	 * Sets the gene at the given index.
	 * 
	 * @param index the index of the gene to set
	 * @param gene  the gene to set
	 */
	public void setGene(int index, Gene gene) {
		genes[index] = gene;
	};
	
	/**
	 * Returns the number of genes that are different between this chromosome and
	 * the given chromosome.
	 * 
	 * @param chromosome the chromosome to compare
	 * @return the number of genes that are different between this chromosome and
	 *         the given chromosome
	 */
	public int getHammingDistance(Chromosome chromosome) {
		int distance = 0;
		for (int i = 0; i < length; i++) {
			if (genes[i].getValue() != chromosome.getGene(i).getValue()) {
				distance++;
			}
		}
		return distance;
	};
	
	/**
	 * Returns the number of genes that are the same between this chromosome and the
	 * given chromosome.
	 * 
	 * @param chromosome the chromosome to compare
	 * @return the number of genes that are the same between this chromosome and the
	 *         given chromosome
	 */
	public int getSimilarity(Chromosome chromosome) {
		return length - getHammingDistance(chromosome);
    };
    
    /**
     * Calculates the fitness of the chromosome using the given fitness function.
     * 
     * @param fitnessFunction the fitness function to use
     * @see #getFitness()
     */
    public void calculateFitness(FitnessFunction fitnessFunction) {
        fitness = fitnessFunction.evaluate(this);
    };

}
