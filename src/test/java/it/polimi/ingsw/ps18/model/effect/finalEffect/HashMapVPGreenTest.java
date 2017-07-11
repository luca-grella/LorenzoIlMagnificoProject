/**
 * 
 */
package it.polimi.ingsw.ps18.model.effect.finalEffect;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * The Class HashMapVPGreenTest.
 *
 * @author luca-grella
 */
public class HashMapVPGreenTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.finalEffect.HashMapVPGreen#HashMapVPGreen()}.
	 */
	@Test
	public void testHashMapVPGreen() {
		
		HashMapVPGreen tester = new HashMapVPGreen();
		int i = 5;
		int ris = tester.getGenVPGEffect(i);
		
		assertEquals(10, ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.finalEffect.HashMapVPGreen#getGenVPGEffect(java.lang.Integer)}.
	 */
	@Test
	public void testGetGenVPGEffect() {
		
		HashMapVPGreen tester = new HashMapVPGreen();
		int i = 6;
		int ris = tester.getGenVPGEffect(i);
		
		assertEquals(20, ris);
		
	}

}
