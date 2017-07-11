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
import it.polimi.ingsw.ps18.model.effect.quickEffect.HashMapQE;
import it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

/**
 * The Class HashMapLCRTest.
 *
 * @author luca-grella
 */
public class HashMapLCRTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.leaderEffects.requirements.HashMapLCR#HashMapLCR()}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testHashMapLCR() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("0");
		
		String name = "CheckMinimumSameTypeCards";
		
		HashMapLCR tester = new HashMapLCR();
		PBoard player = new PBoard();
		List<Cards> cards = new ArrayList<>();
		GreenC e = new GreenC(a);
		cards.add(e );
		player.setCards(cards );
		LCRequirement ris = tester.getRequirement(name);
		assertTrue(ris.checkRequirement(player));
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.leaderEffects.requirements.HashMapLCR#getRequirement(java.lang.String)}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testGetRequirement() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("0");
		
		String name = "CheckNumberCardType";
		
		HashMapLCR tester = new HashMapLCR();
		PBoard player = new PBoard();
		List<Cards> cards = new ArrayList<>();
		GreenC e = new GreenC(a);
		cards.add(e );
		player.setCards(cards );
		LCRequirement ris = tester.getRequirement(name);
		assertTrue(ris.checkRequirement(player));
		
	}

}
