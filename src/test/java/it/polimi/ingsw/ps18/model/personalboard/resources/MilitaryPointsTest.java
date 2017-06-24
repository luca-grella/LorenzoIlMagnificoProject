/**
 * 
 */
package it.polimi.ingsw.ps18.model.personalboard.resources;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class MilitaryPointsTest.
 *
 * @author luca-grella
 */
public class MilitaryPointsTest {
	
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
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.resources.MilitaryPoints#MilitaryPoints(int)}.
	 */
	@Test
	public void testMilitaryPointsInt() {
		MilitaryPoints tester = new MilitaryPoints(a);
		int ris = tester.getQuantity();
		if(a!=ris){
			fail("errore in MilitaryPoints (int)");
		}}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.resources.MilitaryPoints#MilitaryPoints(long)}.
	 */
	@Test
	public void testMilitaryPointsLong() {
		MilitaryPoints tester = new MilitaryPoints(a);
		long ris = tester.getQuantity();
		if(a!=ris){
			fail("errore in MilitaryPoints (long)");
		}}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.resources.MilitaryPoints#getQuantity()}.
	 */
	@Test
	public void testGetQuantity() {
		MilitaryPoints tester = new MilitaryPoints(a);
		int ris = tester.getQuantity();
		if(a!=ris){
			fail("errore nella getQuantity");
		}}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.resources.MilitaryPoints#addQuantity(int)}.
	 */
	@Test
	public void testAddQuantity() {
		MilitaryPoints tester = new MilitaryPoints(a);
		int ris = tester.getQuantity();
		tester.addQuantity(b);
		int ris2 = tester.getQuantity();
		assertEquals(ris + b, ris2);
	}

}
