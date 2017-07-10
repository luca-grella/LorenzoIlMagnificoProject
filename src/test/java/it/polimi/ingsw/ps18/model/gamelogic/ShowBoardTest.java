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
import it.polimi.ingsw.ps18.model.cards.BonusTile;
import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.cards.GreenC;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;
import it.polimi.ingsw.ps18.view.MainView;
import it.polimi.ingsw.ps18.view.PBoardView;

/**
 * @author luca-grella
 *
 */
public class ShowBoardTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.ShowBoard#ShowBoard(it.polimi.ingsw.ps18.view.PBoardView)}.
	 */
	@Test
	public void testShowBoard() {
		
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		ShowBoard tester = new ShowBoard(pb );
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.ShowBoard#showMarket(it.polimi.ingsw.ps18.model.board.Board)}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testShowMarket() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();

    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/marketcellprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("1");
		
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		ShowBoard tester = new ShowBoard(pb );
		MainView mv = new MainView(mc);
		Board board = new Board(mc, 2, mv );
		List<MarketCell> marketCells = new ArrayList<>();
		MarketCell e = new MarketCell(a);
		marketCells.add(e );
		board.setMarketCells(marketCells );
		tester.setTester(999);
		tester.showMarket(board );
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.ShowBoard#showAllTowers(it.polimi.ingsw.ps18.model.board.Board)}.
	 */
//	@Test
//	public void testShowAllTowers() {
//		MainController mc = new MainController();
//		PBoardView pb = new PBoardView(mc );
//		ShowBoard tester = new ShowBoard(pb );
//		MainView mv = new MainView(mc);
//		Board board = new Board(mc, 2, mv );
//		tester.showAllTowers(board);
//	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.ShowBoard#showAllTowerswithZoom(it.polimi.ingsw.ps18.model.board.Board)}.
	 */
//	@Test
//	public void testShowAllTowerswithZoom() {
//		MainController mc = new MainController();
//		PBoardView pb = new PBoardView(mc );
//		ShowBoard tester = new ShowBoard(pb );
//		MainView mv = new MainView(mc);
//		Board board = new Board(mc, 2, mv );
//		tester.showAllTowers(board);
//	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.ShowBoard#showTowerCell(it.polimi.ingsw.ps18.model.board.Board, int)}.
	 */
	@Test
	public void testShowTowerCell() {
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		ShowBoard tester = new ShowBoard(pb );
		MainView mv = new MainView(mc);
		Board board = new Board(mc, 2, mv );
		tester.setTester(999);
		tester.showTowerCell(board, 0);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.ShowBoard#showCouncil(it.polimi.ingsw.ps18.model.board.Board)}.
	 */
//	@Test
//	public void testShowCouncil() {
//		MainController mc = new MainController();
//		PBoardView pb = new PBoardView(mc );
//		ShowBoard tester = new ShowBoard(pb );
//		MainView mv = new MainView(mc);
//		Board board = new Board(mc, 2, mv );
//		tester.showCouncil(board);
//	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.ShowBoard#showHarvest(it.polimi.ingsw.ps18.model.board.Board)}.
	 */
//	@Test
//	public void testShowHarvest() {
//		MainController mc = new MainController();
//		PBoardView pb = new PBoardView(mc );
//		ShowBoard tester = new ShowBoard(pb );
//		MainView mv = new MainView(mc);
//		Board board = new Board(mc, 2, mv );
//		tester.showHarvest(board);
//	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.ShowBoard#showProduction(it.polimi.ingsw.ps18.model.board.Board)}.
	 */
//	@Test
//	public void testShowProduction() {
//		MainController mc = new MainController();
//		PBoardView pb = new PBoardView(mc );
//		ShowBoard tester = new ShowBoard(pb );
//		MainView mv = new MainView(mc);
//		Board board = new Board(mc, 2, mv );
//		tester.showProduction(board);
//	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.ShowBoard#ShowExcomm(it.polimi.ingsw.ps18.model.board.Board)}.
	 */
//	@Test
//	public void testShowExcomm() {
//		MainController mc = new MainController();
//		PBoardView pb = new PBoardView(mc );
//		ShowBoard tester = new ShowBoard(pb );
//		MainView mv = new MainView(mc);
//		Board board = new Board(mc, 2, mv );
//		tester.ShowExcomm(board);
//	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.ShowBoard#choosePlayer()}.
	 */
//	@Test
//	public void testChoosePlayer() {
//		MainController mc = new MainController();
//		PBoardView pb = new PBoardView(mc );
//		ShowBoard tester = new ShowBoard(pb );
//		MainView mv = new MainView(mc);
//		Board board = new Board(mc, 2, mv );
//		tester.choosePlayer();
//	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.ShowBoard#showPlayer(it.polimi.ingsw.ps18.model.personalboard.PBoard)}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
//	@Test
//	public void testShowPlayer() throws FileNotFoundException, IOException, ParseException {
//		
//		JSONParser parser = new JSONParser();
//		
//    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
//    	JSONObject jsonObject = (JSONObject) obj;
//        JSONObject a = (JSONObject) jsonObject.get("0");
//		
//		MainController mc = new MainController();
//		PBoardView pb = new PBoardView(mc );
//		ShowBoard tester = new ShowBoard(pb );
//		MainView mv = new MainView(mc);
//		Board board = new Board(mc, 2, mv );
//		PBoard player = new PBoard();
//		List<Cards> cards = new ArrayList<>();
//		GreenC e = new GreenC(a);
//		cards.add(e );
//		player.setCards(cards );
//		Stats resources = new Stats(10,10,10,10,10,10,10);
//		player.setResources(resources );
//		tester.showPlayer(player );
//	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.ShowBoard#showServants(it.polimi.ingsw.ps18.model.personalboard.PBoard)}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
//	@Test
//	public void testShowServants() throws FileNotFoundException, IOException, ParseException {
//		
//		JSONParser parser = new JSONParser();
//		
//    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
//    	JSONObject jsonObject = (JSONObject) obj;
//        JSONObject a = (JSONObject) jsonObject.get("0");
//		
//		MainController mc = new MainController();
//		PBoardView pb = new PBoardView(mc );
//		ShowBoard tester = new ShowBoard(pb );
//		MainView mv = new MainView(mc);
//		Board board = new Board(mc, 2, mv );
//		PBoard player = new PBoard();
//		List<Cards> cards = new ArrayList<>();
//		GreenC e = new GreenC(a);
//		cards.add(e );
//		player.setCards(cards );
//		Stats resources = new Stats(10,10,10,10,10,10,10);
//		player.setResources(resources );
//		tester.showServants(player);
//	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.ShowBoard#showBonusTiles(java.util.List)}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
//	@Test
//	public void testShowBonusTiles() throws FileNotFoundException, IOException, ParseException {
//		
//		JSONParser parser = new JSONParser();
//		
//		Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/BonusTileProva.json"));
//		JSONObject jsonObject = (JSONObject) obj;
//	    JSONObject a = (JSONObject) jsonObject.get("0");
//
//		
//		
//		MainController mc = new MainController();
//		PBoardView pb = new PBoardView(mc );
//		ShowBoard tester = new ShowBoard(pb );
//		
//		MainView mv = new MainView(mc);
//		Board board = new Board(mc, 2, mv );
//		PBoard player = new PBoard();
//		
//		Stats resources = new Stats(10,10,10,10,10,10,10);
//		player.setResources(resources );
//		List<Cards> bt = new ArrayList<>();
//		BonusTile e = new BonusTile(a);
//		bt.add(e);
//		tester.showBonusTiles(bt );
//	}

}
