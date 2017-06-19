/**
 * 
 */
package it.polimi.ingsw.ps18.model.personalboard.resources;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

/**
 * @author luca-grella
 *
 */
public class WoodTest {
	Random rand  = new Random();
	int a = rand.nextInt(1000);
	int b = rand.nextInt(1000);

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.resources.Wood#Wood(int)}.
	 */
	@Test
	public void testWoodInt() {
		Wood tester = new Wood(a);
		int ris = tester.getQuantity();
		if(a!=ris){
			fail("errore in Wood (int)");
		}}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.resources.Wood#Wood(long)}.
	 */
	@Test
	public void testWoodLong() {
		Wood tester = new Wood(a);
		long ris = tester.getQuantity();
		if(a!=ris){
			fail("errore in Wood (long)");
		}}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.resources.Wood#getQuantity()}.
	 */
	@Test
	public void testGetQuantity() {
		Wood tester = new Wood(a);
		int ris = tester.getQuantity();
		if(a!=ris){
			fail("errore nella getQuantity");
		}}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.resources.Wood#addQuantity(int)}.
	 */
	@Test
	public void testAddQuantity() {
		Wood tester = new Wood(a);
		int ris = tester.getQuantity();
		tester.addQuantity(b);
		int ris2 = tester.getQuantity();
		assertEquals(ris + b, ris2);
	}

}
