/**
 * 
 */
package it.polimi.ingsw.ps18.model.effect.excommEffects;

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

import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.cards.YellowC;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

/**
 * @author luca-grella
 *
 */
public class LoseVPforCostsTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.excommEffects.LoseVPforCosts#activate(it.polimi.ingsw.ps18.model.personalboard.PBoard)}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testActivate() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("10");
		
		LoseVPforCosts tester = new LoseVPforCosts();
		int quantity = 2;
		int sumcost = 4;
		tester.setQuantity(quantity );
		PBoard player = new PBoard();
		int pv=30;
		Stats resources = new Stats(30,30,30,30,30,30,pv);
		List<Cards> cards = new ArrayList<>();
		YellowC card = new YellowC(a);
		cards.add(card);
		player.setCards(cards );
		player.setResources(resources );
		
		tester.activate(player );
		
		Stats ris = player.getResources();
		
		assertEquals(sumcost*quantity,pv-ris.getVP());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.excommEffects.LoseVPforCosts#setQuantity(int)}.
	 */
	@Test
	public void testSetQuantity() {
		LoseVPforCosts tester = new LoseVPforCosts();
		int quantity=30;
		tester.setQuantity(quantity);
		int ris = tester.getLoseVP();
		
		assertEquals(quantity, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.excommEffects.LoseVPforCosts#getLoseVP()}.
	 */
	@Test
	public void testGetLoseVP() {
		LoseVPforCosts tester = new LoseVPforCosts();
		int quantity=30;
		tester.setQuantity(quantity);
		int ris = tester.getLoseVP();
		
		assertEquals(quantity, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.excommEffects.LoseVPforCosts#getName()}.
	 */
	@Test
	public void testGetName() {
		LoseVPforCosts tester = new LoseVPforCosts();
		String ris = tester.getName();
		
		assertEquals("LoseVpforCosts", ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.excommEffects.LoseVPforCosts#toString()}.
	 */
	@Test
	public void testToString() {
		
	}

}
