/**
 * 
 */
package it.polimi.ingsw.ps18.view;

import static org.junit.Assert.*;

import org.junit.Test;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.messagesandlogs.LogMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.Message;

/**
 * The Class MainViewTest.
 *
 * @author luca-grella
 */
public class MainViewTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.view.MainView#MainView(it.polimi.ingsw.ps18.controller.MainController)}.
	 */
	@Test
	public void testMainView() {
		MainController mcontroller = new MainController();
		
		MainView tester = new MainView(mcontroller);
		
		tester.addObserver(mcontroller);
		
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.view.MainView#update(java.util.Observable, java.lang.Object)}.
	 */
	@Test
	public void testUpdate() {
		
		MainController mcontroller = new MainController();
		
		MainView tester = new MainView(mcontroller);
		
		tester.addObserver(mcontroller);
		
		
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
