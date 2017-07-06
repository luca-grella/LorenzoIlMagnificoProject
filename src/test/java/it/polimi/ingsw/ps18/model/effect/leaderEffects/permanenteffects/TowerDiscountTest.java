/**
 * 
 */
package it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects;

import static org.junit.Assert.*;

import org.junit.Test;

import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

/**
 * @author luca-grella
 *
 */
public class TowerDiscountTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects.TowerDiscount#getDiscount()}.
	 */
	@Test
	public void testGetDiscount() {
		TowerDiscount tester = new TowerDiscount();
		Stats discount = new Stats(2,2,2,2,2,2,2);
		tester.setParam(discount );
		Stats ris = tester.getDiscount();
		
		assertEquals(discount, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects.TowerDiscount#setParam(it.polimi.ingsw.ps18.model.personalboard.resources.Stats)}.
	 */
	@Test
	public void testSetParam() {
		TowerDiscount tester = new TowerDiscount();
		Stats discount = new Stats(2,2,2,2,2,2,2);
		tester.setParam(discount );
		Stats ris = tester.getDiscount();
		
		assertEquals(discount, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects.TowerDiscount#toString()}.
	 */
	@Test
	public void testToString() {
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects.TowerDiscount#getShortDescription()}.
	 */
	@Test
	public void testGetShortDescription() {
		TowerDiscount tester = new TowerDiscount();
		String ris = tester.getShortDescription();
		
		assertEquals("TowerDiscount", ris);
	}

}
