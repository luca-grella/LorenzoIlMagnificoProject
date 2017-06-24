package it.polimi.ingsw.ps18.model.personalboard.resources;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class FaithPointsTest.
 *
 * @author luca-grella
 */

public class FaithPointsTest {
	
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
	 * Test faith points int.
	 */
	@Test
	public void testFaithPointsInt() {
		FaithPoints tester = new FaithPoints(a);
		int ris = tester.getQuantity();
		if(a!=ris){
			fail("errore in FaithPoints (int)");
		}}

	/**
	 * Test faith points long.
	 */
	@Test
	public void testFaithPointsLong() {
		FaithPoints tester = new FaithPoints(a);
		long ris = tester.getQuantity();
		if(a!=ris){
			fail("errore in FaithPoints (long)");
		}}

	/**
	 * Test get quantity.
	 */
	@Test
	public void testGetQuantity() {
		FaithPoints tester = new FaithPoints(a);
		int ris = tester.getQuantity();
		if(a!=ris){
			fail("errore nella getQuantity");
		}}

	/**
	 * Test add quantity.
	 */
	@Test
	public void testAddQuantity() {
		FaithPoints tester = new FaithPoints(a);
		int ris = tester.getQuantity();
		tester.addQuantity(b);
		int ris2 = tester.getQuantity();
		assertEquals(ris + b, ris2);
	}

}
