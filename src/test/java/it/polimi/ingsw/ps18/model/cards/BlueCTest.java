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

import it.polimi.ingsw.ps18.model.effect.permeffects.Permanenteffect;
import it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

/**
 * @author luca-grella
 *
 */
public class BlueCTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.BlueC#hasHarvest()}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testHasHarvest() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser2 = new JSONParser();
		
		Object obj2 = parser2.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
		JSONObject jsonObject2 = (JSONObject) obj2;
	    JSONObject a2 = (JSONObject) jsonObject2.get("4");
	    String name2 = (String) a2.get("name");
	    long number2 = (long) a2.get("number");
	    long color2 = (long) a2.get("color");
	    long period2 = (long) a2.get("period");
		
		BlueC tester2 = new BlueC(a2);
		
		assertTrue(!(tester2.hasHarvest()));
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.BlueC#hasProduction()}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testHasProduction() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser2 = new JSONParser();
		
		Object obj2 = parser2.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
		JSONObject jsonObject2 = (JSONObject) obj2;
	    JSONObject a2 = (JSONObject) jsonObject2.get("4");
	    String name2 = (String) a2.get("name");
	    long number2 = (long) a2.get("number");
	    long color2 = (long) a2.get("color");
	    long period2 = (long) a2.get("period");
		
		BlueC tester2 = new BlueC(a2);
		
		assertTrue(!(tester2.hasProduction()));
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.BlueC#hasFinal()}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testHasFinal() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser2 = new JSONParser();
		
		Object obj2 = parser2.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
		JSONObject jsonObject2 = (JSONObject) obj2;
	    JSONObject a2 = (JSONObject) jsonObject2.get("4");
	    String name2 = (String) a2.get("name");
	    long number2 = (long) a2.get("number");
	    long color2 = (long) a2.get("color");
	    long period2 = (long) a2.get("period");
		
		BlueC tester2 = new BlueC(a2);
		
		assertTrue(!(tester2.hasFinal()));
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.BlueC#hasPermanent()}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testHasPermanent() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser2 = new JSONParser();
		
		Object obj2 = parser2.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
		JSONObject jsonObject2 = (JSONObject) obj2;
	    JSONObject a2 = (JSONObject) jsonObject2.get("4");
	    String name2 = (String) a2.get("name");
	    long number2 = (long) a2.get("number");
	    long color2 = (long) a2.get("color");
	    long period2 = (long) a2.get("period");
		
		BlueC tester2 = new BlueC(a2);
		
		assertTrue((tester2.hasPermanent()));
		
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
		JSONObject jsonObject = (JSONObject) obj;
	    JSONObject a = (JSONObject) jsonObject.get("7");
	    String name = (String) a.get("name");
	    long number = (long) a.get("number");
	    long color = (long) a.get("color");
	    long period = (long) a.get("period");
		
		BlueC tester = new BlueC(a);
		
		assertTrue(!(tester.hasPermanent()));
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.BlueC#BlueC(org.json.simple.JSONObject)}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testBlueC() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
		JSONObject jsonObject = (JSONObject) obj;
	    JSONObject a = (JSONObject) jsonObject.get("4");
	    String name = (String) a.get("name");
	    long number = (long) a.get("number");
	    long color = (long) a.get("color");
	    long period = (long) a.get("period");
		JSONArray cost = (JSONArray) a.get("CardCost");
		JSONArray qeffects = (JSONArray) a.get("QuickEffects");
		JSONArray qeffectvalues = (JSONArray) a.get("QuickEffectsValues");
		JSONArray peffects = (JSONArray) a.get("PermanentEffects");
		JSONArray peffectvalues = (JSONArray) a.get("PermanentEffectsValues");
		
		BlueC tester = new BlueC(a);
		String nam = tester.getName();
		long numb = tester.getID();
		long col = tester.getColor();
		long per = tester.getPeriod();
		Stats prize = tester.getCardCost();
		
		List<QuickEffect> quick = tester.getEffects();
		QuickEffect qeffect = quick.get(0);
		
		List<Permanenteffect> perm = tester.getPermeffect();
		String permeffect = perm.get(0).getName();
		int permeffectvalue = perm.get(0).getQuantity();
		
		PBoard player = new PBoard();
		int pm = 26;
		Stats resources = new Stats(0,0,0,0,0,pm,0);
		player.setResources(resources);
		qeffect.activate(player, new GameLogic());
		int ris2 = player.getResources().getMP();
		
		
		assertEquals(name, nam);
		assertEquals(number, numb);
		assertEquals(color, col);
		assertEquals(period, per);
		assertEquals(cost.get(0), (long) prize.getWood());
		assertEquals(cost.get(1), (long) prize.getRock());
		assertEquals(cost.get(2), (long) prize.getCoin());
		assertEquals(cost.get(3), (long) prize.getServants());
		assertEquals(cost.get(4), (long) prize.getFP());
		assertEquals(cost.get(5), (long) prize.getMP());
		assertEquals(cost.get(6), (long) prize.getVP());
		assertEquals(pm+3, ris2);
		assertEquals("Green", permeffect);
		assertEquals(2, permeffectvalue);
		
		
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.BlueC#getPermeffect()}.
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testGetPermeffect() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
		JSONObject jsonObject = (JSONObject) obj;
	    JSONObject a = (JSONObject) jsonObject.get("4");
	    String name = (String) a.get("name");
	    long number = (long) a.get("number");
	    long color = (long) a.get("color");
	    long period = (long) a.get("period");
		JSONArray peffects = (JSONArray) a.get("PermanentEffects");
		JSONArray peffectvalues = (JSONArray) a.get("PermanentEffectsValues");
		
		BlueC tester = new BlueC(a);
		List<Permanenteffect> ris = tester.getPermeffect();
		String permeffect = ris.get(0).getName();
		int permeffectvalue = ris.get(0).getQuantity();
		
		assertEquals("Green", permeffect);
		assertEquals(2, permeffectvalue);
		
	}

}
