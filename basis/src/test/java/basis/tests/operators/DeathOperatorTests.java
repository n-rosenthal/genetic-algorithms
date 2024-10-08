package basis.tests.operators;

import basis.primitives.*;
import basis.functions.*;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Assert;

/**
 * Tests for the {@link basis.functions.DeathOperator}. The {@code DeathOperator} is responsible for removing {@code Individual}s from a {@code Population}.
 */
public class DeathOperatorTests {
	/**
	 * Empty constructor for the tests' class.
	 */
	public DeathOperatorTests() {};
	
	/**
	 *	General application of the operator
	 */
	@Test
	public void DeathOperatorTest() {
		//	100 individuals of (chromosome) size 10.
		Population population = new Population(100, 10);
		int populationSize = population.getSize();
		
		//	Runs the operator and asserts that the population's size after the operator is smaller than it was before the operator
		Population afterOperatorPopulation = DeathOperator.kill(population, 0.05);
		
		//	Asserts the lengths
		Assert.assertNotEquals(populationSize, afterOperatorPopulation.getSize());
	};
	
	/**
	 * Application of the operator for removing AT MOST n individuals from the population
	 */
	@Test
	public void DeathOperatorTestN() {
//		100 individuals of (chromosome) size 10.
			Population population = new Population(100, 10);
			int populationSize = population.getSize();
			
			//	Runs the operator and asserts that the population's size after the operator is smaller than it was before the operator
			Population afterOperatorPopulation = DeathOperator.kill(population, 0, 95);
			
			//	Asserts the lengths
			int afterSize = afterOperatorPopulation.getSize();
			
			Assert.assertNotEquals(populationSize, afterSize);
			Assert.assertEquals(populationSize, afterSize + 5);
	}
	
	
	
	
	// main
	public void main(String[] args) {
		DeathOperatorTests tests = new DeathOperatorTests();
		tests.DeathOperatorTest();
		tests.DeathOperatorTestN();
	};
};
	
