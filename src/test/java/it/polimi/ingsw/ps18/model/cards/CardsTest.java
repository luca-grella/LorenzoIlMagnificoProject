/**
 * 
 */
package it.polimi.ingsw.ps18.model.cards;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import it.polimi.ingsw.ps18.model.board.boardcells.Cell;
import it.polimi.ingsw.ps18.model.effect.generalEffects.addMP;
import it.polimi.ingsw.ps18.model.effect.generalEffects.addWood;
import it.polimi.ingsw.ps18.model.effect.quickEffect.HashMapQE;
import it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

/**
 * The Class CardsTest.
 *
 * @author luca-grella
 */
public class CardsTest {

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.Cards#activateQEffects(it.polimi.ingsw.ps18.model.personalboard.PBoard, it.polimi.ingsw.ps18.model.gamelogic.GameLogic)}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testActivateQEffects() throws FileNotFoundException, IOException, ParseException {
		
		
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("0");
        String name = (String) a.get("name");
        long number = (long) a.get("number");
        long color = (long) a.get("color");
        long period = (long) a.get("period");
        long harvalue = (long) a.get("HarvestValue");
		
		Cards tester = new GreenC(a);
		

		PBoard player = new PBoard();
	    Stats resources = new Stats(0,0,0,0,0,0,0);
		//	GameLogic game = new GameLogic();
		player.setResources(resources);
		int wood = player.getResources().getWood();
	
		GameLogic game = new GameLogic();
		tester.activateQEffects(player, game);
		int ris = player.getResources().getWood();
		
		assertEquals(wood+1, ris);
		
		JSONParser parser2 = new JSONParser();
		
		Object obj2 = parser2.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
		JSONObject jsonObject2 = (JSONObject) obj2;
	    JSONObject a2 = (JSONObject) jsonObject2.get("4");
	    String name2 = (String) a2.get("name");
	    long number2 = (long) a2.get("number");
	    long color2 = (long) a2.get("color");
	    long period2 = (long) a2.get("period");
		
		Cards tester2 = new BlueC(a2);
		int mp = player.getResources().getMP();
		
		tester2.activateQEffects(player, game);
		int ris2 = player.getResources().getMP();
			
		assertEquals(mp+3, ris2);
		
		JSONParser parser3 = new JSONParser();
		
		Object obj3 = parser3.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
		JSONObject jsonObject3 = (JSONObject) obj3;
	    JSONObject a3 = (JSONObject) jsonObject3.get("5");
	    String name3 = (String) a3.get("name");
	    long number3 = (long) a3.get("number");
	    long color3 = (long) a3.get("color");
	    long period3 = (long) a3.get("period");
		
		Cards tester3 = new YellowC(a3);
		int vp = player.getResources().getVP();
		
		tester3.activateQEffects(player, game);
		int ris3 = player.getResources().getVP();
			
		assertEquals(vp+5, ris3);
		
		
		JSONParser parser4 = new JSONParser();
		
		Object obj4 = parser4.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
		JSONObject jsonObject4 = (JSONObject) obj4;
	    JSONObject a4 = (JSONObject) jsonObject4.get("6");
	    String name4 = (String) a4.get("name");
	    long number4 = (long) a4.get("number");
	    long color4 = (long) a4.get("color");
	    long period4 = (long) a4.get("period");
		
		Cards tester4 = new PurpleC(a4);
		int mp2 = player.getResources().getMP();
		
		tester4.activateQEffects(player, game);
		int ris4 = player.getResources().getMP();
			
