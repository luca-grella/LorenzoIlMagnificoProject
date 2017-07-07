/**
 * 
 */
package it.polimi.ingsw.ps18.model.gamelogic;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.board.Board;
import it.polimi.ingsw.ps18.model.board.boardcells.MarketCell;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;
import it.polimi.ingsw.ps18.view.MainView;
import it.polimi.ingsw.ps18.view.PBoardView;

/**
 * @author luca-grella
 *
 */
public class FamtoMarketTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoMarket#FamtoMarket(it.polimi.ingsw.ps18.view.PBoardView)}.
	 */
	@Test
	public void testFamtoMarket() {
		
		MainController mc = new MainController();
		PBoardView pbv = new PBoardView(mc );
		FamtoMarket tester = new FamtoMarket(pbv );
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoMarket#act(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testAct() throws FileNotFoundException, IOException, ParseException {
		MainController mc = new MainController();
		PBoardView pbv = new PBoardView(mc );
		FamtoMarket tester = new FamtoMarket(pbv );
		MainView mv = new MainView(mc);
		Board board = new Board(mc, 2, mv );
		
		JSONParser parser = new JSONParser();

    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/marketcellprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("1");
		GameLogic game = new GameLogic();
		List<MarketCell> marketCells = new ArrayList<>();
		MarketCell e = new MarketCell(a);
		
		marketCells.add(e);
		board.setMarketCells(marketCells );
		game.setBoard(board);
		tester.setChosenCell(0);
		Dice dice = new Dice(3);
		FMember chosenFam = new FMember(dice , 2);
		PBoard turnplayer = new PBoard();
		List<FMember> fams = new ArrayList<>();
		fams.add(chosenFam);
		turnplayer.setFams(fams );
		Stats resources = new Stats(10,10,10,10,10,10,10);
		turnplayer.setResources(resources );
		game.setCurrentPlayer(turnplayer );
		int numberOfServants = 2;
		tester.setNumberOfServants(numberOfServants );
		tester.setChosenFam(chosenFam );
		tester.act(game );
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoMarket#getChosenFam()}.
	 */
	@Test
	public void testGetChosenFam() {
		MainController mc = new MainController();
		PBoardView pbv = new PBoardView(mc );
		FamtoMarket tester = new FamtoMarket(pbv );
		Dice dice = new Dice(2);
		FMember chosenFam = new FMember(dice , 2);
		tester.setChosenFam(chosenFam );
		FMember ris = tester.getChosenFam();
		
		assertEquals(chosenFam,ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoMarket#setChosenFam(it.polimi.ingsw.ps18.model.personalboard.FMember)}.
	 */
	@Test
	public void testSetChosenFam() {
		MainController mc = new MainController();
		PBoardView pbv = new PBoardView(mc );
		FamtoMarket tester = new FamtoMarket(pbv );
		Dice dice = new Dice(2);
		FMember chosenFam = new FMember(dice , 2);
		tester.setChosenFam(chosenFam );
		FMember ris = tester.getChosenFam();
		
		assertEquals(chosenFam,ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoMarket#getChosenCell()}.
	 */
	@Test
	public void testGetChosenCell() {
		MainController mc = new MainController();
		PBoardView pbv = new PBoardView(mc );
		FamtoMarket tester = new FamtoMarket(pbv );
		
		
		int chosenCell = 9;
		tester.setChosenCell(chosenCell );
		int ris = tester.getChosenCell();
		
		assertEquals(chosenCell,ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoMarket#setChosenCell(int)}.
	 */
	@Test
	public void testSetChosenCell() {
		MainController mc = new MainController();
		PBoardView pbv = new PBoardView(mc );
		FamtoMarket tester = new FamtoMarket(pbv );
		
		
		int chosenCell = 9;
		tester.setChosenCell(chosenCell );
		int ris = tester.getChosenCell();
		
		assertEquals(chosenCell,ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoMarket#setIndexFamtoRemove(int)}.
	 */
	@Test
	public void testSetIndexFamtoRemove() {
		MainController mc = new MainController();
		PBoardView pbv = new PBoardView(mc );
		FamtoMarket tester = new FamtoMarket(pbv );
		
		int indexFamtoRemove = 2;
		tester.setIndexFamtoRemove(indexFamtoRemove );
		int ris = tester.getIndexFamtoRemove();
		
		assertEquals(indexFamtoRemove,ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoMarket#getNumberOfServants()}.
	 */
	@Test
	public void testGetNumberOfServants() {
		MainController mc = new MainController();
		PBoardView pbv = new PBoardView(mc );
		FamtoMarket tester = new FamtoMarket(pbv );
		
		int numberOfServants=3;
		tester.setNumberOfServants(numberOfServants);
		int ris = tester.getNumberOfServants();
		
		assertEquals(numberOfServants,ris);
				
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoMarket#setNumberOfServants(int)}.
	 */
	@Test
	public void testSetNumberOfServants() {
		MainController mc = new MainController();
		PBoardView pbv = new PBoardView(mc );
		FamtoMarket tester = new FamtoMarket(pbv );
		
		int numberOfServants=3;
		tester.setNumberOfServants(numberOfServants);
		int ris = tester.getNumberOfServants();
		
		assertEquals(numberOfServants,ris);
	}

}
