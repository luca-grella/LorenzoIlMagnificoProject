/**
 * 
 */
package it.polimi.ingsw.ps18.controller.controlleractions;

import static org.junit.Assert.*;

import org.junit.Test;

import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

/**
 * The Class ReceiveBonusTileTest.
 *
 * @author luca-grella
 */
public class ReceiveBonusTileTest {
	
	/** The ris. */
	boolean ris=true;
	/**
	 * Test method for {@link it.polimi.ingsw.ps18.controller.controlleractions.ReceiveBonusTile#act(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)}.
	 */
	@Test
	public void testAct() {
		
		ReceiveBonusTile tester = new ReceiveBonusTile();
		GameLogic game = new GameLogic();
		PBoard turnplayer = new PBoard();
		turnplayer.setPlayercol(1);
		game.setCurrentPlayer(turnplayer );
		PBoard currentplayer = game.getTurnplayer();
		tester.setIndex(1);

		tester.act(game);

		assertTrue(ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.controller.controlleractions.ReceiveBonusTile#setIndex(int)}.
	 */
	@Test
	public void testSetIndex() {
		ReceiveBonusTile tester = new ReceiveBonusTile();
		int i = 2;
		tester.setIndex(i );
		
		assertEquals(i, tester.getIndex());
	}

}
