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

import it.polimi.ingsw.ps18.model.effect.generalEffects.addMP;
import it.polimi.ingsw.ps18.model.effect.harvestEffect.HarvestEffect;
import it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

/**
 * The Class GreenCTest.
 *
 * @author luca-grella
 */
public class GreenCTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.GreenC#hasHarvest()}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testHasHarvest() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("0");
        String name = (String) a.get("name");
        long number = (long) a.get("number");
        long color = (long) a.get("color");
        long period = (long) a.get("period");
        long harvalue = (long) a.get("HarvestValue");
		
		GreenC tester = new GreenC(a);
		
		assertTrue(tester.hasHarvest());
		
		JSONParser parser2 = new JSONParser();
		
    	Object obj2 = parser2.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject2 = (JSONObject) obj2;
        JSONObject a2 = (JSONObject) jsonObject2.get("1");
        String name2 = (String) a2.get("name");
        long number2 = (long) a2.get("number");
        long color2 = (long) a2.get("color");
        long period2 = (long) a2.get("period");
        long harvalue2 = (long) a2.get("HarvestValue");
		
		GreenC tester2 = new GreenC(a2);
		
		assertTrue(!(tester2.hasHarvest()));
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.GreenC#hasProduction()}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testHasProduction() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("0");
        String name = (String) a.get("name");
        long number = (long) a.get("number");
        long color = (long) a.get("color");
        long period = (long) a.get("period");
        long harvalue = (long) a.get("HarvestValue");
		
		GreenC tester = new GreenC(a);
		
		assertTrue(!(tester.hasProduction()));
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.GreenC#hasFinal()}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testHasFinal() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("0");
        String name = (String) a.get("name");
        long number = (long) a.get("number");
        long color = (long) a.get("color");
        long period = (long) a.get("period");
        long harvalue = (long) a.get("HarvestValue");
		
		GreenC tester = new GreenC(a);
		
		assertTrue(!(tester.hasFinal()));
		
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.GreenC#hasPermanent()}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testHasPermanent() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("0");
        String name = (String) a.get("name");
        long number = (long) a.get("number");
        long color = (long) a.get("color");
        long period = (long) a.get("period");
        long harvalue = (long) a.get("HarvestValue");
		
		GreenC tester = new GreenC(a);
		
		assertTrue(!(tester.hasPermanent()));
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.GreenC#GreenC(org.json.simple.JSONObject)}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testGreenC() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("0");
        String name = (String) a.get("name");
        long number = (long) a.get("number");
        long color = (long) a.get("color");
        long period = (long) a.get("period");
        long harvalue = (long) a.get("HarvestValue");
		JSONArray qeffects = (JSONArray) a.get("QuickEffects");
		JSONArray qeffectvalues = (JSONArray) a.get("QuickEffectsValues");
		JSONArray heffects = (JSONArray) a.get("HarvestEffects");
		JSONArray heffectvalues = (JSONArray) a.get("HarvestEffectsValues");
		
		GreenC tester = new GreenC(a);
		String nam = tester.getName();
		long numb = tester.getID();
		long col = tester.getColor();
		long per = tester.getPeriod();
		long harval = tester.getHarvValue();
		
		List<QuickEffect> quick = tester.getEffects();
		QuickEffect qeffect = quick.get(0);
		
		List<HarvestEffect> harv = tester.getHarveffect();
		HarvestEffect heffect = harv.get(0);
		
		PBoard player = new PBoard();
		int wood = 26;
		int coin = 23;
		Stats resources = new Stats(wood,0,coin,0,0,0,0);
		player.setResources(resources);
		qeffect.activate(player, new GameLogic());
		int ris2 = player.getResources().getWood();
		heffect.activate(player, new GameLogic());
		int ris3 = player.getResources().getCoin();
		
		
		assertEquals(name, nam);
		assertEquals(number, numb);
		assertEquals(color, col);
		assertEquals(period, per);
		assertEquals(harvalue, harval);
		assertEquals(wood+1, ris2);
		assertEquals(coin+1, ris3);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.GreenC#getHarvValue()}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testGetHarvValue() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("0");
        String name = (String) a.get("name");
        long number = (long) a.get("number");
        long color = (long) a.get("color");
        long period = (long) a.get("period");
        long harvalue = (long) a.get("HarvestValue");
		JSONArray qeffects = (JSONArray) a.get("QuickEffects");
		JSONArray qeffectvalues = (JSONArray) a.get("QuickEffectsValues");
		JSONArray heffects = (JSONArray) a.get("HarvestEffects");
		JSONArray heffectvalues = (JSONArray) a.get("HarvestEffectsValues");
		
		GreenC tester = new GreenC(a);
		long ris = tester.getHarvValue();
		
		assertEquals(harvalue, ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.GreenC#setHarvValue(long)}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testSetHarvValue() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("0");
        String name = (String) a.get("name");
        long number = (long) a.get("number");
        long color = (long) a.get("color");
        long period = (long) a.get("period");
        long harvalue = (long) a.get("HarvestValue");
		JSONArray qeffects = (JSONArray) a.get("QuickEffects");
		JSONArray qeffectvalues = (JSONArray) a.get("QuickEffectsValues");
		JSONArray heffects = (JSONArray) a.get("HarvestEffects");
		JSONArray heffectvalues = (JSONArray) a.get("HarvestEffectsValues");
		
		GreenC tester = new GreenC(a);
		long expected = 35;
		tester.setHarvValue(expected);
		long ris = tester.getHarvValue();
		
		assertEquals(expected, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.GreenC#getHarveffect()}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testGetHarveffect() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("0");
        String name = (String) a.get("name");
        long number = (long) a.get("number");
        long color = (long) a.get("color");
        long period = (long) a.get("period");
        long harvalue = (long) a.get("HarvestValue");
		JSONArray qeffects = (JSONArray) a.get("QuickEffects");
		JSONArray qeffectvalues = (JSONArray) a.get("QuickEffectsValues");
		JSONArray heffects = (JSONArray) a.get("HarvestEffects");
		JSONArray heffectvalues = (JSONArray) a.get("HarvestEffectsValues");
		
		GreenC tester = new GreenC(a);
		List<HarvestEffect> ris = tester.getHarveffect();
		PBoard player = new PBoard();
		Stats resources = new Stats(0,0,0,0,0,0,0);
		player.setResources(resources);
		ris.get(0).activate(player, new GameLogic());
		int ris1 = player.getResources().getCoin();
		
		assertEquals(1, ris1);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.GreenC#setHarveffect(java.util.List)}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testSetHarveffect() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("0");
        String name = (String) a.get("name");
        long number = (long) a.get("number");
        long color = (long) a.get("color");
        long period = (long) a.get("period");
        long harvalue = (long) a.get("HarvestValue");
		JSONArray qeffects = (JSONArray) a.get("QuickEffects");
		JSONArray qeffectvalues = (JSONArray) a.get("QuickEffectsValues");
		JSONArray heffects = (JSONArray) a.get("HarvestEffects");
		JSONArray heffectvalues = (JSONArray) a.get("HarvestEffectsValues");
		
		GreenC tester = new GreenC(a);
		List<HarvestEffect> he = new ArrayList<>();
		HarvestEffect e = new addMP();
		e.setQuantity(85);
		he.add(e );
		tester.setHarveffect(he);
		PBoard player = new PBoard();
		Stats resources = new Stats(0,0,0,0,0,0,0);
		player.setResources(resources);
		tester.getHarveffect().get(0).activate(player, new GameLogic());
		int ris = player.getResources().getMP();
		
		assertEquals(85, ris);
		
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
        JSONObject a = (JSONObject) jsonObject.get("0");

		
		GreenC tester = new GreenC(a);
		String ris = tester.toString(1);
		
		assertEquals("Card number 1:\n\tName: GreenProva\n\tID: 1\n\tColor: 0\n\tPeriod: 1\n\tHarvest Value 1\nQuick Effects:\n\t0: add 1 Wood\n\nHarvest Effects\n\t0: add 1 Coin\n", ris);
		
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
        JSONObject a = (JSONObject) jsonObject.get("0");

		
		GreenC tester = new GreenC(a);
		String ris = tester.toString();
		
		assertEquals("Current Card:\n\tName: GreenProva\n\tID: 1\n\tColor: 0\n\tPeriod: 1\n\tHarvest Value 1\nQuick Effects:\n\t0: add 1 Wood\n\nHarvest Effects\n\t0: add 1 Coin\n", ris);
		
	}

}
