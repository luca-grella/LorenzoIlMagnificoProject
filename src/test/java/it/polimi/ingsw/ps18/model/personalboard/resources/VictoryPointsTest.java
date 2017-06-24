/**
 * 
 */
package it.polimi.ingsw.ps18.model.personalboard.resources;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class VictoryPointsTest.
 *
 * @author luca-grella
 */
public class VictoryPointsTest {
	
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
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.resources.VictoryPoints#VictoryPoints(int)}.
	 */
	@Test
	public void testVictoryPointsInt() {
		VictoryPoints tester = new VictoryPoints(a);
		int ris = tester.getQuantity();
		if(a!=ris){
			fail("errore in VictoryPoints (int)");
		}}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.resources.VictoryPoints#VictoryPoints(long)}.
	 */
	@Test
	public void testVictoryPointsLong() {
		VictoryPoints tester = new VictoryPoints(a);
		long ris = tester.getQuantity();
		if(a!=ris){
			fail("errore in VictoryPoints (long)");
		}}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.resources.VictoryPoints#getQuantity()}.
	 */
	@Test
	public void testGetQuantity() {
		VictoryPoints tester = new VictoryPoints(a);
		int ris = tester.getQuantity();
		if(a!=ris){
			fail("errore nella getQuantity");
		}}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.personalboard.resources.VictoryPoints#addQuantity(int)}.
	 */
	@Test
	public void testAddQuantity() {
		VictoryPoints tester = new VictoryPoints(a);
		int ris = tester.getQuantity();
		tester.addQuantity(b);
		int ris2 = tester.getQuantity();
		assertEquals(ris + b, ris2);
	}

}
