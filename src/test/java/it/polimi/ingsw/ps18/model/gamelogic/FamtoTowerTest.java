/**
 * 
 */
package it.polimi.ingsw.ps18.model.gamelogic;

import static org.junit.Assert.*;

import org.junit.Test;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.board.Board;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;
import it.polimi.ingsw.ps18.view.MainView;
import it.polimi.ingsw.ps18.view.PBoardView;

/**
 * @author luca-grella
 *
 */
public class FamtoTowerTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoTower#FamtoTower(it.polimi.ingsw.ps18.view.PBoardView)}.
	 */
	@Test
	public void testFamtoTower() {
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoTower tester = new FamtoTower(pb);
		boolean canGoBacktoFamChoice = true;
		tester.setCanGoBacktoFamChoice(canGoBacktoFamChoice);
		boolean canGoBacktoTowerChoice = true;
		tester.setCanGoBacktoTowerChoice(canGoBacktoTowerChoice);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoTower#famchoice()}.
	 */
	@Test
	public void testFamchoice() {
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoTower tester = new FamtoTower(pb);
//		tester.famchoice();
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoTower#towerChoice()}.
	 */
	@Test
	public void testTowerChoice() {
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoTower tester = new FamtoTower(pb);
//		tester.towerchoice();
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoTower#floorChoice(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)}.
	 */
	@Test
	public void testFloorChoice() {
		
		
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoTower tester = new FamtoTower(pb);
		GameLogic game = new GameLogic();
		PBoard turnplayer = new PBoard();
		turnplayer.setpBoardView(pb);
		MainView mv = new MainView(mc);
		Board board= new Board(mc, 2, mv );
		game.setBoard(board);
		game.setCurrentPlayer(turnplayer );
		
		
		tester.setChosenTower(0);
//		tester.floorChoice(game );
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoTower#costChoice()}.
	 */
	@Test
	public void testCostChoice() {
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoTower tester = new FamtoTower(pb);
//		tester.costChoice();
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoTower#act(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)}.
	 */
	@Test
	public void testAct() {
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoTower tester = new FamtoTower(pb);
		GameLogic game = new GameLogic();
		PBoard turnplayer = new PBoard();
		turnplayer.setpBoardView(pb);
		MainView mv = new MainView(mc);
		Board board= new Board(mc, 2, mv );
		game.setBoard(board);
		game.setCurrentPlayer(turnplayer );
		
		
		tester.setChosenTower(0);
//		tester.act(game);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoTower#getChosenFam()}.
	 */
	@Test
	public void testGetChosenFam() {
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoTower tester = new FamtoTower(pb);
		GameLogic game = new GameLogic();
		PBoard turnplayer = new PBoard();
		turnplayer.setpBoardView(pb);
		MainView mv = new MainView(mc);
		Board board= new Board(mc, 2, mv );
		game.setBoard(board);
		game.setCurrentPlayer(turnplayer );
		
		
		Dice dice = new Dice(3);
		FMember chosenFam = new FMember(dice , 3);
		tester.setChosenFam(chosenFam );
		FMember ris = tester.getChosenFam();
		
		assertEquals(chosenFam, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoTower#setChosenFam(it.polimi.ingsw.ps18.model.personalboard.FMember)}.
	 */
	@Test
	public void testSetChosenFam() {
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoTower tester = new FamtoTower(pb);
		GameLogic game = new GameLogic();
		PBoard turnplayer = new PBoard();
		turnplayer.setpBoardView(pb);
		MainView mv = new MainView(mc);
		Board board= new Board(mc, 2, mv );
		game.setBoard(board);
		game.setCurrentPlayer(turnplayer );
		
		
		Dice dice = new Dice(3);
		FMember chosenFam = new FMember(dice , 3);
		tester.setChosenFam(chosenFam );
		FMember ris = tester.getChosenFam();
		
		assertEquals(chosenFam, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoTower#getChosenTower()}.
	 */
	@Test
	public void testGetChosenTower() {
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoTower tester = new FamtoTower(pb);
		GameLogic game = new GameLogic();
		PBoard turnplayer = new PBoard();
		turnplayer.setpBoardView(pb);
		MainView mv = new MainView(mc);
		Board board= new Board(mc, 2, mv );
		game.setBoard(board);
		game.setCurrentPlayer(turnplayer );
		
		int chosenTower = 3;
		tester.setChosenTower(chosenTower );
		int ris = tester.getChosenTower();
		
		assertEquals(chosenTower, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoTower#setChosenTower(int)}.
	 */
	@Test
	public void testSetChosenTower() {
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoTower tester = new FamtoTower(pb);
		GameLogic game = new GameLogic();
		PBoard turnplayer = new PBoard();
		turnplayer.setpBoardView(pb);
		MainView mv = new MainView(mc);
		Board board= new Board(mc, 2, mv );
		game.setBoard(board);
		game.setCurrentPlayer(turnplayer );
		
		int chosenTower = 3;
		tester.setChosenTower(chosenTower );
		int ris = tester.getChosenTower();
		
		assertEquals(chosenTower, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoTower#getChosenFloor()}.
	 */
	@Test
	public void testGetChosenFloor() {
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoTower tester = new FamtoTower(pb);
		GameLogic game = new GameLogic();
		PBoard turnplayer = new PBoard();
		turnplayer.setpBoardView(pb);
		MainView mv = new MainView(mc);
		Board board= new Board(mc, 2, mv );
		game.setBoard(board);
		game.setCurrentPlayer(turnplayer );
		
		int chosenFloor = 3;
		tester.setChosenFloor(chosenFloor);
		int ris = tester.getChosenFloor();
		
		assertEquals(chosenFloor, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoTower#setChosenFloor(int)}.
	 */
	@Test
	public void testSetChosenFloor() {
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoTower tester = new FamtoTower(pb);
		GameLogic game = new GameLogic();
		PBoard turnplayer = new PBoard();
		turnplayer.setpBoardView(pb);
		MainView mv = new MainView(mc);
		Board board= new Board(mc, 2, mv );
		game.setBoard(board);
		game.setCurrentPlayer(turnplayer );
		
		int chosenFloor = 3;
		tester.setChosenFloor(chosenFloor);
		int ris = tester.getChosenFloor();
		
		assertEquals(chosenFloor, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoTower#getTotalCostPreview()}.
	 */
	@Test
	public void testGetTotalCostPreview() {
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoTower tester = new FamtoTower(pb);
		GameLogic game = new GameLogic();
		PBoard turnplayer = new PBoard();
		turnplayer.setpBoardView(pb);
		MainView mv = new MainView(mc);
		Board board= new Board(mc, 2, mv );
		game.setBoard(board);
		game.setCurrentPlayer(turnplayer );
		
		Stats totalCostPreview = new Stats(2,3,4,5,6,7,8);
		tester.setTotalCostPreview(totalCostPreview );
		Stats ris = tester.getTotalCostPreview();
		
		assertEquals(totalCostPreview, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoTower#setTotalCostPreview(it.polimi.ingsw.ps18.model.personalboard.resources.Stats)}.
	 */
	@Test
	public void testSetTotalCostPreview() {
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoTower tester = new FamtoTower(pb);
		GameLogic game = new GameLogic();
		PBoard turnplayer = new PBoard();
		turnplayer.setpBoardView(pb);
		MainView mv = new MainView(mc);
		Board board= new Board(mc, 2, mv );
		game.setBoard(board);
		game.setCurrentPlayer(turnplayer );
		
		Stats totalCostPreview = new Stats(2,3,4,5,6,7,8);
		tester.setTotalCostPreview(totalCostPreview );
		Stats ris = tester.getTotalCostPreview();
		
		assertEquals(totalCostPreview, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoTower#setIndexFamtoRemove(int)}.
	 */
	@Test
	public void testSetIndexFamtoRemove() {
		
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoTower tester = new FamtoTower(pb);
		GameLogic game = new GameLogic();
		PBoard turnplayer = new PBoard();
		turnplayer.setpBoardView(pb);
		MainView mv = new MainView(mc);
		Board board= new Board(mc, 2, mv );
		game.setBoard(board);
		game.setCurrentPlayer(turnplayer );

		int indexFamtoRemove = 3;
		tester.setIndexFamtoRemove(indexFamtoRemove );
		int ris = tester.getIndexFamtoRemove();
		
		assertEquals(indexFamtoRemove, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoTower#getCostchoice()}.
	 */
	@Test
	public void testGetCostchoice() {
		
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoTower tester = new FamtoTower(pb);
		GameLogic game = new GameLogic();
		PBoard turnplayer = new PBoard();
		turnplayer.setpBoardView(pb);
		MainView mv = new MainView(mc);
		Board board= new Board(mc, 2, mv );
		game.setBoard(board);
		game.setCurrentPlayer(turnplayer );

		int costchoice = 2;
		tester.setCostchoice(costchoice );
		int ris = tester.getCostchoice();
		
		assertEquals(costchoice, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoTower#setCostchoice(int)}.
	 */
	@Test
	public void testSetCostchoice() {
		
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoTower tester = new FamtoTower(pb);
		GameLogic game = new GameLogic();
		PBoard turnplayer = new PBoard();
		turnplayer.setpBoardView(pb);
		MainView mv = new MainView(mc);
		Board board= new Board(mc, 2, mv );
		game.setBoard(board);
		game.setCurrentPlayer(turnplayer );

		int costchoice = 2;
		tester.setCostchoice(costchoice );
		int ris = tester.getCostchoice();
		
		assertEquals(costchoice, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoTower#isCanGoBacktoFamChoice()}.
	 */
	@Test
	public void testIsCanGoBacktoFamChoice() {
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoTower tester = new FamtoTower(pb);
		GameLogic game = new GameLogic();
		PBoard turnplayer = new PBoard();
		turnplayer.setpBoardView(pb);
		MainView mv = new MainView(mc);
		Board board= new Board(mc, 2, mv );
		game.setBoard(board);
		game.setCurrentPlayer(turnplayer );
		
		tester.setCanGoBacktoFamChoice(true);

		assertTrue(tester.isCanGoBacktoFamChoice());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoTower#setCanGoBacktoFamChoice(boolean)}.
	 */
	@Test
	public void testSetCanGoBacktoFamChoice() {
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoTower tester = new FamtoTower(pb);
		GameLogic game = new GameLogic();
		PBoard turnplayer = new PBoard();
		turnplayer.setpBoardView(pb);
		MainView mv = new MainView(mc);
		Board board= new Board(mc, 2, mv );
		game.setBoard(board);
		game.setCurrentPlayer(turnplayer );
		
		boolean choice = true;
		tester.setCanGoBacktoFamChoice(choice);
		assertTrue(tester.isCanGoBacktoFamChoice());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoTower#isCanGoBacktoTowerChoice()}.
	 */
	@Test
	public void testIsCanGoBacktoTowerChoice() {
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoTower tester = new FamtoTower(pb);
		GameLogic game = new GameLogic();
		PBoard turnplayer = new PBoard();
		turnplayer.setpBoardView(pb);
		MainView mv = new MainView(mc);
		Board board= new Board(mc, 2, mv );
		game.setBoard(board);
		game.setCurrentPlayer(turnplayer );
		
		tester.setCanGoBacktoTowerChoice(true);

		assertTrue(tester.isCanGoBacktoTowerChoice());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoTower#setCanGoBacktoTowerChoice(boolean)}.
	 */
	@Test
	public void testSetCanGoBacktoTowerChoice() {
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoTower tester = new FamtoTower(pb);
		GameLogic game = new GameLogic();
		PBoard turnplayer = new PBoard();
		turnplayer.setpBoardView(pb);
		MainView mv = new MainView(mc);
		Board board= new Board(mc, 2, mv );
		game.setBoard(board);
		game.setCurrentPlayer(turnplayer );
		
		boolean choice = true;
		tester.setCanGoBacktoTowerChoice(choice);
		assertTrue(tester.isCanGoBacktoTowerChoice());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoTower#getTotalDiscountPreview()}.
	 */
	@Test
	public void testGetTotalDiscountPreview() {
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoTower tester = new FamtoTower(pb);
		GameLogic game = new GameLogic();
		PBoard turnplayer = new PBoard();
		turnplayer.setpBoardView(pb);
		MainView mv = new MainView(mc);
		Board board= new Board(mc, 2, mv );
		game.setBoard(board);
		game.setCurrentPlayer(turnplayer );
		
		Stats totalDiscountPreview = new Stats(2,4,3,7,4,1,7);
		tester.setTotalDiscountPreview(totalDiscountPreview);
		Stats ris = tester.getTotalDiscountPreview();
		
		assertEquals(totalDiscountPreview, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoTower#getNumberOfServants()}.
	 */
	@Test
	public void testGetNumberOfServants() {
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoTower tester = new FamtoTower(pb);
		GameLogic game = new GameLogic();
		PBoard turnplayer = new PBoard();
		turnplayer.setpBoardView(pb);
		MainView mv = new MainView(mc);
		Board board= new Board(mc, 2, mv );
		game.setBoard(board);
		game.setCurrentPlayer(turnplayer );
		
		int numberOfServants = 4;
		tester.setNumberOfServants(numberOfServants );
		int ris = tester.getNumberOfServants();
		
		assertEquals(numberOfServants, ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoTower#setNumberOfServants(int)}.
	 */
	@Test
	public void testSetNumberOfServants() {
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoTower tester = new FamtoTower(pb);
		GameLogic game = new GameLogic();
		PBoard turnplayer = new PBoard();
		turnplayer.setpBoardView(pb);
		MainView mv = new MainView(mc);
		Board board= new Board(mc, 2, mv );
		game.setBoard(board);
		game.setCurrentPlayer(turnplayer );
		
		int numberOfServants = 4;
		tester.setNumberOfServants(numberOfServants );
		int ris = tester.getNumberOfServants();
		
		assertEquals(numberOfServants, ris);
	}

}
