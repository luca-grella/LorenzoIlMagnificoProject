/**
 * 
 */
package it.polimi.ingsw.ps18.model.effect.permeffects;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * The Class HashMapPermETest.
 *
 * @author luca-grella
 */
public class HashMapPermETest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.permeffects.HashMapPermE#HashMapPermE()}.
	 */
	@Test
	public void testHashMapPermE() {
		
		Permanenteffect a = new IncreaseFMValueOnAction();
		int quantity = 45;
		a.setQuantity(quantity);
		Permanenteffect b = new IncreaseFMValueOnActionWR();
		int quantity2 = 47;
		b.setQuantity(quantity2);
		Permanenteffect c = new BlockFloorBonus();
		int quantity3 = 38;
		c.setQuantity(quantity3);
		
		Map<String,Permanenteffect> permEffects = new HashMap<>();
		permEffects.put("IncreaseFMvalueOnAction", new IncreaseFMValueOnAction());
		permEffects.put("IncreaseFMvalueOnActionWR", new IncreaseFMValueOnActionWR());
		permEffects.put("BlockFloorBonus", new BlockFloorBonus());
		
		Permanenteffect ris = permEffects.get("IncreaseFMvalueOnAction");
		ris.setQuantity(quantity);
		
		assertEquals(quantity, ris.getQuantity());
		
		Permanenteffect ris2 = permEffects.get("IncreaseFMvalueOnActionWR");
		ris2.setQuantity(quantity2);
		
		assertEquals(quantity2, ris2.getQuantity());
		
		Permanenteffect ris3 = permEffects.get("BlockFloorBonus");
		ris3.setQuantity(quantity3);
		
		assertEquals(quantity3, ris3.getQuantity());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.permeffects.HashMapPermE#getEffect(java.lang.String)}.
	 */
	@Test
	public void testGetEffect() {
		
		int quantity = 0;
		String name = "BlockFloorBonus";
		
		HashMapPermE tester = new HashMapPermE();
		Permanenteffect ris = tester.getEffect("BlockFloorBonus");
		
		assertEquals(name, ris.getName());
		assertEquals(quantity, ris.getQuantity());
		
	}

}
