/**
 * 
 */
package it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects;

import static org.junit.Assert.*;

import org.json.simple.JSONArray;
import org.junit.Test;

/**
 * @author luca-grella
 *
 */
public class ModifierValueTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects.ModifierValue#setParam(java.lang.String, int)}.
	 */
	@Test
	public void testSetParam() {
		ModifierValue tester = new ModifierValue();
		String shortDescription = "ok";
		long quantity = 1;
		JSONArray parameters = new JSONArray();
		parameters.add(shortDescription);
		parameters.add(quantity);
		tester.setParam(parameters);
		int ris = tester.getQuantity();
		String ris2 = tester.getShortDescription();
		
		assertEquals(shortDescription, ris2);
		assertEquals(quantity, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects.ModifierValue#getShortDescription()}.
	 */
	@Test
	public void testGetShortDescription() {
		ModifierValue tester = new ModifierValue();
		String shortDescription = "ok";
		long quantity = 1;
		JSONArray parameters = new JSONArray();
		parameters.add(shortDescription);
		parameters.add(quantity);
		tester.setParam(parameters);
		String ris = tester.getShortDescription();
		
		assertEquals(shortDescription, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects.ModifierValue#toString()}.
	 */
	@Test
	public void testToString() {
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects.ModifierValue#getQuantity()}.
	 */
	@Test
	public void testGetQuantity() {
		ModifierValue tester = new ModifierValue();
		String shortDescription = "ok";
		long quantity = 1;
		JSONArray parameters = new JSONArray();
		parameters.add(shortDescription);
		parameters.add(quantity);
		tester.setParam(parameters);
		int ris = tester.getQuantity();
		
		assertEquals(quantity, ris);
	}

}
