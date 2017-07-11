/**
 * 
 */
package it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.junit.Test;

import it.polimi.ingsw.ps18.model.gamelogic.Dice;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

/**
 * The Class ModifierValueTest.
 *
 * @author luca-grella
 */
public class ModifierValueTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects.ModifierValue#setParam(java.lang.String, int)}.
	 */
	@Test
	public void testSetParam() {
		ModifierValue tester = new ModifierValue();
		String shortDescription = "ok";
		long quantity = 1;
		JSONArray parameters = new JSONArray();
		parameters.add(shortDescription);
		parameters.add(quantity);
		tester.setParam(parameters);
		int ris = tester.getQuantity();
		String ris2 = tester.getShortDescription();
		
		assertEquals(shortDescription, ris2);
		assertEquals(quantity, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects.ModifierValue#getShortDescription()}.
	 */
	@Test
	public void testGetShortDescription() {
		ModifierValue tester = new ModifierValue();
		String shortDescription = "ok";
		long quantity = 1;
		JSONArray parameters = new JSONArray();
		parameters.add(shortDescription);
		parameters.add(quantity);
		tester.setParam(parameters);
		String ris = tester.getShortDescription();
		
		assertEquals(shortDescription, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects.ModifierValue#toString()}.
	 */
	@Test
	public void testToString() {
		ModifierValue tester = new ModifierValue();
		tester.setQuantity(1);
		String shortDescription = "BonusDiceValue";
		tester.setShortDescription(shortDescription);
		tester.toString();
		shortDescription = "BonusNeutralFam";
		tester.setShortDescription(shortDescription);
		tester.toString();
		shortDescription = "BonusNeutralFam";
		tester.setShortDescription(shortDescription);
		tester.toString();

	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects.ModifierValue#getQuantity()}.
	 */
	@Test
	public void testGetQuantity() {
		ModifierValue tester = new ModifierValue();
		String shortDescription = "ok";
		long quantity = 1;
		JSONArray parameters = new JSONArray();
		parameters.add(shortDescription);
		parameters.add(quantity);
		tester.setParam(parameters);
		int ris = tester.getQuantity();
		
		assertEquals(quantity, ris);
	}
	
	/**
	 * Test set short description.
	 */
	@Test
	public void testSetShortDescription() {
		ModifierValue tester = new ModifierValue();
		String shortDescription = "ok";

		tester.setShortDescription(shortDescription);
		String ris = tester.getShortDescription();
		
		assertEquals(shortDescription, ris);
	}
	
	/**
	 * Test set quantity.
	 */
	@Test
	public void testSetQuantity() {
		ModifierValue tester = new ModifierValue();
		
		int quantity = 1;
		
		tester.setQuantity(quantity);
		int ris = tester.getQuantity();
		
		assertEquals(quantity, ris);
	}
	
	/**
	 * Test refresh.
	 */
	@Test
	public void testRefresh() {
		ModifierValue tester = new ModifierValue();
		
		GameLogic game = new GameLogic();
		PBoard turnplayer = new PBoard();
		List<FMember> fams = new ArrayList<>();
		Dice dice = new Dice(3);
		FMember e = new FMember(dice , 0);
		fams.add(e );
		turnplayer.setFams(fams );
		game.setCurrentPlayer(turnplayer );
		tester.refreshFMember(game);
	}

}
