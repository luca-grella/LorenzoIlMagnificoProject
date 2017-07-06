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
 * @author luca-grella
 *
 */
public class CheckMinimumSameTypeCardsTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.leaderEffects.requirements.CheckMinimumSameTypeCards#checkRequirement(it.polimi.ingsw.ps18.model.personalboard.PBoard)}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testCheckRequirement() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("0");
		
        CheckMinimumSameTypeCards tester = new CheckMinimumSameTypeCards();
		PBoard player = new PBoard();
		List<Cards> cards = new ArrayList<>();
		GreenC gc = new GreenC(a);
		cards.add(gc );
		player.setCards(cards );
		int minimum = 1;
		tester.setParam(minimum );
		
		
		
		boolean ris = tester.checkRequirement(player );
		
		assertTrue(ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.leaderEffects.requirements.CheckMinimumSameTypeCards#setParam(int)}.
	 */
	@Test
	public void testSetParam() {
		CheckMinimumSameTypeCards tester = new CheckMinimumSameTypeCards();

		int minimum = 1;
		tester.setParam(minimum );
		
		assertEquals(minimum, tester.getParam());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.leaderEffects.requirements.CheckMinimumSameTypeCards#toString()}.
	 */
	@Test
	public void testToString() {
		
	}

}
