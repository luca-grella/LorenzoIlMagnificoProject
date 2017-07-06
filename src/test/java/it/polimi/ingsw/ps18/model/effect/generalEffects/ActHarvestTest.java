package it.polimi.ingsw.ps18.model.effect.generalEffects;
/**
 * 
 */

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import java.util.Vector;

import org.junit.Test;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.effect.generalEffects.ActHarvest;
import it.polimi.ingsw.ps18.model.gamelogic.Dice;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.view.PBoardView;

/**
 * @author luca-grella
 *
 */
public class ActHarvestTest {

	private static final List<Cards> BonusTiles = null;

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.generalEffects.ActHarvest#activate(it.polimi.ingsw.ps18.model.personalboard.PBoard, it.polimi.ingsw.ps18.model.gamelogic.GameLogic)}.
	 */
	@Test
	public void testActivate() {
		ActHarvest tester = new ActHarvest();
		PBoard player = new PBoard();
		List<FMember> fams = new ArrayList<>();
		FMember e = new FMember(3, 1);
		fams.add(e );
		player.setFams(fams );
		player.setPlayercol(2);
		List<Dice> dices = new ArrayList<>();
		MainController mcontroller = new MainController();
		List<Cards> bonustile = new ArrayList<>();
		player.completePBoardSetup(dices, mcontroller, bonustile );
		
		tester.setQuantity(1);
//		player.actHarvest();
//		tester.activate(player, new GameLogic());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.generalEffects.ActHarvest#setQuantity(int)}.
	 */
	@Test
	public void testSetQuantity() {
		
		ActHarvest tester = new ActHarvest();
		int quantity = 1;
		tester.setQuantity(quantity );
		
		assertEquals(quantity, tester.getQuantity());
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.generalEffects.ActHarvest#getName()}.
	 */
	@Test
	public void testGetName() {
		ActHarvest tester = new ActHarvest();
		String c = tester.getName();
		
		assertEquals("activate harvest", c);
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
