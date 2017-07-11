/**
 * 
 */
package it.polimi.ingsw.ps18.model.effect.generalEffects;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.json.simple.JSONArray;
import org.junit.Test;

import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.gamelogic.Dice;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

/**
 * The Class AddVPforMPTest.
 *
 * @author luca-grella
 */
public class AddVPforMPTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.generalEffects.AddVPforMP#activate(it.polimi.ingsw.ps18.model.personalboard.PBoard, it.polimi.ingsw.ps18.model.gamelogic.GameLogic)}.
	 */
	@Test
	public void testActivate() {
		
		
		AddVPforMP tester = new AddVPforMP();
		
		JSONArray count = new JSONArray();
		long vp = 5;
		long mp = 10;
		count.add(vp);
		count.add(mp);
		tester.setQuantity(count );
		
		
		PBoard player = new PBoard();
		int vpplayer = 20;
		int vptot = (int) ((vpplayer/mp) * vp);
		Stats resources = new Stats(20, 20, 20, 20, 20, 20, vpplayer );
		player.setResources(resources );
		int in = player.getResources().getVP();
		tester.activate(player , new GameLogic());
		int out = player.getResources().getVP();
		
		assertEquals(in + vptot, out);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.generalEffects.AddVPforMP#setQuantity(int)}.
	 */
	@Test
	public void testSetQuantityInt() {
		
		AddVPforMP tester = new AddVPforMP();
		int quantity = 5;
		tester.setQuantity(quantity );
		int ris = tester.getQuantity(quantity);
		
		assertEquals(quantity, ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.generalEffects.AddVPforMP#setQuantity(org.json.simple.JSONArray)}.
	 */
	@Test
	public void testSetQuantityJSONArray() {
		
		AddVPforMP tester = new AddVPforMP();
		JSONArray count = new JSONArray();
		long a = 2;
		count.add(a);
		long b = 4;
		count.add(b);
		tester.setQuantity(count);
		JSONArray ris = tester.getQuantity(count);
		
		assertEquals(count, ris);
		
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.generalEffects.AddVPforMP#getName()}.
	 */
	@Test
	public void testGetName() {
		
		AddVPforMP tester = new AddVPforMP();
		String name = tester.getName();
		
		assertEquals("GainVPforMP", name);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.generalEffects.AddVPforMP#toString()}.
	 */
	@Test
	public void testToString() {
		
	}

}
