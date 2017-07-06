/**
 * 
 */
package it.polimi.ingsw.ps18.model.effect.generalEffects;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author luca-grella
 *
 */
public class DifferentPrivilegeTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.generalEffects.DifferentPrivilege#activate(it.polimi.ingsw.ps18.model.personalboard.PBoard, it.polimi.ingsw.ps18.model.gamelogic.GameLogic)}.
	 */
	@Test
	public void testActivate() {
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.generalEffects.DifferentPrivilege#setQuantity(int)}.
	 */
	@Test
	public void testSetQuantity() {
		DifferentPrivilege tester = new DifferentPrivilege();
		int quantity = 5;
		tester.setQuantity(quantity );
		int ris = tester.getQuantity();
		
		assertEquals(quantity, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.generalEffects.DifferentPrivilege#toString()}.
	 */
	@Test
	public void testToString() {
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.generalEffects.DifferentPrivilege#getName()}.
	 */
	@Test
	public void testGetName() {
		DifferentPrivilege tester = new DifferentPrivilege();
		String name = tester.getName();
		
		assertEquals("different privilege", name);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.generalEffects.DifferentPrivilege#getPreviousChoices()}.
	 */
	@Test
	public void testGetPreviousChoices() {
		
		DifferentPrivilege tester = new DifferentPrivilege();
		List<Integer> previousChoices = new ArrayList<>();
		previousChoices.add(3);
		previousChoices.add(4);
		previousChoices.add(5);
		previousChoices.add(6);
		tester.setPreviousChoices(previousChoices);
		List<Integer> ris = tester.getPreviousChoices();
		int ris0 = ris.get(0);
		int ris1 = ris.get(1);
		int ris2 = ris.get(2);
		int ris3 = ris.get(3);
		
		assertEquals(3, ris0);
		assertEquals(4, ris1);
		assertEquals(5, ris2);
		assertEquals(6, ris3);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.generalEffects.DifferentPrivilege#setPreviousChoices(java.util.List)}.
	 */
	@Test
	public void testSetPreviousChoices() {
		
		DifferentPrivilege tester = new DifferentPrivilege();
		List<Integer> previousChoices = new ArrayList<>();
		previousChoices.add(3);
		previousChoices.add(4);
		previousChoices.add(5);
		previousChoices.add(6);
		tester.setPreviousChoices(previousChoices);
		List<Integer> ris = tester.getPreviousChoices();
		int ris0 = ris.get(0);
		int ris1 = ris.get(1);
		int ris2 = ris.get(2);
		int ris3 = ris.get(3);
		
		assertEquals(3, ris0);
		assertEquals(4, ris1);
		assertEquals(5, ris2);
		assertEquals(6, ris3);
		
	}

}
