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
public class RockTest {
	Random rand  = new Random();
	int a = rand.nextInt(1000);
	int b = rand.nextInt(1000);

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.resources.Rock#Rock(int)}.
	 */
	@Test
	public void testRockInt() {
		Rock tester = new Rock(a);
		int ris = tester.getQuantity();
		if(a!=ris){
			fail("errore in Rock (int)");
		}}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.resources.Rock#Rock(long)}.
	 */
	@Test
	public void testRockLong() {
		Rock tester = new Rock(a);
		long ris = tester.getQuantity();
		if(a!=ris){
			fail("errore in Rock (long)");
		}}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.resources.Rock#getQuantity()}.
	 */
	@Test
	public void testGetQuantity() {
		Rock tester = new Rock(a);
		int ris = tester.getQuantity();
		if(a!=ris){
			fail("errore nella getQuantity");
		}}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.resources.Rock#addQuantity(int)}.
	 */
	@Test
	public void testAddQuantity() {
		Rock tester = new Rock(a);
		int ris = tester.getQuantity();
		tester.addQuantity(b);
		int ris2 = tester.getQuantity();
		assertEquals(ris + b, ris2);
	}

}
