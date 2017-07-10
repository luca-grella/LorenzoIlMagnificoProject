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
import it.polimi.ingsw.ps18.model.cards.Excommunications;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;
import it.polimi.ingsw.ps18.view.PBoardView;

/**
 * @author luca-grella
 *
 */
public class VaticanReportTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.VaticanReport#VaticanReport(it.polimi.ingsw.ps18.view.PBoardView)}.
	 */
	@Test
	public void testVaticanReport() {
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.VaticanReport#reportChoice()}.
	 */
	@Test
	public void testReportChoice() {
		
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		VaticanReport tester = new VaticanReport(pb );
//		tester.reportChoice();
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.VaticanReport#act(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)}.
	 */
	@Test
	public void testAct() {
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		VaticanReport tester = new VaticanReport(pb );
		
		int chosenAnswer = 1;
		tester.setChosenAnswer(chosenAnswer );
		
		GameLogic game = new GameLogic();
		PBoard turnplayer = new PBoard();
		Stats resources = new Stats(10,10,10,10,10,10,10);
		turnplayer.setResources(resources );
		game.setCurrentPlayer(turnplayer );
		tester.act(game);
		
	}
	
	@Test
	public void testAct2() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/Excommunicationsprova.json"));
		JSONObject jsonObject = (JSONObject) obj;
	    JSONObject a = (JSONObject) jsonObject.get("1");
		
		
		
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		VaticanReport tester = new VaticanReport(pb );
		
		int chosenAnswer = 2;
		tester.setChosenAnswer(chosenAnswer );
		
		GameLogic game = new GameLogic();
		game.setAGE(0);
		PBoard turnplayer = new PBoard();
		Stats resources = new Stats(10,10,10,10,10,10,10);
		turnplayer.setResources(resources );
		List<Excommunications> ex = new ArrayList<>();
		turnplayer.setExcommCards(ex );
		List<Excommunications> excomm = new ArrayList<>();
		Excommunications e = new Excommunications(a);
		excomm.add(e );
		game.setExcommcards(excomm );
		game.setCurrentPlayer(turnplayer );
		tester.act(game);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.VaticanReport#setChosenFam(it.polimi.ingsw.ps18.model.personalboard.FMember)}.
	 */
	@Test
	public void testSetChosenFam() {
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		VaticanReport tester = new VaticanReport(pb );
		
		Dice dice = new Dice(3);
		FMember chosenFam = new FMember(dice , 2);
		tester.setChosenFam(chosenFam );
		FMember ris = tester.getChosenFam(chosenFam);
		
		assertEquals(chosenFam, ris);
	}
	


	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.VaticanReport#getChosenAnswer()}.
	 */
	@Test
	public void testGetChosenAnswer() {
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		VaticanReport tester = new VaticanReport(pb );
		
		int chosenAnswer = 3;
		tester.setChosenAnswer(chosenAnswer );
		int ris = tester.getChosenAnswer();
		
		assertEquals(chosenAnswer, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.VaticanReport#setChosenAnswer(int)}.
	 */
	@Test
	public void testSetChosenAnswer() {
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		VaticanReport tester = new VaticanReport(pb );
		
		int chosenAnswer = 3;
		tester.setChosenAnswer(chosenAnswer );
		int ris = tester.getChosenAnswer();
		
		assertEquals(chosenAnswer, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.gamelogic.VaticanReport#setNumberOfServants(int)}.
	 */
	@Test
	public void testSetNumberOfServants() {
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		VaticanReport tester = new VaticanReport(pb );
		
		int numberOfServants = 3;
		tester.setNumberOfServants(numberOfServants);
		int ris = tester.getNumberOfServants(numberOfServants);
		
		assertEquals(numberOfServants, ris);
	}

}
