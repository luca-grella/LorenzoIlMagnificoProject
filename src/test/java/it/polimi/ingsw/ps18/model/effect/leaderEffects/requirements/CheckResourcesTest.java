/**
 * 
 */
package it.polimi.ingsw.ps18.model.effect.leaderEffects.requirements;

import static org.junit.Assert.*;

import org.json.simple.JSONArray;
import org.junit.Test;

import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

/**
 * @author luca-grella
 *
 */
public class CheckResourcesTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.leaderEffects.requirements.CheckResources#checkRequirement(it.polimi.ingsw.ps18.model.personalboard.PBoard)}.
	 */
	@Test
	public void testCheckRequirement() {
		
		CheckResources tester = new CheckResources();
		JSONArray minimum = new JSONArray();
		long a = 4;
		long b = 4;
		long c = 4;
		long d = 4;
		long e = 4;
		long f = 4;
		long g = 4;
		minimum.add(a);
		minimum.add(b);
		minimum.add(c);
		minimum.add(d);
		minimum.add(e);
		minimum.add(f);
		minimum.add(g);
		tester.setParam(minimum );
		PBoard player = new PBoard();
		Stats resources = new Stats(4,6,7,5,9,6,7);
		player.setResources(resources );
		
		boolean ris = tester.checkRequirement(player);
		
		assertTrue(ris);
		
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.leaderEffects.requirements.CheckResources#setParam(org.json.simple.JSONArray)}.
	 */
	@Test
	public void testSetParam() {
		CheckResources tester = new CheckResources();
		JSONArray minimum = new JSONArray();
		long a = 4;
		long b = 4;
		long c = 4;
		long d = 4;
		long e = 4;
		long f = 4;
		long g = 4;
		minimum.add(a);
		minimum.add(b);
		minimum.add(c);
		minimum.add(d);
		minimum.add(e);
		minimum.add(f);
		minimum.add(g);
		tester.setParam(minimum);
		
		Stats ris = tester.getParam();
		
		assertEquals(4, ris.getWood());
		assertEquals(4, ris.getRock());
		assertEquals(4, ris.getCoin());
		assertEquals(4, ris.getServants());
		assertEquals(4, ris.getFP());
		assertEquals(4, ris.getMP());
		assertEquals(4, ris.getVP());
		
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.leaderEffects.requirements.CheckResources#toString()}.
	 */
	@Test
	public void testToString() {
		
	}

}
