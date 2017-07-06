/**
 * 
 */
package it.polimi.ingsw.ps18.model.effect.generalEffects;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import it.polimi.ingsw.ps18.model.cards.BlueC;
import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.cards.GreenC;
import it.polimi.ingsw.ps18.model.gamelogic.Dice;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

/**
 * @author luca-grella
 *
 */
public class AddPVforGreenCTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.generalEffects.AddPVforGreenC#activate(it.polimi.ingsw.ps18.model.personalboard.PBoard, it.polimi.ingsw.ps18.model.gamelogic.GameLogic)}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testActivate() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("0");

		
		GreenC tester2 = new GreenC(a);
		
		Random rand  = new Random();
		int c = rand.nextInt(1000);
		int b = rand.nextInt(1000);
		AddPVforGreenC tester = new AddPVforGreenC();
		tester.setQuantity(b);
		List<Dice> dices = new ArrayList<>(1);
		dices.add(new Dice(0));
		PBoard player = new PBoard(c, dices);
		List<Cards> cards = new ArrayList<>();
		cards.add(tester2);
		player.setCards(cards );
		
		Stats stats = player.getResources();
		int ris = stats.getVP();
		tester.activate(player, new GameLogic());
		int ris2 = stats.getVP();
		
		assertEquals(ris + b, ris2);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.generalEffects.AddPVforGreenC#setQuantity(int)}.
	 */
	@Test
	public void testSetQuantity() {
		AddPVforGreenC tester = new AddPVforGreenC();
		int quantity = 2;
		tester.setQuantity(quantity );
		int ris = tester.getQuantity();
		
		assertEquals(quantity, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.generalEffects.AddPVforGreenC#toString()}.
	 */
	@Test
	public void testToString() {
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.generalEffects.AddPVforGreenC#getName()}.
	 */
	@Test
	public void testGetName() {
		
		AddPVforGreenC tester = new AddPVforGreenC();
		String name = "ciao";
		tester.setName(name );
		String ris = tester.getName();
		
		assertEquals(name, ris);
	}

}
