/**
 * 
 */
package it.polimi.ingsw.ps18.model.effect.excommEffects;

import static org.junit.Assert.*;

import org.junit.Test;

import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

/**
 * The Class LoseVPforResourcesTest.
 *
 * @author luca-grella
 */
public class LoseVPforResourcesTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.excommEffects.LoseVPforResources#activate(it.polimi.ingsw.ps18.model.personalboard.PBoard)}.
	 */
	@Test
	public void testActivate() {
		LoseVPforResources tester = new LoseVPforResources();
		tester.setQuantity(1);
		PBoard player = new PBoard();
		int vp = 100;
		Stats resources =new Stats(10,10,10,10,0,0,vp );
		player.setResources(resources );
		tester.activate(player );
		int ris = player.getResources().getVP();
		
		assertEquals(vp-40,ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.excommEffects.LoseVPforResources#setQuantity(int)}.
	 */
	@Test
	public void testSetQuantity() {
		LoseVPforResources tester = new LoseVPforResources();
		int quantity=1;
		tester.setQuantity(quantity);
		int ris = tester.getLoseVP();
		
		assertEquals(quantity, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.excommEffects.LoseVPforResources#getLoseVP()}.
	 */
	@Test
	public void testGetLoseVP() {
		LoseVPforResources tester = new LoseVPforResources();
		int quantity=1;
		tester.setQuantity(quantity);
		int ris = tester.getLoseVP();
		
		assertEquals(quantity, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.excommEffects.LoseVPforResources#getName()}.
	 */
	@Test
	public void testGetName() {
		LoseVPforResources tester = new LoseVPforResources();
		String ris = tester.getName();
		
		assertEquals("LoseVPforResources", ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.excommEffects.LoseVPforResources#toString()}.
	 */
	@Test
	public void testToString() {
		
	}

}
