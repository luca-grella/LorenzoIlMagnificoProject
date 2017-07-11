/**
 * 
 */
package it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * The Class VariousModifierTest.
 *
 * @author luca-grella
 */
public class VariousModifierTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects.VariousModifier#setParam(java.lang.String)}.
	 */
	@Test
	public void testSetParam() {
		
		VariousModifier tester = new VariousModifier();
		String shortDescription = "ok";
		tester.setParam(shortDescription );
		String ris = tester.getShortDescription();
		
		assertEquals(shortDescription, ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects.VariousModifier#getShortDescription()}.
	 */
	@Test
	public void testGetShortDescription() {
		
		VariousModifier tester = new VariousModifier();
		String shortDescription = "ok";
		tester.setParam(shortDescription );
		String ris = tester.getShortDescription();
		
		assertEquals(shortDescription, ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects.VariousModifier#toString()}.
	 */
	@Test
	public void testToString() {
		
		VariousModifier tester = new VariousModifier();
		String shortDescription = "SkipCoinPaymentinTower";
		tester.setParam(shortDescription);
		tester.toString();
		shortDescription = "BonusVPVaticanReport";
		tester.setParam(shortDescription);
		tester.toString();
		shortDescription = "SkipMPCheckGreenCards";
		tester.setParam(shortDescription);
		tester.toString();
		shortDescription = "DoubleBonus";
		tester.setParam(shortDescription);
		tester.toString();
		shortDescription = "SkipFullSpaceControl";
		tester.setParam(shortDescription);
		tester.toString();
		shortDescription = "CopyLC";
		tester.setParam(shortDescription);
		tester.toString();
		
		
	}
	
	/**
	 * Test get name.
	 */
	@Test
	public void testGetName() {
		
		VariousModifier tester = new VariousModifier();
		
		
		
		assertEquals("VariousModifier", tester.getName());
		
		
	}

}