		assertEquals(mp2+5, ris4);
		
	}



	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.Cards#getID()}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testGetID() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("0");
        String name = (String) a.get("name");
        long number = (long) a.get("number");
        long color = (long) a.get("color");
        long period = (long) a.get("period");
        long harvalue = (long) a.get("HarvestValue");
		
		Cards tester = new GreenC(a);
		
		long ris = tester.getID();
		
		assertEquals(number, ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.Cards#setID(long)}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testSetID() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser3 = new JSONParser();
		
		Object obj3 = parser3.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
		JSONObject jsonObject3 = (JSONObject) obj3;
	    JSONObject a3 = (JSONObject) jsonObject3.get("5");
	    String name3 = (String) a3.get("name");
	    long number3 = (long) a3.get("number");
	    long color3 = (long) a3.get("color");
	    long period3 = (long) a3.get("period");
		
		Cards tester3 = new YellowC(a3);
		
		long iD = 145;
		tester3.setID(iD);
		
		assertEquals(iD, tester3.getID());
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.Cards#getName()}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testGetName() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser2 = new JSONParser();
		
		Object obj2 = parser2.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
		JSONObject jsonObject2 = (JSONObject) obj2;
	    JSONObject a2 = (JSONObject) jsonObject2.get("4");
	    String name2 = (String) a2.get("name");
	    long number2 = (long) a2.get("number");
	    long color2 = (long) a2.get("color");
	    long period2 = (long) a2.get("period");
		
		Cards tester2 = new BlueC(a2);
		
		String ris = tester2.getName();
		
		assertEquals(name2, ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.Cards#setName(java.lang.String)}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testSetName() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser2 = new JSONParser();
		
		Object obj2 = parser2.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
		JSONObject jsonObject2 = (JSONObject) obj2;
	    JSONObject a2 = (JSONObject) jsonObject2.get("4");
	    String name2 = (String) a2.get("name");
	    long number2 = (long) a2.get("number");
	    long color2 = (long) a2.get("color");
	    long period2 = (long) a2.get("period");
		
		Cards tester2 = new BlueC(a2);
		
		String name = "WinterIsComing";
		tester2.setName(name );
		
		String ris = tester2.getName();
		
		assertEquals(name, ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.Cards#getPeriod()}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testGetPeriod() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser4 = new JSONParser();
		
		Object obj4 = parser4.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
		JSONObject jsonObject4 = (JSONObject) obj4;
	    JSONObject a4 = (JSONObject) jsonObject4.get("6");
	    String name4 = (String) a4.get("name");
	    long number4 = (long) a4.get("number");
	    long color4 = (long) a4.get("color");
	    long period4 = (long) a4.get("period");
		
		Cards tester4 = new PurpleC(a4);
		
		long ris = tester4.getPeriod();
		
		assertEquals(period4, ris);
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.Cards#setPeriod(long)}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testSetPeriod() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser4 = new JSONParser();
		
		Object obj4 = parser4.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
		JSONObject jsonObject4 = (JSONObject) obj4;
	    JSONObject a4 = (JSONObject) jsonObject4.get("6");
	    String name4 = (String) a4.get("name");
	    long number4 = (long) a4.get("number");
	    long color4 = (long) a4.get("color");
	    long period4 = (long) a4.get("period");
		
		Cards tester4 = new PurpleC(a4);
		
		tester4.setPeriod(455);
		
		assertEquals(455, tester4.getPeriod());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.Cards#getColor()}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testGetColor() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("3");
        String name = (String) a.get("name");
        long number = (long) a.get("number");
        long color = (long) a.get("color");
        long period = (long) a.get("period");
        long harvalue = (long) a.get("HarvestValue");
		
		Cards tester = new GreenC(a);
		
		long ris = tester.getColor();
		
		assertEquals(color, ris);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.Cards#setColor(long)}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testSetColor() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("3");
        String name = (String) a.get("name");
        long number = (long) a.get("number");
        long color = (long) a.get("color");
        long period = (long) a.get("period");
        long harvalue = (long) a.get("HarvestValue");
		
		Cards tester = new GreenC(a);
		
		tester.setColor(122);
		
		assertEquals(122, tester.getColor());
		
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.Cards#getEffects()}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testGetEffects() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("1");
        String name = (String) a.get("name");
        long number = (long) a.get("number");
        long color = (long) a.get("color");
        long period = (long) a.get("period");
        long harvalue = (long) a.get("HarvestValue");
        JSONArray qeffects = (JSONArray) a.get("QuickEffects");
        JSONArray qeffectsvalues = (JSONArray) a.get("QuickEffectsValues");
        
        
        
		Cards tester = new GreenC(a);
		List<QuickEffect> ris = tester.getEffects();
		QuickEffect qeffect = ris.get(0);
		
		PBoard player = new PBoard();
		int wood = 2636;
		Stats resources = new Stats(wood ,0,0,0,0,0,0);
		player.setResources(resources);
		qeffect.activate(player, new GameLogic());
		int ris2 = player.getResources().getWood();
		
		assertEquals(wood+1, ris2);
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.Cards#setEffects(java.util.List)}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testSetEffects() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		
    	Object obj = parser.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
    	JSONObject jsonObject = (JSONObject) obj;
        JSONObject a = (JSONObject) jsonObject.get("1");
        String name = (String) a.get("name");
        long number = (long) a.get("number");
        long color = (long) a.get("color");
        long period = (long) a.get("period");
        long harvalue = (long) a.get("HarvestValue");
//        JSONArray qeffects = (JSONArray) a.get("QuickEffects");
//        JSONArray qeffectsvalues = (JSONArray) a.get("QuickEffectsValues");
        
        
        
		Cards tester = new GreenC(a);
		List<QuickEffect> effects = new ArrayList<>();
		QuickEffect e = new addWood();
		e.setQuantity(5);
		effects.add(e);
		tester.setEffects(effects);
		QuickEffect ris = tester.getEffects().get(0);
		PBoard player = new PBoard();
		int wood = 2636;
		Stats resources = new Stats(wood ,0,0,0,0,0,0);
		player.setResources(resources);
		ris.activate(player, new GameLogic());
		int ris2 = player.getResources().getWood();
		
		assertEquals(wood+5, ris2);
	
	
	
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.Cards#getCardCost()}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testGetCardCost() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser3 = new JSONParser();
		
		Object obj3 = parser3.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
		JSONObject jsonObject3 = (JSONObject) obj3;
	    JSONObject a3 = (JSONObject) jsonObject3.get("5");
	    String name3 = (String) a3.get("name");
	    long number3 = (long) a3.get("number");
	    long color3 = (long) a3.get("color");
	    long period3 = (long) a3.get("period");
		
		Cards tester3 = new YellowC(a3);
		
		
		assertEquals(1, tester3.getCardCost().getWood());
		assertEquals(3, tester3.getCardCost().getRock());
		assertEquals(0, tester3.getCardCost().getCoin());
		assertEquals(0, tester3.getCardCost().getServants());
		assertEquals(0, tester3.getCardCost().getVP());
		assertEquals(0, tester3.getCardCost().getMP());
		assertEquals(0, tester3.getCardCost().getFP());
	}

	/**
	 * Test method for {@link it.polimi.ingsw.ps18.model.cards.Cards#setCardCost(it.polimi.ingsw.ps18.model.personalboard.resources.Stats)}.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParseException the parse exception
	 */
	@Test
	public void testSetCardCost() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser3 = new JSONParser();
		
		Object obj3 = parser3.parse(new FileReader("src/test/java/it/polimi/ingsw/ps18/JSON prova/carteprova.json"));
		JSONObject jsonObject3 = (JSONObject) obj3;
	    JSONObject a3 = (JSONObject) jsonObject3.get("5");
	    String name3 = (String) a3.get("name");
	    long number3 = (long) a3.get("number");
	    long color3 = (long) a3.get("color");
	    long period3 = (long) a3.get("period");
		
		Cards tester3 = new YellowC(a3);
		
		Stats cardCost = new Stats(24,67,78, 0, 12, 5, 87);
		tester3.setCardCost(cardCost );
		
		assertEquals(24, tester3.getCardCost().getWood());
		assertEquals(67, tester3.getCardCost().getRock());
		assertEquals(78, tester3.getCardCost().getCoin());
		assertEquals(0, tester3.getCardCost().getServants());
		assertEquals(87, tester3.getCardCost().getVP());
		assertEquals(5, tester3.getCardCost().getMP());
		assertEquals(12, tester3.getCardCost().getFP());
	}

}
