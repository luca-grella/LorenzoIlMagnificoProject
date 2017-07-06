/**
 * 
 */
package it.polimi.ingsw.ps18.model.effect.excommEffects;

import static org.junit.Assert.*;

import org.json.simple.JSONArray;
import org.junit.Test;

import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

/**
 * @author luca-grella
 *
 */
public class LoseVPforVPTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.excommEffects.LoseVPforVP#activate(it.polimi.ingsw.ps18.model.personalboard.PBoard)}.
	 */
	@Test
	public void testActivate() {
		LoseVPforVP tester = new LoseVPforVP();
		JSONArray param = new JSONArray();
		long a = 20;
		long b = 3;
		param.add(a);
		param.add(b);
		tester.setExcommParam(param);
		
		PBoard player = new PBoard();
		Stats resources = new Stats(20,20,20,20,20,20,20);
		player.setResources(resources );
		tester.activate(player );
		Stats ris = player.getResources();
		
		assertEquals(a-b, ris.getVP());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.excommEffects.LoseVPforVP#setQuantity(int)}.
	 */
	@Test
	public void testSetQuantity() {
		LoseVPforVP tester = new LoseVPforVP();
		int quantity = 3;
		tester.setQuantity(quantity);
		int ris = tester.getQuantity(quantity);
		
		assertEquals(quantity, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.excommEffects.LoseVPforVP#setExcommParam(org.json.simple.JSONArray)}.
	 */
	@Test
	public void testSetExcommParam() {
		LoseVPforVP tester = new LoseVPforVP();
		JSONArray param = new JSONArray();
		long a = 10;
		long b = 4;
		param.add(a);
		param.add(b);
		tester.setExcommParam(param);
		
		PBoard player = new PBoard();
		int vp = 20;
		Stats resources = new Stats(20,20,20,20,20,20,vp );
		player.setResources(resources );
		tester.activate(player );
		Stats ris = player.getResources();
		
		assertEquals((vp/a)*b, vp-(ris.getVP()));
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.excommEffects.LoseVPforVP#getName()}.
	 */
	@Test
	public void testGetName() {
		LoseVPforVP tester = new LoseVPforVP();
		String ris = tester.getName();
		
		assertEquals("LoseVPforVP", ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.excommEffects.LoseVPforVP#getHasVP()}.
	 */
	@Test
	public void testGetHasVP() {
		LoseVPforVP tester = new LoseVPforVP();
		JSONArray param = new JSONArray();
		long a = 10;
		long b = 4;
		param.add(a);
		param.add(b);
		tester.setExcommParam(param);
		
		long ris = tester.getHasVP();
		
		assertEquals(a, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.excommEffects.LoseVPforVP#getLoseVP()}.
	 */
	@Test
	public void testGetLoseVP() {
		LoseVPforVP tester = new LoseVPforVP();
		JSONArray param = new JSONArray();
		long a = 10;
		long b = 4;
		param.add(a);
		param.add(b);
		tester.setExcommParam(param);
		
		long ris = tester.getLoseVP();
		
		assertEquals(b, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.excommEffects.LoseVPforVP#toString()}.
	 */
	@Test
	public void testToString() {
		
	}

}
