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
public class CoinsTest {
	Random rand  = new Random();
	int a = rand.nextInt(1000);
	int b = rand.nextInt(1000);

	@Test
	public void testCoinsInt() {
		Coins tester = new Coins(a);
		int ris = tester.getQuantity();
		if(a!=ris){
			fail("errore in Coins (int)");
		}}

	@Test
	public void testCoinsLong() {
		Coins tester = new Coins(a);
		long ris = tester.getQuantity();
		if(a!=ris){
			fail("errore in Coins (long)");
		}}

	@Test
	public void testGetQuantity() {
		Coins tester = new Coins(a);
		int ris = tester.getQuantity();
		if(a!=ris){
			fail("errore nella getQuantity");
		}}

	@Test
	public void testAddQuantity() {
		Coins tester = new Coins(a);
		int ris = tester.getQuantity();
		tester.addQuantity(b);
		int ris2 = tester.getQuantity();
		assertEquals(ris + b, ris2);
	}

}
