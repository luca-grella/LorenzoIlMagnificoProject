/**
 * 
 */
package it.polimi.ingsw.ps18.controller.controlleractions;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.ShowBoard;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;
import it.polimi.ingsw.ps18.view.PBoardView;

/**
 * @author luca-grella
 *
 */
public class ChosePlayerTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.controller.controlleractions.ChoosePlayer#act(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)}.
	 */
	@Test
	public void testAct() {
		
		ChoosePlayer tester = new ChoosePlayer();
		
		GameLogic game = new GameLogic();
		game.setNplayer(2);
		
		PBoard turnplayer = new PBoard();
		turnplayer.setPlayercol(1);
		List<Cards> cards = null;
		turnplayer.setCards(cards);
		List<FMember> fams = new ArrayList<>();
		FMember e = new FMember(4, 1, turnplayer);
		fams.add(e );
		turnplayer.setFams(fams);
		Stats resources = new Stats(0,0,0,0,0,0,0);
		turnplayer.setResources(resources );
		MainController mcontroller = new MainController();
		PBoardView ciao = new PBoardView(mcontroller );
		turnplayer.setpBoardView(ciao );
		PBoardView ris = turnplayer.getpBoardView();
	
		game.setCurrentPlayer(turnplayer );
		ShowBoard ris2 = new ShowBoard(ris);
//		ris2.choosePlayer();
		
		tester.setIndex(1);
//		tester.act(game);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.controller.controlleractions.ChoosePlayer#setIndex(int)}.
	 */
	@Test
	public void testSetIndex() {
		ChoosePlayer tester = new ChoosePlayer();
		int i =1;
		tester.setIndex(i );
		
		assertEquals(i, tester.getIndex());
	}

}
