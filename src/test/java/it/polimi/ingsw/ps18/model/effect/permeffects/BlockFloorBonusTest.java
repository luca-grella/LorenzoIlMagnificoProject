/**
 * 
 */
package it.polimi.ingsw.ps18.model.effect.permeffects;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author luca-grella
 *
 */
public class BlockFloorBonusTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.permeffects.BlockFloorBonus#getQuantity()}.
	 */
	@Test
	public void testGetQuantity() {
		
		BlockFloorBonus tester = new BlockFloorBonus();
		int blockedfloor = 3;
		tester.setQuantity(blockedfloor);
		int ris = tester.getQuantity();
		
		assertEquals(blockedfloor, ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.permeffects.BlockFloorBonus#setQuantity(int)}.
	 */
	@Test
	public void testSetQuantity() {
		
		BlockFloorBonus tester = new BlockFloorBonus();
		int blockedfloor = 3;
		tester.setQuantity(blockedfloor);
		int ris = tester.getQuantity();
		
		assertEquals(blockedfloor, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.permeffects.BlockFloorBonus#getName()}.
	 */
	@Test
	public void testGetName() {
		
		BlockFloorBonus tester = new BlockFloorBonus();
		String name = tester.getName();
		
		assertEquals("BlockFloorBonus", name);
		
	}

}
