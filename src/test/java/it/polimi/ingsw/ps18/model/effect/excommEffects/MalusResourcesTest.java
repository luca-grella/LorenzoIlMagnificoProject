/**
 * 
 */
package it.polimi.ingsw.ps18.model.effect.excommEffects;

import static org.junit.Assert.*;

import org.json.simple.JSONArray;
import org.junit.Test;

import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

/**
 * The Class MalusResourcesTest.
 *
 * @author luca-grella
 */
public class MalusResourcesTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.excommEffects.MalusResources#setQuantity(int)}.
	 */
	@Test
	public void testSetQuantity() {
		
		MalusResources tester = new MalusResources();
		int quantity = 4 ;
		tester.setQuantity(quantity );
		int ris = tester.getQuantity(quantity);
		
		assertEquals(quantity, ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.excommEffects.MalusResources#setMalus(org.json.simple.JSONArray)}.
	 */
	@Test
	public void testSetMalus() {
		MalusResources tester = new MalusResources();
		JSONArray stats = new JSONArray();
		long a = 1;
		long b = 1;
		long c = 1;
		long d = 1;
		long e = 1;
		long f = 1;
		long g = 1;
		stats.add(a);
		stats.add(b);
		stats.add(c);
		stats.add(d);
		stats.add(e);
		stats.add(f);
		stats.add(g);
		tester.setMalus(stats );
		Stats ris = tester.getMalus();
		
		assertEquals(stats.get(0), (long) ris.getWood());
		assertEquals(stats.get(1), (long) ris.getRock());
		assertEquals(stats.get(2), (long) ris.getCoin());
		assertEquals(stats.get(3), (long) ris.getServants());
		assertEquals(stats.get(4), (long) ris.getFP());
		assertEquals(stats.get(5), (long) ris.getMP());
		assertEquals(stats.get(6), (long) ris.getVP());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.excommEffects.MalusResources#getMalus()}.
	 */
	@Test
	public void testGetMalus() {
		MalusResources tester = new MalusResources();
		JSONArray stats = new JSONArray();
		long a = 1;
		long b = 1;
		long c = 1;
		long d = 1;
		long e = 1;
		long f = 1;
		long g = 1;
		stats.add(a);
		stats.add(b);
		stats.add(c);
		stats.add(d);
		stats.add(e);
		stats.add(f);
		stats.add(g);
		tester.setMalus(stats );
		Stats ris = tester.getMalus();
		
		assertEquals(stats.get(0), (long) ris.getWood());
		assertEquals(stats.get(1), (long) ris.getRock());
		assertEquals(stats.get(2), (long) ris.getCoin());
		assertEquals(stats.get(3), (long) ris.getServants());
		assertEquals(stats.get(4), (long) ris.getFP());
		assertEquals(stats.get(5), (long) ris.getMP());
		assertEquals(stats.get(6), (long) ris.getVP());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.excommEffects.MalusResources#getName()}.
	 */
	@Test
	public void testGetName() {
		MalusResources tester = new MalusResources();
		String ris = tester.getName();
		
		assertEquals("MalusResources", ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.excommEffects.MalusResources#toString()}.
	 */
	@Test
	public void testToString() {
		
		MalusResources tester = new MalusResources();
		JSONArray stats = new JSONArray();
		long a = 1;
		long b = 1;
		long c = 1;
		long d = 1;
		long e = 1;
		long f = 1;
		long g = 1;
		stats.add(a);
		stats.add(b);
		stats.add(c);
		stats.add(d);
		stats.add(e);
		stats.add(f);
		stats.add(g);
		tester.setMalus(stats );
		
		String ris = tester.toString();
		
		assertEquals("When you receive resources from an Action Space or a Card, reduce yout income by:\n-----------------\nWood: 1\nRock: 1\nCoin: 1\nServant: 1\nFP: 1\nMP: 1\nVP: 1\n-----------------\n",ris);
		
	}

}
