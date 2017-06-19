package it.polimi.ingsw.ps18.model.personalboard.resources;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

/**
 * @author luca-grella
 *
 */

public class FaithPointsTest {
	Random rand  = new Random();
	int a = rand.nextInt(1000);
	int b = rand.nextInt(1000);

	
	
	@Test
	public void testFaithPointsInt() {
		FaithPoints tester = new FaithPoints(a);
		int ris = tester.getQuantity();
		if(a!=ris){
			fail("errore in FaithPoints (int)");
		}}

	@Test
	public void testFaithPointsLong() {
		FaithPoints tester = new FaithPoints(a);
		long ris = tester.getQuantity();
		if(a!=ris){
			fail("errore in FaithPoints (long)");
		}}

	@Test
	public void testGetQuantity() {
		FaithPoints tester = new FaithPoints(a);
		int ris = tester.getQuantity();
		if(a!=ris){
			fail("errore nella getQuantity");
		}}

	@Test
	public void testAddQuantity() {
		FaithPoints tester = new FaithPoints(a);
		int ris = tester.getQuantity();
		tester.addQuantity(b);
		int ris2 = tester.getQuantity();
		assertEquals(ris + b, ris2);
	}

}
