/**
 * 
 */
package it.polimi.ingsw.ps18.model.personalboard.resources;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;


/**
 * The Class ServantsTest.
 *
 * @author luca-grella
 */
public class ServantsTest {
	
	/**
	 * The rand.
	 */
	Random rand  = new Random();
	
	/**
	 * The a.
	 */
	int a = rand.nextInt(1000);
	
	/**
	 * The b.
	 */
	int b = rand.nextInt(1000);

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.resources.Servants#Servants(int)}.
	 */
	@Test
	public void testServantsInt() {
		Servants tester = new Servants(a);
		int ris = tester.getQuantity();
		if(a!=ris){
			fail("errore in Servants (int)");
		}}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.resources.Servants#Servants(long)}.
	 */
	@Test
	public void testServantsLong() {
		Servants tester = new Servants(a);
		long ris = tester.getQuantity();
		if(a!=ris){
			fail("errore in Servants (long)");
		}}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.resources.Servants#getQuantity()}.
	 */
	@Test
	public void testGetQuantity() {
		Servants tester = new Servants(a);
		int ris = tester.getQuantity();
		if(a!=ris){
			fail("errore nella getQuantity");
		}}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.resources.Servants#addQuantity(int)}.
	 */
	@Test
	public void testAddQuantity() {
		Servants tester = new Servants(a);
		int ris = tester.getQuantity();
		tester.addQuantity(b);
		int ris2 = tester.getQuantity();
		assertEquals(ris + b, ris2);
	}

}
