/**
 * 
 */
package it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects;

import static org.junit.Assert.*;

import org.json.simple.JSONArray;
import org.junit.Test;

import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

/**
 * The Class TowerDiscountTest.
 *
 * @author luca-grella
 */
public class TowerDiscountTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects.TowerDiscount#getDiscount()}.
	 */
	@Test
	public void testGetDiscount() {
		TowerDiscount tester = new TowerDiscount();
		Stats baseDiscount = new Stats(2,2,2,2,2,2,2);
		JSONArray discount = new JSONArray();
		discount.add((long) 2);
		discount.add((long) 2);
		discount.add((long) 2);
		discount.add((long) 2);
		discount.add((long) 2);
		discount.add((long) 2);
		discount.add((long) 2);
		tester.setParam(discount);
		Stats ris = tester.getDiscount();
		
		assertEquals(baseDiscount.getWood(), ris.getWood());
		assertEquals(baseDiscount.getRock(), ris.getRock());
		assertEquals(baseDiscount.getCoin(), ris.getCoin());
		assertEquals(baseDiscount.getServants(), ris.getServants());
		assertEquals(baseDiscount.getFP(), ris.getFP());
		assertEquals(baseDiscount.getMP(), ris.getMP());
		assertEquals(baseDiscount.getVP(), ris.getVP());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects.TowerDiscount#setParam(it.polimi.ingsw.ps18.model.personalboard.resources.Stats)}.
	 */
	@Test
	public void testSetParam() {
		TowerDiscount tester = new TowerDiscount();
		Stats baseDiscount = new Stats(2,2,2,2,2,2,2);
		JSONArray discount = new JSONArray();
		discount.add((long) 2);
		discount.add((long) 2);
		discount.add((long) 2);
		discount.add((long) 2);
		discount.add((long) 2);
		discount.add((long) 2);
		discount.add((long) 2);
		tester.setParam(discount );
		Stats ris = tester.getDiscount();
		
		assertEquals(baseDiscount.getWood(), ris.getWood());
		assertEquals(baseDiscount.getRock(), ris.getRock());
		assertEquals(baseDiscount.getCoin(), ris.getCoin());
		assertEquals(baseDiscount.getServants(), ris.getServants());
		assertEquals(baseDiscount.getFP(), ris.getFP());
		assertEquals(baseDiscount.getMP(), ris.getMP());
		assertEquals(baseDiscount.getVP(), ris.getVP());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects.TowerDiscount#toString()}.
	 */
	@Test
	public void testToString() {
		TowerDiscount tester = new TowerDiscount();
		JSONArray discount = new JSONArray();
		long a = 1;
		long b = 1;
		long c = 1;
		long d = 1;
		long e = 1;
		long f = 1;
		long g = 1;
		discount.add(a );
		discount.add(b );
		discount.add(c );
		discount.add(d );
		discount.add(e );
		discount.add(f );
		discount.add(g );
		tester.setParam(discount );
		tester.toString();
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects.TowerDiscount#getShortDescription()}.
	 */
	@Test
	public void testGetShortDescription() {
		TowerDiscount tester = new TowerDiscount();
		String ris = tester.getShortDescription();
		
		assertEquals("TowerDiscount", ris);
	}
	
	/**
	 * Test get name.
	 */
	@Test
	public void testGetName() {
		TowerDiscount tester = new TowerDiscount();
		
		
		assertEquals("TowerDiscount", tester.getName());
	}
	


}
