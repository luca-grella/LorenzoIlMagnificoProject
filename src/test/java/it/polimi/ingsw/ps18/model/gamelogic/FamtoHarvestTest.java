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
import it.polimi.ingsw.ps18.model.cards.BonusTile;
import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.cards.Excommunications;
import it.polimi.ingsw.ps18.model.cards.GreenC;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;
import it.polimi.ingsw.ps18.view.MainView;
import it.polimi.ingsw.ps18.view.PBoardView;

/**
 * The Class FamtoHarvestTest.
 *
 * @author luca-grella
 */
public class FamtoHarvestTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoHarvest#FamtoHarvest(it.polimi.ingsw.ps18.view.PBoardView)}.
	 */
	@Test
	public void testFamtoHarvest() {
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoProduction tester = new FamtoProduction(pb);
		
	}
	
	/**
	 * Test servant choice.
	 */
	@Test
	public void testServantChoice() {
		
		MainController mc = new MainController();
		PBoardView pbv = new PBoardView(mc );
		FamtoHarvest tester = new FamtoHarvest(pbv);
		
		GameLogic game = new GameLogic();
		PBoard turnplayer = new PBoard();
		turnplayer.setpBoardView(pbv);
		MainView mv = new MainView(mc);
		Board board = new Board(mc, 2, mv );
		game.setBoard(board );
		game.setCurrentPlayer(turnplayer );
		tester.setTester(999);
		tester.servantsChoice(game );
		
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoHarvest#act(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)}.
	 */
	@Test
	public void testAct() {
		
		MainController mc = new MainController();
		PBoardView pbv = new PBoardView(mc );
		FamtoHarvest tester = new FamtoHarvest(pbv);
		
		GameLogic game = new GameLogic();
		
//		tester.act(game );
		
	}
	
	/**
	 * Test activate harvest.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testActivateHarvest() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("0");
        
        JSONParser parser2 = new JSONParser();
		
		Object obj2 = parser2.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/BonusTileProva.json"));
		JSONObject jsonObject2 = (JSONObject) obj2;
	    JSONObject a2 = (JSONObject) jsonObject2.get("0");
		
		MainController mc = new MainController();
		PBoardView pbv = new PBoardView(mc );
		FamtoHarvest tester = new FamtoHarvest(pbv);
		tester.setActionValue(100);
		
		GameLogic game = new GameLogic();
		
		PBoard player = new PBoard();
		List<Cards> cards = new ArrayList<>();
		GreenC e = new GreenC(a);
		cards.add(e );
		BonusTile f = new BonusTile(a2);
		cards.add(f );
		player.setCards(cards );
		List<Excommunications> excommCards = new ArrayList<>();
		player.setExcommCards(excommCards );
		Stats ris = player.generateExcommMalus();
		tester.setTester(999);
//		tester.activateHarvest(player , game);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoHarvest#getChosenFam()}.
	 */
	@Test
	public void testGetChosenFam() {
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoHarvest tester = new FamtoHarvest(pb);
		
		Dice dice = new Dice(3);
		FMember chosenFam = new FMember(dice , 2);
		tester.setChosenFam(chosenFam );
		FMember ris = tester.getChosenFam();
		assertEquals(chosenFam, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoHarvest#setChosenFam(it.polimi.ingsw.ps18.model.personalboard.FMember)}.
	 */
	@Test
	public void testSetChosenFam() {
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoHarvest tester = new FamtoHarvest(pb);
		
		Dice dice = new Dice(3);
		FMember chosenFam = new FMember(dice , 2);
		tester.setChosenFam(chosenFam );
		FMember ris = tester.getChosenFam();
		assertEquals(chosenFam, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoHarvest#setChosenCell(int)}.
	 */
	@Test
	public void testSetChosenCell() {
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoHarvest tester = new FamtoHarvest(pb);
		
		int chosenCell = 3;
		tester.setChosenCell(chosenCell );
		int ris = tester.getChosenCell();
		
		assertEquals(chosenCell, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoHarvest#setActionValue(int)}.
	 */
	@Test
	public void testSetActionValue() {
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoHarvest tester = new FamtoHarvest(pb);
		
		int actionValue = 5;
		tester.setActionValue(actionValue );
		int ris = tester.getActionValue();
		
		assertEquals(actionValue,ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoHarvest#setIndexFamtoRemove(int)}.
	 */
	@Test
	public void testSetIndexFamtoRemove() {
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoHarvest tester = new FamtoHarvest(pb);
		
		int indexFamtoRemove=4;
		tester.setIndexFamtoRemove(indexFamtoRemove);
		int ris = tester.getIndexFamtoRemove();
		
		assertEquals(indexFamtoRemove,ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoHarvest#getNumberOfServants()}.
	 */
	@Test
	public void testGetNumberOfServants() {
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoHarvest tester = new FamtoHarvest(pb);
		
		int numberOfServants = 4;
		tester.setNumberOfServants(numberOfServants );
		int ris = tester.getNumberOfServants();
		
		assertEquals(numberOfServants,ris);
				
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.FamtoHarvest#setNumberOfServants(int)}.
	 */
	@Test
	public void testSetNumberOfServants() {
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		FamtoHarvest tester = new FamtoHarvest(pb);
		
		int numberOfServants = 4;
		tester.setNumberOfServants(numberOfServants );
		int ris = tester.getNumberOfServants();
		
		assertEquals(numberOfServants,ris);
	}

}
