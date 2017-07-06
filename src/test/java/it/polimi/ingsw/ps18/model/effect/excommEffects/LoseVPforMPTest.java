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
public class LoseVPforMPTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.excommEffects.LoseVPforMP#activate(it.polimi.ingsw.ps18.model.personalboard.PBoard)}.
	 */
	@Test
	public void testActivate() {
		LoseVPforMP tester = new LoseVPforMP();
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
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.excommEffects.LoseVPforMP#setQuantity(int)}.
	 */
	@Test
	public void testSetQuantity() {
		LoseVPforMP tester = new LoseVPforMP();
		int quantity=5;
		tester.setQuantity(quantity);
		int ris = tester.getQuantity(quantity);
		
		assertEquals(quantity, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.excommEffects.LoseVPforMP#setExcommParam(org.json.simple.JSONArray)}.
	 */
	@Test
	public void testSetExcommParam() {
		LoseVPforMP tester = new LoseVPforMP();
		JSONArray param = new JSONArray();
		long a = 20;
		long b = 3;
		param.add(a);
		param.add(b);
		tester.setExcommParam(param);
		long ris = tester.getHasMP();
		long ris2 = tester.getLoseVP();
		
		assertEquals(a, ris);
		assertEquals(b,ris2);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.excommEffects.LoseVPforMP#getName()}.
	 */
	@Test
	public void testGetName() {
		LoseVPforMP tester = new LoseVPforMP();
		String ris = tester.getName();
		
		assertEquals("LoseVPforMP", ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.excommEffects.LoseVPforMP#getHasMP()}.
	 */
	@Test
	public void testGetHasMP() {
		LoseVPforMP tester = new LoseVPforMP();
		JSONArray param = new JSONArray();
		long a = 20;
		long b = 3;
		param.add(a);
		param.add(b);
		tester.setExcommParam(param);
		long ris = tester.getHasMP();

		
		assertEquals(a, ris);

	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.excommEffects.LoseVPforMP#getLoseVP()}.
	 */
	@Test
	public void testGetLoseVP() {
		LoseVPforMP tester = new LoseVPforMP();
		JSONArray param = new JSONArray();
		long a = 20;
		long b = 3;
		param.add(a);
		param.add(b);
		tester.setExcommParam(param);
		long ris2 = tester.getLoseVP();
		
		assertEquals(b,ris2);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.excommEffects.LoseVPforMP#toString()}.
	 */
	@Test
	public void testToString() {
		
	}

}
