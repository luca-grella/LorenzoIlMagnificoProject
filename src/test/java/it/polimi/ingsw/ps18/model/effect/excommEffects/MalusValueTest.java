/**
 * 
 */
package it.polimi.ingsw.ps18.model.effect.excommEffects;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author luca-grella
 *
 */
public class MalusValueTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.excommEffects.MalusValue#setQuantity(int)}.
	 */
	@Test
	public void testSetQuantity() {
		
		MalusValue tester = new MalusValue();
		int malusvalue = 3;
		tester.setQuantity(malusvalue );
		int ris = tester.getMalusValue();
		
		assertEquals(malusvalue, ris);
		
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.excommEffects.MalusValue#setName(java.lang.String)}.
	 */
	@Test
	public void testSetName() {
		
		MalusValue tester = new MalusValue();
		String nameplace = "World";
		tester.setName(nameplace);
		String ris = tester.getPlace();
		
		assertEquals(nameplace, ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.excommEffects.MalusValue#getName()}.
	 */
	@Test
	public void testGetName() {
		
		MalusValue tester = new MalusValue();
		String ris = tester.getName();
		
		assertEquals("MalusValue", ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.excommEffects.MalusValue#getPlace()}.
	 */
	@Test
	public void testGetPlace() {
		MalusValue tester = new MalusValue();
		String nameplace = "World";
		tester.setName(nameplace);
		String ris = tester.getPlace();
		
		assertEquals(nameplace, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.excommEffects.MalusValue#getMalusValue()}.
	 */
	@Test
	public void testGetMalusValue() {
		MalusValue tester = new MalusValue();
		int malusvalue = 3;
		tester.setQuantity(malusvalue );
		int ris = tester.getMalusValue();
		
		assertEquals(malusvalue, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.excommEffects.MalusValue#toString()}.
	 */
	@Test
	public void testToString() {
		
	}

}
