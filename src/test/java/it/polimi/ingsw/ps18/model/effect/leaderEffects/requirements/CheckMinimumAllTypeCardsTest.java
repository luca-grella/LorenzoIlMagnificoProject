/**
 * 
 */
package it.polimi.ingsw.ps18.model.effect.leaderEffects.requirements;

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
import it.polimi.ingsw.ps18.model.cards.GreenC;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

/**
 * The Class CheckMinimumAllTypeCardsTest.
 *
 * @author luca-grella
 */
public class CheckMinimumAllTypeCardsTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.leaderEffects.requirements.CheckMinimumAllTypeCards#checkRequirement(it.polimi.ingsw.ps18.model.personalboard.PBoard)}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testCheckRequirement() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("0");
		
        CheckMinimumAllTypeCards tester = new CheckMinimumAllTypeCards();
		PBoard player = new PBoard();
		List<Cards> cards = new ArrayList<>();
		GreenC gc = new GreenC(a);
		cards.add(gc );
		player.setCards(cards );
		int minimum = 2;
		tester.setParam(minimum );
		
		
		
		boolean ris = tester.checkRequirement(player );
		
		assertTrue(!(ris));
		
		gc.setColor(1);	
		List<Cards> cards1 = new ArrayList<>();
		cards.add(gc );
		player.setCards(cards1 );
		
		ris = tester.checkRequirement(player );
		
		assertTrue(!(ris));
		
		gc.setColor(2);	
		List<Cards> cards2 = new ArrayList<>();
		cards.add(gc );
		player.setCards(cards2 );
		
		ris = tester.checkRequirement(player );
		
		assertTrue(!(ris));
		
		gc.setColor(3);	
		List<Cards> cards3 = new ArrayList<>();
		cards.add(gc );
		player.setCards(cards3 );
		
		ris = tester.checkRequirement(player );
		
		assertTrue(!(ris));
		
		minimum = -2;
		tester.setParam(minimum );
		
		ris = tester.checkRequirement(player );
		
		assertTrue(ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.leaderEffects.requirements.CheckMinimumAllTypeCards#setParam(int)}.
	 */
	@Test
	public void testSetParam() {
		CheckMinimumAllTypeCards tester = new CheckMinimumAllTypeCards();

		int minimum = 1;
		tester.setParam(minimum );
		
		assertEquals(minimum, tester.getParam());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.leaderEffects.requirements.CheckMinimumAllTypeCards#toString()}.
	 */
	@Test
	public void testToString() {
		
		CheckMinimumAllTypeCards tester = new CheckMinimumAllTypeCards();
		int minimum = 3;
		tester.setParam(minimum );
		
		String ris = tester.toString();
		
		assertEquals("3 of each type of card", ris);
		
	}

}
