/**
 * 
 */
package it.polimi.ingsw.ps18.view.pboardviewactions.effectresoution;

import static org.junit.Assert.*;

import java.util.Observable;
import java.util.Observer;

import org.junit.Test;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage;
import it.polimi.ingsw.ps18.view.pboardviewactions.effectresolution.ActHarvestwithParameter;

/**
 * @author luca-grella
 *
 */
public class ActHarvestwithParameterTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.view.pboardviewactions.effectresoution.ActHarvestwithParameter#ActHarvestwithParameter(it.polimi.ingsw.ps18.controller.MainController)}.
	 */
	@Test
	public void testActHarvestwithParameter() {
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.view.pboardviewactions.effectresoution.ActHarvestwithParameter#act()}.
	 */
	@Test
	public void testAct() {
		
//		MainController mcontroller = new MainController();
//		MainController mcontroller1 = new MainController();
//		
//		mcontroller.update(o, arg);
//		ActHarvestwithParameter tester = new ActHarvestwithParameter(mcontroller);
//		
//		tester.addObserver(mcontroller);
//		tester.deleteObserver(mcontroller);
//		tester.addObserver(mcontroller1);
//		tester.hasChanged();
//		tester.notifyObservers(new ParamMessage("actHarvest", 1));
//		
//		tester.act();
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.view.pboardviewactions.effectresoution.ActHarvestwithParameter#setIndex(int)}.
	 */
	@Test
	public void testSetIndex() {
		MainController mcontroller = new MainController();
		
		ActHarvestwithParameter tester = new ActHarvestwithParameter(mcontroller );
		int number = 23;
		tester.setIndex(number);
		
		assertEquals(number, tester.getIndex());
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
