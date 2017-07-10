package it.polimi.ingsw.ps18.model.effect.generalEffects;
/**
 * 
 */

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import java.util.Vector;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import it.polimi.ingsw.ps18.controller.MainController;
import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.cards.Excommunications;
import it.polimi.ingsw.ps18.model.effect.generalEffects.ActHarvest;
import it.polimi.ingsw.ps18.model.gamelogic.Dice;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.view.PBoardView;

/**
 * @author luca-grella
 *
 */
public class ActHarvestTest {

	private static final List<Cards> BonusTiles = null;

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.generalEffects.ActHarvest#activate(it.polimi.ingsw.ps18.model.personalboard.PBoard, it.polimi.ingsw.ps18.model.gamelogic.GameLogic)}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testActivate() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/Excommunicationsprova.json"));
		JSONObject jsonObject = (JSONObject) obj;
	    JSONObject a = (JSONObject) jsonObject.get("5");
		
		ActHarvest tester = new ActHarvest();
		PBoard player = new PBoard();
		List<Excommunications> excommCards = new ArrayList<>();
		Excommunications e = new Excommunications(a);
		excommCards.add(e );
		player.setExcommCards(excommCards );
		MainController mc = new MainController();
		PBoardView pbv = new PBoardView(mc );
		player.setpBoardView(pbv );
		GameLogic game = new GameLogic();
		
		tester.setQuantity(4);
		game.setCurrentPlayer(player);
		tester.setTester(999);
		tester.activate(player, game);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.generalEffects.ActHarvest#setQuantity(int)}.
	 */
	@Test
	public void testSetQuantity() {
		
		ActHarvest tester = new ActHarvest();
		int quantity = 1;
		tester.setQuantity(quantity );
		
		assertEquals(quantity, tester.getQuantity());
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.generalEffects.ActHarvest#getName()}.
	 */
	@Test
	public void testGetName() {
		ActHarvest tester = new ActHarvest();
		String c = tester.getName();
		
		assertEquals("activate harvest", c);
	}

	/**
	 * Test method for {@link java.util.Observable#Observable()}.
	 */
	@Test
	public void testObservable() {
		
	}
	
	/**
	 * 
	 * 
	 */
	
	@Test
	public void testToString() {
		ActHarvest tester = new ActHarvest();
		tester.setQuantity(1);
		String ris = tester.toString();
		
		assertEquals("Trigger an Harvest Action with a Value of 1", ris);
	}

	/**
	 * Test method for {@link java.util.Observable#addObserver(java.util.Observer)}.
	 */
	@Test
	public void testAddObserver() {
		
	}

	/**
	 * Test method for {@link java.util.Observable#deleteObserver(java.util.Observer)}.
	 */
	@Test
	public void testDeleteObserver() {
		
	}

	/**
	 * Test method for {@link java.util.Observable#notifyObservers()}.
	 */
	@Test
	public void testNotifyObservers() {
		
	}

	/**
	 * Test method for {@link java.util.Observable#notifyObservers(java.lang.Object)}.
	 */
	@Test
	public void testNotifyObserversObject() {
		
	}

	/**
	 * Test method for {@link java.util.Observable#deleteObservers()}.
	 */
	@Test
	public void testDeleteObservers() {
		
	}

	/**
	 * Test method for {@link java.util.Observable#setChanged()}.
	 */
	@Test
	public void testSetChanged() {
		
	}

	/**
	 * Test method for {@link java.util.Observable#clearChanged()}.
	 */
	@Test
	public void testClearChanged() {
		
	}

	/**
	 * Test method for {@link java.util.Observable#hasChanged()}.
	 */
	@Test
	public void testHasChanged() {
		
	}

	/**
	 * Test method for {@link java.util.Observable#countObservers()}.
	 */
	@Test
	public void testCountObservers() {
		
	}

}
