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
 * The Class CheckNumberCardTypeTest.
 *
 * @author luca-grella
 */
public class CheckNumberCardTypeTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.leaderEffects.requirements.CheckNumberCardType#checkRequirement(it.polimi.ingsw.ps18.model.personalboard.PBoard)}.
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
		
		CheckNumberCardType tester = new CheckNumberCardType();
		PBoard player = new PBoard();
		List<Cards> cards = new ArrayList<>();
		GreenC gc = new GreenC(a);
		cards.add(gc );
		player.setCards(cards );
		tester.setParam("Green", 0);
		
		boolean ris = tester.checkRequirement(player );
		
		assertTrue(ris);
		
		tester.setParam("Green", 5);
		
		ris = tester.checkRequirement(player );
		
		assertTrue(!(ris));
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.leaderEffects.requirements.CheckNumberCardType#setParam(java.lang.String, int)}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testSetParam() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("0");
		
		CheckNumberCardType tester = new CheckNumberCardType();
		PBoard player = new PBoard();
		List<Cards> cards = new ArrayList<>();
		GreenC gc = new GreenC(a);
		cards.add(gc );
		player.setCards(cards );
		String details = "Green";
		int det=45;
		if (details=="Green"){ det = 0; };
		int minimum = 0;
		tester.setParam(details, minimum );
		int ris = tester.getDetails();
		int ris2 = tester.getMinimum();
		
		assertEquals(det, ris);
		assertEquals(minimum, ris2);
		
		tester.setParam("ciao", minimum );
		int ris3 = tester.getTypeColor();
		
		assertEquals(-3, ris3);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.effect.leaderEffects.requirements.CheckNumberCardType#toString()}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testToString() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("0");
		
		CheckNumberCardType tester = new CheckNumberCardType();
		PBoard player = new PBoard();
		List<Cards> cards = new ArrayList<>();
		GreenC gc = new GreenC(a);
		cards.add(gc );
		player.setCards(cards );
		String details = "Green";
		int det=45;
		if (details=="Green"){ det = 0; };
		int minimum = 0;
		tester.setParam(details, minimum );
		
		String ris = tester.toString();
		
		assertEquals("0 Green cards.",ris);
	}

}
