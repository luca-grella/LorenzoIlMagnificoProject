/**
 * 
 */
package it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author luca-grella
 *
 */
public class HashMapLCPTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects.HashMapLCP#HashMapLCP()}.
	 */
	@Test
	public void testHashMapLCP() {
		HashMapLCP tester = new HashMapLCP();
		String name = "ModifierValue";
		LCPermEffect ris = tester.getLCPermEffect(name );
		String a = ((ModifierValue) ris).getName();
		
		assertEquals("ModifierValue", a);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects.HashMapLCP#getLCPermEffect(java.lang.String)}.
	 */
	@Test
	public void testGetLCPermEffect() {
		HashMapLCP tester = new HashMapLCP();
		String name = "ModifierValue";
		LCPermEffect ris = tester.getLCPermEffect(name );
		String a = ((ModifierValue) ris).getName();
		
		assertEquals("ModifierValue", a);
		
	}

}
