/**
 * 
 */
package it.polimi.ingsw.ps18.model.effect.excommEffects;

import static org.junit.Assert.*;

import org.junit.Test;

import it.polimi.ingsw.ps18.model.effect.quickEffect.HashMapQE;
import it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect;

/**
 * The Class HashMapExcommTest.
 *
 * @author luca-grella
 */
public class HashMapExcommTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.excommEffects.HashMapExcomm#HashMapExcomm()}.
	 */
	@Test
	public void testHashMapExcomm() {
		String name = "MalusValue";
		
		HashMapExcomm tester = new HashMapExcomm();
		ExcommEffects ris = tester.geteffect(name);
		
		int malusvalue = 3;
		ris.setQuantity(malusvalue );
		int ris2 = ((MalusValue) ris).getMalusValue();
		
		assertEquals(malusvalue, ris2);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.excommEffects.HashMapExcomm#geteffect(java.lang.String)}.
	 */
	@Test
	public void testGeteffect() {
		String name = "MalusValue";
		
		HashMapExcomm tester = new HashMapExcomm();
		ExcommEffects ris = tester.geteffect(name);
		
		int malusvalue = 3;
		ris.setQuantity(malusvalue );
		int ris2 = ((MalusValue) ris).getMalusValue();
		
		assertEquals(malusvalue, ris2);
	}

}
