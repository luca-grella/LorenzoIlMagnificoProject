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

import it.polimi.ingsw.ps18.model.effect.finalEffect.FinalEffect;
import it.polimi.ingsw.ps18.model.effect.generalEffects.addServants;
import it.polimi.ingsw.ps18.model.effect.harvestEffect.HarvestEffect;
import it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

/**
 * The Class PurpleCTest.
 *
 * @author luca-grella
 */
public class PurpleCTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.PurpleC#hasHarvest()}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testHasHarvest() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser4 = new JSONParser();
		
		Object obj4 = parser4.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
		JSONObject jsonObject4 = (JSONObject) obj4;
	    JSONObject a4 = (JSONObject) jsonObject4.get("6");
	    String name4 = (String) a4.get("name");
	    long number4 = (long) a4.get("number");
	    long color4 = (long) a4.get("color");
	    long period4 = (long) a4.get("period");
		
		PurpleC tester4 = new PurpleC(a4);
		assertTrue(!(tester4.hasHarvest()));
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.PurpleC#hasProduction()}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testHasProduction() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser4 = new JSONParser();
		
		Object obj4 = parser4.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
		JSONObject jsonObject4 = (JSONObject) obj4;
	    JSONObject a4 = (JSONObject) jsonObject4.get("6");
	    String name4 = (String) a4.get("name");
	    long number4 = (long) a4.get("number");
	    long color4 = (long) a4.get("color");
	    long period4 = (long) a4.get("period");
		
		PurpleC tester4 = new PurpleC(a4);
		assertTrue(!(tester4.hasProduction()));
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.PurpleC#hasFinal()}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testHasFinal() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser4 = new JSONParser();
		
		Object obj4 = parser4.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
		JSONObject jsonObject4 = (JSONObject) obj4;
	    JSONObject a4 = (JSONObject) jsonObject4.get("6");
	    String name4 = (String) a4.get("name");
	    long number4 = (long) a4.get("number");
	    long color4 = (long) a4.get("color");
	    long period4 = (long) a4.get("period");
		
		PurpleC tester4 = new PurpleC(a4);
		assertTrue(tester4.hasFinal());
		
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
		JSONObject jsonObject = (JSONObject) obj;
	    JSONObject a = (JSONObject) jsonObject.get("8");
	    String name = (String) a.get("name");
	    long number = (long) a.get("number");
	    long color = (long) a.get("color");
	    long period = (long) a.get("period");
		
		PurpleC tester = new PurpleC(a);
		assertTrue(!(tester.hasFinal()));
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.PurpleC#hasPermanent()}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testHasPermanent() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser4 = new JSONParser();
		
		Object obj4 = parser4.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
		JSONObject jsonObject4 = (JSONObject) obj4;
	    JSONObject a4 = (JSONObject) jsonObject4.get("6");
	    String name4 = (String) a4.get("name");
	    long number4 = (long) a4.get("number");
	    long color4 = (long) a4.get("color");
	    long period4 = (long) a4.get("period");
		
		PurpleC tester4 = new PurpleC(a4);
		assertTrue(!(tester4.hasPermanent()));
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.PurpleC#PurpleC(org.json.simple.JSONObject)}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testPurpleC() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("6");
        String name = (String) a.get("name");
        long number = (long) a.get("number");
        long color = (long) a.get("color");
        long period = (long) a.get("period");
        long minpm = (long) a.get("minPM");
		JSONArray qeffects = (JSONArray) a.get("QuickEffects");
		JSONArray qeffectvalues = (JSONArray) a.get("QuickEffectsValues");
		JSONArray feffects = (JSONArray) a.get("FinalEffects");
		JSONArray feffectvalues = (JSONArray) a.get("FinalEffectsValues");
		
		PurpleC tester = new PurpleC(a);
		String nam = tester.getName();
		long numb = tester.getID();
		long col = tester.getColor();
		long per = tester.getPeriod();
		long mpm = tester.getMinMP();
		
		List<QuickEffect> quick = tester.getEffects();
		QuickEffect qeffect = quick.get(0);
		
		List<FinalEffect> fin = tester.getFineffect();
		FinalEffect feffect = fin.get(0);
		
		PBoard player = new PBoard();
		int pm = 26;
		int pv = 23;
		Stats resources = new Stats(0,0,0,0,0,pm,pv);
		player.setResources(resources);
		qeffect.activate(player, new GameLogic());
		int ris2 = player.getResources().getMP();
		feffect.activate(player, new GameLogic());
		int ris3 = player.getResources().getVP();
		
		
		assertEquals(name, nam);
		assertEquals(number, numb);
		assertEquals(color, col);
		assertEquals(period, per);
		assertEquals(minpm, mpm);
		assertEquals(pm+5, ris2);
		assertEquals(pv+4, ris3);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.PurpleC#getFineffect()}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testGetFineffect() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("6");
        String name = (String) a.get("name");
        long number = (long) a.get("number");
        long color = (long) a.get("color");
        long period = (long) a.get("period");
        long minpm = (long) a.get("minPM");
		JSONArray qeffects = (JSONArray) a.get("QuickEffects");
		JSONArray qeffectvalues = (JSONArray) a.get("QuickEffectsValues");
		JSONArray feffects = (JSONArray) a.get("FinalEffects");
		JSONArray feffectvalues = (JSONArray) a.get("FinalEffectsValues");
		
		PurpleC tester = new PurpleC(a);
		List<FinalEffect> ris = tester.getFineffect();
		PBoard player = new PBoard();
		int pv = 23;
		Stats resources = new Stats(0,0,0,0,0,0,pv);
		player.setResources(resources);
		ris.get(0).activate(player, new GameLogic());
		int pvfinal = player.getResources().getVP();
		
		assertEquals(pv+4,pvfinal);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.PurpleC#setFineffect(java.util.List)}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testSetFineffect() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("6");
        String name = (String) a.get("name");
        long number = (long) a.get("number");
        long color = (long) a.get("color");
        long period = (long) a.get("period");
        long minpm = (long) a.get("minPM");
		JSONArray qeffects = (JSONArray) a.get("QuickEffects");
		JSONArray qeffectvalues = (JSONArray) a.get("QuickEffectsValues");
		JSONArray feffects = (JSONArray) a.get("FinalEffects");
		JSONArray feffectvalues = (JSONArray) a.get("FinalEffectsValues");
		
		PurpleC tester = new PurpleC(a);
		List<FinalEffect> fineffect = new ArrayList<>();
		FinalEffect e = new addServants();
		e.setQuantity(45);
		fineffect.add(e );
		tester.setFineffect(fineffect );
		List<FinalEffect> ris = tester.getFineffect();
		PBoard player = new PBoard();
		int servant = 23;
		Stats resources = new Stats(0,0,0,servant,0,0,0);
		player.setResources(resources);
		ris.get(0).activate(player, new GameLogic());
		int serfinal = player.getResources().getServants();
		
		assertEquals(servant+45,serfinal);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.PurpleC#getMinMP()}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testGetMinMP() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("6");
        String name = (String) a.get("name");
        long number = (long) a.get("number");
        long color = (long) a.get("color");
        long period = (long) a.get("period");
        long minpm = (long) a.get("minPM");
		JSONArray qeffects = (JSONArray) a.get("QuickEffects");
		JSONArray qeffectvalues = (JSONArray) a.get("QuickEffectsValues");
		JSONArray feffects = (JSONArray) a.get("FinalEffects");
		JSONArray feffectvalues = (JSONArray) a.get("FinalEffectsValues");
		
		PurpleC tester = new PurpleC(a);
		int ris = tester.getMinMP();
		
		assertEquals(minpm, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.PurpleC#getSecondaryCost()}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testGetSecondaryCost() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("9");
        String name = (String) a.get("name");
        long number = (long) a.get("number");
        long color = (long) a.get("color");
        long period = (long) a.get("period");
        long minpm = (long) a.get("minPM");
		JSONArray cost = (JSONArray) a.get("PurpleCardCost");
		JSONArray qeffects = (JSONArray) a.get("QuickEffects");
		JSONArray qeffectvalues = (JSONArray) a.get("QuickEffectsValues");
		JSONArray feffects = (JSONArray) a.get("FinalEffects");
		JSONArray feffectvalues = (JSONArray) a.get("FinalEffectsValues");
		
		PurpleC tester = new PurpleC(a);
		Stats ris = tester.getSecondaryCost();
		assertEquals(5, ris.getMP());
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
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("12");
		
		PurpleC tester = new PurpleC(a);
		String ris = tester.toString();
		
		assertEquals("Current Card:\n\tName: PurpleProva2\n\tID: 74\n\tColor: 3\n\tPeriod: 1\n\tCost:\n-----------------\nCoin: 4\n-----------------\n\n\tRequired MP: 4\n\tSecondary Cost:\n-----------------\nMP: 2\n-----------------\n\nQuick Effects:\n\t0: add 5 Military Points\n\nFinal Effects\n\t0: add 4 Victory Points\n", ris);
	}
	
	/**
	 * Test to string int.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	
	@Test
	public void testToStringInt() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("12");
		
		PurpleC tester = new PurpleC(a);
		String ris = tester.toString(1);
		
		assertEquals("Card number 1:\n\tName: PurpleProva2\n\tID: 74\n\tColor: 3\n\tPeriod: 1\n\tCost:\n-----------------\nCoin: 4\n-----------------\n\n\tRequired MP: 4\n\tSecondary Cost:\n-----------------\nMP: 2\n-----------------\n\nQuick Effects:\n\t0: add 5 Military Points\n\nFinal Effects\n\t0: add 4 Victory Points\n", ris);
	}

}
