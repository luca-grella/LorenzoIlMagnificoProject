/**
 * 
 */
package it.polimi.ingsw.ps18.model.effect.finalEffect;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * The Class HashMapVPBlueTest.
 *
 * @author luca-grella
 */
public class HashMapVPBlueTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.finalEffect.HashMapVPBlue#HashMapVPBlue()}.
	 */
	@Test
	public void testHashMapVPBlue() {
		
		HashMapVPBlue tester = new HashMapVPBlue();
		int ris = tester.getGenVPBEffect(6);
		
		assertEquals(21, ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.finalEffect.HashMapVPBlue#getGenVPBEffect(java.lang.Integer)}.
	 */
	@Test
	public void testGetGenVPBEffect() {
		
		HashMapVPBlue tester = new HashMapVPBlue();
		int ris = tester.getGenVPBEffect(3);
		
		assertEquals(6, ris);
		
	}

}
