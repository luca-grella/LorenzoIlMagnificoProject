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
 * The Class TurnHandlerTest.
 *
 * @author luca-grella
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
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testAct() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/Excommunicationsprova.json"));
		JSONObject jsonObject = (JSONObject) obj;
	    JSONObject a = (JSONObject) jsonObject.get("12");
		
		PBoard currentplayer = new PBoard();
		MainController mc = new MainController();
		PBoardView pb = new PBoardView(mc );
		currentplayer.setpBoardView(pb );
		Stats resources = new Stats(10,10,10,10,10,10,10);
		currentplayer.setResources(resources );
		currentplayer.setPlayercol(1);
		List<Excommunications> excommCards = new ArrayList<>();
		Excommunications ee = new Excommunications(a);
		excommCards.add(ee );
		currentplayer.setExcommCards(excommCards );
		List<FMember> fams=new ArrayList<>();
//		Dice dice = new Dice(4);
//		FMember e = new FMember(dice , 4);
//		
//		e.setColor(0);
//		fams.add(e );
		currentplayer.setFams(fams);
		TurnHandler tester = new TurnHandler(currentplayer);
		
		GameLogic game = new GameLogic();
		currentplayer.setPlayercol(2);
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
