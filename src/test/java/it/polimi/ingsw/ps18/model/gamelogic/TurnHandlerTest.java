/**
 * 
 */
package it.polimi.ingsw.ps18.model.gamelogic;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;
import it.polimi.ingsw.ps18.view.PBoardView;

/**
 * @author luca-grella
 *
 */
public class TurnHandlerTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.TurnHandler#TurnHandler(it.polimi.ingsw.ps18.model.personalboard.PBoard)}.
	 */
	@Test
	public void testTurnHandler() {
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.TurnHandler#act(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)}.
	 */
	@Test
	public void testAct() {
		
		PBoard currentplayer = new PBoard();
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		currentplayer.setpBoardView(pb );
		Stats resources = new Stats(10,10,10,10,10,10,10);
		currentplayer.setResources(resources );
		currentplayer.setPlayercol(1);
		List<FMember> fams=new ArrayList<>();
		Dice dice = new Dice(4);
		FMember e = new FMember(dice , 4);
		e.setColor(0);
		fams.add(e );
		currentplayer.setFams(fams);
		TurnHandler tester = new TurnHandler(currentplayer);
		
		GameLogic game = new GameLogic();
		game.setCurrentPlayer(currentplayer);
//		tester.act(game );
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.TurnHandler#setChosenFam(it.polimi.ingsw.ps18.model.personalboard.FMember)}.
	 */
	@Test
	public void testSetChosenFam() {
		
		PBoard currentplayer = new PBoard();
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		currentplayer.setpBoardView(pb );
		Stats resources = new Stats(10,10,10,10,10,10,10);
		currentplayer.setResources(resources );
		currentplayer.setPlayercol(1);
		List<FMember> fams=new ArrayList<>();
		Dice dice = new Dice(4);
		FMember e = new FMember(dice , 4);
		e.setColor(0);
		fams.add(e );
		currentplayer.setFams(fams);
		TurnHandler tester = new TurnHandler(currentplayer);
		
		GameLogic game = new GameLogic();
		
		tester.setChosenFam(e);
		FMember ris = tester.getChosenFam(e);
		
		assertEquals(e, ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.TurnHandler#setNumberOfServants(int)}.
	 */
	@Test
	public void testSetNumberOfServants() {
		
		
		PBoard currentplayer = new PBoard();
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		currentplayer.setpBoardView(pb );
		Stats resources = new Stats(10,10,10,10,10,10,10);
		currentplayer.setResources(resources );
		currentplayer.setPlayercol(1);
		List<FMember> fams=new ArrayList<>();
		Dice dice = new Dice(4);
		FMember e = new FMember(dice , 4);
		e.setColor(0);
		fams.add(e );
		currentplayer.setFams(fams);
		TurnHandler tester = new TurnHandler(currentplayer);
		
		
		int numberOfServants = 5;
		tester.setNumberOfServants(numberOfServants);
		int ris = tester.getNumberOfServants(numberOfServants);
		
		assertEquals(numberOfServants, ris);
		
	}

}
