/**
 * 
 */
package it.polimi.ingsw.ps18.model.personalboard.resources;

import static org.junit.Assert.*;


import java.util.Random;

import org.junit.Test;


/**
 * The Class CoinsTest.
 *
 * @author luca-grella
 */
public class CoinsTest {
	
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
	 * Test coins int.
	 */
	@Test
	public void testCoinsInt() {
		Coins tester = new Coins(a);
		int ris = tester.getQuantity();
		if(a!=ris){
			fail("errore in Coins (int)");
		}}

	/**
	 * Test coins long.
	 */
	@Test
	public void testCoinsLong() {
		Coins tester = new Coins(a);
		long ris = tester.getQuantity();
		if(a!=ris){
			fail("errore in Coins (long)");
		}}

	/**
	 * Test get quantity.
	 */
	@Test
	public void testGetQuantity() {
		Coins tester = new Coins(a);
		int ris = tester.getQuantity();
		if(a!=ris){
			fail("errore nella getQuantity");
		}}

	/**
	 * Test add quantity.
	 */
	@Test
	public void testAddQuantity() {
		Coins tester = new Coins(a);
		int ris = tester.getQuantity();
		tester.addQuantity(b);
		int ris2 = tester.getQuantity();
		assertEquals(ris + b, ris2);
	}

}
