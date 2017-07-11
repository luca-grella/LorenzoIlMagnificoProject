/**
 * 
 */
package it.polimi.ingsw.ps18.controller.controlleractions;

import static org.junit.Assert.*;

import org.junit.Test;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoCouncil;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoMarket;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.view.PBoardView;

/**
 * The Class ReceiveServantsTest.
 *
 * @author luca-grella
 */
public class ReceiveServantsTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.controller.controlleractions.ReceiveServants#act(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)}.
	 */
	@Test
	public void testAct() {
		int servants = 9;
		ReceiveServants tester = new ReceiveServants();
		tester.setIndex(servants);
		GameLogic game = new GameLogic();
		MainController mcontroller = new MainController();
		PBoardView view = new PBoardView(mcontroller );
		Action currentaction = new FamtoMarket(view );
		
		currentaction.setNumberOfServants(servants );
		game.setOngoingAction(currentaction);
		
		tester.act(game );
		int ris = ((FamtoMarket) currentaction).getNumberOfServants();
		
	    assertEquals(servants, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.controller.controlleractions.ReceiveServants#setIndex(int)}.
	 */
	@Test
	public void testSetIndex() {
		ReceiveServants tester = new ReceiveServants();
		int i = 9;
		tester.setIndex(i );
		
		assertEquals(i, tester.getIndex());
	}

}
