/**
 * 
 */
package it.polimi.ingsw.ps18.model.effect.generalEffects;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.gamelogic.Dice;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;
import it.polimi.ingsw.ps18.view.PBoardView;

/**
 * The Class PrivilegeTest.
 *
 * @author luca-grella
 */
public class PrivilegeTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.generalEffects.Privilege#activate(it.polimi.ingsw.ps18.model.personalboard.PBoard, it.polimi.ingsw.ps18.model.gamelogic.GameLogic)}.
	 */
	@Test
	public void testActivate() {
		Privilege tester = new Privilege();
		PBoard player = new PBoard();
		MainController mcontroller = new MainController();
		PBoardView pb = new PBoardView(mcontroller);
		player.setpBoardView(pb );
		Stats resources = new Stats(0,0,0,0,0,0,0);
		player.setResources(resources );
		
		List<Cards> BonusTiles = new ArrayList<>();
		List<Dice> dice = new ArrayList<>();
		Dice e = new Dice(4);
		dice.add(e );
		tester.activate(player, new GameLogic());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.generalEffects.Privilege#setQuantity(int)}.
	 */
	@Test
	public void testSetQuantity() {
		
		Privilege tester = new Privilege();
		int quantity = 5;
		tester.setQuantity(quantity);
		int ris = tester.getQuantity();
		
		assertEquals(quantity, ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.generalEffects.Privilege#toString()}.
	 */
	@Test
	public void testToString() {
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.generalEffects.Privilege#getName()}.
	 */
	@Test
	public void testGetName() {
		Privilege tester = new Privilege();
		String name = tester.getName();
		
		assertEquals("privilege", name);
	}

	/**
	 * Test method for {@link java.util.Observable#Observable()}.
	 */
	@Test
	public void testObservable() {
		
	}

	/**
	 * Test method for {@link java.util.Observable#addObserver(java.util.Observer)}.
	 */
	@Test
	public void testAddObserver() {
		
	}

	/**
	 * Test method for {@link java.util.Observable#deleteObserver(java.util.Observer)}.
	 */
	@Test
	public void testDeleteObserver() {
		
	}

	/**
	 * Test method for {@link java.util.Observable#notifyObservers()}.
	 */
	@Test
	public void testNotifyObservers() {
		
	}

	/**
	 * Test method for {@link java.util.Observable#notifyObservers(java.lang.Object)}.
	 */
	@Test
	public void testNotifyObserversObject() {
		
	}

	/**
	 * Test method for {@link java.util.Observable#deleteObservers()}.
	 */
	@Test
	public void testDeleteObservers() {
		
	}

	/**
	 * Test method for {@link java.util.Observable#setChanged()}.
	 */
	@Test
	public void testSetChanged() {
		
	}

	/**
	 * Test method for {@link java.util.Observable#clearChanged()}.
	 */
	@Test
	public void testClearChanged() {
		
	}

	/**
	 * Test method for {@link java.util.Observable#hasChanged()}.
	 */
	@Test
	public void testHasChanged() {
		
	}

	/**
	 * Test method for {@link java.util.Observable#countObservers()}.
	 */
	@Test
	public void testCountObservers() {
		
	}

}
