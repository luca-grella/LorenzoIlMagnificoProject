/**
 * 
 */
package it.polimi.ingsw.ps18.model.cards;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import it.polimi.ingsw.ps18.model.effect.excommEffects.ExcommEffects;
import it.polimi.ingsw.ps18.model.effect.excommEffects.LoseVPforResources;

/**
 * The Class ExcommunicationsTest.
 *
 * @author luca-grella
 */
public class ExcommunicationsTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.Excommunications#Excommunications(org.json.simple.JSONObject)}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testExcommunications() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/Excommunicationsprova.json"));
		JSONObject jsonObject = (JSONObject) obj;
	    JSONObject a = (JSONObject) jsonObject.get("1");
	    long number = (long) a.get("number");
	    long period = (long) a.get("period");
		JSONArray effects = (JSONArray) a.get("Effects");
		JSONArray effectvalues = (JSONArray) a.get("EffectsValues");
		
		Excommunications tester = new Excommunications(a);
		
		assertEquals(number, (long) tester.getID());
		assertEquals(period, (long) tester.getPeriod());
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.Excommunications#getID()}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testGetID() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/Excommunicationsprova.json"));
		JSONObject jsonObject = (JSONObject) obj;
	    JSONObject a = (JSONObject) jsonObject.get("1");
	    long number = (long) a.get("number");
	    long period = (long) a.get("period");
		JSONArray effects = (JSONArray) a.get("Effects");
		JSONArray effectvalues = (JSONArray) a.get("EffectsValues");
		
		Excommunications tester = new Excommunications(a);
		long ris = tester.getID();
		
		assertEquals(number, ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.Excommunications#setID(long)}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testSetID() throws FileNotFoundException, IOException, ParseException {

		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/Excommunicationsprova.json"));
		JSONObject jsonObject = (JSONObject) obj;
	    JSONObject a = (JSONObject) jsonObject.get("1");
	    long number = (long) a.get("number");
	    long period = (long) a.get("period");
		JSONArray effects = (JSONArray) a.get("Effects");
		JSONArray effectvalues = (JSONArray) a.get("EffectsValues");
		
		Excommunications tester = new Excommunications(a);
		long iD = 82;
		tester.setID(iD);
		long ris = tester.getID();
		
		assertEquals(iD, ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.Excommunications#getPeriod()}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testGetPeriod() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/Excommunicationsprova.json"));
		JSONObject jsonObject = (JSONObject) obj;
	    JSONObject a = (JSONObject) jsonObject.get("1");
	    long number = (long) a.get("number");
	    long period = (long) a.get("period");
		JSONArray effects = (JSONArray) a.get("Effects");
		JSONArray effectvalues = (JSONArray) a.get("EffectsValues");
		
		Excommunications tester = new Excommunications(a);
		long ris = tester.getPeriod();
		
		assertEquals(period, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.Excommunications#setPeriod(long)}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testSetPeriod() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/Excommunicationsprova.json"));
		JSONObject jsonObject = (JSONObject) obj;
	    JSONObject a = (JSONObject) jsonObject.get("1");
	    long number = (long) a.get("number");
	    long period = (long) a.get("period");
		JSONArray effects = (JSONArray) a.get("Effects");
		JSONArray effectvalues = (JSONArray) a.get("EffectsValues");
		
		Excommunications tester = new Excommunications(a);
		long p = 3;
		tester.setPeriod(p);
		long ris = tester.getPeriod();
		
		assertEquals(p, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.Excommunications#getEffects()}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
//	@Test
//	public void testGetEffects() throws FileNotFoundException, IOException, ParseException {
//		JSONParser parser = new JSONParser();
//		
//		Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/Excommunicationsprova.json"));
//		JSONObject jsonObject = (JSONObject) obj;
//	    JSONObject a = (JSONObject) jsonObject.get("1");
//	    long number = (long) a.get("number");
//	    long period = (long) a.get("period");
//		JSONArray effects = (JSONArray) a.get("Effects");
//		JSONArray effectvalues = (JSONArray) a.get("EffectsValues");
//		
//		Excommunications tester = new Excommunications(a);
//		List<ExcommEffects> ris = tester.getEffects();
//		ExcommEffects ris2 = ris.get(0);
//		String ris3 = ris2.toString();
//		
//		assertEquals("detract 1 Military Point", ris3);
//	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.Excommunications#setEffects(java.util.List)}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
//	@Test
//	public void testSetEffects() throws FileNotFoundException, IOException, ParseException {
//		
//		JSONParser parser = new JSONParser();
//		
//		Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/Excommunicationsprova.json"));
//		JSONObject jsonObject = (JSONObject) obj;
//	    JSONObject a = (JSONObject) jsonObject.get("1");
//	    long number = (long) a.get("number");
//	    long period = (long) a.get("period");
//		JSONArray effects = (JSONArray) a.get("Effects");
//		JSONArray effectvalues = (JSONArray) a.get("EffectsValues");
//		
//		Excommunications tester = new Excommunications(a);
//		List<ExcommEffects> e = new ArrayList<>();
//		ExcommEffects e1 = new MalusServants();
//		e1.setQuantity(56);
//		e.add(e1 );
//		tester.setEffects(e );
//		List<ExcommEffects> ris = tester.getEffects();
//		ExcommEffects ris2 = ris.get(0);
//		String ris3 = ris2.toString();
//		
//		assertEquals("detract 56 Servants", ris3);
//	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.Excommunications#hasEffect()}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testHasEffect() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/Excommunicationsprova.json"));
		JSONObject jsonObject = (JSONObject) obj;
	    JSONObject a = (JSONObject) jsonObject.get("1");
	    long number = (long) a.get("number");
	    long period = (long) a.get("period");
		JSONArray effects = (JSONArray) a.get("Effects");
		JSONArray effectvalues = (JSONArray) a.get("EffectsValues");
		
		Excommunications tester = new Excommunications(a);
		
//		assertTrue(tester.hasEffect());
		
		JSONParser parser2 = new JSONParser();
		
		Object obj2 = parser2.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/Excommunicationsprova.json"));
		JSONObject jsonObject2 = (JSONObject) obj2;
	    JSONObject a2 = (JSONObject) jsonObject2.get("22");
	    long number2 = (long) a2.get("number");
	    long period2 = (long) a2.get("period");
		JSONArray effects2 = (JSONArray) a2.get("Effects");
		JSONArray effectvalues2 = (JSONArray) a2.get("EffectsValues");
		
		Excommunications tester2 = new Excommunications(a2);
		
		assertTrue(!(tester2.hasEffect()));
	}
	
	/**
	 * Test to string.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testToString() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/Excommunicationsprova.json"));
		JSONObject jsonObject = (JSONObject) obj;
	    JSONObject a = (JSONObject) jsonObject.get("1");

		
		Excommunications tester = new Excommunications(a);
		
		tester.toString(1);
		tester.toString();
		
	}

}
