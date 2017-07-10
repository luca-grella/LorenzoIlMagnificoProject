/**
 * 
 */
package it.polimi.ingsw.ps18.model.effect.generalEffects;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import it.polimi.ingsw.ps18.model.gamelogic.Dice;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

/**
 * @author luca-grella
 *
 */
public class addWoodorRockTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.generalEffects.addWoodorRock#activate(it.polimi.ingsw.ps18.model.personalboard.PBoard, it.polimi.ingsw.ps18.model.gamelogic.GameLogic)}.
	 */
	@Test
	public void testActivate() {
		addWood tester = new addWood();
		tester.setQuantity(2);
		List<Dice> dices = new ArrayList<>(1);
		dices.add(new Dice(0));
		PBoard player = new PBoard(3, dices);
		Stats stats = player.getResources();
		int ris = stats.getWood();
		tester.activate(player, new GameLogic());
		int ris2 = stats.getWood();
		if(ris2!=ris + tester.getQuantity()){
			fail("Activate non funziona");
		}
		
		addRock tester2 = new addRock();
		tester2.setQuantity(2);
		List<Dice> dices2 = new ArrayList<>(1);
		dices.add(new Dice(0));
		PBoard player2 = new PBoard(3, dices2);
		Stats stats2 = player.getResources();
		int ris3 = stats2.getRock();
		tester2.activate(player, new GameLogic());
		int ris4 = stats2.getRock();
		if(ris4!=ris3 + tester.getQuantity()){
			fail("Activate non funziona");
		}
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.generalEffects.addWoodorRock#continueEffect(int, it.polimi.ingsw.ps18.model.personalboard.PBoard, it.polimi.ingsw.ps18.model.gamelogic.GameLogic)}.
	 */
	@Test
	public void testContinueEffect() {
		
		addWoodorRock tester = new addWoodorRock();
		PBoard player = new PBoard();
		int wood = 2;
		int rock = 2;
		Stats resources = new Stats(2 ,2 ,2,2,2,2,2);
		player.setResources(resources);
		
		int index = 1;
		tester.continueEffect(index , player, new GameLogic());
		int ris = player.getResources().getWood();
		int ris2 = player.getResources().getRock();
		
		assertEquals(wood, ris);
			
		index = 2;
		assertEquals(rock, ris2);
		
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.generalEffects.addWoodorRock#getQuantity()}.
	 */
	@Test
	public void testGetQuantity() {
		addWoodorRock tester = new addWoodorRock();
		int quantity = 45;
		tester.setQuantity(quantity );
		int ris =tester.getQuantity();
		
		assertEquals(quantity, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.generalEffects.addWoodorRock#setQuantity(int)}.
	 */
	@Test
	public void testSetQuantity() {
		addWoodorRock tester = new addWoodorRock();
		int quantity = 45;
		tester.setQuantity(quantity );
		int ris =tester.getQuantity();
		
		assertEquals(quantity, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.generalEffects.addWoodorRock#toString()}.
	 */
	@Test
	public void testToString() {
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.generalEffects.addWoodorRock#getName()}.
	 */
	@Test
	public void testGetName() {
		addWoodorRock tester = new addWoodorRock();
		String name = tester.getName();
		
		assertEquals("Wood or Rock", name);
	}

}
