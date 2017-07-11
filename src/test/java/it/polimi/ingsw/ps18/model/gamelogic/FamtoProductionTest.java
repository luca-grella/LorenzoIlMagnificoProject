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
import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.cards.YellowC;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;
import it.polimi.ingsw.ps18.view.MainView;
import it.polimi.ingsw.ps18.view.PBoardView;

/**
 * The Class FamtoProductionTest.
 *
 * @author luca-grella
 */
public class FamtoProductionTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoProduction#FamtoProduction(it.polimi.ingsw.ps18.view.PBoardView)}.
	 */
	@Test
	public void testFamtoProduction() {
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoProduction tester = new FamtoProduction(pb);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoProduction#famchoice()}.
	 */
	@Test
	public void testFamchoice() {
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoProduction tester = new FamtoProduction(pb);
		
//		tester.famchoice();
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoProduction#cellChoice()}.
	 */
	@Test
	public void testCellChoice() {
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoProduction tester = new FamtoProduction(pb);
		
//		tester.cellChoice();
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoProduction#servantsChoice(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)}.
	 */
	@Test
	public void testServantsChoice() {
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoProduction tester = new FamtoProduction(pb);
		
		GameLogic game = new GameLogic();
		PBoard turnplayer = new PBoard();
		turnplayer.setpBoardView(pb);
		MainView mv = new MainView(mc);
		Board board = new Board(mc, 2, mv );
		game.setBoard(board );
		game.setCurrentPlayer(turnplayer );
		
//		tester.servantsChoice(game );
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoProduction#act(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)}.
	 */
	@Test
	public void testAct() {
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoProduction tester = new FamtoProduction(pb);
		
		GameLogic game = new GameLogic();
		PBoard turnplayer = new PBoard();
		turnplayer.setpBoardView(pb);
		MainView mv = new MainView(mc);
		Board board = new Board(mc, 2, mv );
		game.setBoard(board );
		game.setCurrentPlayer(turnplayer );
		
//		tester.act(game);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoProduction#activateProduction(it.polimi.ingsw.ps18.model.personalboard.PBoard, it.polimi.ingsw.ps18.model.gamelogic.GameLogic)}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testActivateProduction() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("5");
		
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoProduction tester = new FamtoProduction(pb);
		
		GameLogic game = new GameLogic();
		PBoard turnplayer = new PBoard();
		List<Cards> cards = new ArrayList<>();
		YellowC e = new YellowC(a);
		cards.add(e);
		turnplayer.setCards(cards );
		turnplayer.setpBoardView(pb);
		MainView mv = new MainView(mc);
		Board board = new Board(mc, 2, mv );
		tester.setIndexFamtoRemove(0);
//		tester.activateProduction(turnplayer, game);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoProduction#chooseCards(it.polimi.ingsw.ps18.model.personalboard.PBoard, it.polimi.ingsw.ps18.model.gamelogic.GameLogic)}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testChooseCards() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("5");
		
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoProduction tester = new FamtoProduction(pb);
		
		GameLogic game = new GameLogic();
		PBoard turnplayer = new PBoard();
		List<Cards> cards = new ArrayList<>();
		YellowC e = new YellowC(a);
		cards.add(e);
		turnplayer.setCards(cards );
		turnplayer.setpBoardView(pb);
		MainView mv = new MainView(mc);
		Board board = new Board(mc, 2, mv );
		tester.setIndexFamtoRemove(0);
		
//		tester.chooseCards(turnplayer, game);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoProduction#ChooseEffect()}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testChooseEffect() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("5");
		
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoProduction tester = new FamtoProduction(pb);
		
		GameLogic game = new GameLogic();
		PBoard turnplayer = new PBoard();
		List<Cards> cards = new ArrayList<>();
		YellowC e = new YellowC(a);
		cards.add(e);
		turnplayer.setCards(cards );
		turnplayer.setpBoardView(pb);
		MainView mv = new MainView(mc);
		Board board = new Board(mc, 2, mv );
		tester.setIndexFamtoRemove(0);
		
//		tester.ChooseEffect();
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoProduction#activateEffects(it.polimi.ingsw.ps18.model.personalboard.PBoard, it.polimi.ingsw.ps18.model.gamelogic.GameLogic)}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testActivateEffects() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("5");
		
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoProduction tester = new FamtoProduction(pb);
		
		GameLogic game = new GameLogic();
		PBoard turnplayer = new PBoard();
		List<Cards> cards = new ArrayList<>();
		YellowC e = new YellowC(a);
		cards.add(e);
		List<FMember> fams = new ArrayList<>();
		Dice dice = new Dice(2);
		FMember fam = new FMember(dice , 2);
		fams.add(fam );
		turnplayer.setFams(fams );
		turnplayer.setCards(cards );
		turnplayer.setpBoardView(pb);
		MainView mv = new MainView(mc);
		Board board = new Board(mc, 2, mv );
		tester.setIndexFamtoRemove(0);
		int indexFamtoRemove=2;
		tester.setIndexFamtoRemove(indexFamtoRemove);
//		tester.activateEffects(turnplayer, game);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoProduction#setChosenFam(it.polimi.ingsw.ps18.model.personalboard.FMember)}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testSetChosenFam() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("5");
		
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoProduction tester = new FamtoProduction(pb);
		
		GameLogic game = new GameLogic();
		PBoard turnplayer = new PBoard();
		List<Cards> cards = new ArrayList<>();
		YellowC e = new YellowC(a);
		cards.add(e);
		turnplayer.setCards(cards );
		turnplayer.setpBoardView(pb);
		MainView mv = new MainView(mc);
		Board board = new Board(mc, 2, mv );
		tester.setIndexFamtoRemove(0);
		
		Dice dice = new Dice(2);
		FMember chosenFam = new FMember(dice , 2);
		tester.setChosenFam(chosenFam);
		FMember ris = tester.getChosenFam();
		
		assertEquals(chosenFam, ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoProduction#setActionValue(int)}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testSetActionValue() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("5");
		
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoProduction tester = new FamtoProduction(pb);
		
		GameLogic game = new GameLogic();
		PBoard turnplayer = new PBoard();
		List<Cards> cards = new ArrayList<>();
		YellowC e = new YellowC(a);
		cards.add(e);
		turnplayer.setCards(cards );
		turnplayer.setpBoardView(pb);
		MainView mv = new MainView(mc);
		Board board = new Board(mc, 2, mv );
		tester.setIndexFamtoRemove(0);
		
		int actionValue = 1;
		tester.setActionValue(actionValue );
		int ris = tester.getActionValue();
		
		assertEquals(actionValue, ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoProduction#getCurrentcard()}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testGetCurrentcard() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("5");
		
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoProduction tester = new FamtoProduction(pb);
		
		GameLogic game = new GameLogic();
		PBoard turnplayer = new PBoard();
		List<Cards> cards = new ArrayList<>();
		YellowC e = new YellowC(a);
		cards.add(e);
		turnplayer.setCards(cards );
		turnplayer.setpBoardView(pb);
		MainView mv = new MainView(mc);
		Board board = new Board(mc, 2, mv );
		tester.setIndexFamtoRemove(0);
		
		tester.setCurrentcard(e);
		Cards ris = tester.getCurrentcard();
		
		assertEquals(e, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoProduction#getCardsForActivation()}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testGetCardsForActivation() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("5");
		
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoProduction tester = new FamtoProduction(pb);
		
		GameLogic game = new GameLogic();
		PBoard turnplayer = new PBoard();
		List<Cards> cards = new ArrayList<>();
		YellowC e = new YellowC(a);
		cards.add(e);
		turnplayer.setCards(cards );
		turnplayer.setpBoardView(pb);
		MainView mv = new MainView(mc);
		Board board = new Board(mc, 2, mv );
		tester.setIndexFamtoRemove(0);
		
		tester.setCardsForActivation(cards);
		List<Cards> ris = tester.getCardsForActivation();
		
		assertEquals(cards, ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoProduction#getTotalCostPreview()}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testGetTotalCostPreview() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("5");
		
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoProduction tester = new FamtoProduction(pb);
		
		GameLogic game = new GameLogic();
		PBoard turnplayer = new PBoard();
		List<Cards> cards = new ArrayList<>();
		YellowC e = new YellowC(a);
		cards.add(e);
		turnplayer.setCards(cards );
		turnplayer.setpBoardView(pb);
		MainView mv = new MainView(mc);
		Board board = new Board(mc, 2, mv );
		tester.setIndexFamtoRemove(0);
		
		Stats cost = new Stats(12,34,23,5,79,3,5);
		tester.setTotalCostPreview(cost );
		Stats ris = tester.getTotalCostPreview();
		
		assertEquals(cost, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoProduction#setIndexFamtoRemove(int)}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testSetIndexFamtoRemove() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("5");
		
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoProduction tester = new FamtoProduction(pb);
		
		GameLogic game = new GameLogic();
		PBoard turnplayer = new PBoard();
		List<Cards> cards = new ArrayList<>();
		YellowC e = new YellowC(a);
		cards.add(e);
		turnplayer.setCards(cards );
		turnplayer.setpBoardView(pb);
		MainView mv = new MainView(mc);
		Board board = new Board(mc, 2, mv );
		
		
		int index = 3;
		tester.setIndexFamtoRemove(index );
		
		int ris = tester.getIndexFamtoRemove();
		
		assertEquals(index, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoProduction#getNumberOfServants()}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testGetNumberOfServants() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("5");
		
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoProduction tester = new FamtoProduction(pb);
		
		GameLogic game = new GameLogic();
		PBoard turnplayer = new PBoard();
		List<Cards> cards = new ArrayList<>();
		YellowC e = new YellowC(a);
		cards.add(e);
		turnplayer.setCards(cards );
		turnplayer.setpBoardView(pb);
		MainView mv = new MainView(mc);
		Board board = new Board(mc, 2, mv );
		
		int numberOfServants = 5;
		tester.setNumberOfServants(numberOfServants );
		int ris = tester.getNumberOfServants();
		
		assertEquals(numberOfServants,ris);
				
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoProduction#setNumberOfServants(int)}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testSetNumberOfServants() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("5");
		
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoProduction tester = new FamtoProduction(pb);
		
		GameLogic game = new GameLogic();
		PBoard turnplayer = new PBoard();
		List<Cards> cards = new ArrayList<>();
		YellowC e = new YellowC(a);
		cards.add(e);
		turnplayer.setCards(cards );
		turnplayer.setpBoardView(pb);
		MainView mv = new MainView(mc);
		Board board = new Board(mc, 2, mv );
		
		int numberOfServants = 5;
		tester.setNumberOfServants(numberOfServants );
		int ris = tester.getNumberOfServants();
		
		assertEquals(numberOfServants,ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoProduction#getChosenCell()}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testGetChosenCell() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("5");
		
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoProduction tester = new FamtoProduction(pb);
		
		GameLogic game = new GameLogic();
		PBoard turnplayer = new PBoard();
		List<Cards> cards = new ArrayList<>();
		YellowC e = new YellowC(a);
		cards.add(e);
		turnplayer.setCards(cards );
		turnplayer.setpBoardView(pb);
		MainView mv = new MainView(mc);
		Board board = new Board(mc, 2, mv );
		
		int chosenCell = 4;
		tester.setChosenCell(chosenCell);
		int ris = tester.getChosenCell();
		
		assertEquals(chosenCell,ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoProduction#setChosenCell(int)}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testSetChosenCell() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("5");
		
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoProduction tester = new FamtoProduction(pb);
		
		GameLogic game = new GameLogic();
		PBoard turnplayer = new PBoard();
		List<Cards> cards = new ArrayList<>();
		YellowC e = new YellowC(a);
		cards.add(e);
		turnplayer.setCards(cards );
		turnplayer.setpBoardView(pb);
		MainView mv = new MainView(mc);
		Board board = new Board(mc, 2, mv );
		
		int chosenCell = 4;
		tester.setChosenCell(chosenCell);
		int ris = tester.getChosenCell();
		
		assertEquals(chosenCell,ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoProduction#getChosenFam()}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testGetChosenFam() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("5");
		
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoProduction tester = new FamtoProduction(pb);
		
		GameLogic game = new GameLogic();
		PBoard turnplayer = new PBoard();
		List<Cards> cards = new ArrayList<>();
		YellowC e = new YellowC(a);
		cards.add(e);
		turnplayer.setCards(cards );
		turnplayer.setpBoardView(pb);
		MainView mv = new MainView(mc);
		Board board = new Board(mc, 2, mv );
		tester.setIndexFamtoRemove(0);
		
		Dice dice = new Dice(2);
		FMember chosenFam = new FMember(dice , 2);
		tester.setChosenFam(chosenFam);
		FMember ris = tester.getChosenFam();
		
		assertEquals(chosenFam, ris);
	}

}
