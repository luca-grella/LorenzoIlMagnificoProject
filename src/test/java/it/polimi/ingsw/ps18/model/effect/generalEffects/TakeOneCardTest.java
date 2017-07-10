/**
 * 
 */
package it.polimi.ingsw.ps18.model.effect.generalEffects;

import static org.junit.Assert.*;

import org.json.simple.JSONArray;
import org.junit.Test;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;
import it.polimi.ingsw.ps18.view.PBoardView;

/**
 * @author luca-grella
 *
 */
public class TakeOneCardTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.generalEffects.TakeOneCard#activate(it.polimi.ingsw.ps18.model.personalboard.PBoard, it.polimi.ingsw.ps18.model.gamelogic.GameLogic)}.
	 */
	@Test
	public void testActivate() {
		
		TakeOneCard tester = new TakeOneCard();
		GameLogic game = new GameLogic();
		PBoard player = new PBoard();
		MainController mc = new MainController();
		PBoardView pbv = new PBoardView(mc );
		player.setpBoardView(pbv );
		tester.setChosenTower(0);
		tester.setDiscount(new Stats(3,3,3,3,3,3,3));
		tester.setTester(999);
		tester.activate(player , game );
		
	}
	
	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.generalEffects.TakeOneCard#activate(it.polimi.ingsw.ps18.model.personalboard.PBoard, it.polimi.ingsw.ps18.model.gamelogic.GameLogic)}.
	 */
	@Test
	public void testActivate2() {
		
		TakeOneCard tester = new TakeOneCard();
		GameLogic game = new GameLogic();
		PBoard player = new PBoard();
		MainController mc = new MainController();
		PBoardView pbv = new PBoardView(mc );
		player.setpBoardView(pbv );
		tester.setChosenTower(-1);
		tester.setDiscount(new Stats(3,3,3,3,3,3,3));
		tester.setTester(999);
		tester.activate(player , game );
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.generalEffects.TakeOneCard#setQuantity(int)}.
	 */
	@Test
	public void testSetQuantity() {
		TakeOneCard tester = new TakeOneCard();
		int quantity = 2;
		tester.setQuantity(quantity);
		int ris = tester.getQuantity(quantity);
		
		assertEquals(quantity, ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.generalEffects.TakeOneCard#setParameters(long, java.lang.String, org.json.simple.JSONArray)}.
	 */
	@Test
	public void testSetParameters() {
		TakeOneCard tester = new TakeOneCard();
		long actionValue = 1;
		String chosenTower = "Green";
		JSONArray discount = new JSONArray();
		long a=1;
		long b=1;
		long c=1;
		long d=1;
		long e=1;
		long f=1;
		long g=1;
		discount.add(a);
		discount.add(b);
		discount.add(c);
		discount.add(d);
		discount.add(e);
		discount.add(f);
		discount.add(g);
		tester.setParameters(actionValue, chosenTower, discount);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.generalEffects.TakeOneCard#getName()}.
	 */
	@Test
	public void testGetName() {
		TakeOneCard tester = new TakeOneCard();
		String name = tester.getName();
		
		assertEquals("Take one Card", name);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.generalEffects.TakeOneCard#toString()}.
	 */
	@Test
	public void testToString() {
		
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
