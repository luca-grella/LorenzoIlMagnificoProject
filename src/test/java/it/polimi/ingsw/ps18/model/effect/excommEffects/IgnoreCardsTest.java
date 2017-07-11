/**
 * 
 */
package it.polimi.ingsw.ps18.model.effect.excommEffects;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * The Class IgnoreCardsTest.
 *
 * @author luca-grella
 */
public class IgnoreCardsTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.excommEffects.IgnoreCards#setQuantity(int)}.
	 */
	@Test
	public void testSetQuantity() {
		IgnoreCards tester = new IgnoreCards();
		int quantity = 5;
		tester.setQuantity(quantity );
		int ris = tester.getQuantity(quantity);
		
		assertEquals(quantity, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.excommEffects.IgnoreCards#setName(java.lang.String)}.
	 */
	@Test
	public void testSetName() {
		IgnoreCards tester = new IgnoreCards();
		String name = "ok";
		tester.setName(name );
		String ris = tester.getName();
		
		assertEquals(name, ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.excommEffects.IgnoreCards#getName()}.
	 */
	@Test
	public void testGetName() {
		IgnoreCards tester = new IgnoreCards();
		String name = "ok";
		tester.setName(name );
		String ris = tester.getName();
		
		assertEquals(name, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.excommEffects.IgnoreCards#toString()}.
	 */
	@Test
	public void testToString() {
		
	}

}
