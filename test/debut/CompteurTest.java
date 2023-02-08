package debut;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CompteurTest {

	@Test
	void testConstructeur() {
		Compteur instance= new Compteur ();
		int expected = 0; 
		int result = instance.getNiveau(); 
		assertEquals(expected, result); 
		
	}
	
	@Test 
	void testIncrementer () {
		Compteur instance = new Compteur(); 
		instance.incrementer(); 
		assertEquals(1, instance.getNiveau()); 
	}
	
	@Test 
	void testIncrementer3fois () {
		Compteur instance = new Compteur(); 
		instance.incrementer();
		instance.incrementer();
		instance.incrementer();
		assertEquals(3, instance.getNiveau()); 
		
	}
	@Test 
	void testReinitialiser () {
		// Given
		Compteur instance = new Compteur(); 
		//When
		instance.incrementer();
		instance.incrementer();
		instance.incrementer();
		instance.reinitialiser(); 
		// Then 
		assertEquals(0, instance.getNiveau()); 
	}
	

}
