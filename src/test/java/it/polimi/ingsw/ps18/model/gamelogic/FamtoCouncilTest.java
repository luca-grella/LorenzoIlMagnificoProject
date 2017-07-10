/**
 * 
 */
package it.polimi.ingsw.ps18.model.gamelogic;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.board.Board;
import it.polimi.ingsw.ps18.model.board.boardcells.CouncilCell;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;
import it.polimi.ingsw.ps18.view.MainView;
import it.polimi.ingsw.ps18.view.PBoardView;

/**
 * @author luca-grella
 *
 */
public class FamtoCouncilTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoCouncil#FamtoCouncil(it.polimi.ingsw.ps18.view.PBoardView)}.
	 */
	@Test
	public void testFamtoCouncil() {
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoCouncil#famchoice()}.
	 */
	@Test
	public void testFamchoice() {

		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoCouncil#servantsChoice(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)}.
	 */
	@Test
	public void testServantsChoice() {
//		MainController mc = new MainController();
//		PBoardView pbv = new PBoardView(mc );
//		FamtoCouncil tester = new FamtoCouncil(pbv );
//		tester.setNumberOfServants(1);
//		GameLogic game = new GameLogic();
//		PBoard turnplayer = new PBoard();
//		turnplayer.setResources(new Stats(2,2,2,2,2,2,2));
//		turnplayer.setpBoardView(pbv);
//		MainView mv = new MainView(mc);
//		
//		Board board = new Board(mc, 2, mv );
//		List<CouncilCell> councilCells = new ArrayList<>();
//		board.setCouncilCells(councilCells );
//		game.setBoard(board );
//		game.setCurrentPlayer(turnplayer );
//		tester.servantsChoice(game );
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoCouncil#act(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)}.
	 */
	@Test
	public void testAct() {
		MainController mc = new MainController();
		PBoardView pbv = new PBoardView(mc );
		FamtoCouncil tester = new FamtoCouncil(pbv );
		tester.setNumberOfServants(1);
		
		Dice dice = new Dice(4);
		FMember chosenFam = new FMember(dice ,3);
		tester.setIndexFamtoRemove(0);
		tester.setChosenFam(chosenFam );
		GameLogic game = new GameLogic();
		PBoard turnplayer = new PBoard();
		List<FMember> fams = new ArrayList<>();
		
		fams.add(chosenFam );
		Stats resources = new Stats(2,3,4,5,6,7,8);
		turnplayer.setResources(resources );
		turnplayer.setFams(fams );
		PBoardView pb = new PBoardView(mc);
		turnplayer.setpBoardView(pb );
		game.setCurrentPlayer(turnplayer );
		MainView mv = new MainView(mc);
		Board board = new Board(mc, 2, mv );
		List<CouncilCell> councilCells = new ArrayList<>();
		board.setCouncilCells(councilCells );
		game.setBoard(board );
//		tester.act(game );
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoCouncil#setChosenFam(it.polimi.ingsw.ps18.model.personalboard.FMember)}.
	 */
	@Test
	public void testSetChosenFam() {
		
		MainController mc = new MainController();
		PBoardView pbv = new PBoardView(mc );
		FamtoCouncil tester = new FamtoCouncil(pbv );
		
		Dice dice = new Dice(4);
		FMember chosenFam = new FMember(dice ,3);
		
		tester.setChosenFam(chosenFam);
		FMember ris = tester.getChosenFam();
		
		assertEquals(3, ris.getPlayercol());
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoCouncil#getNumberOfServants()}.
	 */
	@Test
	public void testGetNumberOfServants() {
		MainController mc = new MainController();
		PBoardView pbv = new PBoardView(mc );
		FamtoCouncil tester = new FamtoCouncil(pbv );
		
		int numberOfServants = 3;
		tester.setNumberOfServants(numberOfServants );
		int ris = tester.getNumberOfServants();
		
		assertEquals(numberOfServants, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoCouncil#setNumberOfServants(int)}.
	 */
	@Test
	public void testSetNumberOfServants() {
		MainController mc = new MainController();
		PBoardView pbv = new PBoardView(mc );
		FamtoCouncil tester = new FamtoCouncil(pbv );
		
		int numberOfServants = 3;
		tester.setNumberOfServants(numberOfServants );
		int ris = tester.getNumberOfServants();
		
		assertEquals(numberOfServants, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoCouncil#setIndexFamtoRemove(int)}.
	 */
	@Test
	public void testSetIndexFamtoRemove() {
		MainController mc = new MainController();
		PBoardView pbv = new PBoardView(mc );
		FamtoCouncil tester = new FamtoCouncil(pbv );
		
		tester.setIndexFamtoRemove(0);
		int ris = tester.getIndexFamtoRemove();
		
		assertEquals(0, ris);
	}

}
